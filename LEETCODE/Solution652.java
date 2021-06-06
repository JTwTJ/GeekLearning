import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jiangwentao
 * @date 2021/6/6
 * @detail 寻找重复的子树
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 * <p>
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 * <p>
 * 示例 1：
 * <p>
 * 1
 * / \
 * 2   3
 * /   / \
 * 4   2   4
 * /
 * 4
 * 下面是两个重复的子树：
 * <p>
 * 2
 * /
 * 4
 * 和
 * <p>
 * 4
 * 因此，你需要以列表的形式返回上述重复子树的根结点。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-duplicate-subtrees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution652 {

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

    List<TreeNode> res = new ArrayList<>();
    Map<String, Integer> resultCountMap = new HashMap<>();

    //二叉树后序遍历，将子树转换成序列化字符串，进行比对
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    private String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }
        //查询根节点的左子树上的重复子树
        String leftStr = traverse(root.left);
        //查询根节点的右子树上的重复子树
        String rightStr = traverse(root.right);
        //后序遍历代码逻辑部分
        String subTree = leftStr + "," + rightStr + "," + root.val;
        Integer subTreeCount = resultCountMap.getOrDefault(subTree, 0);
        if (subTreeCount == 1) {
            res.add(root);
        }
        resultCountMap.put(subTree, subTreeCount + 1);
        return subTree;
    }
}
