package com.scala.hao

object P64Exception {
  def main(args: Array[String]): Unit = {
    try {
      val r = 10 / 0
    } catch {
      case ex: ArithmeticException => {
        println("除数为0，异常")
      }
      case ex: Exception => {
        println("异常")
      }
    } finally {
      println("最终要执行的代码")
    }
    println("ok----")
  }


}
