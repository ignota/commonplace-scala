ThisBuild / scalaVersion := "2.13.8"

ThisBuild / version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    name := """commonplace-neo4j-spike-scala""",
    libraryDependencies ++= Seq(
      guice,
      "org.neo4j.driver" % "neo4j-java-driver" % "4.4.9",
      "org.scalatestplus.play" %% "scalatestplus-play" % "5.1.0" % Test,
    )
  )
