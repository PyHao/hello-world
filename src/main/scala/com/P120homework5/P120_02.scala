package com.P120homework5

/*
编写一个 Scala 应用程序,使用 App 特质,以反序打印命令行参数,用空格隔开。
举例来说,scala Reverse Hello World 应该打印 World Hello
 */

object P120_02 extends App {

    var str1 = "hello1 world1"
    println(str1.split(" ").toList.reverse)
  println("=============")
    println(str1.split(" ").reverse.mkString(" "))
  println("=============")
    var args1 = args.reverse.mkString(" ")
    println(args1)

}
