class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode ptr = root;

        while(ptr != null || !stack.isEmpty())
        {
            while(ptr != null)
            {
                stack.push(ptr);
                ptr = ptr.left;
            }

            ptr = stack.pop();
            k--;

            if(k == 0)
            {
                return ptr.val;
            }

            ptr = ptr.right;
        }

        return -1;
    }
}