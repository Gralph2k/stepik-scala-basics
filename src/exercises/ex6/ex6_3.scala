package exercises.ex6

object ex6_3 extends App {
  var network: Map[String, Set[String]] = Map()

  val locations1: Set[String] = Set("A","B","C")
  network = network ++ Map("Z"->locations1)
  network = network ++ Map("X"->locations1)

  val tmp:Set[String] = network("Z")

  val locations2: Set[String] = Set("D")
  network ++= (Map("Z" -> (network("Z") + "D")))

  println(network)

  def add(network: Map[String, Set[String]], location:Set[String]) = {
    network + (location -> (Set("")))
  }


}
