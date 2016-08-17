```java
import java.util.ArrayList;
import java.util.List;

/*
    Recursive solution is trivial, could you do it iteratively?
    (左 -> 中 -> 右) => 中 => (左 -> 中 -> 右)
*/
public class BinaryTreeInorderTraversal {

    public void inorderTraversal1(TreeNode root, List<Integer> ints) {
        if (root == null) return;
        inorderTraversal1(root.left, ints);
        ints.add(root.val);
        inorderTraversal1(root.right, ints);
    }

    // not so functional programming
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ints = new ArrayList<>();
        inorderTraversal1(root, ints);
        return ints;
    }

    public static void main(String[] args) {

        BinaryTreeInorderTraversal tt = new BinaryTreeInorderTraversal();

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

        System.out.println(tt.inorderTraversal(t4));
    }
}
```