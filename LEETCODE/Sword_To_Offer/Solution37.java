package Sword_To_Offer;

import java.util.*;

/**
 * @author jiangwentao
 * @date 2021/6/8
 * @detail 序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * <p>
 * 示例:
 * <p>
 * 你可以将以下二叉树：
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 * <p>
 * 通过
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution37 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x, TreeNode left, TreeNode right) {
            val = x;
            this.right = right;
            this.left = left;
        }

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<String> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            res.add(cur == null ? "null" : String.valueOf(cur.val));
            if (cur == null) {
                continue;
            }
            queue.add(cur.left);
            queue.add(cur.right);
        }
        return "[" + String.join(",", res) + "]";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("[]".equals(data)) {
            return null;
        }
        String substring = data.substring(1, data.length() - 1);
        String[] nodeStr = substring.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodeStr[0]));
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (!"null".equals(nodeStr[i])) {
                cur.left = new TreeNode(Integer.parseInt(nodeStr[i]));
                queue.add(cur.left);
            }
            i++;
            if (!"null".equals(nodeStr[i])) {
                cur.right = new TreeNode(Integer.parseInt(nodeStr[i]));
                queue.add(cur.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        Solution37 solution37 = new Solution37();
        TreeNode root = new TreeNode(5, new TreeNode(4,
                new TreeNode(11, new TreeNode(7, null, null), new TreeNode(2, null, null)), null),
                new TreeNode(8, new TreeNode(13, null, null), new TreeNode(4, new TreeNode(5, null, null), new TreeNode(1, null, null))));
        String serialize = solution37.serialize(root);
        System.out.println(serialize);
        TreeNode rootDes = solution37.deserialize(serialize);
        System.out.println(rootDes);
    }
}
