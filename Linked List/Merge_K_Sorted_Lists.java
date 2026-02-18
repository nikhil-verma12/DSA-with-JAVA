/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode merge(ListNode head1 , ListNode head2){
        ListNode a = head1;
        ListNode b = head2;
        ListNode dummy = new ListNode(-1);
        ListNode k = dummy;

        while(a!=null && b!=null){
            if(a.val<=b.val){
                k.next = a;
                a = a.next;
                
            }
            else{
                k.next = b;
                b = b.next;
            }
            k = k.next;
        }
        if(a == null){
            k.next = b;
        }
        else{
            k.next = a;
        }

        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length<1) return null;
        ArrayList<ListNode> arr = new ArrayList<>();
        for(ListNode n : lists){
            arr.add(n);
        }
        while(arr.size()>1){
            ListNode a = arr.get(arr.size()-1);
            arr.remove(arr.size()-1);
            ListNode b = arr.get(arr.size()-1);
            arr.remove(arr.size()-1);
            ListNode c = merge(a,b);
            arr.add(0,c);
        }
        return arr.get(0);
    }
}
