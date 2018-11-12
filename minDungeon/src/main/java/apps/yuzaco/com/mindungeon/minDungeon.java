package apps.yuzaco.com.mindungeon;

import java.util.ArrayList;
import java.util.Arrays;

public class minDungeon {
    public static void main(String args[]){
        minDungeon obj = new minDungeon();
        obj.minimum();
    }
    ArrayList<ArrayList<Integer>> a;
    int m;
    int n;
    int min;
    void  minimum()
    {
        a = new ArrayList<>();
        for (int i = 0; i < 4; i++){
            //Integer[]  array = new Integer[] {-100, -100, -100, -100, -100, -100, -100, -100, -100,
            //    -100,-100, -100, -100, -100, -100, -100, -100, -100, -100, -100};
            Integer[] array = new Integer[] { -100, -100, -100};
            ArrayList<Integer> temp = new ArrayList<>();
            temp.addAll(Arrays.asList(array));
            a.add(temp);
        }
        System.out.println(calculateMinimumHP(a));
    }
    public int calculateMinimumHP(ArrayList<ArrayList<Integer>> a)
    {
        this.a = a;
        m = a.size() ;
        n = a.get(0).size();
        long[][] dp = new long[m+1][n+1];

        for ( int i =0; i < (m +1 ); i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE );
        dp[m][n-1] = 1;
        dp[m-1][n] = 1;
        long need;
        for (int i = m-1; i >= 0; i--)
        {
            for(int j = n-1; j>=0; j--)
            {
                need  = Math.min( dp[i+1][j], dp[i] [j+1]) - a.get(i).get(j);
                dp[i][j] = need <= 0 ? 1: need;
            }
        }
        return (int) dp[0][0];
    }

    void rec(int row, int col, int sum, int extra)
    {
        if ( row >= m || col >=  n )
            return;
        sum += a.get(row).get(col)  ;
        if ( sum  <= 0 )
        {
            int temp =  Math.abs(sum) + 1;
            sum += temp;
            extra += temp;
        }
        if ( row == (m -1 ) &&  col == ( n  - 1 ) )
        {
            min = Math.min( min, extra );
            return;
        }
        if ( row+1 < m )
            rec(row+1, col, sum, extra );

        if ( col+1 < n )
            rec(row, col+1, sum, extra);
    }

}
