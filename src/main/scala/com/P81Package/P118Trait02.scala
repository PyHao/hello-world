package com.P81Package

object P118Trait02 {
  def main(args: Array[String]): Unit = {
    val sheep = new Sheep()
    sheep.sayHi()
    sheep.sayHello()
  }
}


trait Trait02{
//  抽象方法
  def sayHi()
//  实现普通方法
  def sayHello(): Unit ={
    println("say Hello ~~~~")
  }

}

class Sheep extends Trait02{
  override def sayHi(): Unit = {
    println("sheep say Hi---------")
  }
}