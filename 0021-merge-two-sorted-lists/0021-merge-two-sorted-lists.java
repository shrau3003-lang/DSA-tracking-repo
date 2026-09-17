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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
       ListNode ptr1 = list1;
       ListNode ptr2 = list2;
       ListNode head = null;
       ListNode ptr = null;
       if(list1==null && list2==null)
       {
         return list1;
       }
       else
       if(list1==null)
       {
        return list2;
       }
       else
       if(list2==null)
       {
        return list1;
       }

       if(ptr1.val<=ptr2.val)
       {
        head=ptr1;
        ptr=ptr1;
        ptr1=ptr1.next;
       }
       else
       {
        head=ptr2;
        ptr=ptr2;
        ptr2=ptr2.next;
       }
       while(ptr1!=null && ptr2!=null)
       {
        if(ptr1.val<ptr2.val)
        {
            ptr.next=ptr1;
            ptr=ptr.next;
            ptr1 = ptr1.next;
        }
        else
        {
            ptr.next=ptr2;
            ptr=ptr.next;
            ptr2 = ptr2.next;
        }
       }
       if(ptr1!=null)
       {
          ptr.next=ptr1;
       }
       if(ptr2!=null)
       {
        ptr.next=ptr2;
       }
       return head;
    }
}