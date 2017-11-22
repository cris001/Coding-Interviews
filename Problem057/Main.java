请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
思路：利用递归进行判断，若左子树的左孩子等于右子树的右孩子且左子树的右孩子等于右子树的左孩子，并且左右子树节点的值相等，则是对称的。
代码实现：
/*
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
    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot == null){
            return true;
        }
        return isSimilar(pRoot.left,pRoot.right);
        
    }
    
    boolean isSimilar(TreeNode p1,TreeNode p2){
        if (p1 == null && p2 == null){
            return true;
        }
        if (p1 == null && p2 != null){
            return false;
        }
        if (p1 != null && p2 == null){
            return false;
        }
        return (p1.val == p2.val) && isSimilar(p1.left,p2.right) && isSimilar(p1.right,p2.left);

    }
}