package com.scala.hao

object P62Lazy {
  def main(args: Array[String]): Unit = {
    lazy val res = sum(10, 20)
//    val res = sum(10, 20)
    println("-------------------")
    println("res=" + res)  //再要使用res前，才执行
  }

  def sum(i: Int, i1: Int): Int = {
    println("sum()执行了")
    return i + i1
  }

}
