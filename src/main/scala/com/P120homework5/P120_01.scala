package com.P120homework5

object P120_01 {
  def main(args: Array[String]): Unit = {
    val point = Point(3,4)     //触发apply
    println(point)

    val point2 = new Point(5,6)
    println(point2.x1,point2.x2)
  }

  object Conversions{

    def inchesToCentimeters(inches:Double):Double={
      inches * 2.54
    }

    def gallonsToLiters(gallons:Double):Double={
      gallons * 3.78541178
    }

    def milesToKilmeters(miles:Double): Double ={
      miles * 1.609344
    }

  }

  class Point(inx:Int=0,iny:Int=0){
    var x1 = inx
    var x2 = iny

  }

  object Point{
    def apply(inx: Int = 0, iny: Int = 0): Point = new Point(inx, iny)
  }

}
