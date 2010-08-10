import sbt._

class BlogIn10MinutesProject(info: ProjectInfo) extends DefaultWebProject(info) with IdeaProject {
  override def repositories = super.repositories ++ Set(
    "Nexus Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
    "Nexus Releases" at "https://oss.sonatype.org/content/repositories/releases",
    "Fusesource" at "http://repo.fusesource.com/nexus/content/repositories/public/",
    ScalaToolsSnapshots
  )

  override def libraryDependencies = super.libraryDependencies ++ Set(
    "org.scalatra" %% "scalatra" % "2.0.0-SNAPSHOT",
    "org.scalatra" %% "scalatra-scalate" % "2.0.0-SNAPSHOT",
    "org.eclipse.jetty" % "jetty-webapp" % "7.0.2.RC0" % "test",
    "org.fusesource.scalate" % "scalate-core" % "1.2",
    "org.mortbay.jetty" % "servlet-api" % "2.5-20081211" % "provided",
    "net.liftweb" % "lift-json" % "2.0-scala280-SNAPSHOT"
  )
}