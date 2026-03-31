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
// class Solution {
//     public TreeNode insertIntoBST(TreeNode root, int val) {
//         if(root == null){
//             return new TreeNode(val);
//         } 
//         attach(root,val);
//         return root;
//     }
//     void attach(TreeNode root,int val){
//         if(root == null) return;
//         if(root.val == val) return;
//         if(root.left == null && root.right == null){
//             TreeNode temp = new TreeNode(val);
//             if(temp.val < root.val) root.left = temp;
//             else root.right = temp; 
//             return;
//         }
//         if(val < root.val){
//             if(root.left == null) root.left = new TreeNode(val);
//             else  attach(root.left,val);
//         }
//         else if(val > root.val){
//             if(root.right == null) root.right = new TreeNode(val);
//             else attach(root.right,val);
//         }
//         else return;
//     }
// }
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }
}
