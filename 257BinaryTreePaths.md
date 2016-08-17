```java
import java.util.ArrayList;
import java.util.List;

/*
   https://leetcode.com/problems/binary-tree-paths/

      1
     /   \
    2     3
     \
      5

    ["1->2->5", "1->3"]

    每次循环的时候, 根节点先放入字符串中; 如果左子树存在则进行拼接, 如果右子树存在则进行拼接;
    当左右子树都为null的时候, 则开始往最后的集合中添加
*/
public class BinaryTreePath {

    public List<String> binaryTreePaths3(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        aux(root, String.valueOf(root.val), result);
        return result;
    }


    // 将路径值放到result上面; path相当于Stack实现中父栈
    private void aux(TreeNode root, String path, List<String> result) {
        if (root == null) return;

        // Stack实现中的 出栈的点
        if (root.left == null && root.right == null) {
            result.add(path);
        }

        // 4 -> 2 -> 1 ==  |4| -> |2 -> 1| == |4 -> 2| -> 1
        if (root.left != null) {
            aux(root.left, path + "->" + String.valueOf(root.left.val), result);
        }

        if (root.right != null) {
            aux(root.right, path + "->" + String.valueOf(root.right.val), result);
        }
    }

    public static void main(String[] args) {
        BinaryTreePath bt = new BinaryTreePath();

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);

        t4.left = t2;
        t4.right = t6;

        t2.left = t1;
        // t2.right = t3;

        t6.left = t5;
        t6.right = t7;

        System.out.println(bt.binaryTreePaths3(t4));
    }
}
```