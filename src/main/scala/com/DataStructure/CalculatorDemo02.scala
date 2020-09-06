package com.DataStructure

import util.control.Breaks._

/**
  * 2、完成多位数表达式的计算，例如：30+2*6-2   7*2*2-5+1-5+3-4
  */
object CalculatorDemo02 {
  def main(args: Array[String]): Unit = {
    // 数值栈
    val numStack = new ArrayStack3(20)
    // 符号栈
    val operStack = new ArrayStack3(20)

    /*
    expression = "3+2*6-2"
    思路：
    1、设计两个栈：数值栈，符号栈
    2、对 expresson 进行扫描，一个一个的取出
    3、当取出的字符是数值时，就直接入数值栈
    4、当取出的字符是符号时：
      4.1 如果当前符号栈中没有数据，就直接入栈
      4.2 如果当前符号的优先级小于等于符号栈的栈顶的符号的优先级，
          则pop出该符号，并从数值栈中一次弹出两个数据，进行运算，
          将结果重新push到数值栈，再将当前符号push到符号栈
      4.3 反之直接入符号栈
    5、当整个表达式扫描完毕后，依次从数值栈和符号栈中取出数据，
       进行运算，最后在数值栈中的数据就是结果
     */
    // val expression = "30+2*6-2"
//    val expression = "7*2*2-5+1-5+3-4"
    val expression = "5-3*1+2"
    var index = 0
    var num1 = 0
    var num2 = 0
    var oper = 0
    var res = 0
    var char = ' '
    var keepNum = "" // 在进行扫描时，保存上次的数字char，并进行拼接
    // 循环的取出 expression 的字符
    breakable {
      while (true) {
        // 1、设计两个栈：数值栈，符号栈
        // 2、对 expresson 进行扫描，一个一个的取出
        char = (expression.substring(index, index + 1)) (0)
        if (operStack.isOper(char)) { // 如果当前符号是一个操作符
          if (!operStack.isEmpty()) { // 如果当前符号栈中有数据
            // 当前符号的优先级小于等于符号栈的栈顶的符号的优先级
            if (operStack.priority(char) <= operStack.priority(operStack.stack(operStack.top))) {
              // 开始计算
              num1 = numStack.pop().toString.toInt
              num2 = numStack.pop().toString.toInt
              oper = operStack.pop().toString.toInt
              res = numStack.cal(num1, num2, oper)
              // 将计算的结果入数值栈
              numStack.push(res)
              // 将操作符压入符号栈
              operStack.push(char)
            } else {
              // 反之直接入符号栈
              operStack.push(char)
            }
          } else {
            operStack.push(char)
          }
        } else { // 是一个数
          // 处理多位数的逻辑
          keepNum += char
          // 如果 char 已经是 expression 的最后一个字符，则该数直接入栈
          if (index == expression.length - 1) {
            numStack.push(keepNum.toInt)
          } else {
            // 判断 char 的下一个字符是不是数字，如果是数字，则进行下一次扫描，如果是操作符，就该数直接入栈
            if (operStack.isOper(expression.substring(index + 1, index + 2)(0))) { // 是操作符，就该数直接入栈
              numStack.push(keepNum.toInt)
              keepNum = "" // 清空
            }
          }
          // numStack.push(char - 48) // '1' => 49
          // numStack.push((char + "").toInt)
        }

        // index 后移
        index += 1
        if (index >= expression.length) {
          break()
        }
      }
    }

    // 5、当整个表达式扫描完毕后，依次从数值栈和符号栈中取出数据，进行运算，最后在数值栈中的数据就是结果
    breakable {
      while (true) {
        if (operStack.isEmpty()) {
          break()
        }
        // 开始计算
        num1 = numStack.pop().toString.toInt
        num2 = numStack.pop().toString.toInt
        oper = operStack.pop().toString.toInt
        res = numStack.cal(num1, num2, oper)
        // 将计算的结果入数值栈
        numStack.push(res)
      }
    }
    printf("表达式： %s = %d", expression, numStack.pop().toString.toInt)

  }
}

// 用数组模拟栈的使用，该栈已经测试过了，可以使用
class ArrayStack3(size: Int) {
  // 栈的大小
  val maxSize = size
  var stack = new Array[Int](maxSize)
  // 栈顶，初始化为 -1
  var top = -1

  // 判断是否栈满
  def isFull(): Boolean = {
    top == maxSize - 1
  }

  // 判断是否栈空
  def isEmpty(): Boolean = {
    top == -1
  }

  // 将数据压入栈的方法
  def push(value: Int): Unit = {
    if (isFull()) {
      println("栈满，不能再存放数据")
      return
    }
    top += 1
    stack(top) = value
  }

  // 将数据弹出栈的方法
  def pop(): Any = {
    if (isEmpty()) {
      println("栈空，不能再取出数据")
      return
    }
    val value = stack(top)
    top -= 1
    return value
  }

  // 遍历栈（从栈顶往下取出）
  def list(): Unit = {
    if (isEmpty()) {
      println("栈空，没有数据可显示")
      return
    }
    for (i <- 0 to top reverse) {
      printf("stack[%d]=%d\n", i, stack(i))
    }
  }

  // 自定义运算符的优先级，这里我们先简单定义下符号的优先级
  // +- => 0    * / => 1    数字越大优先级越高
  def priority(oper: Int): Int = {
    if (oper == '*' || oper == '/') {
      return 1
    } else if (oper == '+' || oper == '-') {
      return 0
    } else {
      return -1 // 运算符不正确
    }
  }

  // 判断是否是一个操作符（即符号）
  def isOper(value: Int): Boolean = {
    value == '+' || value == '-' || value == '*' || value == '/'
  }

  // 计算的方法，这里我们仅考虑整数的计算
  def cal(num1: Int, num2: Int, oper: Int): Int = {
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
