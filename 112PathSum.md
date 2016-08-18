```java
/*
     https://leetcode.com/problems/path-sum/

     (1) 汇总路径值看是否等于sum
     (2) 沿着路劲行进的时候不断减小, 停止时看sum是否等于0
*/
public class PathSum {
    // 相加比较最后的值
    private boolean dfCompare0(TreeNode root, int prev, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null)
            return (prev + root.val) == sum ;
        return dfCompare0(root.left, (prev + root.val), sum) || dfCompare0(root.right, (prev + root.val), sum);
    }

    // 相减看最后是否为零
    private boolean dfCompare1(TreeNode root, int sum) {
        if (root == null) return sum == 0;
        sum -= root.val;
        if (root.left == null && root.right == null) return sum == 0;
        return dfCompare1(root.left, sum) || dfCompare1(root.right, sum);
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        return dfCompare1(root, sum);
    }
}
```