```java
import java.util.ArrayList;
import java.util.List;

/*
    https://leetcode.com/problems/kth-smallest-element-in-a-bst/

    遍历一遍, 然后Index. O(n) = n

*/
public class KthSmallest {

    public void inorderTraversal0(TreeNode root, List<Integer> ints) {
        if (root == null) return;
        inorderTraversal0(root.left, ints);
        ints.add(root.val);
        inorderTraversal0(root.right, ints);
    }

    // not so functional programming
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ints = new ArrayList<>();
        inorderTraversal0(root, ints);
        return ints;
    }

    // 这种实现都需要N次操作, 也就是要将整个树遍历一遍, 实际上完全没有必要
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> ints = inorderTraversal(root);
        return ints.get(k - 1);
    }

    public static void main(String[] args) {

        KthSmallest kk = new KthSmallest();

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);

        t2.left = t1;
        t2.right = t3;

        t6.left = t5;
        t6.right = t7;

        t4.left = t2;
        t4.right = t6;
    }

}
```