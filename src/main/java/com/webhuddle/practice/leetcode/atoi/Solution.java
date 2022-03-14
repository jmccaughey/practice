package com.webhuddle.practice.leetcode.atoi;

//import java.math.BigInteger;

//import java.math.BigInteger;

class Solution {

//    public int clamp(BigInteger bi){
//      if(bi.compareTo(new BigInteger(Integer.MAX_VALUE+"")) > -1) return Integer.MAX_VALUE;
//      if(bi.compareTo(new BigInteger(Integer.MIN_VALUE+"")) < 0) return Integer.MIN_VALUE;
//      return bi.intValueExact();
//    }

    public int myAtoi(String s) {
        boolean negative = isNegative(s);
        s = cleanup(s);
        if (s.length() == 0) return 0;
        //BigInteger bi = new BigInteger(clean);
        return loopAdding(s, negative);
    }

    boolean isNegative(String s) {
        return s.trim().startsWith("-");
    }

    private String cleanup(String s) {
        s = s.trim();
        int readUntil = findFirstNonDigit(s);
        if (readUntil != -1) {
            s = s.substring(0, readUntil);
        }
        return s;
    }

    public int findFirstNonDigit(String s) {
        int start = 0;
        if (s.startsWith("-") || s.startsWith("+")) {
            start = 1;
        }
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                return i;
            }
        }
        return -1;
    }

    public int loopAdding(String s, boolean negative) {
        long result = 0;
        s = s.replace('-', '0');
        s = s.replace('+', '0');
        for (int i = 0; i < s.length(); i++) {
            result = result + ((int) Math.pow(10, i) * Integer.parseInt(s.charAt((s.length() - 1) - i) + ""));
            if (result > Integer.MAX_VALUE) {
                result = Integer.MAX_VALUE;
                break;
            }
        }
        if (negative) {
            if(result == Integer.MAX_VALUE ) {
                return Integer.MIN_VALUE;
            }
            result = result * -1;
        }
        return new Long(result).intValue();
    }
}