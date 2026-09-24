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
    public ListNode modifiedList(int[] nums, ListNode head) {
    
    HashSet<Integer> set = new HashSet<>();

    for(int i=0; i<nums.length; i++)
    {
        set.add(nums[i]);
    }

    ListNode ptr=head;
    ListNode prev=null;

    while(ptr!=null)
    {
        if(set.contains(ptr.val))
        {
            if(prev==null)
            {
                head=ptr.next;
            }
            else
            {
                prev.next=ptr.next;
            }
        }
        else
        {
            prev=ptr;
        }
        ptr=ptr.next;
    }
    return head;
    }
}
/*
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
      
        ListNode ptr = head;
        ListNode prev = null;

        while(ptr != null)
        {
            boolean found = false;

            for(int i=0; i<nums.length; i++)
            {
                if(nums[i] == ptr.val)
                {
                    found = true;
                    break;
                }
            }

            if(found)
            {
                if(prev == null)
                {
                    head = ptr.next;
                }
                else
                {
                    prev.next = ptr.next;
                }
            }
            else
            {
                prev = ptr;
            }

            ptr = ptr.next;
        }

        return head; 
    }
}*/