package com.spark.hao

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object oper02flapMap {
  def main(args: Array[String]): Unit = {
    val config: SparkConf = new SparkConf().setAppName("haoTest").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(config)

    val listRDD: RDD[List[Int]] = sc.makeRDD(Array(List(1,2),List(3,4)))
    val flatMapRDD: RDD[Int] = listRDD.flatMap(datas=>datas)

//    1 2 3 4
    flatMapRDD.foreach(println)


    
  }

}
