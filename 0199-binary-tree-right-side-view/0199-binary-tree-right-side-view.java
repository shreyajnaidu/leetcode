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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root!=null){
            q.offer(root);
        }
        while(!q.isEmpty()){
            int n=q.size();
            int level=0;
            for(int i=0;i<n;i++){
             TreeNode current=q.poll();
                if(i==0){
                    level=current.val;
                }
            if(current.right!=null){
                q.offer(current.right);
            }
            if(current.left!=null){
                q.offer(current.left);
            }
         }
         result.add(level);
        }
        return result;
    }
}