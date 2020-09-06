package com.P145dataStructure

object P272_3 {
  def main(args: Array[String]): Unit = {

    val list1 = List("hello","A","cat")
    val list2 = List(1,2,3,4)
    println(midList[String](list1))
    println(list1.length)
    println(list1.length/2)
    println(midList[Int](list2))
  }

  /*
  定义一个函数，可以获取各种类型的 List 的中间index的值
  使用泛型完成

   */
  def midList[T](l:List[T]): T ={
    l(l.length/2)
  }

}

