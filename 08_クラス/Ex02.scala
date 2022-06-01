/**
 * 抽象クラス Shape を継承して、 Rectangle クラス（長方形クラス）とCircle クラス（円クラス）を定義してください
 * また、area メソッドをオーバーライドして、ただしく面積が計算できるように定義してください
 */

object Ex02 {

  abstract class Shape {
    def area: Double
  }

  class Rectangle(val w: Double, val h: Double) extends Shape {
    override def area: Double = w * h
  }

  class Circle(val r: Double) extends Shape {
    override def area: Double = r * r * math.Pi
  }

}

