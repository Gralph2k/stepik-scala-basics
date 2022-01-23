package exercises.ex5

import scala.util.Try

object e5_8 extends App {

  def getNumericVersion(version:String):List[Int] = {
    version.split("\\.")
      .map(_.trim)
      .map(n => n.toInt)
      .toList
  }

  def levelOfVersions(version:List[Int], targetSize:Int):List[Int] = {
    var buf =  version
    while (buf.length<targetSize) {
      buf = buf++Seq(0)
    }
   buf
  }

  def compare(v1: String, v2: String): Int = {
    var version1 = getNumericVersion(v1)
    var version2 = getNumericVersion(v2)
    val level = if (version1.length>version2.length) version1.length else version2.length
    version1 = levelOfVersions(version1,level)
    version2 = levelOfVersions(version2,level)
    println(version1)
    println(version2)
    for(x <- Range(0,level) ){
      if (version1(x)<version2(x))
        return -1
      else if  (version1(x)>version2(x))
        return 1
    }
    0
  }

  var version1 = "3.0"
  var version2 = "3.0.0.1"

  println(compare(version1, version2))


}
