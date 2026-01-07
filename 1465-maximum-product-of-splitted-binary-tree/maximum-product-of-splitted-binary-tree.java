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
    long ans=0,tot=0,sub;
    public int maxProduct(TreeNode root) {
        tot = s(root); s(root);
        return (int)(ans%(int)(1e9 + 7));
    }
    private long s(TreeNode root){
        if(root == null) return 0;
        sub = root.val + s(root.left) + s(root.right);
        ans = Math.max(ans ,sub * (tot-sub));
        return sub;
    }
}