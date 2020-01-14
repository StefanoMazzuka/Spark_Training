package spark.sql

import utils.utils

/**
 * Created on 14/01/2020
 * Time 9:35H
 *
 * @author Stefano Mazzuka
 */

// A DataFrame is a tag for a Dataset[Row]
object dataFrame {

  var sparkSession = utils.createSession()
  var df = utils.readDataset(sparkSession, "Animals.csv")

  // Returns a new DataFrame with an alias set
  var aliasDf = df.alias("df alias")
  aliasDf = df.as("df alias")

  // Selects column based on the column name and return it as a Column
  var newCol = df.apply("Age")
  newCol = df.col("Age")

  // Returns a new DataFrame that has exactly numPartitions partitions
  val dfPartitioned = df.coalesce(5)

  // Returns an array that contains all of Rows in this DataFrame
  val rowsArray = df.collect()

  // Returns a Java list that contains all of Rows in this DataFrame
  val rowsList = df.collectAsList()

  // Returns all column names as an array
  val columNames = df.columns

  // Returns the number of rows in the DataFrame
  val numRows = df.count()

  // Create a multi-dimensional cube for the current DataFrame using the specified columns, so we can run aggregation on them
  val groupedData = df.cube("Age", "Race")

  // Computes statistics for numeric columns, including count, mean, stddev, min, and max
  println(df.describe("Age"))

  // Returns a new DataFrame that contains only the unique rows from this DataFrame
  var dfDistinct = df.distinct()
  dfDistinct = df.dropDuplicates("Race")

}