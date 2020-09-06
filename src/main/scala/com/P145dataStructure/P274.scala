package com.P145dataStructure

import com.P275lowerBounds
import com.P275lowerBounds.Earth

object P274 {
  def main(args: Array[String]): Unit = {
    biophony(Seq(new P275lowerBounds.Bird, new P275lowerBounds.Bird)) // yes
    biophony(Seq(new P275lowerBounds.Animal, new P275lowerBounds.Animal)) //yes
    biophony(Seq(new P275lowerBounds.Animal, new P275lowerBounds.Bird)) //yes
//    biophony(Seq(new Earth, new Earth)) //no earth不是animal的子类
  }
  def biophony[T <: P275lowerBounds.Animal](things: Seq[T]) = things map (_.sound)
}
class Earth { //Earth 类
  def sound(){ //方法
    println("hello !")
  }}
class Animal extends Earth{
  override def sound() ={ //重写了Earth的方法sound()
    println("animal sound")
  }}
class Bird extends P275lowerBounds.Animal{
  override def sound()={ //将Animal的方法重写
    print("bird sounds")
  }
}
