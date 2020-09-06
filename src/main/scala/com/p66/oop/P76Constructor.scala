package com.p66.oop

object P76Constructor {
  def main(args: Array[String]): Unit = {
    val p1 = new Person("jack", 10)
    println(p1)
    println("================================")
    val p2 = new Person("tomcat")
    println(p2)
  }

  //  创建person对象的同时，初始化对象的age和name
  class Person(inName: String, inAge: Int) {
    var name = inName
    var age = inAge

    age += 10
    println("++++++")

    override def toString: String = {
      "name=" + this.name + " age=" + this.age
    }

    println("zhixing -----")
    println("age=" + age)

    def this(name: String) {
      //      辅助构造器，必须在第一行显式调用主构造器
      this("tom", 10)
      this.name = name //重新赋值
    }

  }

}
