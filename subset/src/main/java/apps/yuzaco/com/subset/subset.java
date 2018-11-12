package apps.yuzaco.com.subset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class subset {
    public static void main(String args[]){
        ArrayList<Integer> a = new ArrayList<>();
        a.add(3);
        a.add(1);
        a.add(2);
        a.add(2);
        subset s = new subset();
        System.out.println(s.subsetsWithDup(a));
    }
    ArrayList<ArrayList<Integer>> res;
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> a) {
        if ( a == null)
            return null;
        res = new ArrayList<>();
        Collections.sort(a);

        rec(a, new ArrayList<Integer>(), 0);

        Collections.sort(res, new Comparator<List<Integer>>(){
            @Override
            public int compare(List<Integer>a, List<Integer>b){
                int size = Math.min(a.size(), b.size());
                for(int i = 0; i < size; i++)
                {
                    int cmp = Integer.compare(a.get(i), b.get(i));
                    if ( cmp == 0 )
                        continue;
                    else
                        return cmp;
                }
                return(Integer.compare(a.size(), b.size()));
            }

        });
        return res;
    }
    public void rec(ArrayList<Integer> A, ArrayList<Integer> ans, int index){
        if ( index >= A.size() )
        {
            res.add(new ArrayList<Integer>(ans));
            return;
        }
        int curIndex = index + 1;
        while( curIndex < A.size() && ( A.get(curIndex) == A.get(index))){
            curIndex++;
        }

        for ( int i = 0; i <= ( curIndex - index); i++)
        {
            for ( int k = 0; k < i; k++)
            {
                ans.add(A.get(index));
            }
            rec(A, ans, curIndex);
            for ( int t = 0; t < i; t++)
            {
                ans.remove(ans.size() -1);
            }
        }
    }
}
