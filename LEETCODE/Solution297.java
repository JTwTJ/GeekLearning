import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jiangwentao
 * @date 2021/6/24
 * @detail 二叉树的序列化与反序列化
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，
 * 同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅LeetCode 序列化二叉树的格式。
 * 你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 * <p>
 * 输入：root = [1,2]
 * 输出：[1,2]
 * <p>
 * 提示：
 * <p>
 * 树中结点数在范围 [0, 104] 内
 * -1000 <= Node.val <= 1000
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution297 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder("[");
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll == null) {
                sb.append("null").append(",");
            } else {
                sb.append(poll.val).append(",");
                queue.add(poll.left);
                queue.add(poll.right);
            }
//            if (poll.left != null) {
//                queue.add(poll.left);
//            }
//            if (poll.right != null) {
//                queue.add(poll.right);
//            }
        }
        sb.deleteCharAt(sb.length() - 1).append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("[]".equals(data)) {
            return null;
        }
        String substring = data.substring(1, data.length() - 1);
        String[] split = substring.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (!"null".equals(split[i])) {
                TreeNode treeNode = new TreeNode(Integer.parseInt(split[i]));
                poll.left = treeNode;
                queue.add(treeNode);
            }
            i++;
            if (!"null".equals(split[i])) {
                TreeNode treeNode = new TreeNode(Integer.parseInt(split[i]));
                poll.right = treeNode;
                queue.add(treeNode);
            }
            i++;
        }
        return root;
    }

//    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1, new TreeNode(2, null, null),
//                new TreeNode(3, new TreeNode(4, null, null),
//                        new TreeNode(5, null, null)));
//        Solution297 solution297 = new Solution297();
//        String serialize = solution297.serialize(root);
//        System.out.println(serialize);
//    }
}
