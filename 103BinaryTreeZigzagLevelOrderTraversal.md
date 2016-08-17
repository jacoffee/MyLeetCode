```java
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
    https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

          4
       2     6
    1    3  5   7

    4 -> 2 -> 6 -> 1 -> 3 -> 5 -> 7
    广度优先


    |           |
    |     6      |
    |   5   7    |
    |     2      |
    |   1   3    |
    + 什么时候转移到下一层 ||
    + List[List[Integer]]中每一个集合何时装满
    + 整个递归何时终止
*/
public class BinaryTreeZigzagLevelOrderTraversa {

    public void dfSearch(TreeNode root) {
        if (root == null) return;
        java.util.Queue<TreeNode> q = new java.util.LinkedList();
        if (q.isEmpty()) q.add(root);

        while (!q.isEmpty()) {
            TreeNode head = q.poll();
            System.out.println(" element " + head.val);

            if (head.left != null) {
                q.add(head.left);
            }
            if (head.right != null) {
                q.add(head.right);
            }
        }
    }

    public void bfCollect1(Stack<TreeNode> stack, List<List<Integer>> result) {
        if (stack.isEmpty()) return;

        // 左右 || 右左
        List<Integer> ints = new ArrayList<>();
        // 存放每次遍历完之后, 放当次Stack的状态
        Stack<TreeNode> newStack = new Stack<>();

        while (!stack.isEmpty()) {
            //
            TreeNode root = stack.pop();
            ints.add(root.val);

            // 如果Result目前的元素个数是偶数, 接下来的遍历方向就应该 左 ==> 右
            if (result.size() % 2 == 0) {
                if (root.left != null) {
                    newStack.push(root.left);
                }
                if (root.right != null) {
                    newStack.push(root.right);
                }
            } else {
                if (root.right != null) {
                    newStack.push(root.right);
                }
                if (root.left != null) {
                    newStack.push(root.left);
                }
            }
        }

        result.add(ints);
        stack = newStack;
        bfCollect1(stack, result);
    }


    public List<List<Integer>> zigzagOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        bfCollect1(stack, result);

        return result;
    }

    public static void main(String[] args) {
        BinaryTreeZigzagLevelOrderTraversa tn = new BinaryTreeZigzagLevelOrderTraversa();

        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(6);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(3);
        TreeNode t6 = new TreeNode(5);
        TreeNode t7 = new TreeNode(7);

        t1.left = t2;
        t1.right = t3;

        t2.left = t4;
        t2.right = t5;

        t3.left = t6;
        t3.right = t7;

        System.out.println(tn.zigzagOrder(t1));
    }

}
```