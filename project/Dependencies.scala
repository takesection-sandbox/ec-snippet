import sbt._

object Dependencies {
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.5"

  lazy val lettuceCore = "io.lettuce" % "lettuce-core" % "5.2.1.RELEASE"

  lazy val Deps = Seq(
    scalaTest % Test,
    lettuceCore
  )
}
