package com.spark.hao

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
import scala.util.parsing.json.JSON

object RDD_JSON {
  def main(args: Array[String]): Unit = {

    val config:SparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD checkPoint")
    val sc = new SparkContext(config)

    val json = sc.textFile("in/user.json")
    val result  = json.map(JSON.parseFull)
    result.foreach(println)

//释放资源
    sc.stop()
  }

}
