package Trait_Read_Example

import Utils.Utils

object Example extends App {

  val sparkSession = Utils.createSession()

  val readCSV = new ReadCSV
  var dataFrameAnimals = readCSV.read(sparkSession, "Animals.csv")
  //dataAnimals.write.parquet("src\\main\\resources\\Animals.parquet")
  dataFrameAnimals.dropDuplicates().show()

  val readPARQUET = new ReadPARQUET
  dataFrameAnimals = readPARQUET.read(sparkSession, "Animals.parquet")
  dataFrameAnimals.dropDuplicates().show()
}
