package apps.yuzaco.com.decodingways;

import java.util.Arrays;

public class decodingWays {
    public static void main(String args[])
    {
        decodingWays obj = new decodingWays();
        System.out.println(obj.numDecodings("8"));
    }
    int[] dp;
    public int numDecodings(String a) {
        if ( a == null || a.length() == 0 )
            return 0;
        dp = new int[a.length()];

        Arrays.fill(dp, -1);
        return(ways(a, 0) );
    }
    int ways(String a, int start)
    {

        if ( start >= a.length())
            return  1;

        if ( dp[start] != -1 )
            return dp[start];
        int answer = 0;
        if ( isValid1(a.charAt(start)))
            answer +=  ways(a, start+1);
        else
            return 0;

        if ( isValid(a, start, start+1 ))
        {
            answer += ways(a, start+2);
        }

        return dp[start] = answer;
    }
    boolean isValid1(char a)
    {
        return ( a >= '1' && a <= '9');
    }
    boolean isValid(String a, int start, int end)
    {
        int num = 0;
        if ( start >  ( a.length() -2 ))
            return false;

        while (start <= end )
        {
            num = num*10;
            num +=  (int) ( a.charAt(start)  - '0');
            start++;
        }
        if ( num >= 1 && num <= 26 )
        {
            return true;
        }
        return false;
    }
}
