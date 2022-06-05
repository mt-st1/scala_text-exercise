object Ex {

  /**
   * [練習問題]
   * DayOfWeek型を使って、ある日の次の曜日を返すメソッドnextDayOfWeekをパターンマッチを用いて定義してみましょう
   */
  def nextDayOfWeek(d: DayOfWeek): DayOfWeek = d match {
    case Sunday => Monday
    case Monday => Tuesday
    case Tuesday => Wednesday
    case Wednesday => Thursday
    case Thursday => Friday
    case Friday => Saturday
    case Saturday => Sunday
  }

}
