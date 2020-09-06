package com.DataStructure

import scala.io.StdIn

/*
存在数据空间不能复用的问题
需要用到取模算法，将数组看成一个环形：
尾索引的下一个为头索引时表示队列满，即将队列容量空出一个作为约定，(rear+1)%maxSize==front 则满
rear == front 为空
 */


object P7ArrayQueue {
  def main(args: Array[String]): Unit = {

    //初始化一个队列
    val queue = new ArrayQueue(5)

    var key = ""
    while (true){
      println("show : 显示队列")
      println("add :  增加队列")
      println("get :  取出队列数据")
      println("head :  查看队列头数据")
      println("exit : 退出程序")

      key = StdIn.readLine()
      key match {
        case "show" => queue.showQueue()
        case "add" =>{
          println("请输入一个数:")
          val value = StdIn.readInt()
          queue.addQueue(value)
        }
        case "get" =>{
          val res = queue.getQueue()
          if (res.isInstanceOf[Exception]){
            println(res.asInstanceOf[Exception].getMessage)
          }else {
            println("取出数据是:",res)
          }
        }
        case "head" => {
          val res = queue.headQueue()
          if (res.isInstanceOf[Exception]){
            println(res.asInstanceOf[Exception].getMessage)
          }else {
            println("队列头元素值 = " + res)
          }

        }
        case "exit" => System.exit(0)
      }
    }
  }

}

//使用数组模拟队列
class ArrayQueue(arrMaxSize:Int){
  val maxSize = arrMaxSize
  val arr = new Array[Int](maxSize)    //该数组存放数据，模拟队列
  var front = -1    //指向队列头部    front指向队列数据的前一个位置
  var rear = -1     //指向队列的尾部   rear指向队列的最后一个数据（包含）

  //判断队列是否满
  def ifFull():Boolean={
    rear == maxSize -1
  }

  //判断队列是否空
  def ifEmpty():Boolean={
    front == rear
  }

  //添加数据到队列
  def addQueue(n:Int):Unit={
    //判断是否满
    if (ifFull()){
      println("队列满，无法加入")
      return
    }
    rear += 1   //先让rear后移
    arr(rear) = n
  }

  //取出队列数据
  def getQueue(): Any ={
    if (ifEmpty()){
      return new Exception("队列空")
    }
    front += 1
    arr(front)
  }

  //查看头元素
  def headQueue():Any={
    if(ifEmpty()){
      return new Exception("队列空")
    }
    return arr(front +1)    //不去改变front值
  }



  //显示队列的所有数据
  def showQueue():Unit={
    if(ifEmpty()){
      println("队列空的，没有数据显示")
      return
    }
    for (i<- front+1 to rear){
      printf("arr[%d]=%d\n",i,arr(i))
    }
  }


}