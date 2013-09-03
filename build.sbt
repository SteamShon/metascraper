name := "metascraper"

version := "0.0.1"

scalaVersion := "2.10.2"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "1.9.1" % "test",
  "com.typesafe.akka" %% "akka-testkit" % "2.2.1",
  "com.typesafe.akka" %% "akka-agent" % "2.2.1",
  "com.typesafe" %% "scalalogging-slf4j" % "1.0.1",
  "org.jsoup" % "jsoup" % "1.7.2",
  "org.slf4j" % "slf4j-api" % "1.7.1",
  "ch.qos.logback" % "logback-classic" % "1.0.3"
)

testOptions in Test += Tests.Setup(classLoader =>
  classLoader
    .loadClass("org.slf4j.LoggerFactory")
    .getMethod("getLogger", classLoader.loadClass("java.lang.String"))
    .invoke(null, "ROOT")
)
