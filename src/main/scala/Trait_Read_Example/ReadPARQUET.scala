package Trait_Read_Example

import org.apache.spark.sql.{DataFrame, SparkSession}

class ReadPARQUET extends Read {
  override def read(sparkSession: SparkSession, path: String): DataFrame = {
    val dataSet = sparkSession.read.format("parquet")
      .load(path)

    dataSet
  }
}
