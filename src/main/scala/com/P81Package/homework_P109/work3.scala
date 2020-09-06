package com.P81Package.homework_P109

object work3 {

  def main(args: Array[String]): Unit = {

    var m1 = new master
    m1.xm = "hao"
    m1.money = 100.0
    m1.bonus = 500
    m1.getAnnual

    showEmpAnnal(m1)
    testWork(m1)

  }

  class emp {
    var xm = ""
    var money = 0.0

    def getAnnual: Unit ={
      println("年工资:" + 12*money)
    }
  }

  class worker extends emp{

    def work: Unit ={
      println("work function")
    }

    override def getAnnual: Unit = {
      println("年薪:" + 13*money)
    }
  }


  class master extends emp{

    var bonus = 0.0
    def manage: Unit ={
      println("manage function")
    }

    override def getAnnual: Unit = {
      println("年薪:" + (bonus+12*money))
    }

  }


    def showEmpAnnal(e: emp): Unit ={
      e.getAnnual
    }

    def testWork(w:emp): Unit ={
      if (w.isInstanceOf[worker]){
        w.asInstanceOf[worker].work
      } else if (w.isInstanceOf[master]){
        w.asInstanceOf[master].manage
      } else {
        println("非员工，没有工作方法")
      }
    }



}

