package apps.yuzaco.com.minpalincut;

public class minPalinCut {
    final static int MOD = 10000003;
    ArrayList<Integer> panels;
    int n;
    public int paint(int a, int b, ArrayList<Integer> c) {

        long high = Long.MAX_VALUE;
        long low = 0;
        long mid;
        long total = Long.MAX_VALUE;
        panels = c;
        n = c.size();

        while( low <= high )
        {
            mid =  low + (( high - low )>>1);
            if ( isPossible(a, b, mid))
            {
                high = mid - 1;
                total = mid;
            }
            else
            {
                low = mid+1;
            }
        }
        return   (int) (total%MOD));
    }
    boolean isPossible(int painters, long time, long total)
    {
        long sum;
        int index = 0;
        for ( int i = 0; i < painters && index < n; i++ )
        {
            sum = 0;

            while( index < n && sum < total )
            {
                sum +=  1L*(panels.get(index)*time);
                if ( sum > total )
                    break;
                index++;
            }
        }
        if ( index == n )
            return true;
        else
            return false;
    }

}
