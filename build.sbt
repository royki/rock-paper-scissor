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

testOptions in Test ++= Seq(
  Tests.Argument(TestFrameworks.ScalaTest, "-oSD"),
  Tests.Argument(TestFrameworks.ScalaTest, "-h", "target/test-reports"),
  Tests.Argument(TestFrameworks.ScalaCheck, "-s", "10")
)
// Test / testOptions += Tests.Argument(TestFrameworks.ScalaCheck, "-s", "10")

addCommandAlias("testc", ";clean;coverage;test;coverageReport")
coverageExcludedPackages := "Main"

scalacOptions ++= Seq(
  "-deprecation",
  "-Ywarn-unused"
)
