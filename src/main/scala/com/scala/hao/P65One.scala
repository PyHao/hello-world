package com.scala.hao

object P65One {
  def main(args: Array[String]): Unit = {
pyramid(10)
  }

  def pyramid(n:Int): Unit = {
    for (i <- 1 to n) {
      println(" " * (n-i) + "*" * (2*i-1))
    }
  }
}
