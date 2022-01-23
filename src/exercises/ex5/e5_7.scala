package exercises.ex5

object e5_7 extends App {
  def chatbot(input:String):Option[String] = {
    val aPartialFunction: PartialFunction[String, String] = {
      case "hello" => "Hi, I'm Bot"
      case "bye" => "Bye-bye"
      case "what's up" => "sup-sup"
    }
    val lifted = aPartialFunction.lift
    lifted(input)
  }


 // List("hello","what's up", "hi", "bye")
   // .foreach(line => println(chatbot(line)))


  val tst = List("hello","what's up", "hi", "bye")
    .iterator
    .map(chatbot(_))
    .foreach(println(_))

  println(tst)
}
