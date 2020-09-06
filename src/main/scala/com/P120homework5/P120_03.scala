package com.P120homework5

/*
编写一个扑克牌 4 种花色的枚举,让其 toString 方法分别返回♣,♦,♥,♠，
并实现一个函数,检查某张牌的花色是否为红色
 */

object P120_03 {
  def main(args: Array[String]): Unit = {
    println(Suits)

    println(Suits.Clue)
    Suits.isRed(Suits.Diamond)
    print("=========")
    print(Suits.isRed2(Suits.Spade))
    print("=========")
    println(Suits.isRed3(Suits.Spade))

  }
}

object Suits extends Enumeration{    //枚举
  type Suits = Value   //给value 类型取别名

  val Spade = Value("♠")
  val Clue = Value("♣")
  val Heart = Value("♥")
  val Diamond = Value("♦")

  override def toString(): String = {
    Suits.values.mkString(",")
  }

  // 简写
  def isRed2(suits: Suits) = suits == Heart || suits == Diamond

  def isRed(suit: Suits): Unit ={
    if (suit == Heart || suit == Diamond) {
      print("true")
    } else  {
      print("false")
    }

  }

  def isRed3(suits: Suits): Boolean ={
    if(suits == Heart || suits == Diamond){
      true
    }else {
      false
    }
  }

}
