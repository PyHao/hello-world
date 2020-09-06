package com.spark.hao

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object oper07sortBy {
  def main(args: Array[String]): Unit = {
    val config: SparkConf = new SparkConf().setAppName("haoTest").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(config)

val listRDD: RDD[Int] = sc.makeRDD(1 to 16)
//    val listRDD: RDD[Int] = sc.makeRDD(Array(1,2,3,4,5,6,7,8,9))
    val reRDD: RDD[Int] = listRDD.repartition(2)
    val glomRDD: RDD[Array[Int]] = reRDD.glom()

//    glomRDD.collect().foreach(array=>{
//      println(array.
//    }
//    )

    glomRDD.foreach(array=>{
      println(array.foreach(x=>x))
    })

    val arr = Array((1, 6, 3), (2, 3, 3), (1, 1, 2), (1, 3, 5), (2, 1, 2))
    val datas2 = sc.parallelize(arr)
    val sorts2 = datas2.sortBy(e => (e._1,e._2),false)
    sorts2.collect().foreach(println)





    
  }

}
