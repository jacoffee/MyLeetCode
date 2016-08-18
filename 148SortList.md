```java
/**
    https://leetcode.com/problems/sort-list/

	分治算法
	链表的中点确认
	两个有序链表的合并	
*/
public class SortLinkedList {

    private ListNode merge(ListNode l1, ListNode l2) {
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


    private ListNode findMiddle(ListNode head) {
        ListNode middle = head, high = head.next;

        while (high != null && high.next != null) {
           middle = middle.next;
           high = high.next.next;
        }

        return middle;
    }

    public ListNode sortList(ListNode head) {
        // 为空或者是单节点链表
       if (head == null || head.next == null) { // l.size / 2 == 0
            return head;
       }

       ListNode middle = findMiddle(head);
       ListNode right = sortList(middle.next);
       middle.next = null;
       ListNode left = sortList(head);

       return merge(left, right);
    }

    public static void main(String[] args) {
        SortLinkedList solution = new SortLinkedList();

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode l6 = new ListNode(1);
        ListNode l7 = new ListNode(2);
        ListNode l8 = new ListNode(3);
        ListNode l9 = new ListNode(10);

        l6.next = l7;
        l7.next = l8;
        l8.next = l9;

        ListNode l10 = new ListNode(10);
        ListNode l11 = new ListNode(6);
        ListNode l12 = new ListNode(12);
        ListNode l13 = new ListNode(4);

        l10.next = l11;
        l11.next = l12;
        l12.next = l13;


        //ListNode result = solution.sortList1(l10);
        ListNode result = solution.sortList(l10);
        System.out.println("合成之后的结果");
        System.out.println(result);
    }
}
```