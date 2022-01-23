package exercises.ex5


import scala.io.StdIn.readLine;
object e5_6_2 extends App {
    object User {
      def apply(name: String) = s"$name"

      def unapply(user: String): Option[String] = {
        val strArr: Array[String] = user.split(" ")
        if (strArr.tail.nonEmpty)
          Some(strArr(0).head.toUpper+". "+strArr(1).head.toUpper+".")
        else
          None
      }
    }

    val fName = readLine()
    val aUser = User(fName)

    aUser match {
      case User(name) => println(name)
      case _ => println("Oops, something is wrong")
    }

  }