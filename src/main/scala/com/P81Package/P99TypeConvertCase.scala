package com.P81Package

object P99TypeConvertCase {
  def main(args: Array[String]): Unit = {

    val stu = new Student
    val emp = new Emp
    test(stu)
    test(emp)
  }

//  写一个参数多态代码
//  在oop中一个父类的引用可以接收所有子类的引用，多态（参数多态）
  def test(p:Person): Unit ={
//  使用scala 中的类型检查和转换
  if (p.isInstanceOf[Emp]){
//  p.asInstanceOf[Emp],对p的类型没有任何变化，而是返回emp类型
    p.asInstanceOf[Emp].work()
  } else if (p.isInstanceOf[Student]){
    p.asInstanceOf[Student].exam()
  } else {
    println("转换失败")
  }
}

  class Person{
    def printName(): Unit ={
      println("Person printName")
    }

    def sayOK(): Unit ={
      println("say OK")
    }
  }

//  student 类
  class Student extends Person {
    val stdId=100

    override def printName(): Unit = {
      println("Student printName")
    }

    def exam(): Unit ={
      println("student ID is : " + this.stdId)
    }
  }

  //  Emp 类
  class Emp extends Person {
    val empId=900

    override def printName(): Unit = {
      println("Emp printName")
    }

    def work(): Unit ={
      println("Emp ID is : " + this.empId)
    }
  }

}
