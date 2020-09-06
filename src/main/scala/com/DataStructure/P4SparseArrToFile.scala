package com.DataStructure

import java.io.{File, FileWriter, PrintWriter}

import scala.collection.mutable.ArrayBuffer
import scala.io.Source

object P4SparseArrToFile {
  def main(args: Array[String]): Unit = {

    val rowSize = 11
    val colSize = 13
    val chessMap = Array.ofDim[Int](rowSize,colSize)

    chessMap(3)(1) = 1
    chessMap(5)(4) = 2

//    for(items <- chessMap){
//      for (item <- items){
//        printf("%d\t",item)
//      }
//      println()
//    }
    //转成稀疏数组

    val sparseArr = ArrayBuffer[Node]()
    val node = new Node(rowSize,colSize,0)
    sparseArr.append(node)

    for(i<- 0 until(chessMap.length)){
      for (j <- 0 until(chessMap(i).length)){
        if(chessMap(i)(j) != 0){
          val node = new Node(i,j,chessMap(i)(j))
          sparseArr.append(node)
        }
      }
    }

//    将稀疏数组存盘
//    val out = new FileWriter("D:\\project_HAO\\spark02\\src\\main\\scala\\com\\DataStructure\\map.data",true)
//    for (node <- sparseArr){
//      out.write(node.row.toString,node.col.toString,node.value.toString)
//      out.close()
//    }

//    存盘是  怎么去掉括号 ？？？？？？？？？
//    (11,13,0)
////    (3,1,1)
////    (5,4,2)
    val writer = new PrintWriter(new File("D:\\project_HAO\\spark02\\src\\main\\scala\\com\\DataStructure\\map.data"))
    for (node <- sparseArr){
//      printf("%d\t",node.row,node.col,node.value)
//      for(j<- 0 until(sparseArr(i).length))
      writer.println(node.row,node.col,node.value)
//      writer.printf("%d\t%d\t%d\t\n",node.row,node.col,node.value)
    }
    writer.close()

    //读取 存盘的文件，对稀疏数组进行恢复
    val file = Source.fromFile("D:\\project_HAO\\spark02\\src\\main\\scala\\com\\DataStructure\\map.data")
    for (line <- file.getLines){
//      val newNode = line(1)
      println(line)
    }
    file.close()



  }




}

class Node(val row:Int,val col:Int,val value:Int)
