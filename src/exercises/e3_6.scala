package exercises

/*
Напишите функцию для класса Person, которая будет срабатывать на вызов:

  val person = new Person("Bob")
  println((+person).name)
и выводить на экран Bob c
 */
object e3_6 extends App {
  class Person(val name:String) {
    def unary_+():Person = {
      new Person(name+ " NoSurname")
    }
  }


  val person:Person = new Person("Bob")
  println(person.name)
  println((+person).name)

}
