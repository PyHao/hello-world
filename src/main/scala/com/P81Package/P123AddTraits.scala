package com.P81Package

object P123AddTraits {
  def main(args: Array[String]): Unit = {

    //创建MySQL4实例时，动态混入 DB4和File4
    //创建一个动态混入对象时，顺序是
//    1.Operate4   2 Data4  3 DB4  4 File4   叠加特质的时候，从左到右开始叠加
    val mysql = new MySQL4 with DB4 with File4
    println(mysql)
//    执行动态混入对象的方法时，执行顺序是,从右到左开始执行，类似 栈，后进先出
//    1 向文件  2 File4中的super.insert(id) 指的是左边的特质 DB4 向数据库
    // 3 DB4中的super.insert(id) 去找左边特质，发现没有特质，则去找父特质  插入数据
    mysql.insert(100)
    println("=====================================")
    val mySQL4 = new MySQL4 with File4 with DB4  //构建：Operate4  Data4  File4  DB4
    println(mySQL4)
    mySQL4.insert(999)     //执行：向数据库，向文件，插入数据999  此时super.insert(id)  super[Data4].insert(id) 输出一样
  }


}

trait Operate4 {
  println("Operate4...")
  def insert(id : Int)      //抽象方法
}

trait Data4 extends Operate4 {  //特质
  println("Data4")
  override  def insert(id : Int): Unit = {   //实现/重写 Operate4的 insert 方法
    println("插入数据 = " + id)
  }
}

trait DB4 extends Data4 {    //特质
  println("DB4")
  override def insert(id : Int): Unit = {   //重写 Data4 的 insert 方法
    println("向数据库")
    super.insert(id)
  }
}


trait File4 extends  Data4 {   //特质
  println("File4")
  override def insert(id : Int): Unit = {   //重写 Data4 的 insert 方法
    println("向文件")
//    super.insert(id)             //调用 insert方法（难点），super在动态混入时 ，不一定是父类
//可以直接调用Data4 的insert 方法，其中Data4 的类型，必须是当前的特质的直接父特质（超类）
    super[Data4].insert(id)    //向文件   插入数据
  }}

class MySQL4 {}    //普通类

