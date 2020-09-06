package com.leecode

object T26 {
    def removeDuplicates(nums: Array[Int]): Int = {

      if (nums.length == 0) {
        println("0")
        return 0
      }
      var i = 0
      for (j <- 1 until nums.length){
        if (nums(i) != nums(j)) {
          i += 1
          nums(i) = nums(j)
        }
      }

      println(nums.mkString(" "))
      println("i:" + (i+1))
      return i+1

    }

    def removeDuplicates2(nums: Array[Int]): Int = {



    }

  def main(args: Array[String]): Unit = {

//    removeDuplicates(Array())
    removeDuplicates(Array(1,1,2,2,2,3,3,3))

  }

}
