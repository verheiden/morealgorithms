package com.example;

import java.util.HashMap;
import java.util.Map;

public class formatFloating {
    public static void main(String args[])
    {
        formatFloating obj = new formatFloating();
        System.out.println(obj.fractionToDecimal(87, 22));

    }
    public String fractionToDecimal(int numerator, int denominator) {


        StringBuffer buf = new StringBuffer();
        boolean positive = false;
        long previous = 0;
        if (numerator < 0 && denominator < 0)
            positive = true;
        else if (numerator > 0 && denominator > 0)
            positive = true;
        else if (numerator == 0) {
            positive = true;
        }
        if (positive == false)
            buf.append("-");
        long Lnumerator = Math.abs((long) numerator);
        long Ldenominator = Math.abs((long) denominator);
        long whole = Lnumerator / Ldenominator;
        long remainder = Lnumerator % Ldenominator;
        Map<Long, Integer> map = new HashMap<>();
        buf.append(Long.toString(whole));
        if (remainder == 0)
            return buf.toString();

        buf.append(".");
        remainder *= 10;
        while (!map.containsKey(remainder)) {
            map.put(remainder, buf.length());
            whole = remainder / Ldenominator;
            buf.append(String.valueOf(whole));
            remainder = remainder % Ldenominator * 10;
            if (remainder == 0)
                return buf.toString();
        }
        return buf.insert(map.get(remainder), "(").append(")").toString();
    }

}
