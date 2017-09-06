输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
思路：利用递归遍历分别返回左右子树深度
代码实现：
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    public int TreeDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return Math.max(TreeDepth(root.left),TreeDepth(root.right)) + 1;
    }
}


输入一棵二叉树，判断该二叉树是否是平衡二叉树。
思路：平衡因子的绝对值<= 1.
代码实现：
public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null){
            return true;
        }
        int l = getDepth(root.left);
        int r = getDepth(root.right);
        if (Math.abs(l - r) > 1){
            return false;
        }
        return Math.abs(l - r) <= 1 && IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }
    public int getDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        return Math.max(getDepth(root.left),getDepth(root.right)) + 1;
    }
}