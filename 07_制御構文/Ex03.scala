/**
 * 1から1000までの3つの整数a, b, cについて、三辺からなる三角形が直角三角形になるような a, b, cの組み合わせを全て出力してください
 * 直角三角形の条件にはピタゴラスの定理を利用してください
 */

object Ex03 {

  def main(args: Array[String]): Unit = {
    for (a <- 1 to 1000; b <- 1 to 1000; c <- 1 to 1000 if a * a == b * b + c * c) {
      println((a, b, c))
    }
  }

}

