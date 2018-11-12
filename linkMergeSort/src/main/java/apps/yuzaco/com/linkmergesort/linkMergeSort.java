package apps.yuzaco.com.linkmergesort;

import java.util.ArrayList;
import java.util.Arrays;

public class linkMergeSort {
    public static  void main(String args[])
    {
        linkMergeSort obj = new linkMergeSort();
         obj.merge();
    }
    void merge()
    {
        Integer[] array = new Integer[]{5, 66, 68, 42, 73, 25, 84, 63, 72, 20, 77, 38, 8, 99, 92, 49, 74, 45, 30, 51, 50, 95, 56, 19, 31, 26, 98, 67, 100, 2, 24, 6, 37, 69, 11, 16, 61, 23, 78, 27, 64, 87, 3, 85, 55, 22, 33, 62};
        //Integer[] array = new Integer[]{5, 66, 68, 42, 73, 25, 84, 63, 72, 20, 77};
        ArrayList<Integer> a = new ArrayList<>();
        a.addAll(Arrays.asList(array));
        ListNode aa = new ListNode(a.get(0));
        ListNode first = aa;
        for (int i = 1; i < a.size(); i++) {
            aa.next = new ListNode(a.get(i));
            aa = aa.next;
        }

        ListNode b = mergeSort(first);
        while (b != null) {
            System.out.print(" " + b.val + " ");
            b = b.next;
        }
    }
    public ListNode sortList(ListNode a) {
        if ( a == null || a.next == null )
            return a;

        return mergeSort(a);
    }

    ListNode mergeSort(ListNode a )
    {
        int total = size(a);
        if ( total <= 1 )
            return a;
        ListNode b = divideTwo( a, (int) total/2) ;
        ListNode a1 = mergeSort(a);
        ListNode a2 = mergeSort(b);
        ListNode m = mergeSort( a1, a2);
        return( m);
    }
    ListNode mergeSort(ListNode a, ListNode b)
    {
        ListNode st = null;
        ListNode ap = a;
        ListNode bp = b;
        ListNode current = null;
        while( ap != null && bp != null)
        {
            if ( ap.val < bp.val )
            {
                ListNode temp = ap.next;
                if ( st == null )
                {
                    st = ap;
                    current = ap;
                    ap.next = null;
                    ap = temp;
                }
                else
                {
                    current.next = ap;
                    ap.next = null;
                    current = ap;
                    ap = temp;
                }
            }
            else
            {
                ListNode temp = bp.next;
                if ( st == null )
                {
                    st = bp;
                    current = bp;
                    bp.next = null;
                    bp = temp;
                }
                else
                {
                    current.next = bp;
                    bp.next = null;
                    current = bp;
                    bp = temp;
                }
            }
        }
        while(ap != null )
        {
            ListNode temp = ap.next;
            if ( current  == null )
            {
                current = ap;
                st = ap;
            }
            else
            {
                current.next = ap;
            }
            ap.next = null;
            current = ap;
            ap = temp;
        }

        while(bp != null)
        {
            ListNode temp = bp.next;
            if ( current  == null )
            {
                current = bp;
                st = bp;
            }
            else
            {
                current.next = bp;
                current = bp;
            }
            bp.next = null;
            bp = temp;
        }
        return st;
    }
    int size(ListNode list)
    {
        int total = 0;

        while( list != null )
        {
            list = list.next;
            total++;
        }
        return total;
    }
    ListNode divideTwo(ListNode a, int mid)
    {
        ListNode start = a;
        ListNode previous = start;
        while( mid > 0 && start != null)
        {
            ListNode temp = start.next;
            if ( previous == null )
                previous = start;
            else
            {
                previous.next = start;
                previous = start;
            }
            start.next = null;
            start = temp;
            mid--;
        }
        return start;
    }
    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
    public int minimumTotal(ArrayList<ArrayList<Integer>> A) {
        int m, n;
        m = A.size();
        n = A.get(m - 1).size();
        int[] dp = new int[n + 1];
        int size = n;

        for (int i = m - 1; i >= 0; i--) {

            for (int j = 0; j < size; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + A.get(i).get(j);
            }

            size--;
        }

        return dp[0];
    }
}
