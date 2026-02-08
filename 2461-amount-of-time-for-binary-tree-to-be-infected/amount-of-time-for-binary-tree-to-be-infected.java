class Solution {
    TreeNode startnode = null;

    public void parent_tracker(TreeNode root,
                               Map<TreeNode, TreeNode> map,
                               int start) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (curr.val == start)
                startnode = curr;

            if (curr.left != null) {
                map.put(curr.left, curr);
                q.add(curr.left);
            }

            if (curr.right != null) {
                map.put(curr.right, curr);
                q.add(curr.right);
            }
        }
    }

    public int amountOfTime(TreeNode root, int start) {

        Map<TreeNode, TreeNode> parent_track = new HashMap<>();
        parent_tracker(root, parent_track, start);

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.add(startnode);
        visited.add(startnode);

        int currlevel = -1;

        while (!q.isEmpty()) {
            int size = q.size();
            currlevel++;

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                if (curr.left != null && !visited.contains(curr.left)) {
                    q.add(curr.left);
                    visited.add(curr.left);
                }

                if (curr.right != null && !visited.contains(curr.right)) {
                    q.add(curr.right);
                    visited.add(curr.right);
                }

                if (parent_track.get(curr) != null &&
                    !visited.contains(parent_track.get(curr))) {

                    q.add(parent_track.get(curr));
                    visited.add(parent_track.get(curr));
                }
            }
        }
        return currlevel;
    }
}
