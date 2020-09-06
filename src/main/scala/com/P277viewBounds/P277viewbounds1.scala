package com.P277viewBounds

object P277viewbounds1 {
  def main(args: Array[String]): Unit = {
    //方式1 支持隐式转换
    val compareComm1 = new CompareComm(20, 30)
    println(compareComm1.greater)
    //同时，也支持前面学习过的上界使用的各种方式,看后面代码
  }
}
class CompareComm[T <% Comparable[T]](obj1: T, obj2: T) {
  def greater = if(obj1.compareTo(obj2) > 0) obj1 else obj2
}

