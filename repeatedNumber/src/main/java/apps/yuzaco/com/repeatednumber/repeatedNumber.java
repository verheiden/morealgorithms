package apps.yuzaco.com.repeatednumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 *  repeatedNumber : given series of  n number, which is different by one  to n, except
 *  one number is repeated twice and one number is missing. Find these two numbers.
 */

public class repeatedNumber
{
     public static  void main(String args[]){
         repeatedNumber obj = new repeatedNumber();
         obj.dups();
         /*obj.reverse();
         ArrayList<Integer> qes = new ArrayList();
         Integer[] array = new Integer[] {4, 1, 2, 5, 4, 3};
         qes.addAll(Arrays.asList(array));
         ArrayList<Integer> ans =
         obj.repeatN(qes);

             System.out.println("Answer is " + ans.get(0) + " , " + ans.get(1)); */

     }
     void dups()
     {
         Integer[] array = new Integer[] { 1,1,1,3,4,4,4,55,6,7,7,7};

         ArrayList<Integer> a = new ArrayList<> ();
         a.addAll(Arrays.asList(array));
         ListNode aa = new ListNode(a.get(0));
         ListNode first = aa;
         for( int i = 1; i < a.size(); i++)
         {
             aa.next = new ListNode(a.get(i));
             aa = aa.next;
         }

         ListNode b = deleteDuplicates(first);
         while(b != null )
         {
             System.out.print(" " + b.val + " ");
             b = b.next;
         }
     }
public ListNode deleteDuplicates(ListNode a) {
    if ( a == null || a.next == null )
        return a;

    ListNode list = a;
    ListNode previous = null;
    ListNode head = null;

        while( list != null )
        {
            ListNode first = list;
            while( (list != null && (list.next != null)) && ( list.val == list.next.val ))
            {
                list = list.next;
            }

            if ( first == list  )
            {
                ListNode temp = list.next;
                if ( previous != null ){
                    previous.next = list;
                    previous = list;
                    previous.next = null;
                }
                else if ( previous == null )
                {
                    previous = list;
                    previous.next = null;
                    head = list;
                }
                list = temp;
            }
            else
            {
                if ( list != null ) {
                    list = list.next;
                }
            }
        }
        return head;
    }
     void reverse()
     {
         ListNode b = new ListNode(46);
         ListNode c = new ListNode(26);
         ListNode d = new ListNode(92);
         ListNode e = new ListNode(73);
         ListNode f = new ListNode(42);
         ListNode g = new ListNode(89);
         ListNode h = new ListNode(42);


         b.next = c;
         c.next = d;
         d.next = e;
         e.next = f;
         f.next = g;
         g.next = h;
         ListNode k =  reverseBetween(b,1,4);

         while(k!= null )
         {
             System.out.println(k.val);
             k = k.next;
         }
     }

     ArrayList<Integer>  repeatN(final List<Integer> a){
         if ( a == null || a.size() == 0 )
             return null;
         long sum = 0;
         long sumSq = 0;
         for ( int i = 0; i < a.size(); i++){
            long temp = (long) a.get(i);
            sum += temp ;
            sum -= (i+1);

            sumSq +=  temp*temp;
            sumSq -= (i+1)*(i+1);
         }
         // sumSq =  A^2 - B^2;
         // sumSq = ( A+B) (A-B)
         // sum = A -B
         sumSq /= sum;  // A+B
         int A;
         int B;
         A = (int) (sumSq + sum )/2;
         B = (int) ( sumSq - A);
         ArrayList<Integer> ans = new ArrayList<>();
         ans.add(A);
         ans.add(B);
         return ans;
     }

    public ListNode reverseBetween(ListNode a, int m, int n) {
        if ( a == null )
            return a;
        ListNode head =a;
        ListNode front = a;
        ListNode bPrevious = null;
        ListNode previous = null ;
        ListNode begin = null;
        int index = 0;

        while((index < n ) && ( head != null ))
        {
            index++;
            ListNode p = head.next;
            if ( index == m )
            {
                bPrevious = previous;
                begin = head;
            }
            else if ( index > m && index < n)
            {
                head.next = previous;
            }
            else if ( index == n )
            {
                if ( bPrevious == null )
                {
                    front = head;
                }
                else {
                    bPrevious.next = head;
                }
                ListNode pNext = head.next;
                head.next = previous;
                begin.next = pNext;

                break;
            }
            previous = head;
            head = p;
        }
        return front;
    }

      class ListNode {
          public int val;
          public ListNode next;
          ListNode(int x) { val = x; next = null; }
      }
     
}
