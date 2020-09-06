package com.P81Package.homework_P109

import sun.plugin2.gluegen.runtime.CPU

/*
编写Computer类，包含CPU、内存、硬盘等属性，getDetails方法用于返回Computer的详细信息
编写PC子类，继承Computer类，添加特有属性【品牌brand】
编写NotePad子类，继承Computer类，添加特有属性【颜色color】
编写Test Object，在main方法中创建PC和NotePad对象，分别对象中特有的属性赋值，以及从Computer类继承的属性赋值，并使用方法并打印输出信息。
 */
object Computer_Class {
  def main(args: Array[String]): Unit = {

    val tp = new Computer()
    tp.cpu = "i7"
    tp.cache = "256"
    tp.disk = "1T"

    tp.getDetails()
println("==================================")

    val pc = new PC()
    pc.cpu = "i7"
    pc.cache = "512G"
    pc.disk = "5T"
    pc.brand = "ThinkerPad"
    pc.getDetails()


//    val C2 = new PC("i5","11","12")


  }

//  class Computer(CPU:String,nc:String,cipan:String){
//    val cpu = CPU
//    val cache = nc
//    val disk = cipan
  class Computer(){
      var cpu = ""
      var cache = ""
      var disk = ""

    def getDetails():Unit={
//      printf("CPU is %s,\ncache is %s,\ndisk is %s",CPU,nc,cipan)
      printf("CPU is %s,\ncache is %s,\ndisk is %s\n",cpu,cache,disk)
    }
  }

  class PC extends Computer{
    var brand = ""

  }
}
