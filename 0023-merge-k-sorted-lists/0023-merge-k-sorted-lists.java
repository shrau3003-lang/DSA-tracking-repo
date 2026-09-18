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
}