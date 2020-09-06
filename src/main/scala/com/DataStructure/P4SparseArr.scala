package com.DataStructure

import scala.collection.mutable.ArrayBuffer

object P4SparseArr {
  def main(args: Array[String]): Unit = {

    val rowSize = 11
    val colSize = 11

//    演示一个稀疏数组使用
    val chessMap = Array.ofDim[Int](rowSize,colSize)     //n1 是行，n2 是列
    chessMap(1)(2) = 1  // 1是黑
    chessMap(2)(3) = 2  // 2是白

//    println(chessMap(1).length)

//    println(chessMap(1)(2))
//    println(chessMap(1)(1))
    //输出原始数组
    for (items <- chessMap){
      for (item <- items){
        printf("%d\t",item )
      }
      println()
    }

    //将chessMap转成稀疏数组    目的是达到数据的压缩
//    class Node(row,col,value)   ArrayBuffer

    val sparseArr = ArrayBuffer[Node]()
    val node = new Node(rowSize,colSize,0)
    sparseArr.append(node)

    for (i <- 0 until(chessMap.length)){   //chessMap.length  是行
      for (j <- 0 until(chessMap(i).length)){      //chessMap(i).length  是列
        if (chessMap(i)(j) != 0){
//          构建一个node
          val node = new Node(i,j,chessMap(i)(j))
//          sparseArr += node      等价 sparseArr.append(node)
          sparseArr.append(node)
        }
      }
    }
//输出稀疏数组
    println("------------稀疏数组------------")
    for (node <- sparseArr){
      printf("%d\t%d\t%d\t\n",node.row,node.col,node.value)
    }

//    存盘

//    读盘 -》 稀疏数组

//    恢复  从稀疏数组-》原始数组

//    读取稀疏数组的第一个节点

    val newNode = sparseArr(0)
    val rowSize2 = newNode.row
    val colSize2 = newNode.col
//    println(rowSize2,colSize2)

    val chessMap2 = Array.ofDim[Int](rowSize2,colSize2)
//    println(sparseArr.length)      //3
    for (i <- 1 until(sparseArr.length)){
      val node = sparseArr(i)
      chessMap2(node.row)(node.col) = node.value
    }


  }

}

class Node(val row:Int,val col:Int,val value:Int)
