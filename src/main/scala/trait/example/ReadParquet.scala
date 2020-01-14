package `trait`.example

import org.apache.spark.sql.{DataFrame, SparkSession}

class ReadParquet extends Read {
  override def read(sparkSession: SparkSession, path: String): DataFrame = {
    val dataSet = sparkSession.read.format("parquet")
      .load(path)

    dataSet
  }
}
