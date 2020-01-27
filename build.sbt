val catsV = "2.1.0"
val catsEffectV = "2.0.0"
val fs2V = "2.1.1"
val http4sV = "0.21.0-M6"
val circeV = "0.12.3"
val circeAuxV = "0.12.0"

val doobieV = "0.8.8"
val log4catsV = "1.0.1"
val scalatestV = "3.1.0"
val scalacheckV = "1.14.1"
val catsEffectTestingV = "0.4.0"

val kindProjectorV = "0.11.0"
val betterMonadicForV = "0.3.1"

// This build is for this Giter8 template.
// To test the template run `g8` or `g8Test` from the sbt session.
// See http://www.foundweekends.org/giter8/testing.html#Using+the+Giter8Plugin for more details.
lazy val root = (project in file("."))
  .enablePlugins(ScriptedPlugin)
  .settings(
    scalaVersion := "2.12.10",
    name := "base",
    Keys.test in Test := {
      val _ = (g8Test in Test).toTask("").value
    },
    scriptedLaunchOpts ++= List("-Xms1024m", "-Xmx1024m", "-XX:ReservedCodeCacheSize=128m", "-Xss2m", "-Dfile.encoding=UTF-8"),
    resolvers += Resolver.url("typesafe", url("http://repo.typesafe.com/typesafe/ivy-releases/"))(Resolver.ivyStylePatterns),

    addCompilerPlugin("org.typelevel" %% "kind-projector" % kindProjectorV cross CrossVersion.full),
    addCompilerPlugin("com.olegpy"    %% "better-monadic-for" % betterMonadicForV),
  
    libraryDependencies ++= Seq(
      "org.typelevel"               %% "cats-core"                     % catsV,
      "org.typelevel"               %% "alleycats-core"                % catsV,
   
      "org.typelevel"               %% "cats-effect"                   % catsEffectV,
   
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
      "org.tpolecat"                %% "doobie-scalatest"              % doobieV            % Test,
   
      "io.chrisdavenport"           %% "log4cats-core"                 % log4catsV,
      "io.chrisdavenport"           %% "log4cats-slf4j"                % log4catsV,
      "io.chrisdavenport"           %% "log4cats-testing"              % log4catsV          % Test,

      "com.codecommit"              %% "cats-effect-testing-scalatest" % catsEffectTestingV % Test,
      "com.codecommit"              %% "cats-effect-testing-scalatest-scalacheck" % catsEffectTestingV % Test
    )
  )

