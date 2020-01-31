package Leecode;

import java.util.LinkedHashMap;

public class ListTest {

    private static class Node {

        int value;
        Node next;
    }

    public static Node reserve(Node head) {

        Node cur = head;
        Node nextNode = head.next;
        Node temp;
        while (nextNode != null) {
            temp = nextNode.next;
            nextNode.next = cur;
            cur = nextNode;
            nextNode = temp;
        }
        return cur;
    }


    LinkedHashMap<String, String> map = new LinkedHashMap<String, String>(16,
            0.75f, true);





}
