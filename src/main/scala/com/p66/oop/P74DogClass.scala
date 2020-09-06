package com.p66.oop

object P74DogClass {
  def main(args: Array[String]): Unit = {
    val myDog = new Dog
    myDog.name="tt"
    myDog.age=2
    myDog.weight=2.0
    println(myDog.say())

  }

  class Dog(){
    var name = ""
    var age=0
    var weight=0.0
    def say():String={
      return name + age + weight
    }
  }

}
