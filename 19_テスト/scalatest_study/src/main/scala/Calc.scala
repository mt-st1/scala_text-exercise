class Calc {

  /** 整数の配列を受け取り、それらを足し合わせた整数を返す
    *
    * Int の最大値を上回った際にはオーバーフローする
    */
  def sum(seq: Seq[Int]): Int = seq.foldLeft(0)(_ + _)

  /** 整数を2つ受け取り、分子を分母で割った浮動小数点の値を返す
    *
    * 0 で割ろうとした際には実行時例外が投げられる
    */
  def div(num: Int, denom: Int): Double = {
    if (denom == 0) throw new ArithmeticException("/ by zero")
    num.toDouble / denom.toDouble
  }

  /** 整数を1つ受け取り、その値が素数であるかどうかのブール値を返す */
  def isPrime(n: Int): Boolean = {
    if (n < 2) false else !((2 to Math.sqrt(n).toInt) exists (n % _ == 0))
  }

}
