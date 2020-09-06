package com.P130Package

object P139ImplicitClass {
  def main(args: Array[String]): Unit = {

    implicit class DB1(db: MySql1){
      def addSuffix(): Unit ={
        println(db + " scala")
      }
    }

    val mysql = new MySql1
    mysql.sayOk()
    mysql.addSuffix()     // DB1$1(MySql).addSuffix

  }

  class MySql1{
    def sayOk(): Unit ={
      println("sayOK!")
    }
  }

}
