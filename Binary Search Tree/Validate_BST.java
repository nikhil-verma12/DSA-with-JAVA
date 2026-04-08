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
// --------------------------------------------------------------------------------------------------------------------------------------------
// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         if(root == null) return true;
//         return isValid(root,Long.MIN_VALUE,Long.MAX_VALUE);
        
//     }
//     public boolean isValid(TreeNode root,long min,long max){
//         if(root == null) return true;
//         else if(root.val <= min || root.val >= max){
//             return false;
//         }
//         return isValid(root.left,min,root.val) && isValid(root.right,root.val,max);

//     }
// }
// -------------------------------------------------------------------------------------------------------------------------------------------

// Morris Traversal---------------------------------------------------------------------------------------------------------------------------
class Solution {
    public boolean isValidBST(TreeNode root) {
        TreeNode curr = root;
        long prev = Long.MIN_VALUE;
        while(curr != null ){
            if(curr.left != null){
                TreeNode pred = curr.left;
                while(pred.right != null && pred.right != curr){
                    pred = pred.right;
                }
                if(pred.right == null){
                    pred.right = curr;
                    curr = curr.left;
                }
                else{
                    pred.right = null;
                    if(curr.val <= prev) return false;
                    prev = curr.val;
                    curr = curr.right;
                }
            }
            else{
                if(curr.val <= prev) return false;
                prev = curr.val;
                curr = curr.right;   
            }
        }
        return true;
    }
}
