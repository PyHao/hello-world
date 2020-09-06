package com.P145dataStructure

/*
编写一个通用的类，可以进行Int之间、Float之间、等实现了Comparable接口的值直接的比较.//java.lang.Integer
分别使用传统方法和上界的方式来完成，体会上界使用的好处
 */


object P273_upper {
  def main(args: Array[String]): Unit = {

    val c1 = new CompareInt(10, 20)
    println(c1.greater)

    val c2 = new CompareComm(Integer.valueOf(10),Integer.valueOf(40))
    println(c2.greater)

    val c2_2 = new CompareComm[java.lang.Integer](300,500)
    println(c2_2.greater)

    val c3 = new CompareComm(java.lang.Float.valueOf(10.1f),java.lang.Float.valueOf(40.2f))
    println(c3.greater)

    //隐式转换 , Predef
//  implicit def Float2float(x: java.lang.Float): Float         = x.floatValue

    val c4 = new CompareComm[java.lang.Float](100.001f,202.123f)
    println(c4.greater)

  }



}

class CompareInt(n1: Int, n2: Int) {
  def greater = if (n1 > n2) n1 else n2
}

/*
[T <: Comparable[T]] 表示T类型是 Comparable 子类型
传入的T类型要继承 Comparable 接口，这样就可以使用 compareTo 方法
通用性更高
 */

class CompareComm[T <: Comparable[T]](obj1: T, obj2: T) {
  def greater = if (obj1.compareTo(obj2) > 0) obj1 else obj2
}