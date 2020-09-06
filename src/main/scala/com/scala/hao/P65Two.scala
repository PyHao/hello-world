package com.scala.hao

object P65Two {
  def main(args: Array[String]): Unit = {
    multi(9)
  }

  def multi(n: Int): Unit = {
    for (i <- 1 to n) {
      for (j <- 1 to i) {
        printf("%d*%d=%d ", j, i, i * j)
        //        println()
      }
      println()
    }
  }
}
