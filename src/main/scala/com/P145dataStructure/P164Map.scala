package com.P145dataStructure

import scala.collection.mutable


object P164Map {
  def main(args: Array[String]): Unit = {

    val map1 = mutable.Map(("A",1),("B",2),("C",3))
    for ((k,v) <- map1) println(k + " is mapped to  " + v)
    println("========================")
    for (k <- map1.keys) println(k)
    println("========================")
    for (v<- map1.values) println(v)
    println("========================")
    for (kv <- map1) println(kv)   //kv 类型是tuple2
  }

}
