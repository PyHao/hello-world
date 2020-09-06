package com.P279bounds

object P279bounds {
  //  定义一个隐式值 Ordering[Person] 类型
  implicit val personComparetor = new Ordering[Person] {
    override def compare(p1: Person, p2: Person): Int =
      p1.age - p2.age
  }


  def main(args: Array[String]): Unit = {

    val p1 = new Person("CK", 20)
    val p2 = new Person("TT", 50)
    val compareComm4 = new CompareComm4(p1, p2)
    println(compareComm4.geatter)

    val compareComm5 = new CompareComm5(p1, p2)
    println(compareComm5.geatter)

    println("personComparetor hashcode = " + personComparetor.hashCode())

    val compareComm6 = new CompareComm6(p1, p2)
    println(compareComm6.geatter)

  }

}

class Person(val name: String, val age: Int) {
  override def toString = this.name + "\t" + this.age

}

// 方式一：
//[T:Ordering] 泛型
//obj1:T,obj2:T 接受T类型的对象
//implicit comparetor:Ordering[T] 是一个隐式参数

class CompareComm4[T: Ordering](obj1: T, obj2: T)(implicit comparetor: Ordering[T]) {
  def geatter = if (comparetor.compare(obj1, obj2) > 0) obj1 else obj2
}

// 方式二： 将隐式参数放到方法体内

class CompareComm5[T: Ordering](o1: T, o2: T) {
  def geatter = {
    def f1(implicit cmptor: Ordering[T]) = cmptor.compare(o1, o2)

    if (f1 > 0) o1 else o2
  }

  def lower = {
    def f1(implicit cmptor: Ordering[T]) = cmptor.compare(o1, o2)

    if (f1 > 0) o2 else o1
  }
}

// 方式三，推荐使用，最简单，使用 implicitly 语法糖
class CompareComm6[T:Ordering](o1:T,o2:T){
  def geatter = {
//    这句话会发生隐式转换，获取到隐式值 personComparetor
//    底层使用编译器完成绑定（赋值）
    val comparetor = implicitly[Ordering[T]]

    println("CompareComm6 comparetor" + comparetor.hashCode())
    if (comparetor.compare(o1,o2)>0) o1 else o2
  }
}