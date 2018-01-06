请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，依此类推。
思路：利用两个栈的辅助空间分别存储奇数偶数层的节点，然后打印输出。或使用链表的辅助空间来实现，利用链表的反向迭实现逆序输出。
代码实现：
import java.util.ArrayList;

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
import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > ans = new ArrayList<ArrayList<Integer> >();
        if (pRoot == null){
            return ans;
        }
        
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        int level = 1;
        s1.push(pRoot);
        while(!s1.empty() || !s2.empty()){
            ArrayList<Integer> list = new ArrayList<Integer>();
            if ((level & 1) == 1){
                while(!s1.empty()){
                    TreeNode t = s1.pop();
                    list.add(t.val);
                    if (t.left!=null){
                        s2.push(t.left);
                    }
                    if (t.right!=null){
                        s2.push(t.right);
                    }
                    
                }
            }else{
                while(!s2.empty()){
                    TreeNode t = s2.pop();
                    
                    list.add(t.val);
                    if (t.right!=null){
                        s1.push(t.right);
                    }
                    if (t.left!=null){
                        s1.push(t.left);
                    }
                }
            }
            if (!list.isEmpty()){
                ans.add(list);
                //list.clear();
                level++;
            }
            
        }
        
        return ans;
    }

}