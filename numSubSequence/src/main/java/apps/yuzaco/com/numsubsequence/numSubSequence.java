package apps.yuzaco.com.numsubsequence;

import java.util.Arrays;

public class numSubSequence {
    String S;
    String T;
    int n, m;
    int[][] dp;
    static public void main(String args[]){
        numSubSequence obj = new numSubSequence();

    }
    public int numDistinct(String S, String T)
    {
        this.S = S;
        this.T = T;
        if ( S == null || T == null  )
            return 0;

        n = S.length();
        m = T.length();

        if( n == 0 || m == 0 )
            return 0;
        dp = new int[n][m];
        for ( int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1 );
        rec(0, 0);
        return dp[0][0];
    }

    int rec(int i, int j)
    {
        if ( j == m )
            return 1;
        if ( j > m )
            return 0;
        if ( i >= n )
            return 0;
        if ( dp[i][j] != -1 )
            return dp[i][j];
        dp[i][j] = 0;
        if( S.charAt(i)  == T.charAt(j) )
        {
            dp[i][j] +=  rec( i+1, j+1 );
        }
        dp[i][j] += rec(i+1, j);
        return  dp[i][j];
    }
}
