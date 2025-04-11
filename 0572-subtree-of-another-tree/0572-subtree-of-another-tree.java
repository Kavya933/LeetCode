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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null){
            return true;
        }
        if(root == null && subRoot == null){
            return true;
        }
        if(isSameTree(root,subRoot)){
            return true;
        }
        if(root == null){
            return false;
        }
        if(isSubtree(root.left, subRoot) || isSubtree(root.right,subRoot)){
            return true;
        }
        return false;
    }
    private boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){  // both null at same time then we are at the end of tree
            return true;
        }
        if(p == null || q == null){    // any one null means not same tree
            return false;
        }
        if(p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right)){
            return true;
        }
        else{
            return false;
        }
    }
}