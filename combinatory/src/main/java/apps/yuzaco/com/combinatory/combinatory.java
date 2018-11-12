package apps.yuzaco.com.combinatory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

/*
 * Given 1-n numbers and K element from the number set, compute all the possible
 * k number comination of given n number range.  Each comination has to be lexiographically
 * ordered and entries should be ordered.
 */
public class combinatory {
    public static void main(String args[])
    {
        combinatory obj = new combinatory();
        ArrayList<ArrayList<Integer>> ans = obj.combine(5,2);
        for ( int i = 0; i < ans.size(); i++){
            System.out.print("\n\t[");
            ArrayList<Integer> array = ans.get(i);
            for ( int k = 0; k < array.size(); k++) {
                System.out.print(array.get(k) + "  ");
            }
            System.out.print(" ]");
        }
    }
    public ArrayList<ArrayList<Integer>> res;

    public ArrayList<ArrayList<Integer>> combine(int n, int k)
    {
        if ( n < k )
             return null;
        res = new ArrayList<>();
        rec(n, k, new ArrayList<Integer>());
        Collections.sort(res, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> a, List<Integer> b)
            {
                int size = Math.min(a.size(), b.size());
                for (int i = 0; i < size; i++) {
                    int cmp = Integer.compare(a.get(i), b.get(i));
                    if (cmp != 0)
                        return cmp;
                }
                if (a.size() > b.size())
                    return 1;
                else if (a.size() == b.size())
                    return 0;
                return -1;
            }
        });
        return res;
    }

    private void rec( int n, int k, ArrayList<Integer> temp) {
        if (k == 0) {
            ArrayList<Integer> ans = new ArrayList<Integer>(temp);
            Collections.reverse(ans);
            res.add(ans);
            return;
        }
        if (n == 0 || n < k) {
            return;
        }
        // for combinatory exclude this number first
         rec(n - 1, k, temp);
        // or include this number
        temp.add(n);
        rec(n - 1, k - 1, temp);
        temp.remove(temp.size() - 1);
    }
}
