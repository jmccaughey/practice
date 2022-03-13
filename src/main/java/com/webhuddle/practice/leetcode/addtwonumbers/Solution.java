package com.webhuddle.practice.leetcode.addtwonumbers;

class Solution {

    /* original test cases
            [2,4,3]
            [5,6,4]
            [0]
            [0]
            [9,9,9,9,9,9,9]
            [9,9,9,9]
            [9,9,1]
            [1]
    */

    ListNode buildList(int[] input) {
        ListNode start = new ListNode(input[0]);
        ListNode current = start;
        for (int i = 1; i < input.length; i++) {
            current.next = new ListNode(input[i]);
            current = current.next;
        }
        return start;
    }

    String writeListToString(ListNode listNode) {
        StringBuilder result = new StringBuilder("[");
        while (listNode != null) {
            result.append(listNode.val).append(" ");
            listNode = listNode.next;
        }
        return result.toString().trim() + "]";
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ptr1 = l1;
        ListNode ptr2 = l2;
        ListNode prev1 = null;
        ListNode prev2 = null;

        int carry = 0;
        while (ptr1 != null || ptr2 != null) {
            int a = ptr1 != null ? ptr1.val : 0;
            int b = ptr2 != null ? ptr2.val : 0;
            int sum = a + b + carry;
            if (sum > 9) {
                carry = 1;
                sum = sum - 10;
            } else {
                carry = 0;
            }
            if (ptr1 != null) ptr1.val = sum;
            if (ptr2 != null) ptr2.val = sum;
            prev1 = ptr1;
            prev2 = ptr2;
            if (ptr1 != null) ptr1 = ptr1.next;
            if (ptr2 != null) ptr2 = ptr2.next;
        }
        if (carry == 0) {
            if (prev1 != null) {
                return l1;
            }
        } else {
            if (prev1 != null) {
                prev1.next = new ListNode(1);
                return l1;
            }
            prev2.next = new ListNode(1);
        }
        return l2;
    }

    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}