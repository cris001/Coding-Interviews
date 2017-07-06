输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
思路：若根节点相等，利用递归比较他们的子树是否相等，若根节点不相等，则利用递归分别在左右子树中查找。
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
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null){
            return false;
        }
        if (isSameTree(root1,root2)){
            return true;
        }else{
            return isSameTree(root1.left,root2) || isSameTree(root1.right,root2);
        }
    }
    public boolean isSameTree(TreeNode root1,TreeNode root2) {
        if (root1 == null && root2 == null){
            return true;
        }
        if (root1 == null && root2 != null){
            return false;
        }
        if (root1 != null && root2 == null){
            return true;
        }
        if (root1.val != root2.val){
            return false;
        }else{
            return isSameTree(root1.left,root2.left) && isSameTree(root1.right,root2.right);
        }
    }
    
    
}