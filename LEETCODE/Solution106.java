import java.util.HashMap;
import java.util.Map;

/**
 * @author jiangwentao
 * @date 2021/5/27
 * @detail 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution106 {
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

    private Map<Integer, Integer> valPosMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            valPosMap.put(inorder[i], i);
        }
        return dfs(postorder, 0, inorder.length - 1, inorder.length - 1);
    }

    private TreeNode dfs(int[] postOrder, int start, int end, int rootIndex) {

        //base case
        if (start > end) {
            return null;
        }
        int rootVal = postOrder[rootIndex];
        //求rootVal在中序遍历处的位置
        Integer position = valPosMap.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = dfs(postOrder, start, position - 1, rootIndex - (end - position) -1);
        root.right = dfs(postOrder, position + 1, end, rootIndex - 1);
        return root;
    }
}
