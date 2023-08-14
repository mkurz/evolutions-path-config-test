lazy val root = (project in file("."))
  //.enablePlugins(PlayScala)
  .settings(
    name := "evolutions-path-config",
    scalaVersion := "2.13.11",
    libraryDependencies ++= Seq(
      guice,
      jdbc,
      evolutions,
      "com.h2database" % "h2" % "2.2.220",
    )
  )

lazy val itTests = (project in file("integration-tests"))
  .enablePlugins(PlayScala)
  .dependsOn(root)
  .settings(
    name := "evolutions-path-config-integration-tests",
    scalaVersion := "2.13.11",
    publish / skip := true,
    // test dependencies
    libraryDependencies ++= Seq(
      "org.scalatestplus.play" %% "scalatestplus-play" % "6.0.0-M6" % Test
    )
  )
