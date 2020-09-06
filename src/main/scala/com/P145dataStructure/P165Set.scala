package com.P145dataStructure

import scala.collection.mutable

object P165Set {
  def main(args: Array[String]): Unit = {

    val set = Set(1,2,"a")   //不可变
    println(set)

    val set2 = mutable.Set(1,3,"5a",1,3,5)
    println(set2)

    set2.add(true)
    println(set2)
    set2 += 7
    set2.+=(8)
    println(set2)
    set2.remove(true)
    println(set2)

    for (x <- set2) println(x)

  }

}
