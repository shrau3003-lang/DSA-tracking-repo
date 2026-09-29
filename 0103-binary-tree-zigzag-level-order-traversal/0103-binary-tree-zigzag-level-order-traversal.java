/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
     List<List<Integer>> result = new ArrayList<>();

     if(root==null)
     {
        return result;
     }   
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    boolean leftToRight = true;

    while(!queue.isEmpty())
    {
        ArrayList<Integer> list = new ArrayList<>();
        int size = queue.size();

        for(int i=0; i<size; i++)
     {
        TreeNode ptr = queue.poll();
        list.add(ptr.val);

        if(ptr.left!=null)
        {
            queue.add(ptr.left);
        }
        if(ptr.right!=null)
        {
            queue.add(ptr.right);
        }
     }
     if(!leftToRight)
     {
        Collections.reverse(list);
     }
     result.add(list);
     leftToRight = !leftToRight;
    }
    return result;
    }
}