package com.scala.hao
import util.control.Breaks._

object P49Exercise {
  def main(args: Array[String]): Unit = {
    //    打印9*9乘法表
    val num = 9
    for (i<- 1 to num){   //行数
      for (j <- 1 to i){    //列数
        //        println(i + "*" + j "=" + i*j)
        printf("%d * %d = %d\t",j,i, i*j)
             }
      println()
      break()
    }


  }

}
