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
    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode l = root.left;
        TreeNode r = root.right;
        TreeNode curr = root;
        flatten(root.left);
        flatten(root.right);
        root.left = null;
        root.right = l;
       while(curr.right != null){
            curr = curr.right;
        }
        curr.right = r;

    }
}
