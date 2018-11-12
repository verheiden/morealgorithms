package apps.yuzaco.com.arrangehorse;

import java.util.ArrayList;
import java.util.Arrays;

public class arrangeHorse {
    int dp[][];
    int n;
    int k;
    String a;
    public static void main(String args[])
    {
        arrangeHorse obj = new arrangeHorse();
        //System.out.println(obj.arrange("WBWB", 2));
        obj.cycle();
    }
    class ListNode
    {
        int val;
        ListNode next;
        ListNode(int x) { val = x;  next = null;}
    }
    void cycle()
    {
        //Integer[] array = new Integer[]{5, 66, 68, 42, 73, 25, 84, 63, 72, 20, 77, 38, 8, 99, 92, 49, 74, 45, 30, 51, 50, 95, 56, 19, 31, 26, 98, 67, 100, 2, 24, 6, 37, 69, 11, 16, 61, 23, 78, 27, 64, 87, 3, 85, 55, 22, 33, 62};
       Integer[] array = new Integer[]{5, 66, 68, 42, 73, 25, 84, 63, 72, 20, 77};
        ArrayList<Integer> a = new ArrayList<>();
        a.addAll(Arrays.asList(array));
        ListNode aa = new ListNode(a.get(0));
        ListNode first = aa;
        for (int i = 1; i < a.size(); i++) {
            aa.next = new ListNode(a.get(i));
            aa = aa.next;
        }

        ListNode b = detectCycle(first);
        if ( b ==null )
            System.out.println("NULL");
        else
            System.out.println(b.val);
    }
    public ListNode detectCycle(ListNode a) {

        if ( a == null || a.next == null )
            return a;
        ListNode slow = a;
        ListNode fast = a;
        boolean isCircle = false;
        while(slow != null && fast != null  )
        {
            slow = slow.next;
            if ( slow == null )
                return null;
            if ( fast == null  ||  fast.next == null )
                return null;
            fast = fast.next.next;

            if ( fast == slow )
            {
                isCircle = true;
                break;
            }
        }
        if ( isCircle == false )
            return null;
        slow =a;
        while(slow != fast)
        {
            if ( slow == null || fast == null )
                return null;
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    public int arrange(String a, int b) {
        if ( a == null || a.length() == 0 || b == 0 )
            return 0;
        this.a = a;
        k = b;
        n = a.length();
        dp = new int[n][k];
        if ( a.length() < b )
            return -1;

        for ( int i = 0; i <n; i++)
        {
            Arrays.fill(dp[i], -1);
        }

        int ans = rec(0,0);
        if ( ans == Integer.MAX_VALUE )
            return -1;
        else
            return ans;
    }
    int rec(int horse, int stable)
    {
        if ( horse == n ){
            if ( stable == k )
                return 0;
            return Integer.MAX_VALUE;
        }
        if ( stable == k )
            return Integer.MAX_VALUE;

        if (horse >=n )
            return Integer.MAX_VALUE;

        if ( dp[horse][stable] != -1 ){
            return dp[horse][stable];
        }
        int res = Integer.MAX_VALUE;
        int W = 0;
        int B = 0;
        for(int l = horse; l <n ; l++ )
        {
            if ( a.charAt(l) == 'W' )
                W++;
            else
                B++;
            int temp =   rec(l+1, stable+1);
            if ( temp  != Integer.MAX_VALUE )
                res = Math.min(res,  rec(l+1, temp + W*B ));
        }
        return dp[horse][stable] = res;
    }
}
