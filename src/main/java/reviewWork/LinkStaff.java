package reviewWork;

import java.util.*;

public class LinkStaff {


    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    //递归的方式反转
    public ListNode reverseListV2(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = null;
        ListNode cur, reverseList;
        reverseList = cur = reverseListV2(next);
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = head;
        return reverseList;
    }

    //
    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode preHandle = null;
        if (m > 1) {
            preHandle = head;
            for (int i = 1; i <= m - 1; i++) {
                preHandle = preHandle.next;
            }
        }
        ListNode last, cur, pre;
        cur = last = preHandle == null ? head : preHandle.next;
        pre = null;
        int count = n - m + 1;
        while (cur != null && count > 0) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            count--;
        }
        if (preHandle != null) {
            preHandle.next = pre;
        }
        last.next = cur;
        return head;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode res = null;
        ListNode cur = res;
        int x = 0;
        while (l1 != null && l2 != null) {
            int a = l1.val;
            int b = l2.val;
            l1 = l1.next;
            l2 = l2.next;
            int sum = a + b + x;
            if (sum > 9) {
                x = 1;
                sum = sum % 10;
            } else {
                x = 0;
            }
            if (cur == null) {
                res = cur = new ListNode(sum);
            } else {
                cur.next = new ListNode(sum);
                cur = cur.next;
            }
        }
        ListNode others = l1 == null ? l2 : l1;
        while (others != null) {
            int sum = others.val + x;
            if (sum > 9) {
                x = 1;
                sum = sum % 10;
            } else {
                x = 0;
            }
            cur.next = new ListNode(sum);
            cur = cur.next;
            others = others.next;
        }
        if (x == 1) {
            cur.next = new ListNode(1);
        }
        return res;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode res = null;
        ListNode cur = null;
        while (l1 != null && l2 != null) {
            ListNode node;
            if (l1.val < l2.val) {
                node = l1;
                l1 = l1.next;
            } else {
                node = l2;
                l2 = l2.next;
            }
            node.next = null;
            if (cur == null) {
                res = cur = node;
            } else {
                cur.next = node;
                cur = cur.next;
            }
        }
        ListNode others = l1 == null ? l1 : l2;
        cur.next = others;
        return res;
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }
        return spiltMerge(lists, 0, lists.length - 1);
    }

    public ListNode spiltMerge(ListNode[] lists, int start, int end) {

        if (start == end) {
            return lists[start];
        } else if (end - start == 1) {
            return baseMerge(lists[end], lists[start]);
        } else {
            int mid = (end - start) / 2 + start;
            ListNode l1 = spiltMerge(lists, start, mid);
            ListNode l2 = spiltMerge(lists, mid + 1, end);
            return baseMerge(l1, l2);
        }
    }

    private ListNode baseMerge(ListNode l1, ListNode l2) {

        ListNode res = null;
        ListNode cur = null;
        while (l1 != null && l2 != null) {
            ListNode node;
            if (l1.val < l2.val) {
                node = l1;
                l1 = l1.next;
            } else {
                node = l2;
                l2 = l2.next;
            }
            //node.next = null;
            if (res == null) {
                res = cur = node;
            } else {
                cur.next = node;
                cur = cur.next;
            }
        }
        ListNode others = l1 == null ? l2 : l1;
        if (res == null) {
            return null;
        }
        cur.next = others;
        return res;
    }

    /**
     * 合并可重复的区间
     *
     * @param intervals
     * @return
     */
    public List<List<Integer>> merge(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });
        LinkedList<List<Integer>> lists = new LinkedList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (lists.isEmpty() || lists.getLast().get(1) < intervals[i][0]) {
                List<Integer> newList = Arrays.asList(intervals[i][0], intervals[i][1]);
                lists.add(newList);
            } else {
                int max = Math.max(lists.getLast().get(1), intervals[i][1]);
                lists.getLast().set(1, max);
            }

        }
        return lists;
    }

    /**
     * 排序链表去除重复元素
     */
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            if (pre != null && pre.val == cur.val) {
                pre.next = cur.next;
                cur.next = null;
                cur = pre.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }


    /**
     * 在上边的基础上，只保留不重复的元素
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicatesV2(ListNode head) {

        ListNode fast = head;
        ListNode newHead = new ListNode(-1);
        ListNode slow = newHead;
        newHead.next = head;
        while (fast != null && fast.next != null) {
            if (fast.val != fast.next.val) {
                if (slow.next != fast) {
                    slow.next = fast.next;
                } else {
                    slow = fast;
                }
            }
            fast = fast.next;
        }
        if (slow.next != fast) {
            slow.next = null;
        }
        return newHead.next;
    }


    /**
     * nlogn对链表进行排序,采用分治再合并的方式
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode spiltList = slow.next;
        slow.next = null;
        ListNode firstList = sortList(head);
        ListNode secondList = sortList(spiltList);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (firstList != null && secondList != null) {
            if (firstList.val < secondList.val) {
                h.next = firstList;
                firstList = firstList.next;
            } else {
                h.next = secondList;
                secondList = secondList.next;
            }
            h = h.next;
        }
        h.next = firstList == null ? secondList : firstList;
        return res.next;
    }


    /**
     * 两个链表相加
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbersv2(ListNode l1, ListNode l2) {

        ListNode cur1 = l1;
        ListNode cur2 = l2;
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (cur1 != null && cur2 != null) {
            stack1.push(cur1);
            stack2.push(cur2);
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        if (cur1 == null) {
            while (cur2 != null) {
                stack2.push(cur2);
                cur2 = cur2.next;
            }
        } else {
            while (cur1 != null) {
                stack1.push(cur1);
                cur1 = cur1.next;
            }
        }
        ListNode res = null;
        ListNode cur = null;
        int c = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int sum = stack1.pop().val + stack2.pop().val + c;
            if (sum > 9) {
                c = 1;
                sum = sum % 10;
            } else {
                c = 0;
            }
            if (res == null) {
                res = new ListNode(sum);
                cur = res;
            } else {
                cur.next = new ListNode(sum);
                cur = cur.next;
            }
        }
        Stack<ListNode> remainNode = stack1.isEmpty() ? stack2 : stack1;
        while (!remainNode.isEmpty()) {
            int sum = c + remainNode.pop().val;
            if (sum > 9) {
                c = 1;
                sum = sum % 10;
            } else {
                c = 0;
            }
            cur.next = new ListNode(sum);
            cur = cur.next;
        }
        if (c > 0) {
            cur.next = new ListNode(1);
        }
        return res;
    }

}
