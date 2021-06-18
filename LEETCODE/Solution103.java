import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jiangwentao
 * @date 2021/6/18
 * @detail 二叉树的锯齿形层序遍历
 *
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层序遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution103 {
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList<>(0);
        }
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 1;
        while (!queue.isEmpty()) {
            LinkedList<Integer> temp = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode cur = queue.poll();
                if (cur == null) {
                    continue;
                }
                if (count % 2 == 0) {
                    temp.addLast(cur.val);
                } else {
                    temp.addFirst(cur.val);
                }
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            res.add(temp);
            count++;
        }
        return res;
    }
    
}
