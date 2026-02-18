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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k==0){
            return head; 
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = head;
        int size = 0;
        while(temp!=null){
            temp = temp.next;
            size++;
        }
        k = k%size;
        ListNode newHead = null;
        ListNode curr = null;
        if(k!=0){
            int x = 0;
        while(x<k+1){
            fast = fast.next;
            x++;
        }
        while(fast!=null){
            slow  = slow.next;
            fast = fast.next;
        }
        newHead = slow.next;
        slow.next = null;
        curr = newHead;
        while(curr.next!=null){
            curr = curr.next;
        }
        curr.next = head;
        return newHead;
        }
        
        return head;
    }
}
