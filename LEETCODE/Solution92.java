/**
 * @author jiangwentao
 * @date 2021/5/20
 * @detail 翻转链表II
 *
 * 给你单链表的头指针 head 和两个整数left 和 right ，
 * 其中left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 示例 2：
 *
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 *
 * 提示：
 *
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 *
 * 进阶： 你可以使用一趟扫描完成反转吗？
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution92 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        //递归到翻转链表的开始位置
        if(left == 1) {
            return reverseN(head, right);
        }
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    //后置节点 翻转过后的链表部分的最后节点需要链接的节点
    private ListNode backendNode = null;
    private ListNode reverseN(ListNode head, int right) {
        //base case
        //递归到翻转的最后一个节点时记录backend节点
        if (right == 1) {
            backendNode = head.next;
            return head;
        }
        //递归翻转需要翻转的链表部分
        ListNode last = reverseN(head.next, right - 1);
        head.next.next = head;
        head.next = backendNode;
        return last;
    }
}
