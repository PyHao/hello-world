package com.spark.hao

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object oper0_map {
  def main(args: Array[String]): Unit = {
    val config: SparkConf = new SparkConf().setMaster("local[*]").setAppName("map")
    val sc = new SparkContext(config)

    val listRDD: RDD[Int] = sc.makeRDD(1 to 10)

//  i在driver  i必须要能序列化，否则无法通过网络 从driver传输到executor
    val i = 10

//    所有RDD算子的计算功能全部由executor执行 (_ * i)，其他都在driver执行

    val mapRDD: RDD[Int] = listRDD.map(_ * i)

    val L1 = List(1,2,3,4)
    val L2 = L1.map(_*2)
    mapRDD.foreach(println)
    L2.foreach(println)
  }

}
