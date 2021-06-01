/**
 * @author jiangwentao
 * @date 2021/5/18
 * @detail 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 进阶：你能尝试使用一趟扫描实现吗？
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */
public class Solution19 {

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

    /**
     * 常规方法-找出对应正数第几个
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        //首先找出正数第几个节点
        int nodeSize = 0;
        ListNode tempHead = head;
        while (tempHead != null) {
            nodeSize++;
            tempHead = tempHead.next;
        }
        //即删除正数为第 nodeSize - n + 1个节点
        int pos = nodeSize - n + 1;
        if (pos == 1) {
            return head.next;
        }
        //当前节点位置
        int curPos = 0;
        ListNode root = head;
        while (head != null) {
            curPos++;
            if (curPos == nodeSize - n) {
                ListNode next = head.next;
                head.next = next.next;
                return root;
            }
            head = head.next;
        }
        return root;
    }

    /**
     * 递归回溯
     */
    int k = 0;
    int n;

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        this.n = n;
        ListNode root = head;
        dfs(head);
        return root;
    }

    private void dfs(ListNode head) {
        if (head == null) {
            return;
        }
        dfs(head.next);
        k++;
        if (k == n && n == 1) {
            head.next = null;
        }
        if (k == n && n != 1) {
            ListNode next = head.next;
            head.next = next.next;
        }
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
}
