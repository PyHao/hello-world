package com.P81Package

object P103Override {
  def main(args: Array[String]): Unit = {

    val obj1:A = new B
    val obj2:B = new B
// obj1.age  => obj1.age()   //动态绑定机制，还是调用的是obj2.age()
// obj2.age  => obj2.age()
    println("obj1.age = " + obj1.age + "\t obj2.age = " + obj2.age)   // 都是20

  }

  class A {
    val age:Int=10   // 会生成 public age()
  }

  class B extends A{
    override val age:Int =20    // 会生成 public age()
  }

}
