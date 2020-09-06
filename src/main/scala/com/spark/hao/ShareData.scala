package com.spark.hao

import java.util

import org.apache.spark.rdd.RDD
import org.apache.spark.util.{AccumulatorV2, LongAccumulator}
import org.apache.spark.{SparkConf, SparkContext}

import scala.util.parsing.json.JSON

object ShareData {
  def main(args: Array[String]): Unit = {

    val config:SparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD checkPoint")
    val sc = new SparkContext(config)

    val dataRDD: RDD[Int] = sc.makeRDD(List(1,2,3,4,5,6),2)

//    val i: Int = dataRDD.reduce(_+_)
//    println(i)

    var sum = 0
    // 使用累加器共享变量，来累加数据

    // 创建累加器对象
    val accumulator: LongAccumulator = sc.longAccumulator

    dataRDD.foreach{
      case i => {
        //执行累加功能
        accumulator.add(i)
      }
    }

    println("sum = " + accumulator.value)

//    dataRDD.foreach(i=>sum = sum+i)
//    println("sum = " + sum)    // 0


//释放资源
    sc.stop()
  }

}


