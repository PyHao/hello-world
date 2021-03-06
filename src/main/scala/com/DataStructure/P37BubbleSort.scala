package com.DataStructure

import java.text.SimpleDateFormat
import java.util.Date

object P37BubbleSort {
  def main(args: Array[String]): Unit = {
    ////    数组
    //    val arr = Array(3,0,-9,10,-1)
    //// 测试冒泡
    //    bubbleSort(arr)
    //    println(arr.mkString(" "))

    //    for (j <- 0 to 10){
    //      println(j)
    //    }

// 执行11s
    val random = new util.Random()
    val arr = new Array[Int](80000)
    for (i <- 0 until arr.length) {
      arr(i) = random.nextInt(8000000)
    }
    println("排序前")
    val now: Date = new Date()
    val dateFormat: SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val date = dateFormat.format(now)
    println("排序前时间=" + date)

    println(arr.mkString(" "))
    println("排序后")
    bubbleSort(arr)
    println(arr.mkString(" "))
    val now2: Date = new Date()
    val date2 = dateFormat.format(now2)
    println("排序后时间=" + date2)
  }

  def bubbleSort(arr: Array[Int]): Unit = {

    for (i <- 0 until arr.length - 1) {
      for (j <- 0 until arr.length - 1 - i) {
        if (arr(j) > arr(j + 1)) {
          val temp = arr(j)
          arr(j) = arr(j + 1)
          arr(j + 1) = temp
        }
      }
    }

  }

}
