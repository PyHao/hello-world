package com.P145dataStructure

object P145 {
  def main(args: Array[String]): Unit = {

    val arr01 = new Array[Int](4)   // 底层 int[] arr01 = new int[4]
    println(arr01.length)

    for (i <- arr01){
      println(i)
    }

    println("-----------------------")
    arr01(3) = 100
    for (i <- arr01){
      println(i)
    }

    println("========================================================")

    val arr02: Array[Any] = Array(1, 2, "abc")
    arr02(1) = "xx"
    for (i<-arr02){
      println(i)
    }


  }

}
