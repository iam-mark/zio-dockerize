scalaVersion := "2.13.18"

libraryDependencies ++= Seq(
  "dev.zio"       %% "zio"            % "2.1.26",
  "dev.zio"       %% "zio-json"       % "0.7.44",
  "dev.zio"       %% "zio-http"       % "3.8.1",
  "io.getquill"   %% "quill-zio"      % "4.8.5",
  "io.getquill"   %% "quill-jdbc-zio" % "4.8.5",
  "com.h2database" % "h2"             % "2.5.250"
)

enablePlugins(JavaAppPackaging)
enablePlugins(DockerPlugin)

dockerExposedPorts := Seq(8080)

dockerBaseImage := "openjdk:17-jdk"

dockerUsername   := sys.props.get("docker.username")
dockerRepository := sys.props.get("docker.registry")

resolvers ++= Resolver.sonatypeOssRepos("snapshots")
