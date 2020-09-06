package com.p66.oop

import scala.beans.BeanProperty


object P78BeanPropetry {
  def main(args: Array[String]): Unit = {
    val car = new Car
    car.name = "X3"
    println(car.name)

    car.setName("X5")
    print(car.getName)
  }

}

class Car {
  @BeanProperty var name: String = null
}