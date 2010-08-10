package com.meetup.scala

import xml.NodeSeq

case class Blog(entries: List[Entry])

case class Entry(id: Int, content: String, var comments: List[Comment])

case class Comment(text: String, username: String = "anonymous")