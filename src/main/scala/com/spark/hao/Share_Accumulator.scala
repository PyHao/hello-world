package com.spark.hao

import java.util

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.util.AccumulatorV2

object Share_Accumulator {

  def main(args: Array[String]): Unit = {
    val config:SparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD checkPoint")
    val sc = new SparkContext(config)

    val dataRDD: RDD[String] = sc.makeRDD(List("hadoop","spark","hive","scala"),2)

    //创建累加器
    val wordAccumulator = new WordAccumulator
    //注册累加器
    sc.register(wordAccumulator)

    dataRDD.foreach{
      case word =>{
        wordAccumulator.add(word)
      }
    }

    println("wordAccumulator.value :" + wordAccumulator.value)

  }

}


//声明累加器
//1 继承
//2 实现抽象方法
// 创建累加器

class WordAccumulator extends AccumulatorV2[String,util.ArrayList[String]] {

  val list = new util.ArrayList[String]()

  //当前累加器是否为初始化状态
  override def isZero: Boolean = list.isEmpty

  //复制累加器对象
  override def copy(): AccumulatorV2[String, util.ArrayList[String]] = {
    new WordAccumulator()
  }

  //重置累加器对象
  override def reset(): Unit = {
    list.clear()
  }

  // 向累加器中增加数据
  override def add(v: String): Unit = {
    if (v.contains("h")){
      list.add(v)
    }

  }

  //合并
  override def merge(other: AccumulatorV2[String, util.ArrayList[String]]): Unit = {
    list.addAll(other.value)
  }

  //  获取累加器结果
  override def value: util.ArrayList[String] = list
}
