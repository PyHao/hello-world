package com.P81Package

object P88TestVisit {
  def main(args: Array[String]): Unit = {
    val c = new Clerk()
    c.showInfo()
    Clerk.test(c)
  }
}

class Clerk {
  var name: String = "jack"
  private var sal: Double = 9999.9

  def showInfo(): Unit = {
//    本类中可以使用私有的变量
    println(" name " + name + " sal= " + sal)
  }
}

/*
class Clerk 为伴生类
object Clerk 为伴生对象
scala设计者将static拿掉了，设计了伴生类和伴生对象
伴生类 写非静态内容，伴生对象 是静态内容
伴生对象中可以访问伴生类的私有属性
 */

object Clerk {
  def test(c: Clerk): Unit = {
    //这里体现出在伴生对象中，可以访问c.sal
    println("test() name=" + c.name + " sal= " + c.sal)
  }
}
