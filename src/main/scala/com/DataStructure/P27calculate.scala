package com.DataStructure
import util.control.Breaks._

/*
这段代码有个问题，5-2*1+2  这样的话，计算结果不对
 */


object P27calculate {

  def main(args: Array[String]): Unit = {

    val expression = "5-2*1+2"
//    val expression = "3+2*6-2"


    val numStack = new ArrayStack2(10)
    val operStack = new ArrayStack2(10)

    var index = 0
    var num1 = 0
    var num2 = 0
    var oper = 0
    var res = 0
    var ch = ' '

    breakable {
      while (true) {

        ch = (expression.substring(index, index + 1))(0)
//        println(ch)

        if (operStack.isOper(ch)) { //如果是操作符
          if (!operStack.stackIsEmpty()) { //符号栈不为空
            if (operStack.priority(ch) <= operStack.priority(operStack.stack(operStack.top))) { //栈顶优先级 大
              //开始计算
              num1 = numStack.pop().toString.toInt
              num2 = numStack.pop().toString.toInt
              oper = operStack.pop().toString.toInt
              res = numStack.calculate(num1, num2, oper)
              println(num1,num2,oper,res)
              //入栈
              numStack.push(res)
              operStack.push(ch)

            } else { //栈顶优先级 小于当前 符号优先级，则直接入栈
              operStack.push(ch)
            }
          } else { //符号栈是空的，直接入栈
            operStack.push(ch) // '+' => 43

          }

        } else { //是数字
          numStack.push((ch + "").toInt) // '1' => 49 '3'
        }

        // index 后移
        index += 1

        println("numstack:",numStack.list())
        println("operstack:",operStack.list())
        if (index >= expression.length()) {
          break()
        }


      }
    }

    // 当整个表达式扫描完毕后，依次从数栈和符号栈 取出数据，进行运算，最后在数栈中的数据就是结果
    breakable {
      while (true) {
        if (operStack.stackIsEmpty()) {
          break()
        }
        // 运算
        num1 = numStack.pop().toString.toInt
        num2 = numStack.pop().toString.toInt
        oper = operStack.pop().toString.toInt
        res = numStack.calculate(num1, num2, oper)
        println("res2:",num1,num2,oper,res)
        numStack.push(res) //入栈结果
        println("numstack:",numStack.list())

      }

    }

    // 将数字栈最后一个数字pop
    //    val result = numStack.pop()
    printf("表达式 %s = %d\n", expression, numStack.pop().toString.toInt)

  }
}


  //定义栈
  class ArrayStack2(size:Int){
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
      }
      else {
        top += 1
        stack(top) = value
      }
    }

    //  出栈
    def pop(): Any ={
      if (stackIsEmpty()){
        return new Exception("栈空")
      }
      else {
        val value = stack(top)
        top -=1
        return value
      }
    }

    //遍历栈
    def list(): Unit ={
      if (stackIsEmpty()){
        println("栈空")
      }
      else {
        for (i <- 0 to top reverse){
          printf("stack[%d] : %d \n",i,stack(i))
        }
      }
    }

    def isOper(value:Int): Boolean ={
      value == '+' || value == '-' || value == '*' || value == '/'
    }

    //运算符优先级，优先级越高，数字越大
    //+ - > 0   * / > 1
    def priority(oper:Int): Int ={
      if (oper == '+' || oper == '-'){
        return 0
      }else if (oper == '*' || oper == '/'){
        return 1
      }else -1
    }

    //计算方法
    def calculate(num1:Int,num2:Int,oper:Int): Int ={
      var res = 0
      oper match {
        case '+' => res = num2 + num1
        case '-' => res = num2 - num1
        case '*' => res = num2 * num1
        case '/' => res = num2 / num1
      }
      res
    }


  }


