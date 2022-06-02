object Ex {

  /**
   * [練習問題1]
   * 配列のi番目の要素とj番目の要素を入れ替えるswapArrayメソッドを定義してみましょう
   */
  def swapArray[T] (arr: Array[T])(i: Int, j: Int): Unit = {
    val tmp = arr(i)
    arr(i) = arr(j)
    arr(j) = tmp
  }

  /**
   * [練習問題2]
   * mkStringを使って、最初の数startと最後の数endを受け取って、
   * 「start,(start+1),(start+2)...,end」となるような文字列を返すメソッドjoinByCommaを定義してみましょう
   */
  def joinByComma(start: Int, end: Int): String = {
    (start to end).mkString(",")
  }

  /**
   * [練習問題3]
   * foldLeftを用いて、Listの要素を反転させる次のシグニチャを持ったメソッドreverseを実装してみましょう
   */
  def reverse[T](list: List[T]): List[T] = list.foldLeft(Nil: List[T])((acc, x) => x :: acc)

  /**
   * [練習問題4]
   * Listの全ての要素を足し合わせるメソッドsumをfoldRightを用いて実装してみましょう
   */
  def sum(list: List[Int]): Int = list.foldRight(0)((x, acc) => x + acc)

  /**
   * [練習問題5]
   * Listの全ての要素を掛け合わせるメソッドmulをfoldRightを用いて実装してみましょう
   */
  def mul(list: List[Int]): Int = list.foldRight(1)((x, acc) => x * acc)

  /**
   * [練習問題6]
   * mkStringを実装してみましょう。mkStringそのものを使ってはいけませんが、
   * foldLeftやfoldRightなどのListに定義されている他のメソッドは自由に使って構いません
   */
  def mkString[T](list: List[T])(sep: String): String = {
    list match {
      case Nil => ""
      case x::xs => xs.foldLeft(x.toString)((acc, cur) => acc + sep + cur)
    }
  }

  /**
   * [練習問題7]
   * mapメソッドをfoldLeftとreverseを使って実装してみましょう
   */
  def map[T, U](list: List[T])(f: T => U): List[U] = {
    list.foldLeft(Nil: List[U])((acc, x) => f(x) :: acc).reverse
  }

  /**
   * [練習問題8]
   * filterメソッドをfoldLeftとreverseを使って実装してみましょう
   */
  def filter[T](list: List[T])(f: T => Boolean): List[T] = {
    list.foldLeft(Nil: List[T])((acc, x) => if (f(x)) x::acc else acc).reverse
  }

  /**
   * [練習問題9]
   * findメソッドをfoldLeftまたは再帰で実装してみましょう
   */
  def find[T](list: List[T])(f: T => Boolean): Option[T] = {
    list match {
      case x::xs if f(x) => Some(x)
      case x::xs => find(xs)(f)
      case _ => None
    }
  }

  /**
   * [練習問題10]
   * takeWhileメソッドをループまたは再帰を使って実装してみましょう
   */
  def takeWhile[T](list: List[T])(f: T => Boolean): List[T] = {
    list match {
      case x::xs if f(x) => x::takeWhile(xs)(f)
      case _ => Nil
    }
  }

  /**
   * [練習問題11]
   * countメソッドをfoldLeftを使って実装してみましょう
   */
  def count[T](list: List[T])(f: T => Boolean): Int = {
    list.foldLeft(0)((acc, x) => if (f(x)) acc + 1 else acc)
  }

  /**
   * [練習問題12]
   * flatMapメソッドを再帰やループで実装してみましょう
   */
  def flatMap[T, U](list: List[T])(f: T => List[U]): List[U] = {
    list match {
      case x::xs => f(x) ++ flatMap(xs)(f)
      case Nil => Nil
    }
  }

}
