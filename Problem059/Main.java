从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
思路：利用辅助空间链表或队列来存储节点，每层输出。
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
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> >  ans = new ArrayList<ArrayList<Integer> >();
        if (pRoot == null){
            return ans;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        int level = 1;
        s1.push(pRoot);
        while(!s1.empty() || !s2.empty()){
            if ((level & 1) == 1){
                while(!s1.empty()){
                    TreeNode t = s1.pop();
                    if (t != null){
                        list.add(t.val);
                        s2.push(t.left);
                        s2.push(t.right);
                    }
                }
            }else{
                while(!s2.empty()){
                    TreeNode t = s2.pop();
                    if (t != null){
                        list.add(t.val);
                        s1.push(t.right);
                        s1.push(t.left);
                    }
                }
            }
            if (!list.isEmpty()){
                if ((level & 1) == 0){
                    Collections.reverse(list);
                }
                ans.add(new ArrayList<>(list) );
                list.clear();
                level++;
            }
        }
        return ans;
    }
    
}