// build.sbt
//
lazy val defaults = Def.settings(
  organization := "who",
  version := "0.0.0",
  scalaVersion := "2.12.4",

  scalacOptions ++= Seq(
    "-deprecation",
    "-encoding", "utf8",
    "-feature",
    "-unchecked"
  )
)

val main = (project in file(".")).settings(defaults)
  .settings(
    libraryDependencies ++= Seq(
      "com.beachape" %% "enumeratum-circe" % "1.5.14"
    )
  )
