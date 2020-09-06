package com.spark.hao

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object oper01_mapPartitions {
  def main(args: Array[String]): Unit = {

    val config: SparkConf = new SparkConf().setMaster("local[*]").setAppName("wordcount")
    //创建spark上下文对象
    val sc = new SparkContext(config)

    val listRDD: RDD[Int] = sc.makeRDD(1 to 10)

//    可以简写成 x=>x.map(_*2)
//    val mapPartitionsRDD: RDD[Int] = listRDD.mapPartitions(
//      datas =>{datas.map(data => data * 2)}
//    )

//    对一个RDD中所有分区进行遍历
//    效率优于map算子，减少了发送到执行器执行交互次数
//    可能出现内存溢出 omm

//    所有RDD算子的计算功能全部由 executor 执行 (x=>x.map(_*2))
    val mapPartitionsRDD: RDD[Int] = listRDD.mapPartitions(x=>x.map(_*2))
    mapPartitionsRDD.foreach(println)
    mapPartitionsRDD.collect()

  }

}
