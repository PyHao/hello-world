package com.spark.hao

import org.apache.spark.rdd.RDD
import org.apache.spark.{Partitioner, SparkConf, SparkContext}

object oper08partitionBy {
  def main(args: Array[String]): Unit = {
    val config: SparkConf = new SparkConf().setAppName("haoTest").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(config)

val listRDD: RDD[(String, Int)] = sc.makeRDD(List(("a",1),("b",2),("c",3),("d",4)))

    val partRDD: RDD[(String, Int)] = listRDD.partitionBy(new MyPartition(4))
    partRDD.saveAsTextFile("output")

  }

}

//声明分区器
//继承partitioner类
class MyPartition(partitions: Int) extends Partitioner{
  override def numPartitions: Int = {
    partitions
  }

  override def getPartition(key: Any): Int = {
    1
  }
}
