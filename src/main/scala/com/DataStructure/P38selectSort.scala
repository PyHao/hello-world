package com.DataStructure

object P38selectSort {
    def main(args: Array[String]): Unit = {
      val arr = Array(3,0,-9,10,-1)

      println(arr.mkString(" "))
      selectSort(arr)
      println(arr.mkString(" "))
    }

    def selectSort(arr:Array[Int]): Unit ={

      for (i <- 0 until arr.length) {
        var min = arr(i)
        var minIndex = i

        for (j <- (i+1) until arr.length) {
            if (min > arr(j)){    //找到最小值和最小index  找位子
              min = arr(j)
              minIndex = j
            }
        }
        if (minIndex !=i){         //是否进行交换
          arr(minIndex) = arr(i)
          arr(i) = min
        }

        println(s"第${i+1}轮结束")
        println(arr.mkString(" "))
      }

    }




}
