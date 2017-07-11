输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
思路：先保存根节点，然后分别递归在左右子树中找目标值，若找到即到达叶子节点，打印路径中的值
代码实现：
import java.util.ArrayList;
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
import java.util.*;
public class Solution {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if (root == null){
            return ans;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(root.val);
        dfs(list,root,target-root.val);
        return ans;
    }
    public void dfs(ArrayList<Integer> list, TreeNode root,int target){
        if (root == null){
            return;
        }
        if (target < 0){
            return;
        }
        if (target == 0 && root.left == null && root.right == null){
            ans.add(new ArrayList<>(list));
            return;
        }
        if (root.left != null){
            list.add(root.left.val);
            dfs(list,root.left,target - root.left.val);
            list.remove(list.size() - 1);
        }
        if (root.right != null){
            list.add(root.right.val);
            dfs(list,root.right,target - root.right.val);
            list.remove(list.size() - 1);
        }
        
    }
}