package com.P81Package
import java.util.{HashMap=>JavaHashMap}
import collection.mutable.{HashMap=>ScalaHashMap,Map=>ScalaMap}

// 当继承了App后，就可以直接在这个类中执行代码，不需要main
// trait等价于java中的接口和抽象类

object P92ZuoYe4_2 extends App {

  val javaMap = new JavaHashMap[Int,String]  //[Int,String] 泛型
  javaMap.put(1,"A")   //加入4对key-value
  javaMap.put(2,"B")
  javaMap.put(3,"C")
  javaMap.put(4,"D")

  val scalaMap = new ScalaHashMap[Int,String]  //创建scala的hashmap

/*
1 javaMap.keySet().toArray() 将javaMap的key转成数组
2 key.asInstanceOf[Int] 将key转成Int类型
3 javaMap.get(key) 获取key对应的value
4 (key.asInstanceOf[Int] -> javaMap.get(key))  生成key-value
5 += 将key-value加入到scalaMap
 */

  for (key<- javaMap.keySet().toArray()){
    scalaMap += (key.asInstanceOf[Int] -> javaMap.get(key))
  }
  println(scalaMap.mkString(" "))
  println(scalaMap)

}
