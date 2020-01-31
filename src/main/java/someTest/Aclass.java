package someTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Aclass implements aInterface {

    private Bclass bclass;

    public Aclass(Bclass b) {
        this.bclass = b;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static void a() {

    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode newList = null;
        ListNode indexNode = null;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                if (newList == null) {
                    newList = l1;
                    indexNode = l1;
                } else {
                    indexNode.next = l1;
                    indexNode = indexNode.next;
                }
                l1 = l1.next;
            } else {
                if (newList == null) {
                    newList = l2;
                    indexNode = l2;
                } else {
                    indexNode.next = l2;
                    indexNode = indexNode.next;
                }
                l2 = l2.next;
            }
        }
        ListNode noEndNode = l1 == null ? l2 : l1;
        while (noEndNode != null) {
            indexNode.next = noEndNode;
            noEndNode = noEndNode.next;
            indexNode = indexNode.next;
        }
        return newList;

    }

    public ListNode mergeKLists(ListNode[] lists) {

        int length = lists.length;
        if (length == 0) {
            return null;
        }
        if (length == 1) {
            return lists[0];
        }
        insertSort(lists);
        ListNode newNode = lists[0];
        ListNode index = lists[0];
        lists[0] = lists[0].next;

        int i = 0;
        while (i < length) {
            if (lists[i] != null) {
                reOrder(lists, i);
                index.next = lists[i];
                index = index.next;
                lists[i] = lists[i].next;
            } else {
                i++;
            }

        }
        return newNode;
    }

    public void insertSort(ListNode[] l) {

        for (int i = 0; i < l.length; i++) {
            for (int j = i; j - 1 > 0 && l[j].val < l[j - 1].val; j--) {
                ListNode temp = l[j];
                l[j] = l[j - 1];
                l[j - 1] = temp;
            }
        }

    }

    public void reOrder(ListNode[] l, int j) {

        for (int i = j; i < l.length && l[i].val > l[i + 1].val; i++) {
            ListNode temp = l[i];
            l[i] = l[i - 1];
            l[i - 1] = temp;
        }
    }

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode node0 = head;
        ListNode node1 = head.next;
        ListNode node2 = node1.next;
        node0.next = node2;
        node1.next = node0;
        head = node1;

        ListNode pre = head.next;
        ListNode n1 = pre.next;
        while (n1 != null) {
            ListNode n2 = n1.next;
            if (n2 == null) {
                return head;
            } else {
                ListNode n3 = n2.next;
                pre.next = n2;
                n2.next = n1;
                n1.next = n3;
                pre = pre.next.next;  //对应交换前的n2
                n1 = pre.next; //对应交换前的n3
            }
        }
        return head;
    }

    public int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;

    }

    public int removeElement(int[] nums, int val) {

        int i = 0;
        for (int j = nums.length - 1; i <= j; i++) {
            if (nums[i] != val) {
                continue;
            }
            while (j > i && nums[j] == val) {
                j--;
            }
            if (j == i) {
                break;
            } else {
                nums[i] = nums[j];
                j--;
            }
        }
        String a = "aaaa";
        int x = a.indexOf("");
        return i > 0 ? i - 1 : 0;
    }

    public int strStr(String haystack, String needle) {

        if (haystack == null || needle == null) {
            return -1;
        }
        if ("".equals(needle)) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        //Queue<Character> queue = new LinkedList<Character>();
        int i = 0;
        char firstChar = needle.charAt(0);
        while (i < haystack.length()) {
            if (haystack.charAt(i) != firstChar) {
                i++;
                continue;
            } else {
                int x = i;
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < needle.length() && x < haystack.length(); j++) {
                    builder.append(haystack.charAt(x++));
                }
                if (builder.toString().equals(needle)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {

        return findX(nums, 0, nums.length - 1, target);

    }

    public int findX(int[] a, int start, int end, int target) {

        if (start == end) {
            if (a[start] == target) {
                return start;
            } else {
                return -1;
            }
        }
        if (a[start] > a[end]) {
            if (a[end] <= target) {
                int i = 0, j = 0;
                i = findX(a, start, start + (end - start) / 2, target);
                j = findX(a, start + (end - start) / 2 + 1, end, target);
                if (i == -1 && j == -1) {
                    return -1;
                } else {
                    return i == -1 ? j : i;
                }
            } else {
                return -1;
            }
        } else {
            int x = 0, y = 0;
            x = findX(a, start, start + (end - start) / 2, target);
            y = findX(a, start + (end - start) / 2 + 1, end, target);
            if (x == -1 && y == -1) {
                return -1;
            } else {
                return x == -1 ? y : x;
            }
        }
    }

    public int[] searchRange(int[] nums, int target) {

        int[] result = new int[2];
        int l = nums.length;
        if (l == 0) {
            result[0] = -1;
            result[1] = -1;
            return result;
        } else {
            return binSearch(nums, 0, nums.length - 1, target);
        }

    }

    public int[] binSearch(int nums[], int start, int end, int target) {

        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        if (start == end) {
            if (nums[start] == target) {
                result[0] = start;
                result[1] = start;
                return result;
            } else {
                return result;
            }
        }
        if (nums[start] > target) {
            return result;
        } else if (nums[end] < target) {
            return result;
        } else {
            int mid = start + (end - start) / 2;
            int[] result1 = binSearch(nums, start, mid, target);
            int[] result2 = binSearch(nums, mid + 1, end, target);
            if (result1[0] == result1[1] && result1[1] == -1) {
                return result2;
            } else if (result2[0] == result2[1] && result2[1] == -1) {
                return result1;
            } else {
                result[0] = result1[0];
                result[1] = result2[1];
            }
            return result;
        }
    }


    public int searchInsert(int[] nums, int target) {

        int l = nums.length;
        if (l == 0) {
            return 0;
        }
        if (nums[0] >= target) {
            return 0;
        } else if (nums[l - 1] <= target) {
            return l - 1;
        } else {
            int i;
            for (i = 0; i < l; i++) {
                if (nums[i] >= target) {
                    break;
                }
            }
            return i;
        }
    }
}
