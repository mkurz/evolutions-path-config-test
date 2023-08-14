name := """evolutions-path-config"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    scalaVersion := "2.13.11",
    libraryDependencies ++= Seq(
      jdbc,
    )
  )

lazy val itTests = (project in file("integration-tests")).enablePlugins(PlayScala)
  .dependsOn(root)
  .settings(
    scalaVersion := "2.13.11",
    publish / skip := true,
    // test dependencies
    libraryDependencies ++= Seq(
      guice,
      jdbc,
      evolutions,
      "com.h2database" % "h2" % "2.2.220" % Test,
      "org.scalatestplus.play" %% "scalatestplus-play" % "6.0.0-M6" % Test
    )
  )

scalaVersion := "2.13.11"

PlayKeys.includeDocumentationInBinary := false

//In Windows when "input path is too long" or similar message
//scriptClasspath := Seq("*")

//PlayKeys.externalizeResources := false

//Universal / mappings ++= (baseDirectory.value / "asdf" ** "*").get.map {
//  (f: File) => f -> f.relativeTo(baseDirectory.value).get.toString
//}
