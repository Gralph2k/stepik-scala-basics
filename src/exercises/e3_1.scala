package exercises

/*
Instructor: id, name, surname

Методы класса:
- fullName: возвращает полное имя в виде Имя Фамилия.
первые буквы имени и фамилии обязательно должны быть заглавными, но на вход вполне могут передаваться данные, состоящие полностью как из больших букв, так и из маленьких.


Course: courseID, title, releaseYear, instructor

Методы класса:
- getID: возвращает id в формате courseID + instructor.id (например, если courseId = 1, а instructor.id = 2, то метод вернет 12)
- isTaughtBy(instructor): проверяет, является ли указанный человек инструктором курса
- copyCourse(newReleaseYear): возвращает новый экземпляр класса Course
 */
object e3_1 extends App {

  class Instructor(val id: Int, val name: String, val surname: String) {
    def capitalize(name: String): String = {
      name.substring(0, 1).toUpperCase + name.substring(1).toLowerCase()
    }

    def fullName(): String = {
      capitalize(name) + " " + capitalize(surname)
    }
  }

  class Course(val courseID:Int, val title:String, val releaseYear:String, val instructor: Instructor) {
    def getID():Int = {
      (courseID.toString+instructor.id.toString).toInt
    }

    def isTaughtBy(instructor: Instructor):Boolean = {
      instructor.equals(this.instructor)
    }

    def copyCourse(newReleaseYear:String):Course = {
      new Course(this.courseID, this.title, newReleaseYear, this.instructor)
    }
  }


  val instructor = new Instructor(1, "иванов", "ИВАН")
  println(instructor.fullName())

  val instructor2 = new Instructor(2, "Сидоров", "ИВАН")


  val course = new Course(1, "Курс", "2000", instructor);
  println();
  println(course.getID())
  println(course.isTaughtBy(instructor))
  println(course.isTaughtBy(instructor2))
  println(course.copyCourse("2020").releaseYear)
}
