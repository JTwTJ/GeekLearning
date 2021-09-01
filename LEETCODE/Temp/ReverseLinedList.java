package Temp;

/**
 * @author jiangwentao
 * @date 2021/9/1
 * @detail 翻转链表
 */
public class ReverseLinedList {

    class Node {
        int val;
        Node next;
    }

    public ReverseLinedList() {
    }

    private Node reverse1(Node head) {
        //base case
        if (head == null || head.next != null) {
            return head;
        }
        Node last = head;
        last = reverse1(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    private Node reverse(Node head) {
        Node pre = null, cur = head, nxt = head;
        while (cur != null) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
