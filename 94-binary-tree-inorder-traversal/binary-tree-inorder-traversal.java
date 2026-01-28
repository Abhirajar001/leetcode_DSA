class Solution {
    ArrayList<Integer> ans = new ArrayList<>();
    public void inorder(TreeNode head){
        if(head == null){
            return;
        }
        inorder(head.left);
        ans.add(head.val);
        inorder(head.right);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return ans;
    }
}