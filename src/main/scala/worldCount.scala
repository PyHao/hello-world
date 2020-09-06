import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object worldCount {
  def main(args: Array[String]): Unit = {

    val config = new SparkConf().setMaster("local[*]").setAppName("wordcount")
    val sc = new SparkContext(config)
    val listRDD: RDD[Int] = sc.parallelize(List(1,2,3,4))

//   读取文件时，传递的分区参数为最小分区数，但不一定是这个分区数，取决于hadoop读取文件分片规则
    val fileRDD: RDD[String] = sc.textFile("in",2)
//    listRDD.saveAsTextFile("output")
    fileRDD.saveAsTextFile("output")

    println(sc)
  }
}
