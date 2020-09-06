package com.DataStructure

/*
 * @desc:需要用到取模算法，将数组看成一个环形：
尾索引的下一个为头索引时表示队列满，即将队列容量空出一个作为约定，(rear+1)%maxSize==front 则满
rear == front 为空
 *       
 * @author: zhuhao
 * @date: 2020/6/4 21:22
 * @param null
 * @return:
 */

object P9CircleArrayQueue {
  def main(args: Array[String]): Unit = {

  }
}

class CircleArrayQueue(arrMaxSize: Int) {
  val maxSize = arrMaxSize
  val arr = new Array[Int](maxSize) //该数组存放数据，模拟队列
  var front = 0 //指向队列头部
  var rear = 0 //指向队列的尾部

  //判断队列满
  def isFull(): Boolean = {
    (rear + 1) % maxSize == front
  }

  //判断队列空
  def isEmpty(): Boolean = {
    rear == front
  }

  //添加数据到队列
  def addQueue(n: Int): Unit = {
    //判断是否满
    if (isFull()) {
      println("队列满，无法加入")
      return
    }
    //加入数据
    arr(rear) = n
    //将rear 后移，取模
    rear = (rear + 1) % maxSize

  }

  //取出队列数据
  def getQueue(): Any = {
    if (isEmpty()) {
      return new Exception("队列空")
    }
    //取数据
    //    1 先把front 数据保存   2 将front后移  3 返回前面保存的变量值

    val value = arr(front)
    front = (front + 1) % maxSize
    return value
  }

  //显示队列的所有数据
  def showQueue():Unit={
    if(isEmpty()){
      println("队列空的，没有数据显示")
      return
    }
    for (i<- front+1 to rear){
      printf("arr[%d]=%d\n",i,arr(i))
    }
  }
}