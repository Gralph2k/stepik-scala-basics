package playground

object ScalaPlayground extends App {
  class Employee(val name: String, var salary: Double) {
    def this() = this("John",0.0)
  }

  val employee = new Employee();
  println(s"${employee.name}'s salary is ${employee.salary}")

  val someVal = Some(2)
  println(someVal.map(_ * 2))
}
