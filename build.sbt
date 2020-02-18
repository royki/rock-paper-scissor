ThisBuild / scalaVersion := "2.12.10" // "2.13.1"
ThisBuild / version := "0.1.0"

Global / onChangedBuildSource := IgnoreSourceChanges

watchTriggeredMessage := Watch.clearScreenOnTrigger

libraryDependencies ++= Seq(
  "org.scalactic" %% "scalactic" % "3.0.8",
  "org.scalatest" %% "scalatest" % "3.0.8" % "test",
  "org.pegdown" % "pegdown" % "1.6.0" % "test"
)

testOptions in Test ++= Seq(
  Tests.Argument(TestFrameworks.ScalaTest, "-oSD"),
  Tests.Argument(TestFrameworks.ScalaTest, "-h", "target/test-reports")
)

addCommandAlias("testc", ";clean;coverage;test;coverageReport")

coverageExcludedPackages := "Main"
