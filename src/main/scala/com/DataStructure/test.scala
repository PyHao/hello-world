package com.DataStructure

object test {
  def main(args: Array[String]): Unit = {

    val chessMap = Array.ofDim[Int](5,5)
    for (items <- chessMap){
      for (item <- items){
        printf("%d\t",item )
      }
      println()
    }

    println("-============================")

    val arr2=new Array[Array[Int]](2)

    arr2(0)=Array(1,2,4)
    arr2(1)=Array(2,4,6,8)

    for (items <- arr2){
      for (item <- items){
        printf("%d\t",item )
      }
      println()
    }

    val arr3=Array.ofDim[Double](3,2,5,4)

    println("-============================")
        for (j <- 0 until 10){
          println(j)
        }

  }

}
