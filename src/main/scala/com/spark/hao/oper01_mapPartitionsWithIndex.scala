package com.spark.hao

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object oper01_mapPartitionsWithIndex {
  def main(args: Array[String]): Unit = {
    val config: SparkConf = new SparkConf().setAppName("haoTest").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(config)

    val listRDD: RDD[Int] = sc.makeRDD(1 to 10,2)
//    多个参数一般使用模式匹配 case

    val tupleRDD: RDD[(Int, String)] = listRDD.mapPartitionsWithIndex {
      case (num, datas) => {
        datas.map((_, "+ 分区号：" + num))
      }
    }

    tupleRDD.foreach(println)


    
  }

}
