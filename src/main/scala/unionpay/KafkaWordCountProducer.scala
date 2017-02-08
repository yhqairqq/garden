package unionpay

import java.util

import org.apache.kafka.clients.producer.{ProducerRecord, KafkaProducer, ProducerConfig}

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


    // Send some messages
    while (true) {
      val str = "this is a message"+System.currentTimeMillis()

      val message = new ProducerRecord[String, String](topic, null, str)
      producer.send(message)
      Thread.sleep(1000)
    }
  }

}
