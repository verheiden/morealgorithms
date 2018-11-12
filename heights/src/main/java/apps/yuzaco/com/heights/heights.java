package apps.yuzaco.com.heights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class heights {
    public static void main(String args[])
    {
        heights obj = new heights();
        obj.test();
    }
    void test()
    {
        ArrayList<Integer> heights = new ArrayList<Integer>(Arrays.asList(86,77));
        ArrayList<Integer> fronts = new ArrayList<Integer>(Arrays.asList(0,1));
        ArrayList<Integer> ans =
              order(heights, fronts);
        for(int i = 0; i < ans.size(); i++){
            System.out.print(ans.get(i) + " ");
        }
    }
    class pair implements Comparable<pair>
    {
        int height;
        int infronts;
        public pair(int h, int i)
        {
            height = h;
            infronts = i;
        }
        @Override
        public int compareTo(pair b)
        {
            return Integer.compare(height, b.height);
        }
    }
    public ArrayList<Integer> order(ArrayList<Integer> heights, ArrayList<Integer> infronts)
    {

        ArrayList<pair> line = new ArrayList<>();
        ArrayList<Integer> orders = new ArrayList<>();

        for( int i = 0; i < heights.size(); i++ )
        {
            line.add(new pair(heights.get(i), infronts.get(i)));
        }
        Collections.sort(line);
        int n = heights.size();
        Bit bit = new Bit(n);
        for ( int i=1; i <=n;i++ )
        {
            bit.update(i, 1);
        }
        for ( int i = 0; i < line.size(); i++ )
        {
            int idx = bit.findOrder(line.get(i).infronts );
            orders.set(idx, line.get(i).height);
        }
        return(orders);
    }

    class Bit
    {
        int[] data;
        int N;
        public Bit(int size)
        {
            data = new int[size+1];
            N = size;
        }
        void update(int bottom, int value )
        {
            while(bottom > 0 && bottom <= N){
                data[bottom] += value;
                bottom++;
            }
        }
        int findOrder(int nTaller)
        {
            int start =1;
            int end = N;
            int count = end - start + 1;
            int idx = 0;
            while(count > 0 )
            {
                int mid = ( start + end )/2;
                int value = fronts(mid);
                if ( value > nTaller ){
                    end = mid -1;
                }
                else if ( value < nTaller )
                {
                    start = mid + 1;
                }
                else if ( value == nTaller )
                {
                    end = mid  - 1;
                    idx = mid;
                }
                count /= 2;
            }
            update(idx, -1);
            return( idx -1 );
        }
        int  fronts(int idx)
        {
            int res = 0;
            while(idx >  0  )
            {
                res += data[idx];
                idx--;
            }
            return res;
        }
    }
}