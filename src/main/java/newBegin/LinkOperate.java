package newBegin;

import java.util.List;

public class LinkOperate {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (head.next == null) {
            return head;
        }
        int count = 1;
        ListNode pre = null;
        ListNode cur = head;
        int operateCount = (n - m) + 1 ;
        //记录下反转前的最后一个节点；
        while (count < m - 1) {
            pre = cur;
            cur = cur.next;
            count++;
        }
        System.out.println(pre.val);
        ListNode con = pre;
        ListNode tail = cur;
        while (operateCount > 0) {
            ListNode nextNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextNode;
            operateCount--;
        }
        if (con != null) {
            con.next = pre;
        } else {
            head = pre;
        }

        tail.next = cur;
        return head;
    }

}
