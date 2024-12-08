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
    private void validPath(TreeNode root, int targetSum,List<Integer> subList,List<List<Integer>> ans){
        if(root == null){
            return;
        }
        subList.add(root.val);
        if(root.left == null && root.right == null && targetSum-root.val == 0){
            ans.add(new ArrayList<Integer>(subList));
        }
        else{
            validPath(root.left,targetSum-root.val,subList,ans);
            validPath(root.right,targetSum-root.val,subList,ans);
        } 
        subList.remove(subList.size()-1);
        
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        validPath(root,targetSum,subList,ans);
        return ans;
        
    }
}