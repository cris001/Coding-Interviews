给定一颗二叉搜索树，请找出其中的第k大的结点
思路：二叉搜索树按照中序遍历的顺序打印出来正好就是排序好的顺序，第k个结点就是第K大的节点，分别递归查找左右子树的第K个节点，或使用非递归借用栈的方式查找，当count=k时返回根节点。
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
    int now = 0;
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if (pRoot == null){
            return null;
        }
        TreeNode ret = KthNode(pRoot.left,k);
        if (ret != null){
            return ret;
        }
        now++;
        if (now == k){
            return pRoot;
        }

        ret = KthNode(pRoot.right,k);
        if (ret != null){
            return ret;
        }
        
        
        return null;
    }


}