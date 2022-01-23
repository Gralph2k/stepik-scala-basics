package lectures.week3fp

import scala.annotation.tailrec

object FunctionsFP extends App {
  //Чистые функции - идемпотенты
  val product = new Function2[Int, Int, Int] {
    override def apply(x: Int, y: Int): Int = x*y
  }
  val product2 = (x:Int, y:Int) => x*y
  val product3 : (Int, Int) => Int = _ * _

  val strlen = (x:String) => x.length
  println(strlen("Hello, world!"))

  //Функции высшего порядка - принимают на вход функцию
  @tailrec
  def nTimes(f: Int => Int, x: Int,  n: Int): Int = {
    if (n <= 0) x
    else nTimes(f, f(x), n - 1)
  }
  val increment = (x: Int) => x + 1
  println(nTimes(increment, 0, 3)) // выведет 3

  //Каррированные функции
  def add(x: Int)(y: Int) = x + y
  println(add(1)(2)) //3

  val multiplier: Int => Int => Int = x => y => x * y
  val multiplier2 = multiplier(2) //Передали 1 параметр
  println(multiplier2(3))//Осталось передать второй параметр
  println(multiplier(2)(3)) //Аналогично
  println("----")

  //Альтернативные варианты записи
  def someFunc1: Int => Function1[Int, Int] = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }
  def someFunc2: Int => (Int => Int) = (x) => (y) => x + y
  def someFunc3: Int => ((Int) => Int) = (x: Int) => (y: Int) => x + y
  def someFunc4 = (x: Int) => (y: Int) => x + y
  def someFunc5: Int => (Int => Int) = (x: Int) => (y: Int) => x + y

  println(someFunc1(2)(3))
  println(someFunc2(2)(3))
  println(someFunc3(2)(3))
  println(someFunc4(2)(3))
  println(someFunc5(2)(3))

}
