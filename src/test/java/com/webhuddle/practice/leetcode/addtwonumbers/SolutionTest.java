package com.webhuddle.practice.leetcode.addtwonumbers;

import com.webhuddle.practice.leetcode.addtwonumbers.Solution.ListNode;
import org.junit.jupiter.api.Assertions;

/* original test case expectations
[7,0,8]
[0]
[8,9,9,9,0,0,0,1]
[0,0,2]
 */

class SolutionTest {

    Solution solution = new Solution();

    @org.junit.jupiter.api.Test
    void addTwoNumbers() {
        ListNode a = solution.buildList(new int[]{2, 4, 3});
        ListNode b = solution.buildList(new int[]{5, 6, 4});
        ListNode result = solution.addTwoNumbers(a, b);
        Assertions.assertEquals("[7 0 8]", solution.writeListToString(result));
    }

    @org.junit.jupiter.api.Test
    void addTwoNumbersZero() {
        ListNode a = solution.buildList(new int[]{0});
        ListNode b = solution.buildList(new int[]{0});
        ListNode result = solution.addTwoNumbers(a, b);
        Assertions.assertEquals("[0]", solution.writeListToString(result));
    }

    @org.junit.jupiter.api.Test
    void addTwoNumbersDiffLengths() {
        ListNode a = solution.buildList(new int[]{9,9,9,9,9,9,9});
        ListNode b = solution.buildList(new int[]{9,9,9,9});
        ListNode result = solution.addTwoNumbers(a, b);
        Assertions.assertEquals("[8 9 9 9 0 0 0 1]", solution.writeListToString(result));
    }

    @org.junit.jupiter.api.Test
    void addTwoNumbersDiffLengthsCarry() {
        ListNode a = solution.buildList(new int[]{9,9,1});
        ListNode b = solution.buildList(new int[]{1});
        ListNode result = solution.addTwoNumbers(a, b);
        Assertions.assertEquals("[0 0 2]", solution.writeListToString(result));
    }

    @org.junit.jupiter.api.Test
    void addTwoNumbersDiffLengthsCarryOtherOrder() {
        ListNode a = solution.buildList(new int[]{1});
        ListNode b = solution.buildList(new int[]{9,9,1});
        ListNode result = solution.addTwoNumbers(a, b);
        Assertions.assertEquals("[0 0 2]", solution.writeListToString(result));
    }

    @org.junit.jupiter.api.Test
    void addTwoNumbersDiffLengthsCarryMore() {
        ListNode a = solution.buildList(new int[]{1});
        ListNode b = solution.buildList(new int[]{9,9,9});
        ListNode result = solution.addTwoNumbers(a, b);
        Assertions.assertEquals("[0 0 0 1]", solution.writeListToString(result));
    }
}