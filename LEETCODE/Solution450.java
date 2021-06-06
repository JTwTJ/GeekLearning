/**
 * @author jiangwentao
 * @date 2021/6/6
 * @detail 删除二叉搜索树中的节点
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的key对应的节点，并保证二叉搜索树的性质不变。
 * 返回二叉搜索树（有可能被更新）的根节点的引用。
 * <p>
 * 一般来说，删除节点可分为两个步骤：
 * <p>
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 说明： 要求算法时间复杂度为O(h)，h 为树的高度。
 * <p>
 * 示例:
 * <p>
 * root = [5,3,6,2,4,null,7]
 * key = 3
 * <p>
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * <p>
 * 给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 * <p>
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 * <p>
 * 5
 * / \
 * 4   6
 * /     \
 * 2       7
 * <p>
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 * <p>
 * 5
 * / \
 * 2   6
 * \   \
 * 4   7
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-node-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution450 {

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

    public TreeNode deleteNode(TreeNode root, int key) {
        return traverse(root, key);
    }

    private TreeNode traverse(TreeNode root, int key) {
        //base case
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            //左子树为空则直接返回右子树
            if (root.left == null) {
                return root.right;
            }
            //右子树为空则直接返回左子树
            if (root.right == null) {
                return root.left;
            }
            //如果左右子树点都不为空则需要删除并重构,去找右子树中最小的节点
            TreeNode minNode = getMinNode(root.right);
            root.val = minNode.val;
            root.right = traverse(root.right, minNode.val);
        } else if (root.val < key) {
            root.right = traverse(root.right, key);
        } else {
            root.left = traverse(root.left, key);
        }
        return root;
    }

    private TreeNode getMinNode(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
