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


//Time Complexity = O(n)
class Solution {
    public ListNode removeNodes(ListNode head) {

    Stack<ListNode> stack = new Stack<>();

    ListNode ptr = head;

    while(ptr!=null)
    {
        while(!stack.isEmpty() && stack.peek().val < ptr.val)
        {
            stack.pop();
        }
        stack.push(ptr);
        ptr=ptr.next;
    }

    ListNode ans = null;
    while(!stack.isEmpty())
    {
        ListNode temp =stack.pop();
        temp.next=ans;
        ans=temp;
    }
    return ans;
    }
}


//Time Complexity = O(n2)
/*class Solution {
    public ListNode removeNodes(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next=head;

        ListNode prev = dummy;
        ListNode ptr= head;

        while(ptr!=null)
        {
            ListNode temp = ptr.next;
            boolean remove  = false;
            while(temp!=null)

        {
            if(ptr.val<temp.val)
            {
                 remove = true;
                 break;
            }
          
            temp = temp.next;
        }
           if(remove)
            {
                prev.next = ptr.next;
            }
            else
            {
                prev = ptr;
            }

        ptr = ptr.next;
        }

        return dummy.next;
    }
}*/