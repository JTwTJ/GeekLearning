package Sword_To_Offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jiangwentao
 * @date 2021/6/8
 * @detail 二叉树中和为某一值的路径
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和target = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 * <p>
 * 提示：
 * <p>
 * 节点总数 <= 10000
 * 注意：本题与主站 113题相同：https://leetcode-cn.com/problems/path-sum-ii/
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution34 {

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

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        traverse(root, target);
        return res;
    }

    //回溯框架的使用
    private void traverse(TreeNode root, int target) {
        //base case
        if (root == null) {
            return;
        }
        path.add(root.val);
        target = target - root.val;
        if (target == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        }
        traverse(root.left, target);
        traverse(root.right, target);
        //撤销选择
        path.removeLast();
    }

    public static void main(String[] args) {
        Solution34 solution34 = new Solution34();
        TreeNode root = new TreeNode(5, new TreeNode(4,
                new TreeNode(11, new TreeNode(7, null, null), new TreeNode(2, null, null)), null),
                new TreeNode(8, new TreeNode(13, null, null), new TreeNode(4, new TreeNode(5, null, null), new TreeNode(1, null, null))));
        List<List<Integer>> lists = solution34.pathSum(root, 22);
        System.out.println(lists);
    }
}
