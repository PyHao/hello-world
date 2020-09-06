package com.P130Package

object P137Implicit {

  def main(args: Array[String]): Unit = {

    implicit def f1(f:Double):Int={   //底层编译生成 f1$1
      f.toInt
    }

    val num:Int=4.4           //底层编译生成 f1$1(4.4)
    println("num=" + num)

    implicit val str1:String = "jack"   //隐式值
    // implicit name:String  : name 就是隐士参数
    def hello(implicit name:String):Unit = {
      println(name + "  hello")
    }

    hello   // 底层 hello$1(str1)   使用隐式值不要带()

//    implicit val name1:String="Scala"
//    implicit val name2:String="Python"

    def hi(implicit content:String="python"): Unit ={
      println("hi:" + content)
    }

    hi
  }



}
