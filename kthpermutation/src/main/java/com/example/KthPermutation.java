package com.example;

import java.util.ArrayList;

public class KthPermutation {
    public String getPermutation(int n, int k) {

        ArrayList<Integer> set = new ArrayList<>();

        for(int i = 1; i <= n; i++)
        {
            set.add(i);
        }
        return( getPermutation(k-1, set));
    }
    String getPermutation(int k, ArrayList<Integer> set)
    {
        int n = set.size();
        if ( n == 0 )
            return "";
        if ( k > factorial(n) )
            return "";
        int fact = factorial(n-1);
        int pos = k/fact;
        k %= fact;
        String ch = String.valueOf(set.get(pos));
        set.remove(pos);
        return ( ch + getPermutation(k, set));

    }
    int factorial(int n){
        if ( n > 12 )
            return Integer.MAX_VALUE;
        int fact = 1;
        for ( int i =2; i <= n; i++) {
            fact = fact*i;
        }
        return fact;
    }
}
