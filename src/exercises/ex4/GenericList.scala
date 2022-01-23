package exercises.ex4

import exercises.ex4.LinkedList.{Empty, Log, LogList}

import java.util.NoSuchElementException

object GenericList extends App {
  abstract class LogList[+A]() {
    def add[B >: A](s: B): LogList[B]

    def last: A

    def previous: LogList[A]

    def all(): String

    def isEmpty: Boolean
  }

    class Log[+A](h: A, t: LogList[A]) extends LogList[A] {
      def add[B >: A](msg: B): LogList[B] = new Log(msg, this)

      def last:A = h

      def previous: LogList[A] = t

      def all: String = h + " " + t.all()

      def isEmpty = false
    }

  object Empty extends LogList[Nothing] {
    def add[B >: Nothing](msg: B): LogList[B] = new Log(msg, Empty)

    def last: Nothing  = throw new NoSuchElementException

    def previous: Nothing  = throw new NoSuchElementException

    def all: String = ""

    def isEmpty = true
  }


  val list = new Log[String]("m1", new Log("m2", new Log("m3", Empty)))
  println(list.all)
  println(list.previous.last)

  val list2 = new Log[Int](1, new Log(2, new Log(3, Empty)))
  println(list2.all)
}
