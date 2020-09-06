package com.scala.hao
import util.control.Breaks._

object P50break {
  def main(args: Array[String]): Unit = {
    var n = 1
    //breakable()函数,高阶函数，可以接受函数的函数就是高阶函数
//    如果传入的是代码块，scala一般会讲（）改成{}
    breakable(
    while (n<=10){
      n+=1
      println("n=" + n)
      if (n==5){
        break()
      }
    })
    println("ok....")

  }
}
