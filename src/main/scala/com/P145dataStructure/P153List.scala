package com.P145dataStructure

object P153List {
  def main(args: Array[String]): Unit = {

    //不可变,可变的使用ListBuffer
    //val List = scala.collection.immutable.List
    val list01 = List(1,2,3)
    println(list01)

    val list02 = Nil   //空集合   List()
    println(list02)

    println(list01(0))  //从 0 开始

    //追加数据
    //在最后加
    val list03 = list01:+"xyz"
    //在前面加
    val list04 = "abc" +: list01
    println(list01)
    println(list03)
    println(list04)


    // ：：使用
    val list05 = 10::12::14::list01::"abc"::Nil
    //新建 list()  再从右往左把元素加入
    println(list05)

    // :::  使用，把list01 打散放入list()  ::: 左右两边都要是list
    val list06 = 10::12::14::list01:::Nil
    println(list06)
  }

}
