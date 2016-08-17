import java.util.ArrayList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode node = this;

        do {
            arr.add(node.val);
            node = node.next;
        } while (node != null);

        return arr.toString();
    }

    private ListNode removeHead(ListNode node) {
        if (node == null) return node;
        if (node.next == null) return node;
        node = node.next;
        return node;
    }

    // return node after head removed
    public ListNode removeHead() {
        return removeHead(this);
    }

    /*
        node --->  |  1 - > 2 |
                   |          |
                   |          |  <------ node.copy ()

        ---

        node --->  |      |
                   |      |
                   |  1   |  <------ node.copy ()

        node.copy and node share the same memory, so the node.copy()'s change will affect the memory
    */
    private ListNode removeEnd(ListNode node) {
        if (node == null) return node;
        if (node.next == null) return node.next;

        ListNode copycat = node;

        while(!(copycat.next != null && copycat.next.next == null)) {
            copycat = copycat.next;
        }

        copycat.next = null;
        return node;
    }

    // return node after end removed
    public ListNode removeEnd() {
        return removeEnd(this);
    }

    // return node with certain key moved after end removed

    // A ==> B ===> C
    // A.next = A.next.next
    // B.next = null for garbage collection
    private ListNode remove(ListNode node, int key) {
        if (node == null) return node;
        if (node.next == null) {
            if (node.val == key) return null;
            else return node;
        }

        ListNode copycat = node;

        while( (copycat != null) && (!(copycat.next != null && copycat.next.val == key)) ) {
            copycat = copycat.next;
        }

        if (copycat == null) return node;
        else {
            ListNode b = copycat.next;
            copycat.next = copycat.next.next;
            b.next = null; // garbage
            return node;
        }
    }
}