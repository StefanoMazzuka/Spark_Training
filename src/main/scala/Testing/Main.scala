package Testing

import Utils.Utils

object Main extends App {
  var sparkSession = Utils.createSession()
  var dfMovies = Utils.readDataset(sparkSession, "movies.csv")
  Utils.show(dfMovies)
}