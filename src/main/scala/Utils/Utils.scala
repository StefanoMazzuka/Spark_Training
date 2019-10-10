package Utils

import org.apache.spark.sql.{DataFrame, Row, SparkSession}
import org.apache.spark.{SparkConf, SparkContext}

import scala.swing.{MainFrame, ScrollPane, Table}

/**
 * @author Stefano Mazzuka
 */
object Utils {

  /**
   * Change to your datasets path
   */
  val datasetPath: String = "src\\main\\resources\\"

  /**
   * Create a spark session
   * @return Returns a spark session
   */
  def createSession(): SparkSession = {
    val sparkSession = SparkSession.builder()
      .master("local[*]")
      .appName("SparkTraining")
      .getOrCreate()

    sparkSession
  }

  /**
   * Create a spark context
   * @return Returns a spark context
   */
  def createContext(): SparkContext = {
    val sparkConf = new SparkConf()
      .setAppName("SparkTraining")
      .setMaster("local")

    new SparkContext(sparkConf)
  }

  /**
   * Read a dataset
   * @param sparkSession Your spark session
   * @param name Name of the dataset to read
   * @return Returns a dataframe
   */
  def readDataset(sparkSession: SparkSession, name: String): DataFrame = {
    val dataSet = sparkSession.read.format("csv")
      .option("header", "true")
      .option("inferSchema", "true")
      .load(datasetPath + name)

    dataSet
  }

  /**
   * Show a dataframe on a GUI
   * @param dataFrame Dataframe to show
   * @param name Dataframe's name (optional)
   */
  def show(dataFrame: DataFrame, name: String = "Happy show"): Unit = {
    val guiDataFrame = new GUIDataFrame(dataFrame, name)
    guiDataFrame.visible = true
  }

  /**
   * GUI to display a dataframe
   * @param dataFrame Dataframe to show
   * @param name GUI title
   */
  class GUIDataFrame(dataFrame: DataFrame, name: String) extends MainFrame {
    title = name

    val headers = dataFrame.columns.toSeq
    val rowData = dataFrame.select(dataFrame.columns.head, dataFrame.columns.tail: _*)
      .rdd.map{r: Row => r.toSeq.toArray}.collect()

    contents = new ScrollPane {
      val table = new Table(rowData, headers)
      table.enabled = false
      contents = table
    }
  }
}
