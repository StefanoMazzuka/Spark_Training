package spark.ui

import utils.utils

object sparkUi {

  def main(args: Array[String]): Unit = {
    val sparkSession = utils.createSession()

    val sparkContext = sparkSession.sparkContext

    val l = sparkContext.parallelize(List(1, 1, 2, 3, 5, 8))
    val res = l.map(mul).reduce( max )
    println(res)

  }

  def mul(x: Int): Int = { x * 2 }

  def max(x: Int, y: Int): Int = { x max y }
}