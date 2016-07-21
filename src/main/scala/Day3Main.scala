/**
  * @author ynupc
  *         Created on 2016/01/26
  */
object Day3Main {
  def main(args: Array[String]): Unit = {
    val executionTime: ExecutionTime = new ExecutionTime(1000000)
    val str: String = "𠮷野家すもももももももものうち祇園精舎の鐘の声、諸行無常の響きあり。沙羅双樹の花の色、盛者必衰の理をあらはす。おごれる人も久しからず。ただ春の夜の夢のごとし。たけき者も遂にはほろびぬ、ひとへに風の前の塵に同じ。 \n\n遠くの異朝をとぶらへば、秦の趙高、漢の王莽、梁の朱忌、唐の禄山、これらは皆、旧主先皇の政にも従はず、楽しみを極め、諫めをも思ひ入れず、天下の乱れんことを悟らずして、民間の愁ふるところを知らざつしかば、久しからずして、亡じにし者どもなり。 \n\n近く本朝をうかがふに、承平の将門、天慶の純友、康和の義親、平治の信頼、これらはおごれる心もたけきことも、皆とりどりにこそありしかども、間近くは六波羅の入道前太政大臣平朝臣清盛公と申しし人のありさま、伝え承るこそ、心も詞も及ばれね。𠮷"
    val length: Int = str.length
    println("codePointAt: Character vs String (1st round)")
    val charArray: Array[Char] = str.toCharArray
    println("Character1")
    executionTime.printlnAverageExecutionTime(Character.codePointAt(charArray, 0))
    executionTime.printlnAverageExecutionTime(Character.codePointAt(charArray, 0))
    executionTime.printlnAverageExecutionTime(Character.codePointAt(charArray, 0))
    println("Character2")
    executionTime.printlnAverageExecutionTime(Character.codePointAt(str, 0))
    executionTime.printlnAverageExecutionTime(Character.codePointAt(str, 0))
    executionTime.printlnAverageExecutionTime(Character.codePointAt(str, 0))
    println("String")
    executionTime.printlnAverageExecutionTime(str.codePointAt(0))
    executionTime.printlnAverageExecutionTime(str.codePointAt(0))
    executionTime.printlnAverageExecutionTime(str.codePointAt(0))
    println()
    println("codePointBefore: Character vs String (1st round)")
    println("Character1")
    executionTime.printlnAverageExecutionTime(Character.codePointBefore(charArray, length))
    executionTime.printlnAverageExecutionTime(Character.codePointBefore(charArray, length))
    executionTime.printlnAverageExecutionTime(Character.codePointBefore(charArray, length))
    println("Character2")
    executionTime.printlnAverageExecutionTime(Character.codePointBefore(str, length))
    executionTime.printlnAverageExecutionTime(Character.codePointBefore(str, length))
    executionTime.printlnAverageExecutionTime(Character.codePointBefore(str, length))
    println("String")
    executionTime.printlnAverageExecutionTime(str.codePointBefore(length))
    executionTime.printlnAverageExecutionTime(str.codePointBefore(length))
    executionTime.printlnAverageExecutionTime(str.codePointBefore(length))
    println()
    println("codePointAt: Character vs String (2nd round)")
    println("Character1")
    executionTime.printlnAverageExecutionTime(Character.codePointAt(str.toCharArray, 0))
    executionTime.printlnAverageExecutionTime(Character.codePointAt(str.toCharArray, 0))
    executionTime.printlnAverageExecutionTime(Character.codePointAt(str.toCharArray, 0))
    println("Character2")
    executionTime.printlnAverageExecutionTime(Character.codePointAt(str, 0))
    executionTime.printlnAverageExecutionTime(Character.codePointAt(str, 0))
    executionTime.printlnAverageExecutionTime(Character.codePointAt(str, 0))
    println("String")
    executionTime.printlnAverageExecutionTime(str.codePointAt(0))
    executionTime.printlnAverageExecutionTime(str.codePointAt(0))
    executionTime.printlnAverageExecutionTime(str.codePointAt(0))
    println()
    println("codePointBefore: Character vs String (2nd round)")
    println("Character1")
    executionTime.printlnAverageExecutionTime(Character.codePointBefore(str.toCharArray, length))
    executionTime.printlnAverageExecutionTime(Character.codePointBefore(str.toCharArray, length))
    executionTime.printlnAverageExecutionTime(Character.codePointBefore(str.toCharArray, length))
    println("Character2")
    executionTime.printlnAverageExecutionTime(Character.codePointBefore(str, length))
    executionTime.printlnAverageExecutionTime(Character.codePointBefore(str, length))
    executionTime.printlnAverageExecutionTime(Character.codePointBefore(str, length))
    println("String")
    executionTime.printlnAverageExecutionTime(str.codePointBefore(length))
    executionTime.printlnAverageExecutionTime(str.codePointBefore(length))
    executionTime.printlnAverageExecutionTime(str.codePointBefore(length))
    println()
    println("codePointAt: Character vs String (3rd round)")
    val n: Int = 20
    println("Character1")
    executionTime.printlnAverageExecutionTime(testCharacter1CodePointAt(str, n))
    executionTime.printlnAverageExecutionTime(testCharacter1CodePointAt(str, n))
    executionTime.printlnAverageExecutionTime(testCharacter1CodePointAt(str, n))
    println("Character2")
    executionTime.printlnAverageExecutionTime(testCharacter2CodePointAt(str, n))
    executionTime.printlnAverageExecutionTime(testCharacter2CodePointAt(str, n))
    executionTime.printlnAverageExecutionTime(testCharacter2CodePointAt(str, n))
    println("String")
    executionTime.printlnAverageExecutionTime(testStringCodePointAt(str, n))
    executionTime.printlnAverageExecutionTime(testStringCodePointAt(str, n))
    executionTime.printlnAverageExecutionTime(testStringCodePointAt(str, n))
    println()
    println("codePointBefore: Character vs String (3rd round)")
    println("Character1")
    executionTime.printlnAverageExecutionTime(testCharacter1CodePointBefore(str, n, length))
    executionTime.printlnAverageExecutionTime(testCharacter1CodePointBefore(str, n, length))
    executionTime.printlnAverageExecutionTime(testCharacter1CodePointBefore(str, n, length))
    println("Character2")
    executionTime.printlnAverageExecutionTime(testCharacter2CodePointBefore(str, n, length))
    executionTime.printlnAverageExecutionTime(testCharacter2CodePointBefore(str, n, length))
    executionTime.printlnAverageExecutionTime(testCharacter2CodePointBefore(str, n, length))
    println("String")
    executionTime.printlnAverageExecutionTime(testStringCodePointBefore(str, n, length))
    executionTime.printlnAverageExecutionTime(testStringCodePointBefore(str, n, length))
    executionTime.printlnAverageExecutionTime(testStringCodePointBefore(str, n, length))
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

  private def testCharacter1CodePointAt(str: String, n: Int): Unit = {
    val characterArray: Array[Char] = str.toCharArray
    Iterator.range(0, n).foreach {
      i =>
        Character.codePointAt(characterArray, 0)
    }
  }

  private def testCharacter2CodePointAt(str: String, n: Int): Unit = {
    Iterator.range(0, n).foreach {
      i =>
        Character.codePointAt(str, 0)
    }
  }

  private def testStringCodePointAt(str: String, n: Int): Unit = {
    Iterator.range(0, n).foreach {
      i =>
        str.codePointAt(0)
    }
  }

  private def testCharacter1CodePointBefore(str: String, n : Int, length: Int): Unit = {
    val characterArray: Array[Char] = str.toCharArray
    Iterator.range(0, n).foreach {
      i =>
        Character.codePointBefore(characterArray, length)
    }
  }

  private def testCharacter2CodePointBefore(str: String, n : Int, length: Int): Unit = {
    Iterator.range(0, n).foreach {
      i =>
        Character.codePointBefore(str, length)
    }
  }

  private def testStringCodePointBefore(str: String, n : Int, length: Int): Unit = {
    Iterator.range(0, n).foreach {
      i =>
        str.codePointBefore(length)
    }
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
