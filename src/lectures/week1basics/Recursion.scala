package lectures.week1basics
import scala.annotation.tailrec

object Recursion extends App {
  def powerOfTwo(n: Int): BigInt = {
    @tailrec
    def loop(n:Int=1, accum:BigInt= BigInt(2)):BigInt = {
      if (n<=0)
        BigInt(1)
      else if (n==1)
        accum
      else
        loop(n-1, accum*2L)
    }
    loop(n)
  }

  def printNumbersResult(fArgs: Array[Int]): Unit = {

    def addNumber(x:Int, y:Int, n:Int): Int = {
      @tailrec
      def loop(x:Int, y:Int, n:Int, accum:Int=x):Int = {
        //println(n +" "+ accum)
        if (n==0) {
          accum
        } else {
          loop(x, y, n-1, accum+y)
        }
      }
      loop(x,y,n)
    }

    def printResult(word:String): String = {
      @tailrec
      def loop(n:Int, accum:String=word):String = {
        if (n==1) {
          accum+" is the result"
        } else {
          loop(n-1, accum+" "+word)
        }
      }

      loop(word.length, word);
    }

    val x = fArgs(0).toInt
    val y = fArgs(1).toInt
    val n = fArgs(2).toInt
    val number = addNumber(x,y,n)
    println(printResult(number.toString))
  }

  printNumbersResult(Array(10,1,5))
  printNumbersResult(Array(10,1,115))
}
