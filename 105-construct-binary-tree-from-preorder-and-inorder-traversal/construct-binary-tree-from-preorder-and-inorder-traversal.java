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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> inmap=new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            inmap.put(inorder[i],i);
        }

        TreeNode root=helptree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,inmap);

        return  root;

    }

    public TreeNode helptree(int[] preorder,int prestart,int preEnd,int[] inorder,int instart,int inEnd,Map<Integer,Integer> inmap){
        if(prestart>preEnd || instart>inEnd){
            return null;
        }
        //yaha root banaoge
        TreeNode root=new TreeNode(preorder[prestart]);

        //yah index dhundhenge uska

        int inroot=inmap.get(root.val);
        int numsleft=inroot-instart;

        root.left=helptree(preorder,prestart+1,prestart+numsleft,inorder,instart,inroot-1,inmap);
        root.right=helptree(preorder,prestart+numsleft+1,preEnd,inorder,inroot+1,inEnd,inmap);

        return root;
    }
}