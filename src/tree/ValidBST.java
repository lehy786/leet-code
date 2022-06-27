package tree;


/**
 * Created by luozhenzhao on 2022/2/17
 * description: 98. 验证二叉搜索树
 */
public class ValidBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    private long max = Long.MIN_VALUE;
    
    
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left))
            return false;
        if (max >= root.val) {
            return false;
        } else {
            max = root.val;
        }
        return isValidBST(root.right);
    }

    public boolean isValidBST1(TreeNode root) {
        if (root == null)
            return true;
        return validateRecursive(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean validateRecursive(TreeNode root, long min, long max) {
        if (root == null)
            return true;
        if (root.val >= max || root.val <= min)
            return false;
        return validateRecursive(root.left,min, root.val) && validateRecursive(root.right, root.val, max);
    }
}
