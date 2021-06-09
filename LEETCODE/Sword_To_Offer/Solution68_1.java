package Sword_To_Offer;

/**
 * @author jiangwentao
 * @date 2021/6/9
 * @detail 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
 * 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5]
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 示例 2:
 * <p>
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 * <p>
 * 说明:
 * <p>
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
 * 注意：本题与主站 235 题相同：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution68_1 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private TreeNode parent = null;
    //树的递归遍历 二叉搜索树的中序遍历使用
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        traverse(root, p, q);
        return parent;
    }

    private void traverse(TreeNode root, TreeNode p, TreeNode q) {
        //base case
        if(root == null) {
            return;
        }
        //二叉搜索树中序遍历
        traverse(root.left, p, q);
        if ((root.val <= p.val && root.val >= q.val) || (root.val >= p.val && root.val <= q.val)) {
            if(touch(root, p) && touch(root, q)) {
                parent = root;
                return;
            }
        }
        traverse(root.right, p, q);
    }

    private boolean touch(TreeNode root, TreeNode target) {
        //base case
        if (root == null) {
            return false;
        }
        return (root.val == target.val) || touch(root.left, target) || touch(root.right, target);
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {

        while (root != null) {
            if (root.val < p.val && root.val < q.val) {
                root = root.right;
            }
            if (root == null) {
                break;
            }
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else {
                break;
            }
        }
        return root;
    }
}
