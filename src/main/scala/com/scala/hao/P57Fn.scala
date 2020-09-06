package com.scala.hao

object P57Fn {
  def main(args: Array[String]): Unit = {

    print(fn(5))
  }

  def fn(n:Int):Int={
    if (n==1){
      3
    } else{
      2*fn(n-1)+1
    }

  }

}
