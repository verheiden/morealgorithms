package com.example;

public class scramble {
    public static void main(String args[])
    {
        scramble obj = new scramble();
        System.out.println(obj.isScramble("ABCDE", "CAEBD"));
    }
    public int isScramble(final String a, final String b) {
        if ( isScramble1(a, b ))
            return 1;
        else
            return 0;
    }
    private boolean isScramble1(String a, String b)
    {
        if ( a.length() != b.length() )
            return false;
        if (! anagram(a, b))
            return false;
        int n = a.length();
        for ( int i = 1; i <n; i++)
        {
            if ( isScramble1(a.substring(0,i), b.substring(0,i)) &&
                isScramble1(a.substring(i), b.substring(i)))
                return true;
            if ( isScramble1(a.substring(0,i), b.substring(b.length() - i)) &&
                isScramble1(a.substring(i), b.substring(0, b.length() - i)))
                return true;
        }
        return false;
    }
    private boolean anagram(String a, String bb )
    {
        char[] aChars = a.toCharArray();
        StringBuilder b = new StringBuilder(bb);

        for ( int i = 0; i < aChars.length; i++)
        {
            int index = b.indexOf("" + aChars[i] );
            if ( index !=  -1 )
            {
                b.deleteCharAt(index);
            }
            else
                return false;
        }

        if ( b.length() == 0  )
            return true;
        return false;
    }
}
