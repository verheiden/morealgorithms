package apps.yuzaco.com.maxsub;

import java.util.ArrayList;

public class maxSub {
    static public void main(String args[])
    {
        maxSub obj = new maxSub();
        obj.maxS();
    }
    private void maxS()
    {
        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(1967513926);
        array.add(1540383426);
        array.add(-1303455736);
        array.add(-521595368);
        ArrayList<Integer> ans = maxset(array);

        for ( Integer i : ans)
        {
            System.out.println( i);
        }
    }
    public ArrayList<Integer> maxset(ArrayList<Integer> a)
    {
        if ( a == null || a.size() == 0 )
            return a;
        int first = 0;
        int last = 0;
        long sum = 0;
        long max = a.get(0);
        int n = a.size();
        int maxFirst = 0;
        int maxLast = 0;
        for ( int i = 0; i < a.size();  )
        {
            sum = (long) a.get(i);
            first = i;
            last = i;
            if ( sum < 0 )
            {
                i++;
                continue;
            }
            while( last+1 < n &&   ( sum <= sum + a.get(last+1)))
            {
                last++;
                sum += a.get(last);
            }

            if (sum>max ||( sum == max  && ((last-first)> (maxLast- maxFirst))))
            {
                maxFirst = first;
                maxLast = last;
                max = sum;
                i = last;
            }
            i++;
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if ( max >= 0 )
        {
            for ( int i = maxFirst; i <= maxLast; i++)
            {
                ans.add(a.get(i));
            }
        }
        return ans;
    }
}
