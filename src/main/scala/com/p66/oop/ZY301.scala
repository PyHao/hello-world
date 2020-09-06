package com.p66.oop

/*

 */

object ZY301 {
  def main(args: Array[String]): Unit = {

//    第一题 1、一个数字如果为正数，则它的signum为1;如果是负数,则signum为-1;如果为0,则signum为0.编写一个函数来计算这个值
    println("第一题：")
    println(signum(10))
    println(signum(-10))
    println(signum(0))

//    第二题 2、一个空的块表达式{}的值是什么？类型是什么？
    println("第二题：")
    val t={}
    println("t=" + t + " " + t.isInstanceOf[Unit])

//    第三题 3、针对下列Java循环编写一个Scala版本:
    //         for(int i=10;i>=0;i–)System.out.println(i);
    println("第三题：")
    for (i<- 0 to 10 reverse){
      printf("%d\t",i)
    }

//    第四题 4、编写一个过程countdown(n:Int)，打印从n到0的数字
    println()
    println("第四题：")
    countdown(5)
    def countdown(n:Int): Unit ={
      for (i<- 0 to n reverse){
        printf("%d\t",i)
      }
    }
    println()
    println("第四题 方法二：")
    countdown2(5)
    def countdown2(n:Int): Unit ={
      (0 to n).reverse.foreach(println)
    }

//    第五题 5、编写一个for循环,计算字符串中所有字母的Unicode代码（toLong方法）的乘积。举例来说，"Hello"中所有字符串的乘积为9415087488L
    println("第五题：")
    def five(n:String):Unit={
      var result:Long = 1
      for (i<- n){
//        println(i.toLong)
        result *= i.toLong
      }
      println(result)
    }
//    println(five("Hello"))
      five("Hello")
    var res = 1l
    for (i<-"Hello"){
      res *=i.toLong
    }
    println("res:" + res)
//    第六题 6、同样是解决前一个练习的问题，请用StringOps的foreach方式解决。
    println("第六题：")
    var res6 = 1L
    "Hello".foreach(res6*=_.toLong)
    println(res6)

//    第七题 编写一个函数product(s:String)，计算字符串中所有字母的Unicode代码（toLong方法）的乘积
//    8、把7练习中的函数改成递归函数
      def product2(s:String): Long ={
        if (s.length == 1){
          s.charAt(0).toLong
        } else {
          s.take(1).charAt(0).toLong * product2(s.drop(1))
        }

      }

    println("第八题：")
    println(product2("Hello"))


//  第九题  编写函数计算 x^n,其中n是整数，使用如下的递归定义:
    //•	  x^n= x*x^(n-1) ,如果n是正数的话
    //•	  x^0= 1
    //•	  x^n= 1/x^-n ,如果n是负数的话
    //•	不得使用return语句

def mi(x:Double,n:Int): Double ={
  if (n==0) 1
  else if (n>0) x*mi(x,n-1)
  else 1/mi(x,-n)
}
    println("第九题：")
    println(mi(4,-2))




  }

  def signum(n: Int): Int = {
    if (n == 0) {
      0
    } else if (n > 0) {
      1
    } else {
      -1
    }
  }
}
