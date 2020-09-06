package com.P277viewBounds

object P277viewbounds2 {

  def main(args: Array[String]): Unit = {
    val p1 = new Person("tom", 10)
    val p2 = new Person("jack", 20)
    val compareComm2 = new CompareComm2(p1, p2)
    println(compareComm2.getter)

  }
}


class Person(val name: String, val age: Int) extends Ordered[Person] {
  override def compare(that: Person): Int = this.age - that.age
  override def toString: String = this.name + "\t" + this.age}

class CompareComm2[T <% Ordered[T]](obj1: T, obj2: T) {
  def getter = if (obj1 > obj2) obj1 else obj2
  def geatter2 = if (obj1.compareTo(obj2) > 0) obj1 else obj2
}
