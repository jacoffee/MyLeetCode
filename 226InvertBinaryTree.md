```java
/**
 https://leetcode.com/problems/invert-binary-tree/

     4
   /   \
  2     7
  / \   / \
 1   3 6   9

      4
    /   \
  7     2
 / \   / \
9   6 3   1
*/


public class InvertBST {

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        else {
             TreeNode left = invertTree(root.left);
             TreeNode right = invertTree(root.right);
             root.left = right;
             root.right = left;
             return root;
        }
    }

    public static void main(String[] args) {

        InvertBST instance = new InvertBST();

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

        TreeNode t8 = new TreeNode(4);
        TreeNode t9 = new TreeNode(6);
        TreeNode t10 = new TreeNode(1);
        TreeNode t11 = new TreeNode(3);
        TreeNode t12 = new TreeNode(7);

        t10.right = t12;
        t9.left = t10;
        t9.right = t11;
        t8.right = t9;

        System.out.println(instance.invertTree(t8).traverse());
    }
}
```