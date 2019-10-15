package Utils

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.{SparkConf, SparkContext}

import scala.swing.{MainFrame, ScrollPane, Table}

/**
 * @author Stefano Mazzuka
 */
object Utils {

  /**
   * Change to your datasets path
   */
  val DATASET_PATH: String = "src\\main\\resources\\"
  val MAX_ROWS: Int = 20000

  /**
   * Create a spark session
   *
   * @return Returns a spark session
   */
  def createSession(): SparkSession = {
    SparkSession.builder()
      .master("local[*]")
      .appName("SparkTraining")
      .getOrCreate()
  }

  /**
   * Create a spark context
   *
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
   *
   * @param sparkSession Your spark session
   * @param name         Name of the dataset to read
   * @return Returns a dataframe
   */
  def readDataset(sparkSession: SparkSession, name: String): DataFrame = {
    sparkSession.read.format("csv")
      .option("header", "true")
      .option("inferSchema", "true")
      .load(DATASET_PATH + name)
  }

  /**
   * Show a dataframe on a GUI
   *
   * @param dataFrame Dataframe to show
   * @param name      Dataframe's name (optional)
   */
  def show(dataFrame: DataFrame, name: String = "Happy show"): Unit = {
    val guiDataFrame = new GUIDataFrame(dataFrame, name)
    guiDataFrame.visible = true
  }

  /**
   * GUI to display a dataframe
   *
   * @param dataFrame Dataframe to show
   * @param name      GUI title
   */
  class GUIDataFrame(dataFrame: DataFrame, name: String) extends MainFrame {
    title = name

    var rows = dataFrame.count().toInt
    if (rows > MAX_ROWS) rows = MAX_ROWS

    val headers = dataFrame.columns
    val model = dataFrame.collect().map(r => r.toSeq.toArray)

    contents = new ScrollPane {
      contents = new Table(model, headers) {
        enabled = false
      }
    }
  }

}