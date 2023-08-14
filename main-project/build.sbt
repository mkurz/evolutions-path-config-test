name := """evolutions-path-config"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)
  .dependsOn(itTests)
  .aggregate(itTests)

lazy val itTests = ProjectRef(file("../integration-tests"), "integration-tests")

scalaVersion := "2.13.11"

libraryDependencies += guice
libraryDependencies += jdbc
libraryDependencies += evolutions
libraryDependencies += "com.h2database" % "h2" % "2.2.220"

libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "6.0.0-M6" % Test

PlayKeys.includeDocumentationInBinary := false

//In Windows when "input path is too long" or similar message
//scriptClasspath := Seq("*")

//PlayKeys.externalizeResources := false

//Universal / mappings ++= (baseDirectory.value / "asdf" ** "*").get.map {
//  (f: File) => f -> f.relativeTo(baseDirectory.value).get.toString
//}
