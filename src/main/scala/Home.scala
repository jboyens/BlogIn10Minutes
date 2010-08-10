package com.meetup.scala

import org.scalatra.{ScalatraFilter, ScalatraServlet}
import org.scalatra.scalate.ScalateSupport
import net.liftweb.json.{JsonParser, Serialization}

class Home extends ScalatraFilter with ScalateSupport {
  val dao = new BlogDAO

  before {
    contentType = "text/html"
  }

  get("/") {
    renderTemplate("index.scaml", "entries" -> dao.getBlog.entries)
  }

  def asJson: String = {
    implicit val formats = net.liftweb.json.DefaultFormats
    Serialization.write(dao.getBlog.entries)
  }
  get("/entries.json") {
    contentType = "application/json"

    asJson
  }

  get("/entries.xml") {
    import net.liftweb.json.Xml.{toJson, toXml}
    import net.liftweb.json.JsonParser

    contentType = "text/xml"

    <entries>
      { toXml(JsonParser.parse(asJson)) }
    </entries>
  }

  post("/postComment") {
    dao.postComment(params("entry_id").toInt, Comment(params("comment")))

    redirect("/")
  }
}