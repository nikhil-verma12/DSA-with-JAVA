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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int count = 1;
        while(q.size()>0){
            int size = q.size();
            List<Integer> l1 = new ArrayList<>(size);
            for(int i = 0 ; i < size ; i++){
                TreeNode front = q.remove();
                if(front.left != null)
                    q.add(front.left);
                if(front.right != null) 
                    q.add(front.right);
                if(count %2 != 0)
                    l1.add(front.val);
                else
                    l1.add(0, front.val);
            }
            count++;
            list.add(l1);
        }
        return list;
    }
}
