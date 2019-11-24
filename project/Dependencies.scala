import sbt._

object Dependencies {
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.5"

  lazy val awsLambdaJavaCore = "com.amazonaws" % "aws-lambda-java-core" % "1.2.0"
  lazy val sprayJson = "io.spray" %% "spray-json" % "1.3.5"
  lazy val lettuceCore = "io.lettuce" % "lettuce-core" % "5.2.1.RELEASE"

  lazy val Deps = Seq(
    scalaTest % Test,
    awsLambdaJavaCore,
    sprayJson,
    lettuceCore
  )
}
