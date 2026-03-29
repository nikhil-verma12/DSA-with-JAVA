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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        path(root,list,"");
        return list;
    }
    private void path(TreeNode root,List<String> list,String s){
        if(root == null) return;
        if (s.length() == 0)  s += root.val;
        else s = s + "->" + root.val;
        if (root.left == null && root.right == null) {
            list.add(s);
            return;
        }
        path(root.left,list,s);
        path(root.right,list,s);
    }
}
