package com.DataStructure

// 0 可以走，还没有走  1 墙， 2 表示可以走  3 表示已经走过，但是是死路
//确定策略1  下右上左
//修改策略2  上右下左

object P34MiGong {
  def main(args: Array[String]): Unit = {

    //地圖
    val map = Array.ofDim[Int](8, 7)

    for (i <- 0 until 7) {
      map(0)(i) = 1
      map(7)(i) = 1
      map(i)(0) = 1
      map(i)(6) = 1
//      设置挡板
      map(3)(1) = 1
      map(3)(2) = 1
      map(4)(3) = 1
//      设置挡板2
//      map(1)(2) = 1
//      map(2)(2) = 1

    }

    for (i <- 0 until 8) {
      for (j <- 0 until 7) {
        print(map(i)(j) + "  ")
      }
      println()
    }

    //    测试方法
    setWay(map, 1, 1)
    println("============策略1===============")
//  打印新的地图
    for (i <- 0 until 8) {
      for (j <- 0 until 7) {
        print(map(i)(j) + "  ")
      }
      println()
    }

//    println("============策略2==============")
//    setWay2(map,1,1)
//    //  打印新的地图
//    for (i <- 0 until 8) {
//      for (j <- 0 until 7) {
//        print(map(i)(j) + "  ")
//      }
//      println()
//    }

  }

  //使用递归回溯
  //  1 map表示地图
  //  2 i j 指定从地图的哪个点开始出发
  def setWay(map: Array[Array[Int]], i: Int, j: Int): Boolean = {
    //    map(i)(j) = 2
    if (map(6)(5) == 2) {
      println("出来了")
      return true
    } else {
      if (map(i)(j) == 0) { //可以走，没走过
        //      开始递归回溯
        map(i)(j) = 2 //认为可以走通，但是不一定
        //开始策略 下
        if (setWay(map, i - 1, j)) { //上
          return true
        } else if (setWay(map, i, j + 1)) { //右
          return true
        } else if (setWay(map, i + 1, j)) { //下
          return true
        } else if (setWay(map, i, j - 1)) { //左
          return true
        } else {
          map(i)(j) = 3 //走不通
          return false
        }

      } else { //  <>0,即为 1,2,3,
        return false
      }

    }
  }


  def setWay2(map: Array[Array[Int]], i: Int, j: Int): Boolean = {
    //    map(i)(j) = 2
    if (map(6)(5) == 2) {
      println("出来了")
      return true
    } else {
      if (map(i)(j) == 0) { //可以走，没走过
        //      开始递归回溯
        map(i)(j) = 2 //认为可以走通，但是不一定
        //开始策略 下
        if (setWay2(map, i + 1, j)) { //下
          return true
        } else if (setWay2(map, i, j + 1)) { //右
          return true
        } else if (setWay2(map, i - 1, j)) { //上
          return true
        } else if (setWay2(map, i, j - 1)) { //左
          return true
        } else {
          map(i)(j) = 3 //走不通
          return false
        }

      } else { //  <>0,即为 1,2,3,
        return false
      }

    }
  }


}
