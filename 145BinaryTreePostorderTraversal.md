import java.util.ArrayList;
import java.util.List;


/**
     https://leetcode.com/problems/binary-tree-postorder-traversal/
 
     左节点(左 -> 右 -> 中) => 右节点(左 -> 右 -> 中) => 中
*/

public class BinaryTreePostorderTraversal {
    public void postorderTraversal1(TreeNode root, List<Integer> ints) {
        if (root == null) return;
        postorderTraversal1(root.left, ints);
        postorderTraversal1(root.right, ints);
        ints.add(root.val);
    }

    // not so functional programming
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ints = new ArrayList<>();
        postorderTraversal1(root, ints);
        return ints;
    }
}
