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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }
        ListNode curr = head;
        int size = 0;
        while(curr != null){
            curr = curr.next;
            size++;
        }
        
        if(size==n){
            return head.next;
        }
        int idx = size-n;
        ListNode temp = head;
        int i=1;
        
        while(i<idx){
            temp = temp.next;
            i++;
        }
        if(temp != null && temp.next != null)
        temp.next = temp.next.next;
        return head;

    }
}
