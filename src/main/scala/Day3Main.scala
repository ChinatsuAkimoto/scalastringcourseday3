/**
  * @author ynupc
  *         Created on 2016/01/26
  */
object Day3Main {
  def main(args: Array[String]): Unit = {
    val executionTime: ExecutionTime = new ExecutionTime(1000000)
    val str: String = "𠮷野家"
    println("codePointAt: Character vs String")
    println("Character")
    executionTime.printlnAverageExecutionTime(Character.codePointAt(str.toCharArray, 0))
    executionTime.printlnAverageExecutionTime(Character.codePointAt(str.toCharArray, 0))
    executionTime.printlnAverageExecutionTime(Character.codePointAt(str.toCharArray, 0))
    println("String")
    executionTime.printlnAverageExecutionTime(str.codePointAt(0))
    executionTime.printlnAverageExecutionTime(str.codePointAt(0))
    executionTime.printlnAverageExecutionTime(str.codePointAt(0))
    println()
    println("codePointBefore: Character vs String")
    println("Character")
    executionTime.printlnAverageExecutionTime(Character.codePointBefore(str.toCharArray, str.length))
    executionTime.printlnAverageExecutionTime(Character.codePointBefore(str.toCharArray, str.length))
    executionTime.printlnAverageExecutionTime(Character.codePointBefore(str.toCharArray, str.length))
    println("String")
    executionTime.printlnAverageExecutionTime(str.codePointBefore(str.length))
    executionTime.printlnAverageExecutionTime(str.codePointBefore(str.length))
    executionTime.printlnAverageExecutionTime(str.codePointBefore(str.length))
    println()
    println("length: String.length vs String.chars.count")
    println("String.length")
    executionTime.printlnAverageExecutionTime(str.length)
    executionTime.printlnAverageExecutionTime(str.length)
    executionTime.printlnAverageExecutionTime(str.length)
    println("String.chars.count")
    executionTime.printlnAverageExecutionTime(str.chars.count)
    executionTime.printlnAverageExecutionTime(str.chars.count)
    executionTime.printlnAverageExecutionTime(str.chars.count)
    println()
    println("codePointCount: String.codePointCount vs String.codePoints.count")
    println("String.codePointCount")
    executionTime.printlnAverageExecutionTime(str.codePointCount(0, str.length))
    executionTime.printlnAverageExecutionTime(str.codePointCount(0, str.length))
    executionTime.printlnAverageExecutionTime(str.codePointCount(0, str.length))
    println("String.codePoints.count")
    executionTime.printlnAverageExecutionTime(str.codePoints.count)
    executionTime.printlnAverageExecutionTime(str.codePoints.count)
    executionTime.printlnAverageExecutionTime(str.codePoints.count)
    println()
    println("offsetByCodePoints: Character.offsetByCodePoints vs String.offsetByCodePoints")
    println("Character.offsetByCodePoints")
    executionTime.printlnAverageExecutionTime(Character.offsetByCodePoints(str, 0, 1))
    executionTime.printlnAverageExecutionTime(Character.offsetByCodePoints(str, 0, 1))
    executionTime.printlnAverageExecutionTime(Character.offsetByCodePoints(str, 0, 1))
    println("String.offsetByCodePoints")
    executionTime.printlnAverageExecutionTime(str.offsetByCodePoints(0, 1))
    executionTime.printlnAverageExecutionTime(str.offsetByCodePoints(0, 1))
    executionTime.printlnAverageExecutionTime(str.offsetByCodePoints(0, 1))
    println()
    println("codePoints: String.codePoints vs toCodePoints")
    println("String.codePoints")
    executionTime.printlnAverageExecutionTime(str.codePoints.toArray)
    executionTime.printlnAverageExecutionTime(str.codePoints.toArray)
    executionTime.printlnAverageExecutionTime(str.codePoints.toArray)
    println("toCodePoints")
    executionTime.printlnAverageExecutionTime(toCodePoints(str))
    executionTime.printlnAverageExecutionTime(toCodePoints(str))
    executionTime.printlnAverageExecutionTime(toCodePoints(str))
  }

  private def toCodePoints(charSequence: CharSequence): Array[Int] = {
    if (charSequence == null) {
      throw new NullPointerException
    }

    val charArray: Array[Char] =
      {
        charSequence match {
          case str: String =>
            str
          case otherwise =>
            otherwise.toString
        }
      }.toCharArray
    val length: Int = charArray.length
    var surrogatePairCount: Int = 0
    var isSkipped: Boolean = false
    for (i <- 0 until length) {
      if (isSkipped) {
        isSkipped = false
      } else {
        if (0 < i && Character.isSurrogatePair(charArray(i - 1), charArray(i))) {
          surrogatePairCount += 1
          isSkipped = true
        }
      }
    }
    isSkipped = false
    val codePoints: Array[Int] = new Array[Int](length - surrogatePairCount)
    var j: Int = 0
    for (i <- 0 until length) {
      if (isSkipped) {
        isSkipped = false
      } else {
        val currentChar = charArray(i)
        if (Character.isHighSurrogate(currentChar) && i + 1 < length) {
          val nextChar = charArray(i + 1)
          if (Character.isLowSurrogate(nextChar)) {
            codePoints(j) = Character.toCodePoint(currentChar, nextChar)
            j += 1
            isSkipped = true
          }
        }
        if (!isSkipped) {
          codePoints(j) = currentChar
          j += 1
        }
      }
    }
    codePoints
  }
}
