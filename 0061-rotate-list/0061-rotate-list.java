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

    if(head==null || head.next==null)
    {
        return head;
    }

     ListNode ptr = head;
     int count = 1;

     while(ptr.next!=null)
     {
        count++;
        ptr=ptr.next;
     }
    
    k = k % count;

    if(k==0)
    {
        return head;
    }
    ptr.next = head;
    ptr = head;

    for(int i=1; i<count-k; i++)
    {
        ptr = ptr.next;
    }
    ListNode newHead = ptr.next;
    ptr.next=null;

    return newHead;
    }
}