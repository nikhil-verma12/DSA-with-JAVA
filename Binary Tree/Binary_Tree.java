import java.util.Queue;
import java.util.Stack;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val = val;
    }
}
class Pair{
    Node node;
    int level;
    Pair(Node node,int level){
        this.node = node;
        this.level = level;
    }
}
public class binaryTree {
    //              3
    //           /    \
    //         5       1
    //      /    \   /   \
    //    6      4  7      9
    // Prefix order
    public static void prefix(Node root){
        // -----------RECURRSION-----------------------------------------------------------------------------

        // if(root == null) return;
        // System.out.print(root.val+" ");
        // prefix(root.left);
        // prefix(root.right);

        // --------------------------------------------------------------------------------------------------

        // ----------ITERATION-------------------------------------------------------------------------------

        Stack<Node> st = new Stack<>();
        st.add(root);
        while(!st.isEmpty()){
            Node ele = st.pop();
            if(ele.left != null) st.push(ele.left);
            if(ele.right != null) st.push(ele.right);
            
            System.out.print(ele.val+" ");
        }
        // --------------------------------------------------------------------------------------------------
    }
    // postfix order
    public static void postfix(Node root){
        // -------RECURRSION---------------------------------------------------------------------------------

        // if(root == null) return;
        // postfix(root.left);
        // postfix(root.right);
        // System.out.print(root.val+" ");

        // --------------------------------------------------------------------------------------------------

        // -----------ITERATION------------------------------------------------------------------------------

        Stack<Node> st = new Stack<>();
        Stack<Node> newSt = new Stack<>();
        st.add(root);
        while(!st.isEmpty()){
            Node ele = st.pop();
            if(ele.left != null) st.push(ele.left);
            if(ele.right != null) st.push(ele.right);
            newSt.add(ele);
        }
        while(!newSt.isEmpty()){
            System.out.print(newSt.pop().val+" ");
        }

        // ---------------------------------------------------------------------------------------------------
    }
    // infix order
    public static void infix(Node root){
        // ----------RECURRSION-------------------------------------------------------------------------------

        // if(root == null) return;
        // infix(root.left);
        // System.out.print(root.val+" ");
        // infix(root.right);

        // --------------ITERATION---------------------------------------------------------------------------

        Stack<Node> st = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        Node curr = root;
        while(curr != null || !st.isEmpty()){
            if(curr != null) {
                if(curr.left != null){
                    st.push(curr);
                    curr = curr.left;
                }
                else{
                    ans.add(curr.val);
                    curr = curr.right;
                }
            }
            else{
                Node top = st.pop();
                ans.add(top.val);
                curr = top.right;
            }
        }
        for(Integer ele : ans){
            System.out.print(ele+" ");
        }
        // ----------------------------------------------------------------------------------------------
    }
    // size of the tree
    public static int size(Node root){
        if(root == null){
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    } 
    // sum of all the roots
    public static int sum(Node root){
        if(root == null){
            return 0;
        }
        return root.val + sum(root.left) + sum(root.right);
    }
    // max value in the tree
    public static int maxVal(Node root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        return Math.max(root.val , Math.max(maxVal(root.left),maxVal(root.right)));
    }
    // min value in the tree
    public static int minVal(Node root){
        if(root == null){
            return Integer.MAX_VALUE;
        }
        return Math.min(root.val , Math.min(minVal(root.left),minVal(root.right)));
    }
    // level of the tree
    public static int level(Node root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(level(root.left),level(root.right));
    }
    // Level Order Traversal
    public static void levelOrder(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            Node front = q.remove();
            System.out.print(front.val+" ");
            if(front.left != null) q.add(front.left);
            if(front.right != null) q.add(front.right);

        }
    }
    // Level wise printing of nodes
    public static void levelOrderLinewise(Node root){
        Queue<Pair> q = new LinkedList<>();
        int currLevel = 0;
        q.add(new Pair(root,0));
        while(q.size()>0){
            Pair front = q.remove();
            Node node = front.node;
            int level = front.level;
            if(currLevel != level){
                currLevel++;
                System.out.println();
            }
            System.out.print(node.val+" ");
            if(node.left != null) q.add(new Pair(node.left,level+1));
            if(node.right != null) q.add(new Pair(node.right,level+1));

        }
    }
    //Kth Level Printing of nodes
    public static void kthLevel(Node root, int level, int k){
        if(root == null) return;
        if(level == k){
            System.out.print(root.val+" ");
        }
        kthLevel(root.left, level+1, k);
        kthLevel(root.right, level+1, k);

    }
    public static void main(String args[]){
        Node a = new Node(3);
        Node b = new Node(5);
        Node c = new Node(1);
        Node d = new Node(6);
        Node e = new Node(4);
        Node f = new Node(7);
        Node g = new Node(9);
        a.left = b;  a.right = c;
        b.left = d;  b.right = e;
        c.left = f;  c.right = g;

        // levelOrder(a);
        // System.out.print("Prefix "+"-> ");
        // prefix(a);
        // System.out.println();
        // System.out.print("PostFix"+"-> ");
        // postfix(a); 
        // System.out.println();
        // System.out.print("Infix"+"-> ");
        infix(a);
        // System.out.println();
        // System.out.println("Size -> "+size(a));
        // System.out.println("Sum -> "+sum(a));
        // System.out.println("Max Value -> "+maxVal(a));
        // System.out.println("Min Value -> "+minVal(a));
        // System.out.println("Level of the tree -> "+level(a));
        // levelOrderLinewise(a);
        // kthLevel(a, 0, 1);
    }
}

