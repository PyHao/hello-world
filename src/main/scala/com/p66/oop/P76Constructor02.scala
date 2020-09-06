package com.p66.oop

object P76Constructor02 {
  def main(args: Array[String]): Unit = {
    val x = new A
//    println(a)
    println("========================= ")
    val y = new A("jack")
  }



  class B{
    println("bbbbbb")
  }

  class A extends B{
    def this(name:String) { //辅助构造器
      this //调用A的主构造器
      println("A this(name:string  )")
    }
  }

}
