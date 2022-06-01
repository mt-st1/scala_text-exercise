/**
 * whileを利用して、0から数え上げて9まで出力して10になったらループを終了するメソッドloopFrom0To9を書いてみましょう
 */

object Ex03 {

  def loopFrom0To9(): Unit = {
    var i = 0
    while (i < 10) {
      println(i)
      i += 1
    }
  }

}

