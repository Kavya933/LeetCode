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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ansList = new ArrayList<>();
        Queue<TreeNode> track = new LinkedList<>();
        if (root == null) { // Handle edge case where the tree is empty
            return ansList;
        }
        track.add(root);
        while(!track.isEmpty()){
            int size = track.size();
            List<Integer> subList = new ArrayList<>();
            
            for(int i = 0; i < size; i++){
                TreeNode currentNode = track.poll();
                subList.add(currentNode.val);

                if (currentNode.left != null) {
                    track.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    track.add(currentNode.right);
                }
            }
            ansList.add(subList);
        }
        return ansList;
    }
}