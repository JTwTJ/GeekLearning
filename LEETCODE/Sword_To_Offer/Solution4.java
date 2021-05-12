package Sword_To_Offer;

import java.util.Stack;

/**
 * @author jiangwentao
 * @date 2021/5/6
 * @detail 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * <p>
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 10000
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution4 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //用栈
    public int[] reversePrint(ListNode head) {

        Stack<Integer> stack = new Stack<>();
        ListNode listNode = head;
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        int[] result = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            result[i++] = stack.pop();
        }
        return result;
    }

    int[] res;
    //这里的i是用来记录数组长度的
    int i = 0;
    int j = 0;
    //递归+回溯
    public int[] reversePrint1(ListNode head) {
        resove(head);
        return res;
    }

    private void resove(ListNode head) {
        if (head == null) {
            res = new int[i];
            return;
        }
        i++;
        resove(head.next);
        res[j++] = head.val;
    }

    //双指针反转链表
    public int[] reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
            i++;
        }
        res = new int[i];
        while (pre != null) {
            res[j++] = pre.val;
            pre = pre.next;
        }
        return res;
    }
}
