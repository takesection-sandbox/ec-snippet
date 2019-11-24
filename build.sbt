import Dependencies._

ThisBuild / scalaVersion     := "2.12.8"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.pigumer"
ThisBuild / organizationName := "ec-snippet"

lazy val root = (project in file("."))
  .settings(
    name := "ec-snippet",
    libraryDependencies ++= Deps
  )

