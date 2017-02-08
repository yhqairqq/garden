package com.unionpay.garden.swallow.entity

/**
  * Created by yhqairqq@163.com on 08/02/2017.
  */
class ViewMessage(userIdx:String,pageIdx:String,browseTimex:Int,clickTimesx:Int) {
  /**
    * 1百万个用户:编号0000001-1000000
    * 100个网页:网页001-100
    * 浏览时间:1秒-300秒
    * 点击次数:0-10次
    */
  var userId:String=userIdx
  var pageId:String=pageIdx
  var browseTime:Int=browseTimex
  var clickTimes:Int=clickTimesx
}
