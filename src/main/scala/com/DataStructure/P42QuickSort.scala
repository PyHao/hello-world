package com.DataStructure

import java.text.SimpleDateFormat
import java.util.Date

import com.DataStructure.P37BubbleSort.bubbleSort

import scala.util.Sorting
import util.control.Breaks._

object P42QuickSort {
  def main(args: Array[String]): Unit = {

//    val random = new util.Random()
//    val arr = new Array[Int](80000)
//    for (i <- 0 until arr.length) {
//      arr(i) = random.nextInt(8000000)
//    }
////    val arr = Array(3,0,-9,10,-1)
//    Sorting.quickSort(arr)
//    println(arr.mkString(" "))

//    println(quickSortList(List(3,0,-9,10,-1)))

//    val arr = Array(2,0,2,10,11)
//    quickSortArr(0,arr.length-1,arr)
//    println("排序后的arr")
//    println(arr.mkString(" "))

    //14s
    val random = new util.Random()
    val arr = new Array[Int](8000000)
    for (i <- 0 until arr.length) {
      arr(i) = random.nextInt(800000000)
    }
    println("排序前")
    val now: Date = new Date()
    val dateFormat: SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val date = dateFormat.format(now)
    println("排序前时间=" + date)

//    println(arr.mkString(" "))
    println("排序后")
    quickSortArr(0,arr.length-1,arr)
//    println(arr.mkString(" "))
    val now2: Date = new Date()
    val date2 = dateFormat.format(now2)
    println("排序后时间=" + date2)



  }

  def quickSortArr(left:Int,right: Int,arr:Array[Int]): Unit ={
    var l = left   //左下标  标记位置
    var r = right
    var pivot = arr((left+right)/2)
    var tmp = 0

    breakable{
      while (l < r) { //位置判断
        while (arr(l) < pivot) {l += 1}
        while (arr(r) > pivot) {r -= 1}
        if (l >= r) {break()}      //退出

        var tmp = arr(l) //交换位置
        arr(l) = arr(r)
        arr(r) = tmp

        //交换完位置之后，比如 2,0,2,10,11 交换完位置之后 是 1,0,2,10,2  arr(r) == pivot 则 l += 1
        if (arr(l) == pivot) {r -= 1}
        if (arr(r) == pivot) {l += 1}
      }
    }
    if (l == r) {
      l += 1
      r -= 1
    }

    if (left < r) { quickSortArr(left,r,arr) }   //向左递归排序  将左边的排序
    if (right > l) { quickSortArr(l,right,arr) }  //向右递归排序  将右边的排序


  }

  def quickSortList(a:List[Int]):List[Int]={
    if (a.length < 2) a
    else quickSortList(a.filter(_ < a.head)) ++ a.filter(_ == a.head) ++ quickSortList(a.filter(_ > a.head))
  }

}
