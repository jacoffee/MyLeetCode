```java
/**

 https://leetcode.com/problems/inorder-successor-in-bst

 > Given a binary search tree and a node in it, find the in-order successor of that node in the BST.


     Given tree = [2,1] and node = 1:

         2
       /
     1

     return node 2.
     Given tree = [2,1,3] and node = 2:

       2
      / \
     1   3
     return node 3.

     给定TreeNode, 和另外一个节点, 找出另外节点在树中的后继
*/
public class InorderSuccessorBST {


    public TreeNode treeSuccessor(TreeNode root, int key) {
        if (root == null) return null;

        TreeNode parent = null;

        while (root != null) {

            if (key > root.val) {
                parent = root;
                root = root.right;
            } else if (key < root.val) {
                parent = root;
                root = root.left;
            } else {
                // 锁定该点之后, 如果右子树不为null, 则min(t.right); 否则就是该节点的父节点
                if (root.right != null) {
                   return root.right.min();
                } else {
                    System.out.println(" parent " + parent.val);
                    /*
                        2
                     1

                     返回2节点, 遍历的时候会把1在带出来
                     */
//                    if (parent != null) {
//                        parent.left = null;
//                    }
                    return parent;
                }

            }
        }

        return root;
    }

    public static void main(String[] args) {
        InorderSuccessorBST isb = new InorderSuccessorBST();

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

        TreeNode a3 = new TreeNode(3);
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);

//        a1.right= a2;
//        a3.left = a1;

        a2.left = a1;

        System.out.println(a2.traverse());
        System.out.println(isb.treeSuccessor(t2, 2).val);

    }


}
```