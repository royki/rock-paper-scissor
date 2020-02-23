ThisBuild / scalaVersion := "2.12.10" // "2.13.1"
ThisBuild / version := "0.1.0"

Global / onChangedBuildSource := IgnoreSourceChanges

watchTriggeredMessage := Watch.clearScreenOnTrigger

libraryDependencies ++= Seq(
  "org.scalactic" %% "scalactic" % "3.0.8",
  "org.scalatest" %% "scalatest" % "3.0.8" % "test",
  "org.scalacheck" %% "scalacheck" % "1.14.1" % "test",
  "com.github.alexarchambault" %% "scalacheck-shapeless_1.14" % "1.2.3",
  "org.pegdown" % "pegdown" % "1.6.0" % "test"
)

This / testOptions ++= Seq(
  Tests.Argument(TestFrameworks.ScalaTest, "-oSD"),
  Tests.Argument(TestFrameworks.ScalaTest, "-h", "target/test-reports"),
  Tests.Argument(TestFrameworks.ScalaCheck, "-s", "10")
)
// Test / testOptions += Tests.Argument(TestFrameworks.ScalaCheck, "-s", "10")

addCommandAlias("testc", ";clean;coverage;test;coverageReport")
coverageExcludedPackages := "Main"

// val `semanticdb-scalac` = "org.scalameta" % "semanticdb-scalac_2.13.0" % "4.2.0" // cross CrossVersion.full
addCompilerPlugin(
  // `semanticdb-scalac`
  scalafixSemanticdb
)

// ThisBuild / scalafixDependencies ++= Seq(
//   "com.geirsson" %% "example-scalafix-rule" % "1.3.0"
// )

// libraryDependencies += "com.geirsson" %% "example-scalafix-rule" % "1.3.0"

scalacOptions ++= Seq(
  "-deprecation",
  "-Ywarn-unused",
  "-Ywarn-unused-import",
  "-Yrangepos",
  "-Yno-adapted-args"
  // "-Ywarn-adapter-args"
)
