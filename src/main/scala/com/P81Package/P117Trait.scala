package com.P81Package

object P117Trait {
  def main(args: Array[String]): Unit = {

    val c = new C()
    val e = new E()
    c.getConnect()
    e.getConnect()
  }

}

//按要求定义一个trait
trait Trait01 {
//  定义一个规范
   def getConnect()
}


//6个类的关系
class A {}
class B extends A{}
class C extends A with Trait01 {
  override def getConnect(): Unit = {
    println("连接mysql数据库。。。")
  }
}

class D {}
class E extends D with Trait01 {
  override def getConnect(): Unit = {
    println("连接oracle数据库...")
  }
}
class F extends D{}

