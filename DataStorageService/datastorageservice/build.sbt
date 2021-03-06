name := "DataStorageService"
version := "0.1-SNAPSHOT"
organization := "newcastleuniversity.joehonour"
scalaVersion in ThisBuild := "2.11.7"

val flinkVersion = "1.4.1"

val flinkDependencies = Seq(
  "org.apache.flink" %% "flink-scala" % flinkVersion % "provided",
  "org.apache.flink" %% "flink-streaming-scala" % flinkVersion % "provided",
  "org.apache.flink" %% "flink-connector-kafka-0.11" % flinkVersion)

val jsonParsingDependencies = Seq(
  "org.json4s" %% "json4s-native" % "3.6.0-M2",
  "org.json4s" %% "json4s-jackson" % "3.6.0-M2"
)

val neo4jDependencies = Seq(
  "org.neo4j.driver" % "neo4j-java-driver" % "1.0.4"
)

lazy val root = (project in file(".")).
  settings(
    libraryDependencies ++= flinkDependencies,
    libraryDependencies ++= jsonParsingDependencies,
    libraryDependencies ++= neo4jDependencies
  )

mainClass in assembly := Some("newcastleuniversity.joehonour.Main")

// make run command include the provided dependencies
run in Compile := Defaults.runTask(fullClasspath in Compile,
                                   mainClass in (Compile, run),
                                   runner in (Compile,run)
                                  ).evaluated

// exclude Scala library from assembly
assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false)
