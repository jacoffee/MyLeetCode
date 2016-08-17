```java
/*
  https://leetcode.com/problems/merge-two-sorted-lists/

  Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.


    A  1 -> 2 -> 3

    B  2 -> 3 -> 4

if    A(1) < B(1)
then
    A  1      2 -> 3
         \   /
    B      2   3 -> 4

finally
                    cursor
                    ||
    A  1  -> 2  ->  2 -> 3

               cursor
              ||
    B         3 -> 4


    A2 = A1.next

    B2 = B1.next
    B1.next = A2

    A1.next = B1
*/

import java.util.ArrayList;

public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode aux = new ListNode(-1);
        // copy the implementation in Java LinkedList
        // adding node to the LastNode of the ListNode
        ListNode lastNode = aux;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                lastNode.next = l1;
                l1 = l1.next;
            } else {
                lastNode.next = l2;
                l2 = l2.next;
            }
            // 将LastNode的指针指向末尾 准备下一次拼接
            lastNode = lastNode.next;
        }

        // 判断到底是l1还是l2为空
        if (l1 == null) {
            lastNode.next = l2;
        } else {
            lastNode.next = l1;
        }

        return aux.next;
    }

    public static void main(String[] args) {
        MergeTwoSortedList solution = new MergeTwoSortedList();

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode l6 = new ListNode(2);
        ListNode l7 = new ListNode(3);
        ListNode l8 = new ListNode(4);
        ListNode l9 = new ListNode(5);

//        l6.next = l7;
//        l7.next = l8;
//        l8.next = l9;

        ListNode result = solution.mergeTwoLists(l1, l6);
        System.out.println("合成之后的结果");
        System.out.println(result);

    }
}
```