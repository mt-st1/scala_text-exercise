/**
 * [練習問題]
 * 二分木（子の数が最大で2つであるような木構造）を表す型TreeとBranch, Emptyを考えます：
 * このような木構造に対して、
 * 最大値を求めるmaxメソッド、最小値を求めるminメソッド、深さを求めるdepthメソッド
 * をそれぞれ定義してみましょう。
 * 余裕があれば木構造を、
 * 左の子孫の全ての値 <= 自分自身の値 < 右の子孫の全部の値
 * となるような木構造に変換するsortメソッドを定義してみましょう。
 */
object BinaryTree {

  sealed abstract class Tree
  case class Branch(value: Int, left: Tree, right: Tree) extends Tree
  case object Empty extends Tree


  def max(t: Tree): Int = t match {
    case Branch(v, Empty, Empty) => v
    case Branch(v, l, Empty) =>
      val x = max(l)
      if (v < x) x else v
    case Branch(v, Empty, r) =>
      val x = max(r)
      if (v < x) x else v
    case Branch(v, l, r) =>
      val x = max(l)
      val y = max(r)
      if (v < x) {
        if (y < x) x else y
      } else {
        if (y < v) v else y
      }
    case Empty =>
      throw new RuntimeException
  }


  def min(t: Tree): Int = t match {
    case Branch(v, Empty, Empty) => v
    case Branch(v, l, Empty) =>
      val x = min(l)
      if (v < x) v else x
    case Branch(v, Empty, r) =>
      val x = min(r)
      if (v < x) v else x
    case Branch(v, l, r) =>
      val x = min(l)
      val y = min(r)
      if (v < x) {
        if (v < y) v else y
      } else {
        if (x < y) x else y
      }
    case Empty =>
      throw new RuntimeException
  }


  def depth(t: Tree): Int = t match {
    case Empty => 0
    case Branch(_, l, r) =>
      val ldepth = depth(l)
      val rdepth = depth(r)
      (if (ldepth < rdepth) rdepth else ldepth) + 1
  }


  def toList(t: Tree): List[Int] = t match {
    case Empty => Nil
    case Branch(v, l, r) => toList(l) ++ List(v) ++ toList(r)
  }


  def sort(t: Tree): Tree = {
    def fromList(l: List[Int]): Tree = {
      def insert(value: Int, t: Tree): Tree = t match {
        case Empty => Branch(value, Empty, Empty)
        case Branch(v, l, r) =>
          if (value <= v) Branch(v, insert(value, l), r)
          else Branch(v, l, insert(value, r))
      }

      l.foldLeft(Empty: Tree)((t, v) => insert(v, t))
    }

    fromList(toList(t))
  }

}

