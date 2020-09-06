package com.P145dataStructure

object P214closure {
  def main(args: Array[String]): Unit = {
//    val a = "test.jpg"
//    println(a.split(".").toList)
    val f = makeSuffix(".jpg")
    println(f("a.jpg"))
    println(f("bbb"))
  }

  def makeSuffix(suffix:String) ={
    (filename:String)=> {
      if (filename.endsWith(suffix)) {
        filename
      } else {
        filename + suffix
      }
    }
  }

}
