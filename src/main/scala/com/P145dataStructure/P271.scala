package com.P145dataStructure

object P271 {
  def main(args: Array[String]): Unit = {
    val intMess = new IntMessage[Int](10)
    println(intMess)

    val strMess = new strMessage[String]("10")
    println(strMess)

  }

}

/*
编写一个Message类
可以构建Int类型的Message,String类型的Message.
要求使用泛型来完成设计,(说明：不能使用Any)

 */

abstract class Message[T](s:T){
  def get=s
  }

class IntMessage[Int](v:Int) extends Message(v)
class strMessage[String](v:String) extends Message(v)