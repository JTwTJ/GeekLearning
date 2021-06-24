/**
 * @author jiangwentao
 * @date 2021/6/24
 * @detail 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * <p>
 * <p>
 * 示例 :
 * 给定二叉树
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * 返回3, 它的长度是路径 [4,2,1,3] 或者[5,2,1,3]。
 * <p>
 * <p>
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diameter-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution543 {

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

    private int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return res - 1;
    }

    //统计当前节点的左右子树中最长的链路节点数
    private int depth(TreeNode root) {
        //base case
        if (root == null) {
            return 0;
        }
        int leftMax = depth(root.left);
        int rightMax = depth(root.right);
        res = Math.max(res, leftMax + rightMax + 1);
        return Math.max(leftMax, rightMax) + 1;
    }
}
