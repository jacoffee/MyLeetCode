```java
import java.util.ArrayList;
import java.util.List;

/**
 https://leetcode.com/problems/sum-root-to-leaf-numbers/

 Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

 An example is the root-to-leaf path 1->2->3 which represents the number 123.

 Find the total sum of all root-to-leaf numbers.

 For example,

 1
 / \
 2   3
 The root-to-leaf path 1->2 represents the number 12.
 The root-to-leaf path 1->3 represents the number 13.

 Return the sum = 12 + 13 = 25.

    如果当前节点, 有左子树或者右子树, 则需要继续分裂

    (1) 结合 height() * val, 在寻址的过程中将值相加 高度是不对称的
    (2) 路径寻找的时候 使用字符串拼接, 然后相加的时候使用number

 */
public class SumRootLeafNum {


    /*
             4
                6
              5   7
           465 + 467 = 400 + (400 + 65 + 67)

               4
            2     6
         1
    */
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        if (root == null) return sum;
        List<Integer> result = new ArrayList<>();
        aux(root, String.valueOf(root.val), result);

        for (int r : result) {
            sum += r;
        }
        return sum;
    }

    // result int是传值的
    private void aux(TreeNode root, String path, List<Integer> result) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            result.add(Integer.parseInt(path));
        }

        if (root.left != null) {
            aux(root.left, path + root.left.val, result);
        }

        if (root.right != null) {
            aux(root.right, path + root.right.val, result);
        }
    }


    /*
               4
         40 /   \ 40
         2         5
       (420)
      1

    */
    private int depthFirstSearch(TreeNode root, int prev) {
        if (root == null) return 0;
        // 每当向下一级移动的时候, 如果该节点有相应方向的子树,  则上一级数字 * 10 + root.val * 10
        // 如果没有子树则上一级 * 10 + root.val

        if (root.left == null && root.right == null) return (prev + root.val);

//        int left = (root.left == null) ? prev : ((prev + root.val) * 10);
//        int right = (root.right == null) ? prev : ((prev + root.val) * 10);
        int nextPrev = (prev + root.val) * 10;

        return  depthFirstSearch(root.left, nextPrev) + depthFirstSearch(root.right, nextPrev);
    }

    public int sumNumbers0(TreeNode root) {
        return depthFirstSearch(root, 0);
    }

    public static void main(String[] args) {

        SumRootLeafNum kk = new SumRootLeafNum();

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


        System.out.println(kk.sumNumbers(t2) == kk.sumNumbers0(t2));
    }

}

```