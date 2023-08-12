lazy val root = Project("integration-tests", file(".")).enablePlugins(PlayScala)
  .settings(
    scalaVersion := "2.13.11",
    libraryDependencies ++= Seq(
    "org.scalatestplus.play" %% "scalatestplus-play" % "6.0.0-M6" % Test,
    evolutions % Test,
    jdbc % Test,
    guice % Test,
    "com.h2database" % "h2" % "2.2.220" % Test,
    ),
  )
