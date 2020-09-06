package com.P81Package

object P105Override02 {
  def main(args: Array[String]): Unit = {

  }

  abstract class A3{
    var name:String    //abstract

  }

  class A3_sub extends A3{
    override var name: String = _
  }

}
