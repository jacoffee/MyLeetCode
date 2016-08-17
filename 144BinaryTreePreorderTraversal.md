```java
import java.util.ArrayList;
import java.util.List;

/**
    https://leetcode.com/problems/binary-tree-preorder-traversal/

   中 => 左节点(中 -> 左 -> 右) => 右节点(中 -> 左 -> 右)
*/
public class BinaryTreePreorderTraversal {

    public void preorderTraversal1(TreeNode root, List<Integer> ints) {
        if (root == null) return;
        ints.add(root.val);
        preorderTraversal1(root.left, ints);
        preorderTraversal1(root.right, ints);
    }

    // not so functional programming
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ints = new ArrayList<>();
        preorderTraversal1(root, ints);
        return ints;
    }

    public static void main(String[] args) {

        BinaryTreePreorderTraversal tt = new BinaryTreePreorderTraversal();

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

        System.out.println(tt.preorderTraversal(t4));
    }

}
```