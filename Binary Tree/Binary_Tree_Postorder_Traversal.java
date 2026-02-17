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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        posOrder(root , l);
        return l;
    }
    private void posOrder(TreeNode root , List<Integer> l){
        if(root == null){
            return;
        }
        posOrder(root.left,l);
        posOrder(root.right,l);
        l.add(root.val);
    }
}
};
