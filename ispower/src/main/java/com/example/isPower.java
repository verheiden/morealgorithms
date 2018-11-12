package com.example;

public class isPower {

    public static void main(String args[])
    {
        isPower obj = new isPower();
         System.out.println(obj.gcd(4,6));
    }
    public int gcd(int a, int b) {
        if ( a < b ) {
            int temp = a;
            a = b;
            b = temp;
        }
        if ( b == 0 )
            return a;

        return (gcd(  a%b, b));
    }

    public boolean isPower1(int a)
    {
        if ( a == 1  )
            return true;
        int sq = (int) Math.sqrt(a);
        int p = 2;
        for ( int i = sq; i >= 2 ; i--)
        {
            p = 2;
            while( Math.pow(i,p) <= a )
            {
                if (Math.pow(i,p) == a )
                    return true;
                p++;
            }
        }
        return false;
    }
}
