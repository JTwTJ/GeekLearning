package Sword_To_Offer;

import java.util.HashMap;

/**
 * @author jiangwentao
 * @date 2021/5/7
 * @detail 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution5 {

    int[] preOrder;
    //定义一个中序遍历值与脚标对应的map集合
    HashMap<Integer, Integer> dic = new HashMap<>();

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preOrder = preorder;
        for (int i = 0; i < preorder.length; i++) {
            //这种做法前提是树中没有重复值节点
            //记录中序遍历数组中值所在的脚标
            dic.put(inorder[i], i);
        }
        return recur(0, 0, inorder.length - 1);
    }

    /**
     * @param root  当前前序数组根节点所在脚标
     * @param left  当前前序数组起始脚标
     * @param right 当前前序数组终止脚标
     */
    private TreeNode recur(int root, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode node = new TreeNode(preOrder[root]);
        //算下一个数组的根节点的脚标
        //1、当前根节点在中序数组中的脚标
        Integer position = dic.get(preOrder[root]);
        node.left = recur(root + 1, left, position - 1);
        //root + (position - left) + 1===>右子树根节点 = 当前根节点索引 + 左子树长度 + 1
        node.right = recur(root + (position - left) + 1, position + 1, right);
        return node;
    }
}
