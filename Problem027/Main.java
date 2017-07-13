输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
思路：定义一个链表的尾节点，递归处理左右子树，最后返回链表的头节点
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
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null){
            return null;
        }
        TreeNode p = treeLink(pRootOfTree);
        
        while(p.left != null){
            p = p.left;
        }
        return p;
    }
    
    public TreeNode treeLink(TreeNode root){
        if (root == null || (root.left == null && root.right == null)){
            return root;
        }
        TreeNode t = null;
        if (root.left != null){
            t = treeLink(root.left);
            while(t.right != null){
                t = t.right;
            }
            t.right = root;
            root.left = t;
        }
        if (root.right != null){
            t = treeLink(root.right);
            while(t.left != null){
                t = t.left;
            }
            t.left = root;
            root.right = t;
        }
        
        return t;
    }
}