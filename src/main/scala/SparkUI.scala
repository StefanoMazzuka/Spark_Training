import org.apache.spark.sql.types.{DecimalType, IntegerType}
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{Column, DataFrame, SparkSession, functions}
import spire.implicits


object SparkUI {
  val station = "src\\main\\resources\\201508_station_data.csv"
  val trip = "src\\main\\resources\\201508_trip_data.csv"
  val movies = "src\\main\\resources\\movies.csv"
  val ratings = "src\\main\\resources\\ratings.csv"

  def main(args: Array[String]): Unit = {
    val sparkSession = Utils.createSession()

    import sparkSession.implicits._

    val sparkContext = sparkSession.sparkContext
    val dataFrameStation = Utils.readDataFrame(sparkSession, station)
    val dataFrameTrip = Utils.readDataFrame(sparkSession, trip)
    val dataFrameMovies = Utils.readDataFrame(sparkSession, movies)
    val dataFrameRatings = Utils.readDataFrame(sparkSession, ratings)

    val l = sparkContext.parallelize(List(1, 1, 2, 3, 5, 8))
    val res = l.map( mul ).reduce( max )
    println(res)
  }

  def mul(x: Int): Int = { x * 2 }

  def max(x: Int, y: Int): Int = { x max y }
}