package apps.yuzaco.com.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class pages {
    int b;
    int k ;
    ArrayList<ArrayList<Integer>> res;
    long totalPages;
    public static void main(String args[]){
        pages obj = new pages();
        obj.test();
    }
    void test()
    {
        ArrayList<Integer> pages = new ArrayList<>(Arrays.asList(417, 929, 845, 462, 675, 175, 73, 867, 14, 201, 777, 407, 80, 882, 785, 563, 209, 261, 776, 362, 730, 74, 649, 465, 353, 801, 503, 154, 998, 286, 520, 692, 68, 805, 835, 210, 819, 341, 564, 215, 984, 643, 381, 793, 726, 213, 866, 706, 97, 538, 308, 797, 883, 59, 328, 743, 694, 607, 729, 821, 32, 672, 130, 13, 76, 724, 384, 444, 884, 192, 917, 75, 551, 96, 418, 840, 235, 433, 290, 954, 549, 950, 21, 711, 781, 132, 296, 44, 439, 164, 401, 505, 923, 136, 317, 548, 787, 224, 23, 185, 6, 350, 822, 457, 489, 133, 31, 830, 386, 671, 999, 255, 222, 944, 952, 637, 523, 494, 916, 95, 734, 908, 90, 541, 470, 941, 876, 264, 880, 761, 535, 738, 128, 772, 39, 553, 656, 603, 868, 292, 117, 966, 259, 619, 836, 818, 493, 592, 380, 500, 599, 839, 268, 67, 591, 126, 773, 635, 800, 842, 536, 668, 896, 260, 664, 506, 280, 435, 618, 398, 533, 647, 373, 713, 745, 478, 129, 844, 640, 886, 972, 62, 636, 79, 600, 263, 52, 719, 665, 376, 351, 623, 276, 66, 316, 813, 663, 831, 160, 237, 567, 928, 543, 508, 638, 487, 234, 997, 307, 480, 620, 890, 216, 147, 271, 989, 872, 994, 488, 291, 331, 8, 769, 481, 924, 166, 89, 824, -4, 590, 416, 17, 814, 728, 18, 673, 662, 410, 727, 667, 631, 660, 625, 683, 33, 436, 930, 91, 141, 948, 138, 113, 253, 56, 432, 744, 302, 211, 262, 968, 945, 396, 240, 594, 684, 958, 343, 879, 155, 395, 288, 550, 482, 557, 826, 598, 795, 914, 892, 690, 964, 981, 150, 179, 515, 205, 265, 823, 799, 190, 236, 24, 498, 229, 420, 753, 936, 191, 366, 935, 434, 311, 920, 167, 817, 220, 219, 741, -2, 674, 330, 909, 162, 443, 412, 974, 294, 864, 971, 760, 225, 681, 689, 608, 931, 427, 687, 466, 894, 303, 390, 242, 339, 252, 20, 218, 499, 232, 184, 490, 4, 957, 597, 477, 354, 677, 691, 25, 580, 897, 542, 186, 359, 346, 409, 655, 979, 853, 411, 344, 358, 559, 765, 383, 484, 181, 82, 514, 582, 593, 77, 228, 921, 348, 453, 274, 449, 106, 657, 783, 782, 811, 333, 305, 784, 581, 746, 858, 249, 479, 652, 270, 429, 614, 903, 102, 378, 575, 119, 196, 12, 990, 356, 277, 169, 70, 518, 282, 676, 137, 622, 616, 357, 913, 161, 3, 589, 327 ));
        //System.out.println(books(pages, 2));
        //System.out.println(fractionToDecimal(-1, 2));
        String s;
        if ( (s = getPermutation2(3,5) ) != null )
        {
            for(int k = 0; k < s.length(); k++)
                System.out.print(s.charAt(k) + " " );
        }
        //System.out.println(maximumGap(pages));
        /*ArrayList<Integer> b = slidingMaximum(pages, 2);
        for ( int c : b)
        {
            System.out.println( c + ' ');
        } */
        //System.out.printn(colorful(12));
        //ArrayList<Integer> b = searchRange(pages,2);
        //for ( int c : b)
        //{
            //System.out.println( c + ' ');
        //}
        //ArrayList<ArrayList<Integer>> b = combine(1,1);
        //for ( ArrayList<Integer> c: b)
        //{
            //System.out.println( c.size());
        //}
        System.out.println(firstMissingPositive(pages));
    }
    ArrayList<Integer> kTh;
    int order;

    public String getPermutation2(int n, int k)
    {
        this.n = n;
        this.k = k;
        kTh = null;
        order = 0;
        if ( n == 1)
            return new String("1");

        ArrayList<Integer> K = new ArrayList<>();
        for ( int i = 1; i <= n; i++ )
            K.add(i);

        rec2(0,K);
        StringBuffer a = new StringBuffer();
        for ( int i = 0; i < kTh.size(); i++)
            a.append((char) ( kTh.get(i) + '0' ));
        return a.toString();

    }

    ArrayList<Integer> rec2( int index, ArrayList<Integer> K)
    {
        if ( index  == (n - 1))
        {
            order++;
            if ( order == k )
            {
                kTh = new ArrayList<Integer> (K);
                return kTh;
            }
            else
                return null;
        }

        for ( int i = index; i <= ( n - 1); i++)
        {
            swap(index, i, K);
            if ( rec2(index+1, K ) != null )
                return kTh;
            swap(index, i, K);
        }
        return null;
    }
    void swap(int i, int j, ArrayList<Integer> K)
    {
        int temp = K.get(i);
        K.set(i, K.get(j));
        K.set(j, temp);
    }
    public int firstMissingPositive(ArrayList<Integer> a) {
        long  total = 0;
        int smallest = Integer.MAX_VALUE;
        if ( a == null || a.size() == 0 )
            return 1;

        int largest = a.get(0);

        for ( int i = 0; i < a.size(); i++ )
        {
            if ( a.get(i) > 0 )
            {
                total += a.get(i);
                smallest = Math.min( smallest, a.get(i));
            }
            largest = Math.max( largest, a.get(i));
        }
        if ( largest <= 0 )
            return 1;
        if ( smallest >= 2 )
            return 1;
        double   sum = 0;
        for(int j = 1; j <= largest; j++)
        {
            sum += j;
        }
        if ( sum == total )
        {
            return ((int) ( largest + 1));
        }
        else if ( sum > total )
        {
            return ( (int) ( sum - total));
        }
        else
        {
            return ( (int) ( total -sum ));
        }
    }
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        this.k = k;
        this.n = n;
        rec1(1, 0, new ArrayList<Integer>());
        return res;
    }
    void rec1(int start, int total, ArrayList<Integer> mem)
    {
        if ( start > ( n +1 - ( k - total )))
            return;
        if ( total >=  k  )
        {
            res.add(new ArrayList<Integer> (mem));
            return;
        }
        mem.add( start);
        rec1( start+1,  total+1, mem);
        mem.remove(mem.size() - 1);
        rec1( start+1, total, mem);
    }
    public int compareVersion(String a, String b)
    {

        int aSize = a.length();
        int bSize = b.length();
        int i = 0;
        int j = 0;
        while(  i < aSize || j < bSize )
        {
            long  aLen = 0;
            long  bLen = 0;
            int aStart = i;
            boolean aLeading = true;
            boolean bLeading = true;
            int aZeros = 0;
            int bZeros = 0;
            while( i < aSize &&  a.charAt(i) != '.' )
            {
                if ( aLeading )
                {
                    if ( a.charAt(i) == '0' )
                    {
                        aZeros++;
                        aStart++;
                    }
                    else
                        aLeading = false;
                }
                aLen++;
                i++;
            }
            i++;
            int bStart = j;
            while( j < bSize && b.charAt(j) != '.' )
            {
                if ( bLeading )
                {
                    if ( b.charAt(j) == '0' )
                    {
                        bZeros++;
                        bStart++;
                    }
                    else
                        bLeading = false;
                }
                bLen++;
                j++;
            }
            aLen -= aZeros;
            bLen -= bZeros;
            if ( aLen > bLen)
                return 1;
            else if ( aLen  <  bLen )
                return -1;
            else
            {

                while ( bLen > 0 )
                {
                    int aChar = (int) ( a.charAt(aStart) - '0');
                    int bChar = (int)  ( b.charAt(bStart) - '0');
                    if ( aChar > bChar )
                        return 1;
                    else if ( aChar < bChar )
                        return -1;
                    bLen--;
                    aStart++;
                    bStart++;
                }
            }
            j++;
        }
        return 0;
    }
    public ArrayList<Integer> searchRange(final List<Integer> a, int b) {

        int low = 0;
        int high = a.size();
        int mid = 0;
        boolean found = false;
        int n = a.size();
        while (low < high )
        {
            mid = ( low+high )/2;
            if ( a.get(mid) == b )
            {
                found = true;
                break;
            }
            else if ( a.get(mid) < b )
            {
                low = mid +1 ;
            }
            else
            {
                high = mid - 1;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        if ( !found )
        {
            ans.add(-1);
            ans.add(-1);
            return ans;
        }
        int start = mid;
        while( (start-1) >= 0 && a.get(start-1) == b ){
            start--;
        }
        int end = mid;
        while( (end+1) < n && a.get(end+1) == b ) end++;
        ans.add(start);
        ans.add(end);
        return ans;

    }
    public int colorful(int a) {
        HashMap<Integer, Integer> map = new HashMap<>();
        String s = toDigit(a);

        for(int len = 1; len <= s.length() ; len++ )
        {
            for(int i = 0; i<= s.length() - len; i++ )
            {
                int product = 1;
                for ( int j = i; j < ( i + len ); j++ )
                {
                    product *= (int) (s.charAt(j) - '0');
                }
                if ( map.containsKey(product) )
                    return 0;
                else
                    map.put(product, product);
            }
        }
        return 1;
    }

    String toDigit(int a )
    {
        StringBuffer buf = new StringBuffer();

        while(a != 0 )
        {
            int digit = a%10;
            a /= 10;

            buf.append((char) (digit + '0'));
        }
        return buf.toString();
    }
    ArrayList<pair> data;
    ArrayList<Integer>  ans;
    List<Integer> a;
    int[][] dp;
    int n;
    public ArrayList<Integer> slidingMaximum(final List<Integer> a, int b) {
        n = a.size();
        dp = new int[n][n];
        for ( int i = 0; i < n; i++)
        {
            Arrays.fill(dp[i], -1);
            dp[i][i] = a.get(i);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n && i < b ; i++){
            max = Math.max(a.get(i), max);
            dp[0][i] = max;
        }
        ans = new ArrayList<>();
        ans.add(max);

        if ( n <= b )
            return ans;

        for ( int i = 1; i<= ( n -b ); i++ )
        {
            ans.add( rec(i, i+b-1) );
        }
        return ans;
    }

    int rec(int i, int j)
    {
        if ( i >  j )
            return Integer.MIN_VALUE;
        if ( j< 0 || j > ( n -1 ) )
            return Integer.MIN_VALUE;
        if ( dp[i][j] != -1 )
            return dp[i][j];
        return ( dp[i][j]  = Math.max( a.get(j), rec(i, j-1)));

    }
    public int maximumGap(final List<Integer> a)
    {
        data = new ArrayList<pair>();
        int n = a.size();
        for ( int i = 0; i < n; i++ )
        {
            data.add(new pair(a.get(i), i ));
        }

        Collections.sort(data);
        int max = -1;
        for( int i = 0; i < (n-1); i++ )
        {
            for ( int j = i +1 ; j < n; j++)
            {
                int index = data.get(i).index;
                if ( index < data.get(j).index )
                {
                    max = Math.max(max, data.get(j).index - index );
                }
            }
        }
        return(max);
    }
    class pair implements Comparable<pair>
    {
        int val;
        int index;
        public pair(int value, int i)
        {
            val = value;
            index = 1;
        }

        @Override
        public int compareTo(pair b )
        {
            return Integer.compare(val, b.val);
        }
    }
    public String getPermutation1(int n, int k)
    {
        ArrayList<Integer> order = new ArrayList<>();
        for ( int i = 1; i <= n; i++)
        {
            order.add(i);
        }

        return rec(k-1, order);
    }
    String rec(int k,  ArrayList<Integer> order )
    {
        int n = order.size();
        if ( n == 0 ) return "";
        if ( n == 1 )
        {
            return  String.valueOf(order.get(0));
        }
        int fact = factorial(n-1);
        int pos = k/fact;
        k %= fact;
        String ch = String.valueOf(order.get(pos));
        order.remove(pos);
        return ch + rec(k, order);
    }
    int factorial(int n)
    {
        if ( n > 12 )
            return Integer.MAX_VALUE;
        int fact = 1;
        for( int i = 1; i <= n; i++)
        {
            fact *= i;
        }
        return fact;
    }
    public String fractionToDecimal(int numerator, int denominator) {

        float  N = Math.abs((long) numerator);
        float  D = Math.abs( (long) denominator);
        float number = N/D;
        StringBuffer buf = new StringBuffer();
        boolean negative = false;
        if ( numerator < 0 && denominator > 0 )
            negative = true;
        else if ( numerator > 0 && denominator < 0 )
            negative = true;
        if ( negative )
            buf.append('-');
        long digit = (long) number;
        buf.append(Long.toString(digit));
        number -= (double) digit;
        if ( number == 0 )
            return buf.toString();
        buf.append('.');
        StringBuffer fraction = new StringBuffer();
        long  previousDigit = -1;
        boolean repeating = false;
        int i = 0;
        while( ( number > 0 ) && ( i < 32 ) )
        {
            number *= 10;

            digit = ( int ) number;
            number -= digit;
            if ( previousDigit == -1 )
                previousDigit = digit;
            else
            {
                if ( previousDigit != digit )
                    repeating = false;
                previousDigit = digit;
            }
            fraction.append(Long.toString(digit));
            i++;
        }
        if ( repeating )
        {
            buf.append('(');
            buf.append(Long.toString(digit));
            buf.append(')');
        }
        else
            buf.append(fraction);
        return buf.toString();
    }

    public int books(ArrayList<Integer> a, int b)
    {
        this.a = a;
        this.b = b;
        this.n = a.size();
        if ( b > n )
            return -1;
        totalPages =0;
        for ( int i = 0; i < n; i++)
            totalPages += a.get(i);

        long start = 0;
        long end = totalPages;
        long res= Integer.MAX_VALUE;
        long mid = Integer.MAX_VALUE;
        while( start <= end )
        {
            mid =  ( start+end )/2;
            if ( isPossible(mid) )
            {
                res = Math.min((int)res,  (int)mid );
                end = mid -1;
            }
            else
            {
                start = mid + 1;
            }
        }
        return (int) res;
    }

    boolean isPossible(long  Max )
    {
        long total = 0;
        int students = 1;
        for ( int i = 0; i < n; i++ )
        {
            if ( Max < a.get(i))
                return false;
            if ( total + a.get(i) > Max )
            {
                students++;
                total = a.get(i);
                if ( students > b )
                    return false;
            }
            else
            {
                total += a.get(i);
            }
        }
        return true;
    }
}
