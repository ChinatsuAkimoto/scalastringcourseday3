<h1>Day 3 コードポイントとサロゲートペア</h1>
<img src="/image/string_course.001.jpeg" width="500px"><br>
今日は、コードポイントとサロゲートペアについて紹介したいと思います。  

<h2>リポジトリ（サンプルコード）</h2>
<a href="https://github.com/ynupc/scalastringcourseday3" target="_blank">https://github.com/ynupc/scalastringcourseday3</a>  

<h2>クイズ</h2>
<a href="http://ynupc.github.io/quiz/scalastringcourse/day3/" target="_blank">http://ynupc.github.io/quiz/scalastringcourse/day3/</a>  

<h2>目次</h2>
<strong><a href="doc/theory.md#1コードポイントとサロゲートペアの理論">1.　コードポイントとサロゲートペアの理論</a></strong>  
<strong><a href="doc/theory.md#11コードポイント">1.1　コードポイント</a></strong>  
<a href="doc/theory.md#コラムbomとeエンディアン">コラム：BOMとエンディアン</a>  
<a href="doc/theory.md#コラムutf-8のbomを削除する方法">コラム：UTF-8のBOMを削除する方法</a>  
<a href="doc/theory.md#１vimによるutf-8のbomの手動削除">（１）VimによるUTF-8のBOMの手動削除</a>  
<a href="doc/theory.md#２scalaによるutf-8のbomの自動削除">（２）ScalaによるUTF-8のBOMの自動削除</a>  
<a href="doc/theory.md#コラムutf-8のセキュリティ問題nimda">コラム：UTF-8のセキュリティ問題、Nimda</a>  
<a href="doc/theory.md#コラムutf-8のテキストのmysqlへの保存utf8mb4">コラム：UTF-8のテキストのMySQLへの保存、utf8mb4</a>  
<strong><a href="doc/theory.md#12サロゲートペア">1.2　サロゲートペア</a></strong>    
<strong><a href="doc/theory.md#13コードポイントとサロゲートペアの相互変換式">1.3　コードポイントとサロゲートペアの相互変換式</a></strong>  

<strong><a href="doc/implementation.md#2コードポイントとサロゲートペアの実装">2.　コードポイントとサロゲートペアの実装</a></strong>  
<strong><a href="doc/implementation.md#21サロゲートペア-arraycharとコードポイント-intの相互変換">2.1　サロゲートペア (Array[Char])とコードポイント (Int)の相互変換</a></strong>  
<strong><a href="doc/implementation.md#211サロゲートペア-arraycharからコードポイント-intへの変換">2.1.1　サロゲートペア (Array[Char])からコードポイント (Int)への変換</a></strong>  
<strong><a href="doc/implementation.md#212コードポイント-intからサロゲートペア-arraycharへの変換">2.1.2　コードポイント (Int)からサロゲートペア (Array[Char])への変換</a></strong>  
<strong><a href="doc/implementation.md#22コードポイント-intからchar数-intの取得">2.2　コードポイント (Int)からChar数 (Int)の取得</a></strong>  
<strong><a href="doc/implementation.md#23コードポイント-intから上位サロゲート-charや下位サロゲート-charの取得">2.3　コードポイント (Int)から上位サロゲート (Char)や下位サロゲート (Char)の取得</a></strong>  
<strong><a href="doc/implementation.md#231コードポイント-intから上位サロゲート-charの取得">2.3.1　コードポイント (Int)から上位サロゲート (Char)の取得</a></strong>  
<strong><a href="doc/implementation.md#232コードポイント-intから下位サロゲート-charの取得">2.3.2　コードポイント (Int)から下位サロゲート (Char)の取得</a></strong>  
<strong><a href="doc/implementation.md#24charsequenceやstringやchar配列-arraycharからコードポイント-intの取得">2.4　CharSequenceやStringやChar配列 (Array[Char])からコードポイント (Int)の取得</a></strong>  
<strong><a href="doc/implementation.md#241指定インデックス-intにある文字のコードポイント-intの取得">2.4.1　指定インデックス (Int)にある文字のコードポイント (Int)の取得</a></strong>  
<strong><a href="doc/implementation.md#242順方向に解析しコードポイント-intを取得">2.4.2　順方向に解析しコードポイント (Int)を取得</a></strong>  
<strong><a href="doc/implementation.md#243逆方向に解析しコードポイント-intを取得">2.4.3　逆方向に解析しコードポイント (Int)を取得</a></strong>  
<strong><a href="doc/implementation.md#244サロゲートペアに対する挙動">2.4.4　サロゲートペアに対する挙動</a></strong>  
<strong><a href="doc/implementation.md#25charsequenceとstringの相互変換">2.5　CharSequenceとStringの相互変換</a></strong>  
<strong><a href="doc/implementation.md#251stringからcharsequenceへの変換">2.5.1　StringからCharSequenceへの変換</a></strong>  
<strong><a href="doc/implementation.md#252charsequenceからstringへの変換">2.5.2　CharSequenceからStringへの変換</a></strong>  
<strong><a href="doc/implementation.md#26charsequenceやstringとchar配列-arraycharの相互変換">2.6　CharSequenceやStringとChar配列 (Array[Char])の相互変換</a></strong>  
<strong><a href="doc/implementation.md#261charsequenceからchar配列-arraycharへの変換">2.6.1　CharSequenceからChar配列 (Array[Char])への変換</a></strong>  
<strong><a href="doc/implementation.md#262stringからchar配列-arraycharへの変換">2.6.2　StringからChar配列 (Array[Char])への変換</a></strong>  
<strong><a href="doc/implementation.md#263char配列-arraycharからstringへの変換">2.6.3　Char配列 (Array[Char])からStringへの変換</a></strong>  
<strong><a href="doc/implementation.md#27stringからchar数-intまたはlongやコードポイント数-intまたはlongの取得">2.7　StringからChar数 (IntまたはLong)やコードポイント数 (IntまたはLong)の取得</a></strong>  
<strong><a href="doc/implementation.md#271stringからchar数-intまたはlongの取得">2.7.1　StringからChar数 (IntまたはLong)の取得</a></strong>  
<strong><a href="doc/implementation.md#272stringからコードポイント数-intの取得">2.7.2　Stringからコードポイント数 (IntまたはLong)の取得</a></strong>  
<strong><a href="doc/implementation.md#28charsequenceやstringとコードポイント配列-arrayintの相互変換">2.8　CharSequenceやStringとコードポイント配列 (Array[Int])の相互変換</a></strong>  
<strong><a href="doc/implementation.md#281コードポイント配列-arrayintからstringへの変換">2.8.1　コードポイント配列 (Array[Int])からStringへの変換</a></strong>  
<strong><a href="doc/implementation.md#282charsequenceやstringからコードポイント配列-arrayintへの変換">2.8.2　CharSequenceやStringからコードポイント配列 (Array[Int])への変換</a></strong>  
<strong><a href="doc/implementation.md#29コードポイント数-intだけ移動した位置のインデックス-intの取得">2.9　コードポイント数 (Int)だけ移動した位置のインデックス (Int)の取得</a></strong>  
<strong><a href="doc/implementation.md#210stringからイテレータの生成">2.10　Stringからイテレータの生成</a></strong>  
<strong><a href="doc/implementation.md#2101stringcharacteriteratorによるchar単位のイテレータ">2.10.1　StringCharacterIteratorによるChar単位のイテレータ</a></strong>  
<strong><a href="doc/implementation.md#2102intstreamによるchar単位のイテレータ">2.10.2　IntStreamによるChar単位のイテレータ</a></strong>  
<strong><a href="doc/implementation.md#2103intstreamによるコードポイント単位のイテレータ">2.10.3　IntStreamによるコードポイント単位のイテレータ</a></strong>  
<strong><a href="doc/implementation.md#211コードポイントとサロゲートペアに関する特に重要な変換">2.11　コードポイントとサロゲートペアに関する特に重要な変換</a></strong>  
<strong><a href="doc/implementation.md#212java-7以前のstringからコードポイント配列-arrayintへの変換">2.12　Java 7以前のStringからコードポイント配列 (Array[Int])への変換</a></strong>
