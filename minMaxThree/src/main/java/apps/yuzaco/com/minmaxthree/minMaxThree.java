package apps.yuzaco.com.minmaxthree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class minMaxThree {
    public static void main(String args[]){
        minMaxThree obj = new minMaxThree();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(2);
        a.add(3);
        a.add(4);
        /*
        int num = 15;
        int n = 10;
        for(int i = 0;i < 4; i++)
        {

            for ( int k = 0; k < n; k++)
            {
                a.add(i);
            }
            n += 4;
        } */
        //List<Integer> b = Arrays.asList(1,1);
        //List<Integer> c = Arrays.asList(1,1);
        //System.out.println(" Answer is : " + obj.minimize(a,b,c));
        System.out.println(" Answer is : " + obj.diffPossible(a,0));

    }
    public int diffPossible(ArrayList<Integer> a, int b) {
        if ( a == null || (a.size() < 2 || b < 0 ))
            return 0;

        int n = a.size();
        int j = 1;
        for ( int i =0; i < (n - 1); i++)
        {
            j = Math.max(i+1, j);
            while( j < n && a.get(j) - a.get(i) < b ) j++;
            if ( a.get(j) - a.get(i) == b )
                return 1;
        }
        return 0;
    }
    public int removeDuplicates(ArrayList<Integer> a) {
        int[] nums;
        if ( a == null || a.size() == 0 )
            return 0;
        int n = a.size();

        int previous = a.get(0);
        int k = 1;
        for ( int i = 1; i < n; )
        {
            int num = a.get(i);
            while( num == previous )
            {
                i++;
                if ( i >=  n )
                {
                    break;
                }
                num = a.get(i);
            }
            if ( i < n ) {
                a.set(k, num);
                previous = num;
                i++;
                k++;
            }
        }
        n = n -1;
        while( n >=k )
        {
            a.remove(n);
            n--;
        }
        return k;
    }
    public int minimize(final List<Integer> aa, final List<Integer> bb, final List<Integer> cc)
    {
        int min = Integer.MAX_VALUE;

        ArrayList<Node> list = new ArrayList<>();
        add(list, aa, 0);
        add(list, bb, 1);
        add(list, cc, 2);

        Collections.sort(list);

        int n = list.size();
        HashMap<Integer, Integer> map = new HashMap<>();
        for ( int i = 0; i < n; i++)
        {
            Node node = list.get(i);
            map.put( node.index, node.value);

            if ( map.size() == 3 )
            {
                int a = map.get(0);
                int b = map.get(1);
                int c = map.get(2);

                int temp = Math.max( Math.abs(a-b), Math.abs(b-c));
                temp = Math.max(Math.abs(c-a), temp );
                min = Math.min(temp, min);
            }
            i++;
        }
        return min;
    }

    private void add(ArrayList<Node> list, List<Integer> a, int index)
    {
        int n = a.size();
        for ( int i = 0; i < n; i++)
        {
            list.add(new Node(a.get(i), index));
        }
    }

    class Node implements Comparable<Node> {
        int value;
        int index;
        public Node(int val, int i)
        {
            value = val;
            index = i;
        }

        @Override
        public int compareTo(Node x)
        {
            return Integer.compare(value, x.value);
        }
    }
}
