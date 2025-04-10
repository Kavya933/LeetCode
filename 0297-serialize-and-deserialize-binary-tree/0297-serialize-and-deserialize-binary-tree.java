public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> track = new LinkedList<>();

        track.add(root);

        while (!track.isEmpty()) {
            TreeNode curr = track.poll();
            if (curr == null) {
                res.append("# ");
                continue;
            }
            res.append(curr.val + " ");
            track.add(curr.left);
            track.add(curr.right);
        }
        //System.out.println(res.toString());
        return res.toString().trim(); // Remove trailing space for cleanliness
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }

        String[] nodes = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> track = new LinkedList<>();
        track.add(root);

        int i = 1;
        while (!track.isEmpty() && i < nodes.length) {
            TreeNode curr = track.poll();

            // Process left child
            if (!nodes[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(nodes[i]));
                curr.left = left;
                track.add(left);
            }
            i++;

            // Process right child
            if (i < nodes.length && !nodes[i].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(nodes[i]));
                curr.right = right;
                track.add(right);
            }
            i++;
        }
        return root;
    }
}