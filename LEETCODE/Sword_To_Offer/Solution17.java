package Sword_To_Offer;

/**
 * @author jiangwentao
 * @date 2021/5/17
 * @detail 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * <p>
 * 返回删除后的链表的头节点。
 * <p>
 * 注意：此题对比原题有改动
 * <p>
 * 示例 1:
 * <p>
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为5的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 * <p>
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为1的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 * <p>
 * <p>
 * 说明：
 * <p>
 * 题目保证链表中节点的值互不相同
 * 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution17 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {

        //头结点为空，或者是正好只有一个节点且正好为需要删除的值则返回null
        if (head == null || (head.val == val && head.next == null)) {
            return null;
        }
        //如果正好头节点需要删除，且后面有节点则返回下一个节点为头节点
        if (head.val == val) {
            return head.next;
        }
        //记录头节点
        ListNode root = head;
        while (head != null) {
            ListNode nxt = head.next;
            if (nxt.val == val) {
                //头节点的下一个为下一个的下一个
                head.next = nxt.next;
                return root;
            }
            head = head.next;
        }
        return root;
    }
}
