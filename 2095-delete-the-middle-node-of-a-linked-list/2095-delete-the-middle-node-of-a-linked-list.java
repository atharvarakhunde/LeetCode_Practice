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
    public ListNode deleteMiddle(ListNode head) {
        if(head.next== null){
            return head = null ;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!= null){
            slow = slow.next ;
            fast = fast.next.next;
        }
        ListNode new1 = head;
        while(new1.next != slow && new1 != null){
            new1 = new1.next;
        }
        new1.next = slow.next;
        slow = null;
        return head;
    }
}