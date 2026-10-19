/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode temp1=root;
        TreeNode temp2=root;
        TreeNode result=null;
        while(temp1.val != p.val || temp2.val != q.val){
            if(temp1==temp2){
                result=temp1;
            }
            if(temp1.val>p.val){
                temp1=temp1.left;
            }else if(temp1.val<p.val){
                temp1=temp1.right;
            }
            if(temp2.val>q.val){
                temp2=temp2.left;
            }else if(temp2.val<q.val){
                temp2=temp2.right;
            }
        }
        return result;
    }
}