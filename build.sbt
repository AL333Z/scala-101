name := "scala-101"

version := "1.0"

scalaVersion := "2.11.8"

lazy val rxScala = Seq(
  "io.reactivex" % "rxjava" % "1.0.14",
  "io.reactivex" % "rxjava-reactive-streams" % "1.0.1",
  "io.reactivex" %% "rxscala" % "0.25.0"
)

lazy val twitterLibs = Seq(
  "org.twitter4j" % "twitter4j-core" % "4.0.2",
  "org.twitter4j" % "twitter4j-stream" % "4.0.2"
)

lazy val utils = Seq(
  "com.typesafe" % "config" % "1.2.0"
)

libraryDependencies ++= rxScala ++ twitterLibs ++ utils
