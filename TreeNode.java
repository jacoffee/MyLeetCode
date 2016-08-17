import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }

    public void inorderTraversal1(TreeNode node, List<Integer> ints) {
        if (node == null) return;
        inorderTraversal1(node.left, ints);
        ints.add(node.val);
        inorderTraversal1(node.right, ints);
    }

    // not so functional programming
    public List<Integer> traverse() {
        List<Integer> ints = new ArrayList<>();
        inorderTraversal1(this, ints);
        return ints;
    }

    private TreeNode deteleMin() {
        return deleteMin(this);
    }

    private TreeNode deleteMin(TreeNode node) {
        if (node.left == null) return node.right;

        node.left = deleteMin(node.left);
        return node;
    }

    private TreeNode deleteMax() {
        return deleteMax(this);
    }

    private TreeNode deleteMax(TreeNode node) {
        if (node.right == null) return node.left;
        node.right = deleteMax(node.right);
        return node;
    }

    public TreeNode max(TreeNode node) {
        if (node == null) return null;
        else {
            while (node.right != null) {
                node = node.right;
            }
            return node;
        }
    }

    public TreeNode min() {
        return min(this);
    }

    private TreeNode min(TreeNode node) {
        if (node == null) return null;
        else {
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
    }

    public TreeNode delete(int key) {
        return delete(this, key);
    }

    private TreeNode delete(TreeNode root, int key) {
        if (root == null) return null;

        if (key > root.val) root.right = delete(root.right, key);
        else if (key < root.val) root.left = delete(root.left, key);
        else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            TreeNode t = root;
            root = min(t.right);
            root.left = t.left;
            root.right = deleteMin(t.right);
        }

        return root;
    }


    public TreeNode treeSuccessor(TreeNode root, TreeNode x) {
        if (root == null) return null;

        while (root != null) {
            TreeNode parent = null;

            if (x.val > root.val) {
                parent = root;
                root = root.right;
            } else if (x.val < root.val) {
                parent = root;
                root = root.left;
            } else {
                // 锁定该点之后, 如果右子树不为null, 则min(t.right); 否则就是该节点的父节点
                if (root.right != null) {
                    return root.right.min();
                } else {
                    return parent;
                }

            }
        }

        return root;
    }

    public List<Integer> leafNodes() {
        return leafNodes(this);
    }

    private List<Integer> leafNodes(TreeNode node) {
        return new ArrayList<>();
    }

    public int height() {
        return height(this);
    }

    // 空树的高度为-1, 只有一个节点的树高度为0
    private int height(TreeNode node) {
        if (node == null) return -1;
        else
          return  1 + java.lang.Math.max(height(node.left), height(node.right));
    }

    // preordertraversal
    private void preorderTraversal1(TreeNode root, List<Integer> ints) {
        if (root == null) return;
        ints.add(root.val);
        preorderTraversal1(root.left, ints);
        preorderTraversal1(root.right, ints);
    }

    // not so functional programming
    public List<Integer> preorderTraversal() {
        List<Integer> ints = new ArrayList<>();
        preorderTraversal1(this, ints);
        return ints;
    }

}