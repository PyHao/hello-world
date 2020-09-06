package com.P145dataStructure

object P151Tuple {
  def main(args: Array[String]): Unit = {
// 编译器会根据元素的个数，对应不同的元组类型
    val tuple1 = (1,2,3,"a",5)
    println(tuple1)

    // 访问
    println(tuple1._1)   //从1开始
    println(tuple1.productElement(0))   //从0 开始，模式匹配

    // 遍历元组,需要使用迭代器
    for (item<- tuple1.productIterator){
      println(item)
    }
  }

}
