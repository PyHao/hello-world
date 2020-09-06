package com.P81Package

object P114apply {
  def main(args: Array[String]): Unit = {

    val pig1 = Pig("小猪猪1")
    val pig2 = Pig()

    println("pig1.name = " + pig1.name)
    println("pig2.name = " + pig2.name)


  }

  class Pig(pName:String){
    var name = pName
  }

  object Pig{
    def apply(pName: String): Pig = new Pig(pName)

    def apply(): Pig = new Pig("小小猪猪")
  }
}
