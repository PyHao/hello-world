package com.spark.hao

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object oper06distinct {
  def main(args: Array[String]): Unit = {
    val config: SparkConf = new SparkConf().setAppName("haoTest").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(config)

    // 数据被打乱，重组，shuffle
    val listRDD: RDD[Int] = sc.makeRDD(List(1,2,1,5,2,9,6,1))

//    listRDD.distinct()





    
  }

}
