package com.meetup.scala

class BlogDAO {
  val comment1 = Comment("My comment", "jboyens")
  val comment2 = Comment("My anon comment")

  val entries = List(
    Entry(1, "This is my entry text", List(comment1, comment2)),
    Entry(2, "This is hacker blogging", List(comment1))
  )

  val blog = Blog(entries)

  def getBlog = blog

  def postComment(id: Int, comment: Comment) = {
    val entry = entries.find(_.id == id)

    if (entry.isDefined) {
      entry.get.comments = comment :: entry.get.comments
    }
  }
}