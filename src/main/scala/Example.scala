object Example extends App {

  val animalsCSV = Utils.getDatasetPath("Animals.csv")
  val animalsParquet = Utils.getDatasetPath("Animals.parquet")

  val sparkSession = Utils.createSession()
  val readCSV = new ReadCSV
  var dataFrameAnimals = readCSV.read(sparkSession, animalsCSV)
  //dataAnimals.write.parquet("src\\main\\resources\\Animals.parquet")
  dataFrameAnimals.dropDuplicates().show()

  val readPARQUET = new ReadPARQUET
  dataFrameAnimals = readPARQUET.read(sparkSession, animalsParquet)
  dataFrameAnimals.dropDuplicates().show()
}