package exercises

object e2_7 extends App {
  def revertString(line:String) = {
    println(line
      .trim
      .split(" ")
      .filter(_ != "")
      .reverse
      .mkString(" ")
    )
  }

  revertString("I like     Scala ")

}
