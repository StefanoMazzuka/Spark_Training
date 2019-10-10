package SparkUI

import Utils.Utils

object SparkUI {

  def main(args: Array[String]): Unit = {
    val sparkSession = Utils.createSession()

    val sparkContext = sparkSession.sparkContext
    val dataFrameStation = Utils.readDataset(sparkSession, "201508_station_data.csv")
    val dataFrameTrip = Utils.readDataset(sparkSession, "201508_trip_data.csv")
    val dataFrameMovies = Utils.readDataset(sparkSession, "movies.csv")
    val dataFrameRatings = Utils.readDataset(sparkSession, "ratings.csv")

    val l = sparkContext.parallelize(List(1, 1, 2, 3, 5, 8))
    val res = l.map( mul ).reduce( max )
    println(res)
  }

  def mul(x: Int): Int = { x * 2 }

  def max(x: Int, y: Int): Int = { x max y }
}
