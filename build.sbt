lazy val commonSettings = Seq(
  name := "fat-jar-latest",
  version := "1.0",
  scalaVersion := "2.12.13"
)

lazy val app = (project in file(".")).
  settings(commonSettings: _*)

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-sql" % "3.1.1" % "provided",
  "org.apache.spark" %% "spark-core" % "3.1.1"
)

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}
