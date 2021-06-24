package Temp;

import java.util.*;

/**
 * @author jiangwentao
 * @date 2021/6/23
 * @detail
 */
public class Solution1 {

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

        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        boolean flag = true;
        while (!deque.isEmpty()) {
            Deque<TreeNode> tempQueue = new LinkedList<>(deque);
            List<Integer> temp = new ArrayList<>();
            if (flag) {
                while (!deque.isEmpty()) {
                    TreeNode treeNode = deque.removeFirst();
                    temp.add(treeNode.val);
                }
            } else {
                while (!deque.isEmpty()) {
                    TreeNode treeNode = deque.removeLast();
                    temp.add(treeNode.val);
                }
            }
            res.add(temp);
            for (int i = tempQueue.size(); i > 0; i--) {
                TreeNode poll = tempQueue.poll();
                if (poll == null) {continue;}
                if (poll.left != null) {
                    deque.add(poll.left);
                }
                if (poll.right != null) {
                    deque.add(poll.right);
                }
            }
            flag = !flag;
        }
        return res;
    }
}
