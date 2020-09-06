package com.P81Package.homework_P109

import scala.beans.BeanProperty

object work2 {
  def main(args: Array[String]): Unit = {

    val area1=new TestCylinder
    var area2=new area1.Cylinder

    var areanum:Double=area2.findArea(5.0)
    println(areanum)
    var volumenum:Double=area2.findVolume(2)
    println(volumenum)
  }

  class TestCylinder {


    class Cylinder {
      @BeanProperty var radius: Double = 1

      def findArea(radius: Double): Double = {

        var area: Double = 0
        area = radius * radius * 3.14
        area

      }

      @BeanProperty var length: Double = 1

      def findVolume(length: Double): Double = {
        var volume: Double = 0
        volume = findArea(radius) * length
        volume
      }

    }

  }

}
