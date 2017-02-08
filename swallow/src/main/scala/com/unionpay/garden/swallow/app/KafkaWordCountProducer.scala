package com.unionpay.garden.swallow.app

import java.util
import scala.util.Random
import com.unionpay.garden.swallow.entity.ViewMessage
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig, ProducerRecord}

/**
  * Created by yhqairqq@163.com on 07/02/2017.
  */
object KafkaWordCountProducer {

  def main(args: Array[String]) {
    //    if (args.length < 4) {
    //      System.err.println("Usage: KafkaWordCountProducer <metadataBrokerList> <topic> " +
    //        "<messagesPerSec> <wordsPerMessage>")
    //      System.exit(1)
    //    }

    //    val Array(brokers, topic, messagesPerSec, wordsPerMessage) = args

    val brokers = "localhost:9092"

    val topic = "test"

    val messagesPerSec = 10

    val wordsPerMessage = 10

    // Zookeeper connection properties
    val props = new util.HashMap[String, Object]()
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokers)
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
      "org.apache.kafka.common.serialization.StringSerializer")
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
      "org.apache.kafka.common.serialization.StringSerializer")

    val producer = new KafkaProducer[String, String](props)

    //    val record = new ProducerRecord[String,String]("","","")

    /**
      * 1百万个用户:编号0000001-1000000
      * 100个网页:网页001-100
      * 浏览时间:1秒-300秒
      * 点击次数:0-10次
      */
    val userTotal=1000000
    val pageTotal=100
    val viewTimeTotal=300
    val perPageClickTimesTotal=10

    // Send some messages
    while (true) {

      var msg = new StringBuilder()
      msg.append("%07d".format((Random.nextInt(userTotal) + 1)))
      msg.append("|")
      var pageId ="%03d".format(Random.nextInt(pageTotal) + 1)
      msg.append(pageId)
      msg.append("|")
      msg.append(Random.nextInt(viewTimeTotal)+1)
      msg.append("|")
      msg.append(Random.nextInt(perPageClickTimesTotal)+1)
      println(msg.toString())

      val message = new ProducerRecord[String, String](topic, pageId.toString, msg.toString)
      producer.send(message)
      Thread.sleep(1000)
    }
  }

}
