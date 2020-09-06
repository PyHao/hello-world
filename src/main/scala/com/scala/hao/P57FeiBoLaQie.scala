package com.scala.hao

object P57FeiBoLaQie {
/*
用递归方式 求斐波拉切数   1,1,2,3,5,8,13.。。
给定整数n
 */
def main(args: Array[String]): Unit = {

  for (i<- 1 to 10){
    print(fblq(i)+",")
  }

  println()
  println(p(10))

  println(p2(1))

//  题目1 斐波拉切
  def fblq(n:Int):Int={
    if (n==1){
//      print(1)
      1
    }else if (n==2){
//      print(1)
      1
    }else {
//      print(fblq(n-1)+ fblq(n-2))
      return fblq(n-1)+ fblq(n-2)


      }
    }

//  题目2 P57Fn

//  题目3 猴子吃桃子  有一堆桃子，猴子第一天吃了其中的一半，并多吃了一个，以后每天都吃其中的一半，并再多吃一个，
  // 当到第十天时，想再吃时（还没吃），发现只有一个桃子了，问最初共有多少个桃子
  def p(n:Int):Int={
      if (n == 1) {
        1
      } else {
        (p(n-1)+1)*2
      }

  }

  /*
    day=10  桃子 1
    day=9   桃子 (day10[1]+1)*2  =4
    day=8   桃子 (day9[4]+1)*2  =10
   */
  def p2(day:Int):Int={
    if (day==10){
      1
    } else{
      (p2(day+1)+1)*2    //f(1)/2-1 = f(2) =f(1+1) 即 f(1)=(f(n+1)+1)*2
    }
  }

  }

}

