```scala
object MergeSort {
  // 左 右分别进行mergeSort
  // merge two ordered List - accurately to build ordered list from single element
  private def merge[A: Ordering](first: List[A], second: List[A]): List[A] = {
    (first, second) match {
      case (Nil, s) => s // 因为都是排好序 如果一边被遍历完了, 则说明这边比另一边都小
      case (f, Nil) => f
      case (f @ h1 :: t1, s @ h2 :: t2) =>
        if (implicitly[Ordering[A]].lteq(h1, h2)) h1 :: merge(t1, s)
        else h2 :: merge(f, t2)
    }
  }

  def mergeSort[A: Ordering](list: List[A]): List[A] = {
    val n = list.size
    if (n / 2 == 0) list
    else {
      val (firstHalf, secondHalf) = list.splitAt(n / 2)

      // 拆分
      val newFirstHalf = mergeSort(firstHalf) // List(6, 7) -- List(6) List(7)
      val newSecondHalf = mergeSort(secondHalf) // List(8, 9) -- List(8) List(9)

      // 合并
      merge(newFirstHalf, newSecondHalf)
    }
  }
}
```