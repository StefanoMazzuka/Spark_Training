package spark.sql

import org.apache.spark.sql.{Column, DataFrame}

/**
 * Created on 15/10/2019
 * Time 11:20H
 *
 * @author Stefano Mazzuka
 */
object join {

  // Cartesian join with another DataFrame
  def Cartesian(dfLeft: DataFrame, dfRight: DataFrame): DataFrame = {
    dfLeft.join(dfRight)
  }

  // Inner join with another DataFrame, using the given join expression.
  def Inner(dfLeft: DataFrame, dfRight: DataFrame, joinExprs: Column): DataFrame = {
    dfLeft.join(dfRight, joinExprs)
  }

  // Join with another DataFrame, using the given join expression and specifying the join type
  def Type(dfLeft: DataFrame, dfRight: DataFrame, joinExprs: Column, joinType: String): DataFrame = {
    dfLeft.join(dfRight, joinExprs, joinType)
  }

  // Inner equi-join with another DataFrame using the given columns
  def InnerEquiColumns(dfLeft: DataFrame, dfRight: DataFrame, usingColumns: Seq[String]): DataFrame = {
    dfLeft.join(dfRight, usingColumns)
  }

  // Equi-join with another DataFrame using the given columns
  def EquiType(dfLeft: DataFrame, dfRight: DataFrame, usingColumns: Seq[String], joinType: String): DataFrame = {
    dfLeft.join(dfRight, usingColumns, joinType)
  }

  // Inner equi-join with another DataFrame using the given column
  def InnerEquiColumn(dfLeft: DataFrame, dfRight: DataFrame, usingColumn: String): DataFrame = {
    dfLeft.join(dfRight, usingColumn)
  }
}