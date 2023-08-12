name := """evolutions-path-config"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)
  .configs(IntegrationTest)
  .settings(
    Defaults.itSettings
  )

scalaVersion := "2.13.11"

libraryDependencies += guice
libraryDependencies += jdbc
libraryDependencies += evolutions
libraryDependencies += "com.h2database" % "h2" % "2.2.220"

libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "6.0.0-M6" % IntegrationTest
