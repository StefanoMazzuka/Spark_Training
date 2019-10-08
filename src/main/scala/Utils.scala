import org.apache.spark.sql.types.IntegerType
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{Column, DataFrame, RelationalGroupedDataset, SparkSession}

object Utils {

  def getDatasetPath(datasetName: String): String = {
    "C:\\Users\\smazzuka\\Desktop\\Datasets\\"
  }

  def createSession(): SparkSession = {
    val sparkSession = SparkSession.builder()
      .master("local[*]")
      .appName("SparkTraining")
      .getOrCreate()

    sparkSession
  }

  def createContext(): SparkContext = {
    val sparkConf = new SparkConf()
      .setAppName("SparkTraining")
      .setMaster("local")

    new SparkContext(sparkConf)
  }

  def readDataFrame(sparkSession: SparkSession, path: String): DataFrame = {
    val dataSet = sparkSession.read.format("csv")
      .option("header", "true")
      .option("inferSchema", "true")
      .load(path)

    dataSet
  }

  def toMinutes(col: Column): Column = (col / 60).cast(IntegerType)

  def joinByMovieID(sparkSession: SparkSession, dataFrameMovies: DataFrame, dataFrameRatings: DataFrame): Unit = {
    dataFrameMovies.createOrReplaceTempView("movies")
    dataFrameRatings.createOrReplaceTempView("ratings")

    val qry =
      "SELECT movies.movieId, movies.title, movies.genres, ratings.userId, ratings.rating, ratings.timestamp " +
        "FROM movies " +
        "INNER JOIN ratings " +
        "ON movies.movieId = ratings.movieId"

    sparkSession.sql(qry).show()
  }

  def clomunToList(sparkSession: SparkSession, dataFrame: DataFrame, col: String): List[Any] = {
    dataFrame.select(col).collect().toList
  }

  def groupBy(dataFrame: DataFrame, col: String): RelationalGroupedDataset = {
    dataFrame.groupBy(col)
  }

  def deleteDuplicates(dataFrame: DataFrame, col: String) : DataFrame = {
    dataFrame.dropDuplicates(col)
    dataFrame
  }
}