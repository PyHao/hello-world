package com.P145dataStructure

import com.P145dataStructure.SeasonEnum.Season

object P271_2 {
  def main(args: Array[String]): Unit = {

    val class1 = new EnglishClass[Season,String,String](SeasonEnum.spring,"0510班","gaoji")
    println("class1: " + class1.jj + " " +class1.mc + " " + class1.leix)

    val class2 = new EnglishClass[Season,String,Int](SeasonEnum.spring,"0510班",2)

    println("class2: " + class2.jj + " " +class2.mc + " " + class2.leix)
  }

}


/*
请设计一个 EnglishClass (英语班级类)，在创建EnglishClass的一个实例时，
需要指定[ 班级开班季节(spring,autumn,summer,winter)、班级名称、班级类型]
开班季节只能是指定的，班级名称为String, 班级类型是(字符串类型 "高级班", "初级班"..) 或者是 Int 类型(1, 2, 3 等)
请使用泛型来完成本案例.

 */

class EnglishClass[A,B,C](val jj:A,val mc:B,val leix:C)      //val 之后传入的就是只读类型

//季节是枚举类型
object SeasonEnum extends Enumeration{
  type Season = Value
  val spring,autumn,summer,winter = Value
}