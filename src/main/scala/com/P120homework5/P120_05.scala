package com.P120homework5

object P120_05 {
  def main(args: Array[String]): Unit = {

  }

  class Point(x:Double,y:Double)
  class LabeledPoint(tag:String,x:Double,y:Double) extends Point(x,y)

  abstract class Shape{
    def centerPoint()
  }

  class Rectangle extends Shape{
    override def centerPoint(): Unit = {}
  }

  class Circle extends Shape{

    override def centerPoint(): Unit = {}
  }

}
