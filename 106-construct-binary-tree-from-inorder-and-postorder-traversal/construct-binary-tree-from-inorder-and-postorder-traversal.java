/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> inmap=new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            inmap.put(inorder[i],i);
        }

        TreeNode root=helptree(postorder,0,postorder.length-1,
                                inorder,0,inorder.length-1,inmap);

        return root;
    }

    public TreeNode helptree(int[] postorder,int poststart,int postend,int[] inorder, int instart,int inend,Map<Integer,Integer> inmap){
        if(  instart>inend || poststart>postend){
            return null;
        }
         TreeNode root=new TreeNode(postorder[postend]);

         int inroot=inmap.get(root.val);
         int numsleft=inroot-instart;

         root.left=helptree(postorder,poststart,poststart+numsleft-1,inorder,instart,inroot-1,inmap);

         root.right=helptree(postorder,poststart+numsleft,postend-1,inorder,inroot+1,inend,inmap);

         return root;
    }
}