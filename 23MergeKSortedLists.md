```java
/*
   https://leetcode.com/problems/merge-k-sorted-lists/

   类似于数组的MergeSort, 区别只是需要实现有序链表的合并
*/
public class MergeKSortedList {

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode aux = new ListNode(-1);
        ListNode lastNode = aux;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                lastNode.next = l1;
                l1 = l1.next;
            } else {
                lastNode.next = l2;
                l2 = l2.next;
            }
            lastNode = lastNode.next;
        }

        if (l1 == null) {
            lastNode.next = l2;
        } else {
            lastNode.next = l1;
        }

        return aux.next;
    }

    public ListNode sort(ListNode[] lists, int low, int high) {
        if (low >= high) {
            return lists[low];
        } else {
            int mid = (low + high) / 2;
            ListNode left = sort(lists, low, mid);
            ListNode right = sort(lists, mid + 1, high);

            return merge(left, right);
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        else return sort(lists, 0, lists.length - 1);
    }

    public static void main(String[] args) {
        MergeKSortedList solution = new MergeKSortedList();

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode l6 = new ListNode(-3);
        ListNode l7 = new ListNode(-3);
        ListNode l8 = new ListNode(-2);
        ListNode l9 = new ListNode(0);

        l6.next = l7;
        l7.next = l8;
        l8.next = l9;

        ListNode[] nodes = new ListNode[]{};
        ListNode[] nodes1 = new ListNode[1];

        ListNode result = solution.mergeKLists(nodes);
        System.out.println("合成之后的结果");
        System.out.println(result);

    }
}
```