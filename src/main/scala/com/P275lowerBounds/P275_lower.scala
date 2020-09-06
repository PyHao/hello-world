package com.P275lowerBounds

object P275_lower {
  def main(args: Array[String]): Unit = {

    biophony(Seq(new Earth, new Earth)).map(_.sound())

    biophony(Seq(new Animal, new Animal)).map(_.sound())

    //可以run，不能使用上界的思路推导
    /*
    1\和Animal直系的，是Animal父类的还是父类处理，是Animal子类的按照Animal处理，
    2）和Animal无关的，一律按照Object处理！

     */
    biophony(Seq(new Bird, new Bird)).map(_.sound())

    val res = biophony(Seq(new Bird))
    println("\nres=" + res)

    val res2 = biophony(Seq(new Object))
    val res3 = biophony(Seq(new Moon))
    println("\nres2=" + res2)
    println("\nres3=" + res2)

  }

  //下界
  def biophony[T >: Animal](things: Seq[T]) = things

}

class Earth { //Earth 类
  def sound() { //方法
    println("hello !")
  }
}

class Animal extends Earth {
  override def sound() = { //重写了Earth的方法sound()
    println("animal sound")
  }
}

class Bird extends Animal {
  override def sound() = { //将Animal的方法重写
    print("bird sounds")
  }
}

class Moon {}

