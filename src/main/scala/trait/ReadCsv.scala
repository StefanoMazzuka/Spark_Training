package `trait`

import org.apache.spark.sql.{DataFrame, SparkSession}

class ReadCsv extends Read {
  override def read(sparkSession: SparkSession, path: String): DataFrame = {
    val dataSet = sparkSession.read.format("csv")
      .option("header", "true")
      .option("inferSchema", "true")
      .load(path)

    dataSet
  }
}
