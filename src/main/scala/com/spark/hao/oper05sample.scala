package com.spark.hao

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object oper05sample {
  def main(args: Array[String]): Unit = {
    val config: SparkConf = new SparkConf().setAppName("haoTest").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(config)

    val listRDD: RDD[Int] = sc.makeRDD(1 to 10)

    // 以指定的随机种子随机抽样出数量为fraction的数据，
    // withReplacement表示是抽出的数据是否放回，true为有放回的抽样，false为无放回的抽样，
    // seed用于指定随机数生成器种子。

    val sampleRDD: RDD[Int] = listRDD.sample(false,0.5,1)
    val sampleRDD2: RDD[Int] = listRDD.sample(true,0.5,1)
    sampleRDD2.foreach(println)





    
  }

}
