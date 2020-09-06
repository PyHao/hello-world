package com.P81Package
import scala.io.AnsiColor

object TestTiger {
  def main(args: Array[String]): Unit = {
//    使用xh的Tiger
    val tiger1 = new com.P81Package.xh.Tiger
//    使用xm的Tiger
    val tiger2 = new com.P81Package.xm.Tiger
    println(tiger1 + " " + tiger2)

  }

}
