package mid;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LowestCommonAncestor {
    public static class TreeNode {
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

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Set<TreeNode> set = new HashSet<>();
        set.add(p);
        set.add(q);
        dfs(root, set);
        int sizea = list.get(0).size();
        int sizeb = list.get(1).size();
        TreeNode res = null;
        for (int a = 0, b = 0; a < sizea && b < sizeb; a++,b++) {
            TreeNode na = list.get(0).get(a);
            TreeNode nb = list.get(1).get(b);
            if (na == nb || na.val == nb.val) {
                res = na;
            }
        }
        return res;
    }

    public static List<List<TreeNode>> list = new ArrayList<>();
    public static List<TreeNode> cur = new ArrayList<>();

    public static boolean dfs(TreeNode root, Set<TreeNode> set) {
        if (root == null)
            return false;
        cur.add(root);
        if (set.contains(root)) {
            list.add(new ArrayList<>(cur));
            set.remove(root);
            if (set.isEmpty())
                return true;
        }
        if (dfs(root.left, set)) {
            return true;
        }
        if (dfs(root.right, set)) {
            return true;
        }
        cur.remove(cur.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        TreeNode res = lowestCommonAncestor(root, root.left, root.left.right.right);
        System.out.println(res.val);

    }
}
