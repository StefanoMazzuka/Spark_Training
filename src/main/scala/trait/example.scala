package `trait`

import utils.utils

object example extends App {

  val sparkSession = utils.createSession()

  val readCSV = new ReadCsv
  var dataFrameAnimals = readCSV.read(sparkSession, "Animals.csv")
  //dataAnimals.write.parquet("src\\main\\resources\\Animals.parquet")
  dataFrameAnimals.dropDuplicates().show()

  val readPARQUET = new ReadParquet
  dataFrameAnimals = readPARQUET.read(sparkSession, "Animals.parquet")
  dataFrameAnimals.dropDuplicates().show()
}
