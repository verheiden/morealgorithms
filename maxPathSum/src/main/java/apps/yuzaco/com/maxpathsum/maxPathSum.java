package apps.yuzaco.com.maxpathsum;

import javax.swing.tree.TreeNode;

public class maxPathSum {
      static public void main(String args[]){
          maxPathSum obj = new maxPathSum();
          obj.test();
      }
      class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; left = null; right = null;}
  }
  void test(){
          TreeNode node1 = new TreeNode(-200);
          TreeNode node2 = node1.left = new TreeNode(-300);
          node1.right = new TreeNode(-100);
          node2.left = new TreeNode(-400);
          System.out.println(maxPathSum(node1));

  }
    int globalMax;
    public int maxPathSum(TreeNode a) {
        globalMax = a.val;
        addPath(a);
        return globalMax;
    }
    int addPath(TreeNode root)
    {
        if ( root == null )
            return Integer.MIN_VALUE;
        int r ;
        int l ;
        int min, max;
        if ( root.val < 0 )
        {
            r = addPath(root.right);
            max = Math.max(r, root.val);
            globalMax = Math.max(max, globalMax);
        }
        else
        {

            l = addPath(root.left);
            r = addPath(root.right);
            max = Math.max(root.val, root.val + Math.max(r, l));
            min = Math.min(r,l);
            if( min > 0 )
            {
                globalMax = Math.max(max + min, globalMax);
            }
            else
            {
                globalMax = Math.max(max, globalMax);
            }
        }
        return( max );
    }
}
