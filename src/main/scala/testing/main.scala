package testing

import org.apache.spark.sql.expressions.Window
import utils.utils
import org.apache.spark.sql.functions._

object main extends App {

  val sparkSession = utils.createSession()
  var df = utils.readDataset(sparkSession, "pricing.csv")

  utils.show(df, "Start")

  var window = Window.partitionBy("id", "id_2")
  df = df.withColumn("max", max("time") over window)
    .select("id", "id_2", "price")
    .where(col("time") === col("max")).distinct()

  utils.show(df, "End")
}
