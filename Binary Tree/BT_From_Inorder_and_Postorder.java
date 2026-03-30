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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = postorder.length;
        return build(inorder,postorder,0,len-1,0,len-1);
    }
    public TreeNode build(int[] inorder,int[] postorder,int inLo,int inHi,int postLo,int postHi){
        if(inLo > inHi || postLo > postHi) return null;
        int r = -1;
        int val = postorder[postHi];
        TreeNode root = new TreeNode(val);
        for(int i = inLo ; i <= inHi ; i++){
            if(inorder[i] == val)
            r = i;
        }
        int count = r - inLo;

        root.left = build(inorder,postorder,inLo,r-1,postLo,postLo+count-1);
        root.right = build(inorder,postorder,r+1,inHi,postLo+count,postHi-1);
        return root;
    }
}
