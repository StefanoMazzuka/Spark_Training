package spark.sql

import utils.utils

/**
 * Created on 14/01/2020
 * Time 12:50H
 *
 * @author Stefano Mazzuka
 */
object app extends App {
  final val DF_LEFT = "left.csv"
  final val DF_RIGHT = "right.csv"

  val spark = utils.createSession()
  val dfLeft = utils.readDataset(spark, DF_LEFT)
  val dfRight = utils.readDataset(spark, DF_RIGHT)

  utils.show(dfLeft, "Left")
  utils.show(dfRight, "Right")

//  var dfResult = join.Cartesian(dfLeft, dfRight)
//  utils.show(dfResult, "Cartesian")

//  var dfResult = join.Inner(dfLeft, dfRight, dfLeft("id") === dfRight("id"))
//  utils.show(dfResult, "Inner")

//  var dfResult = join.Type(dfLeft, dfRight, dfLeft("id") === dfRight("id"), "left")
//  utils.show(dfResult, "Type")

//  var dfResult = join.InnerEquiColumns(dfLeft, dfRight, Seq[String]("id"))
//  utils.show(dfResult, "InnerEquiColumns")

//  var dfResult = join.EquiType(dfLeft, dfRight, Seq[String]("id"), "left")
//  utils.show(dfResult, "EquiType")

//  dfResult = join.InnerEquiColumn(dfLeft, dfRight, "id")
//  utils.show(dfResult, "InnerEquiColumn")
}