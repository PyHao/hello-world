package com.spark.hao

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.Row
import org.apache.spark.{SparkConf, SparkContext}

object oper02glom {
  def main(args: Array[String]): Unit = {
    val config: SparkConf = new SparkConf().setAppName("haoTest").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(config)

    val listRDD: RDD[Int] = sc.makeRDD(1 to 14,3)   //多余数放最后一个分区  4,4,6
    val glomRDD: RDD[Array[Int]] = listRDD.glom()

    glomRDD.collect().foreach(array => {
      println(array.mkString(","))
    })

    println("===================================")

//    对分区内的数据做排序
    listRDD.mapPartitions(x=>{x.toList.sorted.reverse.toIterator}).glom().collect().foreach(x=>{println(x.mkString(","))})

/*
1,2,3,4
5,6,7,8,9
10,11,12,13,14
---------------------
4,3,2,1
9,8,7,6,5
14,13,12,11,10
 */

    println("===================================")
//val glomRDDsort: RDD[(Int, List(String))] = glomRDD.mapPartitionsWithIndex{
//  case (num,datas) => {
//    (num,datas.toList.reverse.toIterator)
//  }
//}
//    glomRDDsort.foreach(x=>{println(x.mkString(","))})
    
  }

}
