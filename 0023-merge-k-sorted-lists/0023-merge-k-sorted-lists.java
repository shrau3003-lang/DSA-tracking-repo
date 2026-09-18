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
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );

        // Add first node of every list
        for(int i = 0; i < lists.length; i++)
        {
            if(lists[i] != null)
            {
                pq.add(lists[i]);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode ptr = dummy;

        while(!pq.isEmpty())
        {
            ListNode temp = pq.poll();

            ptr.next = temp;
            ptr = ptr.next;

            if(temp.next != null)
            {
                pq.add(temp.next);
            }
        }

        return dummy.next;
    }
}

/*
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length == 0)
        {
            return null;
        }

        ListNode head = lists[0];

        for(int i = 1; i < lists.length; i++)
        {
            head = mergeTwoLists(head, lists[i]);
        }

        return head;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode ptr = dummy;

        while(l1 != null && l2 != null)
        {
            if(l1.val <= l2.val)
            {
                ptr.next = l1;
                l1 = l1.next;
            }
            else
            {
                ptr.next = l2;
                l2 = l2.next;
            }

            ptr = ptr.next;
        }

        if(l1 != null)
        {
            ptr.next = l1;
        }
        else
        {
            ptr.next = l2;
        }

        return dummy.next;
    }
}
*/

/*class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        int count = 0;
        // Count total nodes
        for(int i = 0; i < lists.length; i++)
        {
            ListNode temp = lists[i];

            while(temp != null)
            {
                count++;
                temp = temp.next;
            }
        }
         if(count == 0)
        {
            return null;
        }

    int arr[] = new int[count];
    int index=0;
    for(int i=0; i<lists.length; i++)
    {
        ListNode temp = lists[i];
        while(temp!=null)
        {
            arr[index++]=temp.val;
            temp=temp.next;
        }
    }
    Arrays.sort(arr);
    ListNode head = new ListNode(arr[0]);
    ListNode ptr = head;

    for(int i=1; i<arr.length; i++)
    {
        ptr.next=new ListNode(arr[i]);
        ptr = ptr.next;
    }
    return head;
    }
}*/