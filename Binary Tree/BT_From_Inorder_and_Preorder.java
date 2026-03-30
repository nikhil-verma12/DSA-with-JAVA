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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        return build(preorder,inorder,0,len-1,0,len-1);
    }
    public TreeNode build(int[] preorder, int[] inorder,int preLo,int preHi,int inLo,int inHi){
        if(inLo > inHi || preLo > preHi) return null;
        int val = preorder[preLo];
        TreeNode root = new TreeNode(val);
        int r = 0;
        for(int i = inLo ; i <= inHi ; i++){
            if(inorder[i] == val){
                r = i;
                break;
            }
        }
        int count = r - inLo;
        
        root.left = build(preorder,inorder,preLo+1,preLo+count,inLo,r-1);
        root.right = build(preorder,inorder,preLo+count+1,preHi,r+1,inHi);
        return root; 
    }
}
