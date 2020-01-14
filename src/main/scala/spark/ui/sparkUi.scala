package spark.ui

import utils.utils

object sparkUi {

  def main(args: Array[String]): Unit = {
    val sparkSession = utils.createSession()

    val sparkContext = sparkSession.sparkContext
    val dataFrameStation = utils.readDataset(sparkSession, "201508_station_data.csv")
    val dataFrameTrip = utils.readDataset(sparkSession, "201508_trip_data.csv")
    val dataFrameMovies = utils.readDataset(sparkSession, "movies.csv")
    val dataFrameRatings = utils.readDataset(sparkSession, "ratings.csv")

    val l = sparkContext.parallelize(List(1, 1, 2, 3, 5, 8))
    val res = l.map(mul).reduce( max )
    println(res)

  }

  def mul(x: Int): Int = { x * 2 }

  def max(x: Int, y: Int): Int = { x max y }
}