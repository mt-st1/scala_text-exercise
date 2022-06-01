/**
 * withFileメソッドを使って、テキストファイルの中身を一行ずつ表示する関数printFileを実装してみましょう
 */

object Ex {

  import scala.io.Source

  def withFile[A](filename: String)(f: Source => A): A = {
    val s = Source.fromFile(filename)
    try {
      f(s)
    } finally {
      s.close()
    }
  }

  def printFile(filename: String): Unit = {
    withFile(filename) { f =>
      f.getLines.foreach(println)
    }
  }

}

