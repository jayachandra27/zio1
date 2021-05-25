ThisBuild / scalaVersion     := "2.13.5"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"


val attoVersion = "0.7.2"

lazy val testDependencies = Seq(
  "dev.zio" %% "zio-test"     % "1.0.7",
  "dev.zio" %% "zio-test-sbt" % "1.0.7"
) map (_ % Test)

lazy val compileDependencies = Seq(
  "dev.zio"      %% "zio"        % "1.0.7",
  "dev.zio"      %% "zio-macros" % "1.0.7",
  "org.tpolecat" %% "atto-core"  % attoVersion
) map (_ % Compile)

lazy val root = (project in file("."))
  .settings(
    name := "zio1",
    scalacOptions += "-Ymacro-annotations",
    libraryDependencies ++= compileDependencies ++ testDependencies,
    testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")
  )


