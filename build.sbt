ThisBuild / scalaVersion     := "2.13.5"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"


val attoVersion = "0.7.2"

lazy val testDependencies = Seq(
  "dev.zio" %% "zio-test"     % "1.0.7",
  "dev.zio" %% "zio-test-sbt" % "1.0.7",
  "dev.zio" %% "zio-macros" % "1.0.7"
) map (_ % Test)

lazy val root = (project in file("."))
  .settings(
    name := "zio1",
    libraryDependencies ++= Seq(
      "dev.zio" %% "zio" % "1.0.7",
      "dev.zio" %% "zio-test" % "1.0.7" % Test,
      "io.d11" %% "zhttp" % "1.0.0.0-RC16",
      "org.tpolecat" %% "atto-core"  % attoVersion
    ),
    testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")
  )


