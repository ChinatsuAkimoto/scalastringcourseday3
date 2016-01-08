<h1>Day 3 Code PointとSurrogate Pair</h1>
<img src="https://github.com/ynupc/scalastringcourse/blob/master/image/day3/string_course.001.jpeg" width="500px"><br>
今日は、Code PointとSurrogate Pairについて紹介したいと思います。ご質問や間違いなどのご指摘は下記のコメント欄にお書きください。  
<br>
<strong><a href="#1コードポイントとサロゲートペアの理論">1.　コードポイントとサロゲートペアの理論</a></strong>  
<strong><a href="#11コードポイント">1.1　コードポイント</a></strong>  
<a href="#コラムbomとeエンディアン">コラム：BOMとエンディアン</a>  
<a href="#コラムutf-8のbomを削除する方法">コラム：UTF-8のBOMを削除する方法</a>  
<a href="#１vimによるutf-8のbomの手動削除">（１）VimによるUTF-8のBOMの手動削除</a>  
<a href="#２scalaによるutf-8のbomの自動削除">（２）ScalaによるUTF-8のBOMの自動削除</a>  
<a href="#コラムutf-8のセキュリティ問題nimda">コラム：UTF-8のセキュリティ問題、Nimda</a>  
<a href="#コラムutf-8のテキストのmysqlへの保存utf8mb4">コラム：UTF-8のテキストのMySQLへの保存、utf8mb4</a>  
<strong><a href="#12サロゲートペア">1.2　サロゲートペア</a></strong>    
<strong><a href="#13コードポイントとサロゲートペアの相互変換式">1.3　コードポイントとサロゲートペアの相互変換式</a></strong>  

<strong><a href="#2コードポイントとサロゲートペアの実装">2.　コードポイントとサロゲートペアの実装</a></strong>  
<strong><a href="#21サロゲートペア-arraycharとコードポイント-intの相互変換">2.1　サロゲートペア (Array[Char])とコードポイント (Int)の相互変換</a></strong>  
<strong><a href="#211サロゲートペア-arraycharからコードポイント-intへの変換">2.1.1　サロゲートペア (Array[Char])からコードポイント (Int)への変換</a></strong>  
<strong><a href="#212コードポイント-intからサロゲートペア-arraycharへの変換">2.1.2　コードポイント (Int)からサロゲートペア (Array[Char])への変換</a></strong>  
<strong><a href="#22コードポイント-intからchar数-intの取得">2.2　コードポイント (Int)からChar数 (Int)の取得</a></strong>  
<strong><a href="#23コードポイント-intから上位サロゲート-charや下位サロゲート-charの取得">2.3　コードポイント (Int)から上位サロゲート (Char)や下位サロゲート (Char)の取得</a></strong>  
<strong><a href="#231コードポイント-intから上位サロゲート-charの取得">2.3.1　コードポイント (Int)から上位サロゲート (Char)の取得</a></strong>  
<strong><a href="#232コードポイント-intから下位サロゲート-charの取得">2.3.2　コードポイント (Int)から下位サロゲート (Char)の取得</a></strong>  
<strong><a href="#24charsequenceやstringやchar配列-arraycharからコードポイント-intの取得">2.4　CharSequenceやStringやChar配列 (Array[Char])からコードポイント (Int)の取得</a></strong>  
<strong><a href="#241指定インデックス-intにある文字のコードポイント-intの取得">2.4.1　指定インデックス (Int)にある文字のコードポイント (Int)の取得</a></strong>  
<strong><a href="#242順方向に解析しコードポイント-intを取得">2.4.2　順方向に解析しコードポイント (Int)を取得</a></strong>  
<strong><a href="#243逆方向に解析しコードポイント-intを取得">2.4.3　逆方向に解析しコードポイント (Int)を取得</a></strong>  
<strong><a href="#244サロゲートペアに対する挙動">2.4.4　サロゲートペアに対する挙動</a></strong>  
<strong><a href="#25charsequenceとstringの相互変換">2.5　CharSequenceとStringの相互変換</a></strong>  
<strong><a href="#251stringからcharsequenceへの変換">2.5.1　StringからCharSequenceへの変換</a></strong>  
<strong><a href="#252charsequenceからstringへの変換">2.5.2　CharSequenceからStringへの変換</a></strong>  
<strong><a href="#26charsequenceやstringとchar配列-arraycharの相互変換">2.6　CharSequenceやStringとChar配列 (Array[Char])の相互変換</a></strong>  
<strong><a href="#261charsequenceからchar配列-arraycharへの変換">2.6.1　CharSequenceからChar配列 (Array[Char])への変換</a></strong>  
<strong><a href="#262stringからchar配列-arraycharへの変換">2.6.2　StringからChar配列 (Array[Char])への変換</a></strong>  
<strong><a href="#263char配列-arraycharからstringへの変換">2.6.3　Char配列 (Array[Char])からStringへの変換</a></strong>  
<strong><a href="#27stringからchar数-intまたはlongやコードポイント数-intまたはlongの取得">2.7　StringからChar数 (IntまたはLong)やコードポイント数 (IntまたはLong)の取得</a></strong>  
<strong><a href="#271stringからchar数-intまたはlongの取得">2.7.1　StringからChar数 (IntまたはLong)の取得</a></strong>  
<strong><a href="#272stringからコードポイント数-intの取得">2.7.2　Stringからコードポイント数 (IntまたはLong)の取得</a></strong>  
<strong><a href="#28charsequenceやstringとコードポイント配列-arrayintの相互変換">2.8　CharSequenceやStringとコードポイント配列 (Array[Int])の相互変換</a></strong>  
<strong><a href="#281コードポイント配列-arrayintからstringへの変換">2.8.1　コードポイント配列 (Array[Int])からStringへの変換</a></strong>  
<strong><a href="#282charsequenceやstringからコードポイント配列-arrayintへの変換">2.8.2　CharSequenceやStringからコードポイント配列 (Array[Int])への変換</a></strong>  
<strong><a href="#29コードポイント数-intだけ移動した位置のインデックス-intの取得">2.9　コードポイント数 (Int)だけ移動した位置のインデックス (Int)の取得</a></strong>  
<strong><a href="#210stringからイテレータの生成">2.10　Stringからイテレータの生成</a></strong>  
<strong><a href="#2101stringcharacteriteratorによるchar単位のイテレータ">2.10.1　StringCharacterIteratorによるChar単位のイテレータ</a></strong>  
<strong><a href="#2102intstreamによるchar単位のイテレータ">2.10.2　IntStreamによるChar単位のイテレータ</a></strong>  
<strong><a href="#2103intstreamによるコードポイント単位のイテレータ">2.10.3　IntStreamによるコードポイント単位のIterator</a></strong>  
<strong><a href="#211コードポイントとサロゲートペアに関する特に重要な変換">2.11　コードポイントとサロゲートペアに関する特に重要な変換</a></strong>  
<strong><a href="#212java-7以前のstringからコードポイント配列-arrayintへの変換">2.12　Java 7以前のStringからコードポイント配列 (Array[Int])への変換</a></strong>  
***
<h2>2.　Code PointとSurrogate Pairの実装</h2>
<img src="https://github.com/ynupc/scalastringcourse/blob/master/image/day3/string_course.008.jpeg" width="500px"><br>
今日は、この表をインデックスとして使用し、メソッドを表す個々のリンクについて説明していきます。
***
<h3>2.1　Surrogate Pair (Array[Char])とCode Point (Int)の相互変換</h3>
<img src="https://github.com/ynupc/scalastringcourse/blob/master/image/day3/string_course.009.jpeg" width="500px"><br>
Code PointとSurrogate Pairの変換方法について説明します。
<h4>2.1.1　Surrogate Pair (Array[Char])からCode Point (Int)への変換</h4>
Character.toCodePointメソッドがSurrogate PairからCode Pointへの変換メソッドです。
```scala
  @Test
  def testSurrogatePairToCodePoint(): Unit = {
    val high: Char = 0xD842
    val low : Char = 0xDFB7
    assert(Character.isHighSurrogate(high))
    assert(Character.isLowSurrogate(low))
    if (Character.isHighSurrogate(high) && Character.isLowSurrogate(low)) {
      val codePoint: Int = Character.toCodePoint(high, low)

      assert(codePoint == 0x20BB7)
    }
  }
```
<h4>2.1.2　Code Point (Int)からSurrogate Pair (Array[Char])への変換</h4>
Character.toCharsメソッドがCode PointからSurrogate Pairを表すChar配列、あるいはSurrogate Pairで表されないCharを１つ含む配列への変換メソッドです。
```scala
  @Test
  def testCodePointToSurrogatePair1(): Unit = {
    val codePoint: Int = 0x20BB7
    assert(Character.isValidCodePoint(codePoint))
    if (Character.isValidCodePoint(codePoint)) {
      val charArray: Array[Char] = Character.toChars(codePoint)
      //IllegalArgumentException:
      //codePointが有効なUnicodeコードポイントではない場合発生

      assert(charArray.length == 2)
      assert(charArray.head == 0xD842)
      assert(charArray(1) == 0xDFB7)
    }
  }
```
```scala
  @Test
  def testCodePointToSurrogatePair2(): Unit = {
    val codePoint: Int = 0x20BB7
    val dst: Array[Char] = new Array(16)
    val index: Int = 8
    assert(Character.isValidCodePoint(codePoint))
    if (Character.isValidCodePoint(codePoint)) {
      //dst(index)またはdst(index)とdst(index + 1)に変換されたCharを代入し、代入したCharの個数を返す
      val size = Character.toChars(codePoint, dst, index)
      //IllegalArgumentException:
      //codePointが有効なUnicodeコードポイントでない場合発生
      //NullPointerException:
      //dstがnullの場合発生
      //IndexOutOfBoundsException:
      //codePointがBMP領域なら0 ≦ dstIndex < dst.length、Supplementary領域なら0 ≦ dstIndex < dst.length - 1に反した場合発生

      assert(size == 2)
      assert(dst(8) == 0xD842)
      assert(dst(9) == 0xDFB7)
    }
  }
```
***
<h3>2.2　Code Point (Int)からChar数 (Int)の取得</h3>
<img src="https://github.com/ynupc/scalastringcourse/blob/master/image/day3/string_course.010.jpeg" width="500px"><br>
Code PointがいくつのCharで表されるのかを取得する方法について説明します。まずは、先ほどのように一度Charの配列に変換してしまう方法があります。
<br>
```scala
  @Test
  def testCodePointToNumOfChars1(): Unit = {
    val codePoint: Int = 0x20BB7
    assert(Character.isValidCodePoint(codePoint))
    if (Character.isValidCodePoint(codePoint)) {
      val charArray: Array[Char] = Character.toChars(codePoint)
      val length: Int = charArray.length
      //IllegalArgumentException:
      //codePointが有効なUnicodeコードポイントではない場合発生

      assert(length == 2)
    }
  }
```
<img src="https://github.com/ynupc/scalastringcourse/blob/master/image/day3/string_course.011.jpeg" width="500px"><br>
次に、Character.charCountメソッドを使用して、直接Code PointからいくつのCharで表されるのかを取得することができます。
```scala
  @Test
  def testCodePointToNumOfChars2(): Unit = {
    val codePoint: Int = 0x20BB7
    val countOpt: Option[Int] =
      if (Character.isValidCodePoint(codePoint)) {
        Option(Character.charCount(codePoint))}
      else {
        None
      }

    assert(countOpt.nonEmpty)
    if (countOpt.nonEmpty) {
      assert(countOpt.get == 2)
    }
  }
```
最後に、Code PointがBMP領域にあるのかSupplementary領域にあるのかを調べることで、いくつのCharで表されるのかを取得することができます。
```scala
  @Test
  def testCodePointToNumOfChars3(): Unit = {
    val codePoint: Int = 0x20BB7
    val countOpt: Option[Int] =
      if (Character.isBmpCodePoint(codePoint)) {
        Option(1)
      } else if (Character.isSupplementaryCodePoint(codePoint)) {
        Option(2)
      } else {
        None
      }

    assert(countOpt.nonEmpty)
    if (countOpt.nonEmpty) {
      assert(countOpt.get == 2)
    }
  }
```
***
<h3>2.3　Code Point (Int)からHigh Surrogate (Char)やLow Surrogate (Char)の取得</h3>
<img src="https://github.com/ynupc/scalastringcourse/blob/master/image/day3/string_course.012.jpeg" width="500px"><br>
<h4>2.3.1　Code Point (Int)からHigh Surrogate (Char)の取得</h4>
Code PointからHigh SurrogateをCharacter.highSurrogateメソッドで取得できます。
```scala
  @Test
  def testCodePointToHighSurrogate(): Unit = {
    val codePoint: Int = 0x20BB7
    val high: Char = Character.highSurrogate(codePoint)

    assert(Character.isSurrogate(high))
    if (Character.isSurrogate(high)) {
      assert(Character.isHighSurrogate(high))
      if (Character.isHighSurrogate(high)) {
        assert(high == 0xD842)
      }
    }
  }
```
<h4>2.3.2　Code Point (Int)からLow Surrogate (Char)の取得</h4>
Code PointからLow SurrogateをCharacter.lowSurrogateメソッドで取得できます。
```scala
  @Test
  def testCodePointToLowSurrogate(): Unit = {
    val codePoint: Int = 0x20BB7
    val low: Char = Character.lowSurrogate(codePoint)

    assert(Character.isSurrogate(low))
    if (Character.isSurrogate(low)) {
      assert(Character.isLowSurrogate(low))
      if (Character.isLowSurrogate(low)) {
        assert(low == 0xDFB7)
      }
    }
  }
```
***
<h3>2.4　CharSequenceやStringやChar配列 (Array[Char])からCode Point (Int)の取得</h3>
<img src="https://github.com/ynupc/scalastringcourse/blob/master/image/day3/string_course.013.jpeg" width="500px"><br>
CharSequenceインターフェースを実装するオブジェクト、Stringオブジェクト、Char配列からCode PointにcodePointAt/codePointBeforeメソッドを使用して変換できます。
codePointAtは順方向、codePointBeforeは逆方向に解析します。
<h4>2.4.1　指定インデックス (Int)にある文字のCode Point (Int)の取得</h4>
<img src="https://github.com/ynupc/scalastringcourse/blob/master/image/day3/string_course.014.jpeg" width="500px"><br>
CharSequenceインターフェースを実装するオブジェクト、Stringオブジェクト、Char配列のどのメソッドを使用するのが良いかについては、Char配列のようなlower levelで扱うと処理が高速化し、Stringオブジェクトのようなhigher levelで扱うと処理速度は低下します。
一般的にできるだけlower levelで処理を書くと（究極的にはJVMや<a href="https://ja.wikipedia.org/wiki/LLVM" target="_blank">LLVM</a>、<a href="https://ja.wikipedia.org/wiki/%E3%82%A2%E3%82%BB%E3%83%B3%E3%83%96%E3%83%AA%E8%A8%80%E8%AA%9E" target="_blank">アセンブリ言語</a>、<a href="https://ja.wikipedia.org/wiki/%E6%A9%9F%E6%A2%B0%E8%AA%9E" target="_blank">機械語</a>など）処理は高速化しますが、プログラム長が長くなり、プログラムを書く時間が延び、変数が増え、可読性が下がるため、バグが発生しやすく、保守性が低いプログラムになります。逆にできるだけhigher levelで書くと、無駄にメモリを使用したり、余計なオーバヘッドが発生し、処理が遅くなりがちです。例えば、Char配列のラッパークラスのStringクラスからCharを扱うと、Stringクラスが持つ処理に不要なメソッドがメモリに乗りメモリ効率が悪く、また、Stringクラスを介してChar配列にアクセスするため、直接Char配列にアクセスするより、速度が低下します。プログラミングでは、このようなトレードオフがよく発生します。どのくらいの保守性低下を許してどのくらいの処理高速化をとるのかはケースバイケースでのプログラマによる選択が必要です。  <br>
<h4>2.4.2　順方向に解析しCode Point (Int)を取得</h4>
Char配列からCode Pointを順方向にCharacter.codePointAtメソッドで変換できます。
```scala
  @Test
  def testCharArrayElementToCodePointInForwardDirection1(): Unit = {
    val charArray: Array[Char] = Array[Char](0xD842, 0xDFB7)
    val index: Int = 0
    val codePoint: Int = Character.codePointAt(charArray, index)
    //NullPointerException:
    //charArrayがnullの場合発生
    //IndexOutOfBoundsException:
    //0 ≦ index < charArray.lengthに反した場合発生

    assert(codePoint == 0x20BB7)
  }
```
```scala
  @Test
  def testCharArrayElementToCodePointInForwardDirection2(): Unit = {
    val charArray: Array[Char] = Array[Char](0xD842, 0xDFB7, 'C')
    var index: Int = 0
    var limit: Int = 1
    var codePoint: Int = Character.codePointAt(charArray, index, limit)
    //NullPointerException:
    //charArrayがnullである場合発生
    //IndexOutOfBoundsException:
    //0 ≦ index < limit < charArray.lengthに反した場合発生

    assert(codePoint == 0xD842)

    index = 0
    limit = 2
    codePoint = Character.codePointAt(charArray, index, limit)

    assert(codePoint == 0x20BB7)

    index = 1
    limit = 3
    codePoint = Character.codePointAt(charArray, index, limit)

    assert(codePoint == 0xDFB7)
  }
```
CharSequenceインターフェースを実装するオブジェクトからCode Pointに順方向にCharacter.codePointAtメソッドで変換できます。
```scala
  @Test
  def testCharSequenceToCodePointInForwardDirection(): Unit = {
    val charSequence: CharSequence = "CharSequenceは、String、StringBuilder、 StringBuffer、CharBufferなどが実装しているインターフェース"
    val index: Int = 0
    val codePoint: Int = Character.codePointAt(charSequence, index)
    //NullPointerException:
    //charSequenceがnullである場合発生
    //IndexOutOfBoundsException:
    //0 ≦ index < seq.lengthに反した場合発生

    assert(codePoint == 'C')
  }
```
StringオブジェクトからCode Pointに順方向にString.codePointAtメソッドで変換できます。
```scala
  @Test
  def testStringToCodePointInForwardDirection(): Unit = {
    val str: String = "CharSequenceは、String、StringBuilder、 StringBuffer、CharBufferなどが実装しているインターフェース"
    val index: Int = 0
    val codePoint: Int = str.codePointAt(index)
    //NullPointerException:
    //strがnullである場合発生
    //IndexOutOfBoundsException:
    //0 ≦ index < str.lengthに反した場合発生

    assert(codePoint == 'C')
  }
```
<h4>2.4.3　逆方向に解析しCode Point (Int)を取得</h4>
Char配列からCode Pointに逆方向にCharacter.codePointBeforeメソッドで変換できます。
```scala
  @Test
  def testCharArrayElementToCodePointInBackwardDirection1(): Unit = {
    val charArray: Array[Char] = Array[Char](0xD842, 0xDFB7)
    val index: Int = 1
    val codePoint: Int = Character.codePointBefore(charArray, index)
    //NullPointerException:
    //charArrayがnullの場合発生
    //IndexOutOfBoundsException:
    //1 ≦ index ≦ charArray.lengthに反した場合発生

    assert(codePoint == 0xD842)
  }
```
```scala
  @Test
  def testCharArrayElementToCodePointInBackwardDirection2(): Unit = {
    val charArray: Array[Char] = Array[Char]('C', 0xD842, 0xDFB7)
    var index: Int = 3
    var start: Int = 2
    var codePoint: Int = Character.codePointBefore(charArray, index, start)
    //NullPointerException:
    //charArrayがnullである場合発生
    //IndexOutOfBoundsException:
    //0 ≦ start < index ≦ charArray.lengthに反した場合発生

    assert(codePoint == 0xDFB7)

    index = 3
    start = 1
    codePoint = Character.codePointBefore(charArray, index, start)

    assert(codePoint == 0x20BB7)

    index = 2
    start = 0
    codePoint = Character.codePointBefore(charArray, index, start)

    assert(codePoint == 0xD842)
  }
```
CharSequenceインターフェースを実装するオブジェクトからCode Pointに逆方向にCharacter.codePointBeforeメソッドで変換できます。
```scala
  @Test
  def testCharSequenceToCodePointInBackwardDirection(): Unit = {
    val charSequence: CharSequence = "CharSequenceは、String、StringBuilder、 StringBuffer、CharBufferなどが実装しているインターフェース"
    val index: Int = 1
    val codePoint: Int = Character.codePointBefore(charSequence, index)
    //NullPointerException:
    //charSequenceがnullである場合発生
    //IndexOutOfBoundsException:
    //1 ≦ index ≦ seq.lengthに反した場合発生

    assert(codePoint == 'C')
  }
```
StringオブジェクトからCode Pointに逆方向にString.codePointBeforeメソッドで変換できます。
```scala
  @Test
  def testStringToCodePointInBackwardDirection(): Unit = {
    val str: String = "CharSequenceは、String、StringBuilder、 StringBuffer、CharBufferなどが実装しているインターフェース"
    val index: Int = 1
    val codePoint: Int = str.codePointBefore(index)
    //NullPointerException:
    //seqがnullである場合発生
    //IndexOutOfBoundsException:
    //1 ≦ index ≦ seq.lengthに反した場合発生

    assert(codePoint == 'C')
  }
```
<h4>2.4.4　Surrogate Pairに対する挙動</h4>
<img src="https://github.com/ynupc/scalastringcourse/blob/master/image/day3/string_course.015.jpeg" width="500px"><br>
このスライドは、codePointAt/codePointBeforeメソッドが、Surrogate Pairを壊すように解析を開始・終了した場合の挙動を示します。Surrogate Pairが途中で切れてしまった場合にはSurrogate PairのCode Pointは取得できないため、観測されているSurrogateのCode Pointを返します。
***
<h3>2.5　CharSequenceとStringの相互変換</h3>
<img src="https://github.com/ynupc/scalastringcourse/blob/master/image/day3/string_course.016.jpeg" width="500px"><br>
CharSequenceインターフェースを実装したオブジェクトとStringオブジェクトとの間の相互変換について説明します。
<h4>2.5.1　StringからCharSequenceへの変換</h4>
StringオブジェクトはCharSequenceインターフェースを実装しているためStringオブジェクトからCharSequenceへはキャストすることができます。

```scala
  @Test
  def testStringToCharSequence(): Unit = {
    //cast
    val charSequence: CharSequence = "CharSequenceは、String、StringBuilder、 StringBuffer、CharBufferなどが実装しているインターフェース"

  }
```
<h4>2.5.2　CharSequenceからStringへの変換</h4>
CharSequenceインターフェースを実装しているオブジェクトはtoStringメソッドでStringオブジェクトに変換することができます。
```scala
  @Test
  def testCharSequenceToString(): Unit = {
    val charSequence: CharSequence = "CharSequenceは、String、StringBuilder、 StringBuffer、CharBufferなどが実装しているインターフェース"
    val str: String = charSequence.toString
    //NullPointerException:
    //charSequenceがnullである場合発生

    assert(charSequence == str)
  }
```
***
<h3>2.6　CharSequenceやStringとChar配列 (Array[Char])の相互変換</h3>
<img src="https://github.com/ynupc/scalastringcourse/blob/master/image/day3/string_course.017.jpeg" width="500px"><br>
Stringオブジェクト及びCharSequenceインターフェースを実装するオブジェクトとChar配列との相互変換について説明します。
<h4>2.6.1　CharSequenceからChar配列 (Array[Char])への変換</h4>
CharSequenceインターフェースを実装しているオブジェクトからChar配列へは、CharSequenceインターフェースのcharsメソッド（Java 8以降）で<a href="https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html" target="_blank">IntStream</a>を介して変換することができます。
```scala
  @Test
  def testCharSequenceToCharArray(): Unit = {
    val charSequence: CharSequence = "𠮷野家"
    val charArray: Array[Char] = charSequence.chars.toArray.map(_.toChar)
    //NullPointerException:
    //charSequenceがnullである場合発生

    assert(charArray.length == 4)
    assert(charArray.head == 0xD842)
    assert(charArray(1) == 0xDFB7)
    assert(charArray(2) == '野')
    assert(charArray.last == '家')
  }
```
<h4>2.6.2　StringからChar配列 (Array[Char])への変換</h4>
StringオブジェクトからChar配列へ、toCharArrayメソッドを使用して変換できます。
```scala
  @Test
  def testStringToCharArray1(): Unit = {
    val str: String = "𠮷野家"
    val charArray: Array[Char] = str.toCharArray
    //NullPointerException:
    //strがnullである場合発生

    assert(charArray.length == 4)
    assert(charArray.head == 0xD842)
    assert(charArray(1) == 0xDFB7)
    assert(charArray(2) == '野')
    assert(charArray.last == '家')
  }
```
CharSequenceインターフェースを実装しているStringオブジェクトからChar配列へは、CharSequenceインターフェースのcharsメソッド（Java 8以降）でIntStreamを介して変換することができます。
```scala
  @Test
  def testStringToCharArray2(): Unit = {
    val str: String = "𠮷野家"
    val charArray: Array[Char] = str.chars.toArray.map(_.toChar)
    //NullPointerException:
    //strがnullである場合発生

    assert(charArray.length == 4)
    assert(charArray.head == 0xD842)
    assert(charArray(1) == 0xDFB7)
    assert(charArray(2) == '野')
    assert(charArray.last == '家')
  }
```
<h4>2.6.3　Char配列 (Array[Char])からStringへの変換</h4>
Char配列からStringオブジェクトへは、Stringクラスのコンストラクタを使用して変換することができます。
```scala
  @Test
  def testCharArrayToString(): Unit = {
    val charArray: Array[Char] = Array(0xD842.toChar, 0xDFB7.toChar, '野', '家')
    val str = new String(charArray)

    assert(str == "𠮷野家")
  }
```
***
<h3>2.7　StringからChar数 (IntまたはLong)やCode Point数 (IntまたはLong)の取得</h3>
<img src="https://github.com/ynupc/scalastringcourse/blob/master/image/day3/string_course.018.jpeg" width="500px"><br>
StringオブジェクトからChar数とCodePoint数の取得方法を説明します。
Char数とCodePoint数はStringオブジェクト内にSurrogate Pairが存在しない場合は一致します。しかし、Surrogate Pairが含まれている場合には、Char数よりCode Point数が少なくなります。Char数からCode Point数を引いた数がStringオブジェクト内に存在するSurrogate Pairの数です。
```scala
  @Test
  def testNumOfCharactersAndChars(): Unit = {
    val strWithSurrogatePair: String = "𠮷野家"
    val strWithoutSurrogatePair: String = "吉野家"

    val numOfCharsOfStrWithSurrogatePair: Int = strWithSurrogatePair.length
    val numOfCharsOfStrWithoutSurrogatePair: Int = strWithoutSurrogatePair.length

    assert(numOfCharsOfStrWithSurrogatePair == 4)
    assert(numOfCharsOfStrWithoutSurrogatePair == 3)
    assert(numOfCharsOfStrWithoutSurrogatePair < numOfCharsOfStrWithSurrogatePair)

    val numOfCharactersOfStrWithSurrogatePair: Int = strWithSurrogatePair.codePointCount(0, strWithSurrogatePair.length)
    val numOfCharactersOfStrWithoutSurrogatePair: Int = strWithoutSurrogatePair.codePointCount(0, strWithoutSurrogatePair.length)

    assert(numOfCharactersOfStrWithSurrogatePair == 3)
    assert(numOfCharactersOfStrWithoutSurrogatePair == 3)
    assert(numOfCharactersOfStrWithSurrogatePair == numOfCharactersOfStrWithoutSurrogatePair)
  }
```
"𠮷野家"の"𠮷"はSurrogate Pairです。従って、Char数は4、Code Point数は3、Surrogate Pair数は1です。
一方で、"吉野家"の"吉"はSurrogate Pairではありません。従って、Char数は3、Code Point数は3、Surrogate Pair数は0です。
<h4>2.7.1　StringからChar数 (IntまたはLong)の取得</h4>
<img src="https://github.com/ynupc/scalastringcourse/blob/master/image/day3/string_course.019.jpeg" width="500px"><br>
Char数はString.lengthメソッドか、charsメソッドで一度IntStreamに変換しIntStreamのcountメソッドで取得できます。
```scala
  @Test
  def testNumOfChars(): Unit = {
    val strWithSurrogatePair: String = "𠮷野家"
    val strWithoutSurrogatePair: String = "吉野家"

    val numOfCharsOfStrWithSurrogatePair1: Int = strWithSurrogatePair.length
    val numOfCharsOfStrWithoutSurrogatePair1: Int = strWithoutSurrogatePair.length

    val numOfCharsOfStrWithSurrogatePair2: Long = strWithSurrogatePair.chars.count
    val numOfCharsOfStrWithoutSurrogatePair2: Long = strWithoutSurrogatePair.chars.count

    assert(numOfCharsOfStrWithSurrogatePair1 == numOfCharsOfStrWithSurrogatePair2)
    assert(numOfCharsOfStrWithoutSurrogatePair1 == numOfCharsOfStrWithoutSurrogatePair2)
  }
```
<h4>2.7.2　StringからCode Point数 (Int)の取得</h4>
<img src="https://github.com/ynupc/scalastringcourse/blob/master/image/day3/string_course.020.jpeg" width="500px"><br>
Code Point数はString.codePointCountメソッドか、codePointsメソッドで一度IntStreamに変換しIntStreamのcountメソッドで取得できます。
```scala
  @Test
  def testNumOfCharacters(): Unit = {
    val strWithSurrogatePair: String = "𠮷野家"
    val strWithoutSurrogatePair: String = "吉野家"

    val numOfCharactersOfStrWithSurrogatePair1: Int = strWithSurrogatePair.codePointCount(0, strWithSurrogatePair.length)
    val numOfCharactersOfStrWithoutSurrogatePair1: Int = strWithoutSurrogatePair.codePointCount(0, strWithoutSurrogatePair.length)

    val numOfCharactersOfStrWithSurrogatePair2: Long = strWithSurrogatePair.codePoints.count
    val numOfCharactersOfStrWithoutSurrogatePair2: Long = strWithoutSurrogatePair.codePoints.count

    assert(numOfCharactersOfStrWithSurrogatePair1 == numOfCharactersOfStrWithSurrogatePair2)
    assert(numOfCharactersOfStrWithoutSurrogatePair1 == numOfCharactersOfStrWithoutSurrogatePair2)
  }
```
***
<h3>2.8　CharSequenceやStringとCode Point配列 (Array[Int])の相互変換</h3>
<img src="https://github.com/ynupc/scalastringcourse/blob/master/image/day3/string_course.021.jpeg" width="500px"><br>
Stringオブジェクト及びCharSequenceインターフェースを実装するオブジェクトとCode Point配列との間の相互変換について説明します。
<h4>2.8.1　Code Point配列 (Array[Int])からStringへの変換</h4>
<img src="https://github.com/ynupc/scalastringcourse/blob/master/image/day3/string_course.022.jpeg" width="500px"><br>
Code Point配列からStringオブジェクトへはStringクラスのコンストラクタで変換できます。Code Point配列からCharSequenceへは一度Stringクラスのコンストラクトを介してStringオブジェクトに変換し、CharSequenceにキャストすることで変換可能です。
```scala
  @Test
  def testCodePointArrayToString(): Unit = {
    val codePointArray: Array[Int] = Array(0x20BB7, '野', '家')
    val str: String = new String(codePointArray, 0, codePointArray.length)

    assert(str == "𠮷野家")
  }
```
<h4>2.8.2　CharSequenceやStringからCode Point配列 (Array[Int])への変換</h4>
<img src="https://github.com/ynupc/scalastringcourse/blob/master/image/day3/string_course.023.jpeg" width="500px"><br>
Stringオブジェクト及びCharSequenceインターフェースを実装するオブジェクトからCode Point配列へはCharSequenceインターフェースのcodePointsメソッド（Java 8以降）でIntStreamを取得し、それをtoArrayメソッドで配列に変換できます。
```scala
  @Test
  def testCharSequenceToCodePointArray(): Unit = {
    val charSequence: CharSequence = "𠮷野家"
    val codePointArray: Array[Int] = charSequence.codePoints().toArray
    //NullPointerException:
    //charSequenceがnullである場合発生

    assert(codePointArray.length == 3)
    assert(codePointArray.head == 0x20BB7)
    assert(codePointArray(1) == '野')
    assert(codePointArray.last == '家')
  }
```
```scala
  @Test
  def testStringToCodePointArray(): Unit = {
    val str: String = "𠮷野家"
    val codePointArray: Array[Int] = str.codePoints().toArray
    //NullPointerException:
    //strがnullである場合発生

    assert(codePointArray.length == 3)
    assert(codePointArray.head == 0x20BB7)
    assert(codePointArray(1) == '野')
    assert(codePointArray.last == '家')
  }
```
***
<h3>2.9　Code Point数 (Int)だけ移動した位置のインデックス (Int)の取得</h3>
<img src="https://github.com/ynupc/scalastringcourse/blob/master/image/day3/string_course.024.jpeg" width="500px"><br>
codePointAt/codePointBeforeメソッドと同様に、CharacterクラスはChar配列、CharSequenceインターフェースを実装するオブジェクトに対して、Stringクラスは自身に対してoffsetByCodePointsメソッドを持っています。
```scala
  @Test
  def testOffsetByCodePoints1(): Unit = {
    val charArray: Array[Char] = Array(0xD842.toChar, 0xDFB7.toChar, '野', '家')
    val start: Int = 0
    val count: Int = charArray.length
    val index: Int = 0
    val numOfCodePoints: Int = 1
    val indexPlusOffsetByCodePoints: Int = Character.offsetByCodePoints(charArray, start, count, index, numOfCodePoints)
    //NullPointerException
    //charArrayがnullである場合

    //IndexOutOfBoundsException
    //１．startが負数の場合
    //２．countが負数の場合
    //３．indexがstart以上start + count以下に収まらない場合
    //４．charArray.length以下に収まらない場合
    //５．numOfCodePointsが0より大きく、
    //indexから始まりstart + count - 1で
    //終わる範囲のCode Point数が
    //numOfCodePointsより少ない場合
    //６．numOfCodePointsが0未満で
    //startから始まりindex - 1で終わる範囲のCode Point数が
    //numOfCodePointsの絶対値より少ない場合

    assert(indexPlusOffsetByCodePoints == 2)
  }
```
```scala
  @Test
  def testOffsetByCodePoints2(): Unit = {
    val charSequence: CharSequence = "𠮷野家"
    val index: Int = 0
    val numOfCodePoints: Int = 1
    val indexPlusOffsetByCodePoints: Int = Character.offsetByCodePoints(charSequence, index, numOfCodePoints)
    //NullPointerException
    //charSequenceがnullである場合

    //IndexOutOfBoundsException
    //１．indexが0以上charSequence.length()以下に収まらない場合
    //２．numOfCodePointsが0より大きく、
    //indexから始まるサブシーケンスの持つCode Point数が
    //numOfCodePoints未満の場合
    //３．numOfCodePointsが0未満で
    //indexの前のサブシーケンスの持つ値が
    //numCodePointsの絶対値よりも小さい場合

    assert(indexPlusOffsetByCodePoints == 2)
  }
```
```scala
  @Test
  def testOffsetByCodePoints3(): Unit = {
    val str: String = "𠮷野家"
    val index: Int = 0
    val numOfCodePoints: Int = 1
    val indexPlusOffsetByCodePoints: Int = str.offsetByCodePoints(index, numOfCodePoints)
    //NullPointerException
    //strがnullである場合

    //IndexOutOfBoundsException
    //１．indexが0以上str.length以下に収まらない場合
    //２．numOfCodePointsが0より大きく、
    //indexから始まるサブシーケンスの持つCode Point数が
    //numOfCodePoints未満の場合
    //３．numOfCodePointsが0未満で
    //indexの前のサブシーケンスの持つ値が
    //numCodePointsの絶対値よりも小さい場合

    assert(indexPlusOffsetByCodePoints == 2)
  }
```
***
<h3>2.10　StringからIteratorの生成</h3>
<h4>2.10.1　StringCharacterIteratorによるChar単位のIterator</h4>
<img src="https://github.com/ynupc/scalastringcourse/blob/master/image/day3/string_course.025.jpeg" width="500px"><br>
StringCharacterIteratorは、コンストラクタにStringオブジェクトを与えることでChar単位でイテレートすることができます。StringCharacterIteratorが実装するCharacterIteratorインターフェースは順方向から解析するためのfirstメソッドとnextメソッド、そして逆方向から解析するためのlastメソッドとpreviousメソッドを保持しています。CharacterIterator.DONEでイテレータの終了を判定します。CharacterIterator.DONEはUnicode上で文字が割り当てられていない<a href="http://www.fileformat.info/info/unicode/char/ffff/index.htm" target="_blank">U+FFFF</a>です。
サンプルコードは、Surrogate Pairを発見したら幽霊文字の「彁」に置き換える（呪詛的な）処理です。
```scala
  @Test
  def testStringCharacterForwardIterator(): Unit = {
    val str: String = "𠮷野家"
    val ghost: Char = '彁'
    val builder: StringBuilder = new StringBuilder(str.length)
    val iterator: CharacterIterator = new StringCharacterIterator(str)
    var char: Char = iterator.first()
    while (char != CharacterIterator.DONE) {
      if (Character.isHighSurrogate(char)) {
        char = iterator.next()
        if (Character.isLowSurrogate(char)) {
          builder.append(ghost)
        }
      } else {
        builder.append(char)
      }
      char = iterator.next()
    }

    assert(builder.result() == "彁野家")
  }
```
順方向から解析すると「𠮷」が「彁」に置き換わって"彁野家"が出力されます。
```scala
  @Test
  def testStringCharacterBackwardIterator(): Unit = {
    val str: String = "𠮷野家"
    val ghost: Char = '彁'
    val builder: StringBuilder = new StringBuilder(str.length)
    val iterator: CharacterIterator = new StringCharacterIterator(str)
    var char: Char = iterator.last()
    while (char != CharacterIterator.DONE) {
      if (Character.isLowSurrogate(char)) {
        char = iterator.previous()
        if (Character.isHighSurrogate(char)) {
          builder.append(ghost)
        }
      } else {
        builder.append(char)
      }
      char = iterator.previous()
    }

    assert(builder.result() == "家野彁")
  }
```
逆方向から解析すると結果は"家野彁"のように逆順になります。
<h4>2.10.2　IntStreamによるChar単位のIterator</h4>
次のプログラムはChar単位の順方向のIteratorです。
```scala
  @Test
  def testStringToCharLevelIntStreamForwardIterator(): Unit = {
    val str: String = "𠮷野家"
    val charArray: Array[Char] = str.toCharArray
    val iterator = str.chars.iterator
    var counter = 0
    while (iterator.hasNext) {
      val char: Char = iterator.nextInt.toChar

      assert(charArray(counter) == char)

      counter += 1
    }

    assert(counter == 4)
  }
```
次のプログラムはChar単位の逆方向のIteratorです。
```scala
  @Test
  def testStringToCharLevelIntStreamBackwardIterator(): Unit = {
    val str: String = "𠮷野家"
    val charArray: Array[Char] = str.toCharArray.reverse
    val iterator = str.chars.toArray.reverseIterator
    var counter = 0
    while (iterator.hasNext) {
      val char: Char = iterator.next.toChar

      assert(charArray(counter) == char)

      counter += 1
    }

    assert(counter == 4)
  }
```
<h4>2.10.3　IntStreamによるCode Point単位のIterator</h4>
次のプログラムはCode Point単位の順方向のIteratorです。
```scala
  @Test
  def testStringToCodePointLevelIntStreamForwardIterator(): Unit = {
    val str: String = "𠮷野家"
    val codePointArray: Array[Int] = toCodePoints(str)
    val iterator = str.codePoints.iterator
    var counter = 0
    while (iterator.hasNext) {
      val codePoint: Int = iterator.nextInt

      assert(codePointArray(counter) == codePoint)

      counter += 1
    }

    assert(counter == 3)
  }
```
次のプログラムはCode Point単位の逆方向のIteratorです。
```scala
  @Test
  def testStringToCodePointLevelIntStreamBackwardIterator(): Unit = {
    val str: String = "𠮷野家"
    val codePointArray: Array[Int] = toCodePoints(str).reverse
    val iterator = str.codePoints.toArray.reverseIterator
    var counter = 0
    while (iterator.hasNext) {
      val codePoint: Int = iterator.next

      assert(codePointArray(counter) == codePoint)

      counter += 1
    }

    assert(counter == 3)
  }
```
***
<h3>2.11　Code PointとSurrogate Pairに関する特に重要な変換</h3>
<img src="https://github.com/ynupc/scalastringcourse/blob/master/image/day3/string_course.026.jpeg" width="500px"><br>
Surrogate Pairを考慮して文字列をCode Pointで扱うためには、最低でもこのスライドで示したリンクは覚えて欲しいです。
***
<h3>2.12　Java 7以前のStringからCode Point配列 (Array[Int])への変換</h3>
<img src="https://github.com/ynupc/scalastringcourse/blob/master/image/day3/string_course.027.jpeg" width="500px"><br>
これまでに説明したStringオブジェクトからCode Point配列への変換は、Java 8で初めて作られたCharSequenceインターフェースのtoCodePointsメソッドによって可能となります。Java 7以前では、StringオブジェクトからどのようにするとCode Point配列が得られるのでしょうか。これに関するIBMのMasahiko Maederaさんが英語と日本語でJava言語で技術文書を公開しています。
<ul>
<li><a href="http://www.ibm.com/developerworks/library/j-unicode/" target="_blank">http://www.ibm.com/developerworks/library/j-unicode/</a>（英語）
<li><a href="https://www.ibm.com/developerworks/jp/java/library/j-unicode/" target="_blank">https://www.ibm.com/developerworks/jp/java/library/j-unicode/</a>（日本語）
<li><a href="https://www.ibm.com/developerworks/jp/ysl/library/java/j-unicode_surrogate/" target="_blank">https://www.ibm.com/developerworks/jp/ysl/library/java/j-unicode_surrogate/</a>（日本語）
</ul>
<img src="https://github.com/ynupc/scalastringcourse/blob/master/image/day3/string_course.028.jpeg" width="500px"><br>
IBMのMasahiko Maederaさんの技術文書によると、最も高速な変換は、StringをChar配列に変換して、Char配列からCode Point配列にCharacter.toCodePointメソッドを使用して変換する方法です。参考までに、サンプルコードにはこの変換方法をScalaで書いたものを載せました。
```scala
  @Test
  def testCharSequenceToCodePointArrayUnderJava8(): Unit = {
    val str: String = "𠮷野家"
    val codePointArray: Array[Int] = toCodePoints(str)
    //NullPointerException
    //strがnullである場合

    assert(codePointArray sameElements Array(0x20BB7, '野', '家'))
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
```
