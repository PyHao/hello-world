package com.P277viewBounds

object P278_view03 {

  def main(args: Array[String]): Unit = {
    val p1 = new Person3("tom", 10)
    val p2 = new Person3("jack", 20)

    //引入隐式函数
    import MyImplicit._

    val compareComm3 = new CompareComm3(p1, p2)
    println(compareComm3.geater)

  }
}



class Person3(val name: String, val age: Int)  {
  override def toString = this.name + "\t" + this.age
}
class CompareComm3[T <% Ordered[T]](obj1: T, obj2: T) {
  def geater = if (obj1 > obj2) obj1 else obj2
}
