package com.spark.hao

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object oper04groupBy {
  def main(args: Array[String]): Unit = {
    val config: SparkConf = new SparkConf().setAppName("haoTest").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(config)

    //生成数组，按照指定的规则进行分组
    val listRDD: RDD[Int] = sc.makeRDD(1 to 14)
    //分组后的数据形成了对偶元组（k-v），k表示分组的key，v表示分组的数据集合
    val groupByRDD: RDD[(Int, Iterable[Int])] = listRDD.groupBy(x=>x%2)

    val filterRDD: RDD[(Int, Iterable[Int])] = listRDD.groupBy(x=>x%2).filter(x=>x._1==0)
    filterRDD.foreach(println)

    val filterRDD1: RDD[Int] = listRDD.filter(_%2==0)
    filterRDD1.foreach(println)

    val listRDD2: RDD[Int] = sc.makeRDD(List(1,2,3,4,5))
    val groupByRDD2: RDD[(Int, Iterable[Int])] = listRDD2.groupBy(x=>x%2)

//    groupByRDD2.foreach(println)
//
//    groupByRDD.foreach(println)




    
  }

}
