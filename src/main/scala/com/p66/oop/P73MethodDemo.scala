package com.p66.oop

object P73MethodDemo {
  def main(args: Array[String]): Unit = {

    val mdt = new MethodExec()
    mdt.md()

    mdt.len = 10.1
    mdt.width = 2
    println(mdt.area())
    println(mdt.mj(3,4))
  }

  class MethodExec{
    var len = 0.0
    var width = 0.0
    def md(): Unit ={
      for (i<- 1 to 10){
        println("********")
      }

    }

    def area():Double={
      (this.len * this.width).formatted("%.2f").toDouble
    }

    def jux(m:Int,n:Int): Unit ={
      for (i<- 1 to m){
        for (j<- 1 to n){
          print("*")
          println()
        }
      }
    }
    def mj(len:Int,width:Int): Int ={
      len*width
    }

  }

}
