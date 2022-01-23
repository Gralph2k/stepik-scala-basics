package exercises.ex4

import java.util.NoSuchElementException

object LinkedList extends App {
  abstract class LogList() {
    def add(msg: String): LogList

    def last: String

    def previous: LogList

    def all(): String

    def isEmpty: Boolean
  }

  class Log(head: String, tail: LogList) extends LogList {
    def add(msg: String): LogList = new Log(msg, this)

    def last: String = head

    def previous: LogList = tail

    def all: String = head + " " + tail.all()

    def isEmpty = false
  }

  object Empty extends LogList {
    def add(msg: String): LogList = new Log(msg, Empty)

    def last: String = throw new NoSuchElementException

    def previous: LogList = throw new NoSuchElementException

    def all: String = ""

    def isEmpty = true
  }

  val list = new Log("m1", new Log("m2", new Log("m3", Empty)))
  println(list.all)
  println(list.previous.last)
}
