name := "bermuda"

version := "0.1"

scalaVersion := "2.12.6"


val akkaVersion = "2.5.13"
val akkaHttpVersion = "10.1.1"
val scalaTest = "3.0.5"
val poi = "3.17"
libraryDependencies += "com.typesafe.akka" %% "akka-actor" % akkaVersion
libraryDependencies += "com.typesafe.akka" %% "akka-stream" % akkaVersion
libraryDependencies += "com.typesafe.akka" %% "akka-stream-testkit" % akkaVersion
libraryDependencies += "com.typesafe.akka" %% "akka-http" % akkaHttpVersion
libraryDependencies += "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion
libraryDependencies += "org.apache.poi" % "poi" % poi
libraryDependencies += "org.apache.poi" % "poi-ooxml" % poi
libraryDependencies += "org.apache.poi" % "poi-ooxml-schemas" % poi
libraryDependencies += "org.scalactic" %% "scalactic" % scalaTest
libraryDependencies += "org.scalatest" %% "scalatest" % scalaTest % "test"
libraryDependencies += "com.lightbend.akka" %% "akka-stream-alpakka-ftp" % "0.19"
resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"
addSbtPlugin("com.artima.supersafe" % "sbtplugin" % "1.1.3")
