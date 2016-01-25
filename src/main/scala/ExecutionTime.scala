/**
  * 処理の実行時間計測
  * @param n 試行回数
  */
class ExecutionTime(val n: Int) {
  /**
    * 処理の平均実行時間をミリ秒単位で標準出力
    * @param proc 処理
    */
  def printlnAverageExecutionTime(proc : => Unit): Unit = {
    val executionTime: Double =
      if (n <= 1) {
        getExecutionTime(proc)
      } else {
        getAverageExecutionTime(proc)
      }
    val nanoSeconds: Long = math.round(executionTime)
    printf("%,d [nano seconds] (the average of %,d times)%n", nanoSeconds, n)
  }

  /**
    * 処理の平均実行時間を測定
    * @param proc 処理
    * @return 処理の平均実行時間
    */
  def getAverageExecutionTime(proc : => Unit): Double = {
    //オーバーフロー対策としてBigIntを使用
    var total: BigInt = BigInt(0)
    for (i <- 0 until n) {
      total += getExecutionTime(proc)
    }
    //平均化で浮動小数を使用するためにBigDecimalに変換し、平均化後、Doubleに変換
    (BigDecimal(total) / n).toDouble
  }

  /**
    * 実行時間を測定
    * @param proc 処理
    * @return 処理の実行時間
    */
  def getExecutionTime(proc : => Unit): Long = {
    //System.currentTimeMillisより精度が高いSystem.nanoTimeを使用
    val startTime: Long = System.nanoTime
    proc
    val endTime: Long = System.nanoTime
    endTime - startTime
  }
}
