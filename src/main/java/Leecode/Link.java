package Leecode;

import com.sun.scenario.effect.impl.state.LinearConvolveKernel;
import com.sun.tools.javac.code.Lint;

public class Link {


    private static class LinkNode {
        int value;
        LinkNode next;

        public LinkNode(int value) {
            this.value = value;
        }
    }

    public void orderLink(LinkNode head) {

        LinkNode head1 = head;
        LinkNode cur1 = head1;
        LinkNode head2 = head.next;
        LinkNode cur2 = head2;
        int count = 0;
        LinkNode cur = head.next.next;
        head1.next = null;
        head2.next = null;
        while (cur != null) {
            //尾插
            if (count % 2 == 0) {
                LinkNode tmp = cur.next;
                cur.next = null;
                cur1.next = cur;
                cur1 = cur;
                cur = tmp;
            } else {
                //头插
                LinkNode tmp = cur.next;
                cur.next = cur2;
                cur2 = cur;
                cur = tmp;

            }
            count++;
        }
        head2 = cur2;
        printLint(head1);
        System.out.println("---------");
        printLint(head2);
    }

    public void printLint(LinkNode head) {

        while (head != null) {
            System.out.print(head.value + "->");
            head = head.next;
        }
        System.out.println("------");
    }

    public static void main(String[] args) {

        LinkNode head = new LinkNode(1);
        LinkNode one = new LinkNode(10);
        LinkNode two = new LinkNode(2);
        LinkNode three = new LinkNode(9);
        LinkNode four = new LinkNode(3);
        LinkNode five = new LinkNode(8);
        head.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        Link link = new Link();
        link.orderLink(head);
    }
}
