package lectures.week1basics

object Functions extends App {
  def aCondition(): Boolean = if ( 1 > 2) true else false

  def someFunc(x: Int, y: => Int): Int = {
    if (!aCondition)
      x * 2
    else
      multiply(y)
  }

  def multiply(i: Int): Int = {
    i*2
  }


  println(someFunc(3,4))
}
