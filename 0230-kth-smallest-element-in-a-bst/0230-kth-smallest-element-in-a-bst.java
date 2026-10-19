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
    int count;
    int result;
    public void inorder(TreeNode root){
        if(root==null || count==0) return;
        inorder(root.left);
            if (count > 0) {
            count--;
            if (count == 0) {
                result = root.val;
                return;
            }
        }
        inorder(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        count=k;
        result=0;
        inorder(root);
        return result;
    }
}