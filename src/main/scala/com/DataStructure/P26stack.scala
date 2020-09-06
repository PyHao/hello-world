package com.DataStructure

import scala.io.StdIn

object P26stack {
  def main(args: Array[String]): Unit = {

    val stackT = new ArrayStack(4)

    var key = ""

    while (true){
      println("show : 显示")
      println("push :  增加")
      println("pop :  取出数据")
//      println("head :  查看头数据")
      println("exit : 退出程序")

      key = StdIn.readLine()
      key match {
        case "show" => stackT.list()
        case "push" => stackT.push(StdIn.readInt())
        case "pop"  => {
          val res = stackT.pop()
          if (res.isInstanceOf[Exception]){
            println(res.asInstanceOf[Exception].getMessage)
          }else {
            printf("取出的数据为 %d \n",res)
          }
        }
        case "exit" => System.exit(0)
      }
    }

  }

  //定义栈
  class ArrayStack(size:Int){
    val maxSize = size   //栈大小
    var stack = new Array[Int](maxSize)
    //栈顶
    var top = -1

    //栈满

    def stackIsFull():Boolean={
      top == maxSize -1
    }

    //栈空
    def stackIsEmpty():Boolean={
      top == -1
    }

    //  进栈
    def push(value:Int): Unit ={
      if (stackIsFull()){
        println("栈满了")
        return
      }else {
        top += 1
        stack(top) = value
      }
    }

    //  出栈
    def pop(): Any ={
      if (stackIsEmpty()){
        return new Exception("栈空")
      }else {
        val value = stack(top)
        top -=1
        return value
        }
    }

    //遍历栈
    def list(): Unit ={
      if (stackIsEmpty()){
        println("栈空")
      }else {
        for (i <- 0 to top reverse){
          printf("stack[%d] : %d \n",i,stack(i))
        }
      }
    }

  }




}
