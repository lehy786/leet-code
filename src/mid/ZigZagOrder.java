package mid;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigZagOrder {
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> retList = new ArrayList<>();
        if (root == null)
            return retList;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack1 = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty() || !stack1.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int curLen = Math.max(stack.size(), stack1.size());
            for (int i = 0; i < curLen; i++) {
                if (retList.size() % 2 == 0) {
                    TreeNode node = stack.pop();
                    list.add(node.val);
                    if (node.left != null) {
                        stack1.push(node.left);
                    }
                    if (node.right != null) {
                        stack1.push(node.right);
                    }
                } else {
                    TreeNode node = stack1.pop();
                    list.add(node.val);
                    if (node.right != null) {
                        stack.push(node.right);
                    }
                    if (node.left != null) {
                        stack.push(node.left);
                    }
                }
            }
            retList.add(list);
        }
        return retList;
    }
}
