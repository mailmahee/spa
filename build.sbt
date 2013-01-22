organization := "com.github.chesterxgchen,spa"

name := "spa"

version := "0.1.0-SNAPSHOT"

unmanagedBase := file( "lib" ).getAbsoluteFile

libraryDependencies += "org.testng" % "testng" % "6.8"

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.22"

seq(testNGSettings:_*)

testNGVersion         := "6.4"

testNGOutputDirectory := "target/testng"

testNGParameters      := Seq()

testNGSuites          := Seq("src/test/resources/testng.xml")

publishTo <<= version { (v: String) =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

credentials += Credentials( new File("project/.ivy2/.credentials") )