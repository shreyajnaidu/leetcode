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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val);
        }
        TreeNode temp1=root;
        TreeNode temp2=null;
        while(temp1!=null){
            temp2=temp1;
            if(temp1.val>val){
                temp1=temp1.left;
            }else{
                temp1=temp1.right;
            }
        }
        if(temp2.val>val){
            TreeNode temp3=new TreeNode(val);
            temp2.left=temp3;
        }else{
            TreeNode temp3=new TreeNode(val);
            temp2.right=temp3;
        }
        return root;
    }
}