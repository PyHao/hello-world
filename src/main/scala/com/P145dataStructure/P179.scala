package com.P145dataStructure

import scala.collection.mutable.ArrayBuffer

object P179 {
  def main(args: Array[String]): Unit = {

    val sentence = "AAAAAAAABBBBBCCCCCCCCCCDDDD"
    val ArrB = new ArrayBuffer[Char]()
    for (i <- sentence){
      ArrB.append(i)
    }
    println(ArrB)

    val arrA = new ArrayBuffer[Char]()

    sentence.foldLeft(arrA)(putArray)
    println(arrA)

    println(sentence.map((_,1)))
    println(sentence.map(r => (r,1)).groupBy(_._1).mapValues(_.size))


  }

  def putArray(arr:ArrayBuffer[Char],c:Char):ArrayBuffer[Char] ={
    arr.append(c)
    arr
  }
}
