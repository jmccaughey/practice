package com.webhuddle.practice.leetcode.addbinary;

import java.util.Objects;

public class Solution {

    public String addBinary(String a, String b) {
        String longer, shorter;
        if(a.length() >= b.length()){
            longer = a;
            shorter = b;
        } else {
            longer = b;
            shorter = a;
        }
        StringBuilder result = new StringBuilder(longer.length()+1);
        // add reading backwards & carrying one
        BinarySum binarySum = new BinarySum(0, false);
        for(int i = 0; i < longer.length(); i++){
            char l = longer.charAt(longer.length()-(i+1));
            char s = shorter.length() > i ? shorter.charAt(shorter.length()-(i+1)) : '0';
            binarySum = this.addBinaryChar(l, s, binarySum.carry);
            result.append(binarySum.result);
        }
        if(binarySum.carry) result.append(1);
        return result.reverse().toString();
    }

    public BinarySum addBinaryChar(char a, char b, boolean carry){
        int result = Integer.parseInt(a + "", 2) + Integer.parseInt(b + "", 2) + (carry ? 1 : 0);
        if(result == 0){
            return new BinarySum(0, false);
        }
        if(result == 1){
            return new BinarySum(1, false);
        }
        if(result == 2) {
            return new BinarySum(0, true);
        }
        return new BinarySum(1, true);
    }

    static class BinarySum {
        boolean carry;
        int result;
        public BinarySum(int result, boolean carry){
            this.result = result;
            this.carry = carry;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            BinarySum binarySum = (BinarySum) o;
            return carry == binarySum.carry && result == binarySum.result;
        }

        @Override
        public int hashCode() {
            return Objects.hash(carry, result);
        }

        @Override
        public String toString() {
            return "BinarySum{" +
                    "carry=" + carry +
                    ", result=" + result +
                    '}';
        }
    }
}
