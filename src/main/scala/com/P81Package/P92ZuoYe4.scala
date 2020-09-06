package com.P81Package

/*
类
1、编写一个Time类，加入只读属性hours和minutes，和一个检查某一时刻是否早于另一时刻的方法before(other:Time):Boolean。
Time对象应该以new Time(hrs,min)方式构建。

2、创建一个Student类，加入可读写的JavaBeans属性name(类型为String)和id(类型为Long)。有哪些方法被生产？(用javap查看。)你可以在Scala中调用JavaBeans的getter和setter方法吗？

包和引入
1、练习使用包的各种声明方式，并查看他们的不同

2、编写一段程序,将Java哈希映射中的所有元素拷贝到Scala哈希映射。用引入语句重命名这两个类。

 */

object P92ZuoYe4 {
  def main(args: Array[String]): Unit = {
    //Time测试
    val cur1 = new Time(10, 20)
    val cur2 = new Time(10, 20)
    println(cur1.before(cur2))

    // Student测试
  }

  class Time(hrs: Int, min: Int) {
    val hours = hrs //属性
    val minutes = min //属性

    def before(other: Time): Boolean = {
      if (hours < other.hours) {
        true
      } else if (hours > other.hours) {
        false
      } else {
        if (minutes < other.minutes) true else false
      }

    }

  }

  import scala.beans.BeanProperty

  class Student {
    @BeanProperty var name: String = _
    @BeanProperty var id: Long = _
  }




}
