package com.p66.oop

object CatDemo {
  def main(args: Array[String]): Unit = {

//    创建一个对象猫
    val cat = new Cat   // Cat 可以加（），也可以不加
//    给猫的属性赋值
    cat.name = "小白"   //其实不是直接访问属性，而是 cat.name_$eq("小白")
    cat.age=10
    cat.color="black"
    printf("小猫的信息如下：\n%s %d %s ",cat.name,cat.age,cat.color)
  }
}

//定义一个类Cat
class Cat {
  //  定义/声明 三个属性
  /*
  1、当声明了var name：string 时，底层对应private name
  2、同时会生成两个public方法name() <= 类似=>getter public name_$eq() => setter
   */
  var name: String = "" //给初始值
  var age: Int = _ //_ 表示给age一个默认的值，如果Int 默认就是0
  var color: String = _ //默认值是""
  var size="big"  //可以不写数据类型
}