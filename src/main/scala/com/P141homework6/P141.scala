package com.P141homework6

import java.awt.geom.Ellipse2D

object P141 {
  def main(args: Array[String]): Unit = {

//    val egg = new Ellipse2D.Double(5,10,20,30) with RectangleLike
    val egg = new Ellipse2D.Double(5,10,20,30) with RectangleLike2
    println("egg.x=" + egg.x + " egg.y=" + egg.y)

    egg.translate(10,-10)
    println("egg.x=" + egg.x + " egg.y=" + egg.y)
    egg.grow(10,20)
    println("egg.x=" + egg.x + " egg.y=" + egg.y)
  }

//传统写法
  trait RectangleLike extends Ellipse2D.Double{
    def translate(x:Double,y:Double): Unit ={
      this.x = x      //this 从 Ellipse2D.Double 继承的
      this.y = y
    }

    def grow(x:Double,y:Double): Unit ={
      this.x += x
      this.y += y
    }
  }

//  利用 自生类型 扩展
  trait RectangleLike2 extends {
  this:Ellipse2D.Double=>
    def translate(x:Double,y:Double): Unit ={
      this.x = x      //this 从 Ellipse2D.Double 继承的
      this.y = y
    }

    def grow(x:Double,y:Double): Unit ={
      this.x += x
      this.y += y
    }
  }

}
