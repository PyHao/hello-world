package com.P81Package

object P111CompanionObj {
  def main(args: Array[String]): Unit = {
  println(ScalaPerson.sex)   //等价于  ScalaPeron$.MODULE$.sex()
    ScalaPerson.sayHi        //等价于  ScalaPeron$.MODULE$.sayHi()
  }

//  伴生类 非静态内容写入该类中  编译后，底层生成 ScalaPeron类ScalaPeron.class
  class ScalaPerson{
    var name = ""
  }

//  伴生对象  静态内容写入该对象（类）  编译后，底层生成ScalaPeron$类ScalaPeron$.class,可以直接通过ScalaPerson.属性 或者方法
  object ScalaPerson{
    var sex:Boolean = true
    def sayHi: Unit ={
      println("object ScalaPerson say Hi ~~~~~")
    }

  }
}
