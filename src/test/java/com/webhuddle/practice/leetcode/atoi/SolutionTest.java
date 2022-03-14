package com.webhuddle.practice.leetcode.atoi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void myAtoi() {
        Assertions.assertAll(
                () -> assertEquals(75, solution.myAtoi("75")),
                () -> assertEquals(-75, solution.myAtoi("-75")),
                () -> assertEquals(-75, solution.myAtoi("    -75")),
                () -> assertEquals(Integer.MAX_VALUE, solution.myAtoi("434534534534")),
                () -> assertEquals(-4534, solution.myAtoi("-4534")),
                () -> assertEquals(Integer.MIN_VALUE, solution.myAtoi("-456456434534534534"))
        );
    }

    @Test
    void findFirstNonDigit() {
    }

    @Test
    void loopAdding() {
    }
}