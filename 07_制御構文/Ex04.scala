/**
 * 最初と最後の文字が同じ英数字であるランダムな5文字の文字列を1000回出力してください
 */

object Ex04 {

  def main(args: Array[String]): Unit = {
    for (_ <- 1 to 1000) {
      val s = new scala.util.Random(new java.security.SecureRandom()).alphanumeric.take(5).toList match {
        case List(a, b, c, d, _) => List(a, b, c, d, e).mkString
      }
      println(s)
    }
  }

}

