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
    public int diameterOfBinaryTree(TreeNode root) {  // O(n^2) - traversing twice for height and diameter
        if(root == null){
            return 0;
        }
        int leftSide = height(root.left);   // left height
        int rightSide = height(root.right);  // right height

        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);

        int diameter = leftSide + rightSide;   // to get diameter from particular node

        return Math.max(diameter , Math.max(leftDiameter,rightDiameter));  // max from left and right
    }
    private int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight,rightHeight)+1;
    }
}