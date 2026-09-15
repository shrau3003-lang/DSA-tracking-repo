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
    public int[] nextLargerNodes(ListNode head) {

    ArrayList<Integer> list = new ArrayList<>();
       
    ListNode temp = head;
    while (temp!=null)
    {
        ListNode ptr = temp.next;
        boolean found=false;
        
        while(ptr!=null)
        {
            if(ptr.val>temp.val)
            {
                list.add(ptr.val);
                found = true;
                break;
            }
            ptr = ptr.next;
        }

        if(!found)
        {
            list.add(0);
        }
        temp = temp.next;
    }

    int arr[] = new int[list.size()];
    for(int i=0; i<list.size(); i++)
    {
        arr[i]=list.get(i);
    }
    return arr;   
    }
}