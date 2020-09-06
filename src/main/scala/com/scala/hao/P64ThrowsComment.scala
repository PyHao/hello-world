package com.scala.hao

object P64ThrowsComment {
  def main(args: Array[String]): Unit = {
    f11()
  }

//  @throws(classOf[NumberFormatException]) //注解，声明将来可能抛出的NumberFormatException
  def f11() = {
    "abc".toInt
  }


}
