package buildExample

import org.apache.spark.sql.SparkSession

object helloworld {
  def main(args: Array[String]): Unit = {
    println("Hello, Spark!")

    val spark = SparkSession.builder()
      .master("local[*]")
      .appName("SparkByExample")
      .getOrCreate();

    val path = args(0)

    println(s"Path:${path}")

    spark.read.format("csv")
      .option("inferSchema","true")
      .option("header","true")
      .load(path).show(10)

    spark.stop()

  }
}
