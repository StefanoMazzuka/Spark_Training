package `trait`.example

import org.apache.spark.sql.{DataFrame, SparkSession}

trait Read {
  def read(sparkSession: SparkSession, path: String): DataFrame
}