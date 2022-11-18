ThisBuild / scalaVersion := "2.13.8"

ThisBuild / version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    name := """commonplace-neo4j-spike-scala""",
    libraryDependencies ++= Seq(
      guice,
//      "io.github.classgraph" % "classgraph" % "4.8.149",
      "org.neo4j.driver" % "neo4j-java-driver" % "4.3.5",
      "org.neo4j" % "neo4j-ogm-core" % "3.2.37",
      "org.neo4j" % "neo4j-ogm-bolt-driver" % "3.2.37",
      "com.softwaremill.common" %% "id-generator" % "1.4.0",
      "org.scalatestplus.play" %% "scalatestplus-play" % "5.1.0" % Test,
    )
  )
