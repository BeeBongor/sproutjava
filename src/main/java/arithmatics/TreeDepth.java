package arithmatics;

import org.junit.Test;

/**
 * @author dengmingliang
 * @Description
 * @ClassName TreeDepth
 * @Date 2019/12/4 10:30 下午
 */
public class TreeDepth {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

        public int TreeDepth(TreeNode root) {
            if(root==null){
                return 0;
            }

            return lookup(root,0);
        }

        public int lookup(TreeNode root,int maxDepth){

            int leftdeep = 0,rightdeep = 0 ;
            if(root.left!=null){
                leftdeep++;
                leftdeep = lookup(root.left,leftdeep);
            }
            if(root.right!=null){
                rightdeep++;
                rightdeep = lookup(root.right,rightdeep);
            }
            maxDepth+=leftdeep>rightdeep?leftdeep:rightdeep;
            return maxDepth;

        }


    int minLength = 0;

    public boolean IsBalanced_Solution(TreeNode root) {
        int min = 0;
        int maxLength = nslookup(root,min);
        return maxLength - minLength<2;

    }

    public int nslookup(TreeNode root,int min){
        if(root == null){
            if(minLength>0){
                minLength = Math.min(min,minLength);
            }else{
                minLength = min;
            }
            return 0;
        }
        min++;
        int left = nslookup(root.left,min);
        int right = nslookup(root.right,min);
        return Math.max(left,right)+1;
    }

    @Test
    public  void test(){
        int[] p = {955,998,1110,2134,955,1023,924,1000000000};
        System.out.println(Integer.toBinaryString(955));
    }


    public void pre(TreeNode root){
        //前序遍历
        if(root.left!=null){
            pre(root.left);
        }
        System.out.println(root.val);
        if(root.right!=null){
            pre(root.right);
        }
        return;
    }
}
