package lectures.week3fp

object Collections extends App {
  /* Виды коллекций
Set ( т.е. без дубликатов или повторяющихся элементов)
Seq (т.е. у каждого элемента свой индекс, например - Vector, Range, List, Array)
Map (т.е. пары ключ-значение)
 */
  println("-----Set")
  val emptySet: Set[Int] = Set()
  val aSet = Set(10, 20, 30, 40)
  val aSet2 = Set(30, 40, 50, 60)

  println(emptySet.isEmpty)
  println(aSet.head) //10
  println(aSet.tail) //Set(20,30,40)
  println(aSet.min + " " + aSet.max) //10 40
  println(aSet.intersect(aSet2)) //Set(30,40)
  println(aSet ++ aSet2) //HashSet(10, 20, 60, 50, 40, 30)

  println("-----Seq")
  val aSequence = Seq(1, 3, 2, 4)
  println(aSequence) //List(1, 3, 2, 4)
  println(aSequence.length) //4
  println(aSequence ++ Seq(6, 7, 5)) //List(1, 3, 2, 4, 6, 7, 5)
  println(aSequence.reverse) //List(4, 2, 3, 1)
  println(aSequence.sorted) //List(1, 2, 3, 4)
  println(aSequence(1)) //3
  println(aSequence.search(4)) //Found(3)

  println("-----Map")
  val aMap: Map[String, Int] = Map()
  val colors: Map[String, String] = Map(("black", "#000000"), "blue" -> "#0d1ad1").withDefaultValue("na")
  println(colors) //Map(black -> #000000, blue -> #0d1ad1)
  println(colors("black")) //#000000
  val newColor: (String, String) = "green" -> "#339616"
  val newColors: Map[String, String] = colors + newColor
  println(newColors.toList) //List((black,#000000), (blue,#0d1ad1), (green,#339616))

  println("-----Array")
  val anArray: Array[String] = Array("h","e","l","l","o",".")
  anArray(5) = "!"
  println(anArray.mkString("-")) //h-e-l-l-o-!

  println("-----Tuple")
  val aTuple: (Int, String) = (100, "Scala")
  println(aTuple._1, aTuple._2) //(100,Scala)
  println(aTuple.swap)  //(Scala,100)

  println("-----Range")
  val aRange:Seq[Int] = 1 until 3
  println(aRange) //Range 1 until 3
  val aRangeVector: Vector[Int] = (1 to 5).toVector
  println(aRangeVector) //Vector(1, 2, 3, 4, 5)

  val progLanguages = List("java", "scala", "python")
  println(progLanguages.map(x => x.toUpperCase()))
  println(for (lng <-progLanguages) yield lng.toUpperCase())
  println(progLanguages.map(_.toUpperCase()))

}

