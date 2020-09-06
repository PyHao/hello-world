package com.P81Package

//匿名子类
object P108Niname {
  def main(args: Array[String]): Unit = {

    val monster = new Monster {
      override var name: String = _

      override def cry(): Unit = {    //override 可以写可以不写
        println("crying ~~~~")
      }
    }

    monster.cry()

  }

  abstract class Monster{
    var name:String
    def cry()
  }

}
