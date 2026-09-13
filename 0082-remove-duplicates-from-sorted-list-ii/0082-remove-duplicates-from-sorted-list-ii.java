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
    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode ptr = head;

        while(ptr != null)
        {
            if(ptr.next != null && ptr.val == ptr.next.val)
            {
                int value = ptr.val;

                while(ptr != null && ptr.val == value)
                {
                    ptr = ptr.next;
                }

                prev.next = ptr;
            }
            else
            {
                prev = ptr;
                ptr = ptr.next;
            }
        }

        return dummy.next;
    }
}