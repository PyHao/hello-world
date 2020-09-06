package com.P145dataStructure

import scala.collection.mutable.ArrayBuffer

object P146ArrayBuffer {
  def main(args: Array[String]): Unit = {
    //create
    val arr01 = ArrayBuffer[Any](1,3,"jj")
    //visit
    println(arr01(1))
    //遍历
    for (i <- arr01){
      println(i)
    }

    //追加,每次append arr在底层会重新分配空间，进行扩容，arr2的内存地址会发生变化，成为新的arraybuffer
    arr01.append("abc123",567)
    println(arr01.hashCode())
    for (i <- arr01){
      println(i)
    }

    //delete
    arr01.remove(1,2)
    println("----------删除后-------------")
    for (i <- arr01){
      println(i)
    }

    //转换  ArrayBuffer 转换成 array
    val newArr01 = arr01.toArray
    println(newArr01)

    val newArr02 = newArr01.toBuffer
    newArr02.append(123)

    println("===============多维数组===============")
    val arr = Array.ofDim[Int](3,4)
    for (hang <- arr){
      for (lie <- hang){
//        print("i is :" + i)
        print( lie + "\t")
      }
      println()
    }

    println(arr(1)(1))

  }
}
