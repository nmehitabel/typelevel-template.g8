val catsV = "2.0.0"
val catsEffectV = "2.0.0"
val shapelessV = "2.3.3"
val fs2V = "2.0.0"
val http4sV = "0.21.0-M6"
val circeV = "0.12.3"
val circeAuxV = "0.12.0"
val doobieV = "0.8.8"
val log4catsV = "1.0.1"
val catsEffectTestingV = "0.4.0"

val kindProjectorV = "0.11.0"
val betterMonadicForV = "0.3.1"

// Projects
lazy val `$name$` = project.in(file("."))
  .aggregate(core)

lazy val core = project.in(file("core"))
  .settings(commonSettings)
  .settings(
    name := "$name$"
  )


// General Settings
lazy val commonSettings = Seq(
  scalaVersion := "$scala_version$",
  crossScalaVersions := Seq(scalaVersion.value, "$other_scala_version$"),

  addCompilerPlugin("org.typelevel" %% "kind-projector" % kindProjectorV cross CrossVersion.full),
  addCompilerPlugin("com.olegpy"    %% "better-monadic-for" % betterMonadicForV),
  
  libraryDependencies ++= Seq(
    "org.typelevel"               %% "cats-core"                     % catsV,
    "org.typelevel"               %% "alleycats-core"                % catsV,

    "org.typelevel"               %% "cats-effect"                   % catsEffectV,

    "com.chuusai"                 %% "shapeless"                     % shapelessV,

    "co.fs2"                      %% "fs2-core"                      % fs2V,
    "co.fs2"                      %% "fs2-io"                        % fs2V,

    "org.http4s"                  %% "http4s-dsl"                    % http4sV,
    "org.http4s"                  %% "http4s-blaze-server"           % http4sV,
    "org.http4s"                  %% "http4s-blaze-client"           % http4sV,
    "org.http4s"                  %% "http4s-circe"                  % http4sV,

    "io.circe"                    %% "circe-core"                    % circeV,
    "io.circe"                    %% "circe-generic"                 % circeV,
    "io.circe"                    %% "circe-parser"                  % circeV,
    "io.circe"                    %% "circe-fs2"                     % circeAuxV,
    "io.circe"                    %% "circe-optics"                  % circeAuxV,

    "org.tpolecat"                %% "doobie-core"                   % doobieV,
    "org.tpolecat"                %% "doobie-h2"                     % doobieV,
    "org.tpolecat"                %% "doobie-hikari"                 % doobieV,
    "org.tpolecat"                %% "doobie-postgres"               % doobieV,
    "org.tpolecat"                %% "doobie-specs2"                 % doobieV            % Test,

    "io.chrisdavenport"           %% "log4cats-core"                 % log4catsV,
    "io.chrisdavenport"           %% "log4cats-slf4j"                % log4catsV,
    "io.chrisdavenport"           %% "log4cats-testing"              % log4catsV          % Test,

    "com.codecommit"              %% "cats-effect-testing-scalatest" % catsEffectTestingV % Test,
    "com.codecommit"              %% "cats-effect-testing-scalatest-scalacheck" % catsEffectTestingV % Test
  )
)

// General Settings
inThisBuild(List(
  organization := "$organization$",
  developers := List(
    Developer("$contributorUsername$", "$contributorName$", "$contributorEmail$", url("https://github.com/$contributorUsername$"))
  )
))