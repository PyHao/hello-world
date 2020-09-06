package com.spark.hao

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object RDD_checkPoint {
  def main(args: Array[String]): Unit = {

    val config:SparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD checkPoint")
    val sc = new SparkContext(config)

    //设置检查单保存目录
    sc.setCheckpointDir("checkPoint")

    val rdd: RDD[Int] = sc.makeRDD(List(1,2,3,4,5,6,4,5,3))
    val mapRDD: RDD[(Int, Int)] = rdd.map((_,1))

    mapRDD.checkpoint()

    val reduceRDD: RDD[(Int, Int)] = mapRDD.reduceByKey(_+_)

    reduceRDD.foreach(println)
    println(reduceRDD.toDebugString)
//    reduceRDD.foreach(println)

  }

}
