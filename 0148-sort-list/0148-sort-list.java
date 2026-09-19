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
    public ListNode sortList(ListNode head) {

        if(head == null || head.next == null)
            return head;

        // Find middle
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Split into two lists
        ListNode second = slow.next;
        slow.next = null;

        // Sort both halves
        ListNode left = sortList(head);
        ListNode right = sortList(second);

        // Merge sorted lists
        return merge(left, right);
    }

    public ListNode merge(ListNode l1, ListNode l2)
    {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while(l1 != null && l2 != null)
        {
            if(l1.val <= l2.val)
            {
                temp.next = l1;
                l1 = l1.next;
            }
            else
            {
                temp.next = l2;
                l2 = l2.next;
            }

            temp = temp.next;
        }

        if(l1 != null)
            temp.next = l1;

        if(l2 != null)
            temp.next = l2;

        return dummy.next;
    }
}

/*class Solution {
    public ListNode sortList(ListNode head) {
   int count=0;
   ListNode temp=head;
   while(temp!=null)
   {
    count++;
    temp=temp.next;
   }
   
   temp=head;
   int[] arr = new int[count];
   int index=0;
   while(temp!=null)
   {
    arr[index++]=temp.val;
    temp=temp.next;
   }
   Arrays.sort(arr);

   temp=head;
   for(int i=0; i<count; i++)
   {
    temp.val = arr[i];
    temp = temp.next;
   }

   return head;
    }
}*/

/*
class Solution {
    public ListNode sortList(ListNode head) {
   
   if(head == null || head.next == null)
    {
        return head;
    }

    ListNode prev = head;

    while(prev!=null)
   {
    ListNode ptr = prev.next;
    while(ptr!=null)
    {
        if(prev.val>ptr.val)
        {
            int temp = prev.val;
            prev.val=ptr.val;
            ptr.val=temp;
        }
    ptr=ptr.next;
    }
    prev = prev.next;
    }
    return head;
    }
}*/