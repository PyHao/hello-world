package com.scala.hao

import scala.math

object P17Type {
  def main(args: Array[String]): Unit = {
    //    println(sayHello)
    var char1: Char = 'a'
    var char2: Char = 97

    var num = 10 + char1

    math.BigInt(2)

//    var c2:Char = 'a' +1
//    var c3:Char = 97 +1

    println("char1:" + char1)
    println("char2:" + char2)
    println("num : " + num)
    println(math.sqrt(3))


  }

  //  开发中，有一个方法就是会异常中断，这时可以返回noting
  //  当我们nothing做返回值，就是明确说明该方法有没有正常返回值
  def sayHello: Nothing = {
    throw new Exception("抛出异常了")

  }

}
