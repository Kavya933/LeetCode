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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1 == null && l2 == null){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode d = dummy;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        while(temp1!=null && temp2!=null){
            if(temp1.val<temp2.val){
                d.next = temp1;
                temp1 = temp1.next;
            }
            else{
                d.next = temp2;
                temp2 = temp2.next;
            }
            d = d.next;
        }
        while(temp1!=null){
            d.next = temp1;
            temp1 = temp1.next;
            d = d.next;
        }
        while(temp2!=null){
            d.next = temp2;
            temp2 = temp2.next;
            d = d.next;
        }
        return dummy.next;
    }
}