package com.webhuddle.practice.leetcode.addbinary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    void addBinary(){
        Assertions.assertEquals("100", solution.addBinary("11", "1"));
        Assertions.assertEquals("1110", solution.addBinary("111", "111"));
        Assertions.assertEquals("10110", solution.addBinary("111", "1111"));
    }

    @Test
    void addBinaryChar() {
        Assertions.assertAll(
                () -> assertEquals(new Solution.BinarySum(0, false),
                        solution.addBinaryChar('0', '0', false)),

                () -> assertEquals(new Solution.BinarySum(1, false),
                        solution.addBinaryChar('1', '0', false)),

                () -> assertEquals(new Solution.BinarySum(1, false),
                        solution.addBinaryChar('0', '1', false)),

                () -> assertEquals(new Solution.BinarySum(0, true),
                        solution.addBinaryChar('0', '1', true)),

                () -> assertEquals(new Solution.BinarySum(0, true),
                        solution.addBinaryChar('1', '1', false)),

                () -> assertEquals(new Solution.BinarySum(1, true),
                        solution.addBinaryChar('1', '1', true))
        );
    }
}