package exercises.ex5

object e5_3 extends App {
  val progLanguages = List("java", "scala", "python")
  val lngAbbrev = List("JA", "SCA", "PY")

  val result =
    progLanguages
      .flatMap(lng => lngAbbrev.map(
        abrv => (abrv, lng)))
      .filter({case (x,y) => x.toUpperCase().charAt(0)==y.toUpperCase().charAt(0)})



  println(result)
  println("----")

  val nums1 = List(1, 2, 3)
  val nums2 = List(4, 6, 7)
  val nums3 = List(10, 100, 1000)

  println(nums1.flatMap(a => nums2.flatMap(b => nums3.filter(_ % 2 == 1).map(c => (a + b) * c))))

  println(for {
    a <- nums1
    b <- nums2 if b % 2 == 1
    c <- nums3
  } yield (a + b) * c)

  println(for {
    a <- nums1
    b <- nums2
    c <- nums3
  } yield (a + b) * c)

  println(nums1.flatMap(a => nums2.filter(_ % 2 == 1).flatMap(b => nums3.map(c => a + b * c))))

  println(nums1.flatMap(a => nums2.filter(_ % 2 == 1).flatMap(b => nums3.map(c => (a + b) * c))))
}
