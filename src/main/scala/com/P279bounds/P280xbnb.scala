package com.P279bounds

/*
C[+T]：如果A是B的子类，那么C[A]是C[B]的子类，称为协变 
C[-T]：如果A是B的子类，那么C[B]是C[A]的子类，称为逆变 
C[T]：无论A和B是什么关系，C[A]和C[B]没有从属关系。称为不变
 */

object P280xbnb {
  def main(args: Array[String]): Unit = {

    //不变
    val t1:Temp3[Sub] = new Temp3[Sub]("hello")  //ok
//    val t2:Temp3[Sub] = new Temp3[Super]("hello")  //error
//    val t3:Temp3[Super] = new Temp3[Sub]("hello")  //error

//    协变
    val t4:Temp4[Sub] = new Temp4[Sub]("hello")  //ok
//    val t5:Temp4[Sub] = new Temp4[Super]("hello")  //error
    val t6:Temp4[Super] = new Temp4[Sub]("hello")  //ok

    // 逆变
    val t7:Temp5[Sub] = new Temp5[Sub]("hello")  //ok
    val t8:Temp5[Sub] = new Temp5[Super]("hello")  //ok
//    val t9:Temp5[Super] = new Temp5[Sub]("hello")  //error

  }

}


//不变
class Temp3[A](title:String){
  override def toString: String = {
    title
  }
}

//协变
class Temp4[+A](title:String){
  override def toString: String = {
    title
  }
}

//逆变
class Temp5[-A](title:String){
  override def toString: String = {
    title
  }
}

// 支持协变
class Super

class Sub extends Super