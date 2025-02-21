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
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // if p is found return p and same for q if not return null
        // if left is null and right is not then return right and vice versa
        // if both are not null then root is the lca
        if(left == null){   
            return right;
        }
        else if(right == null){
            return left;
        }
        else{
            return root;
        }
    }
}