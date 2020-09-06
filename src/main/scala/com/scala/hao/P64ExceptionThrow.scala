package com.scala.hao

object P64ExceptionThrow {
  def main(args: Array[String]): Unit = {

    try {
      test()
    } catch {
      case ex: Exception => println("捕获异常：" + ex.getMessage)
    } finally {
      println("最终执行")
    }
    println("后续执行")
  }

  def test(): Nothing = {
    throw new Exception("异常No1出现")
  }

}
