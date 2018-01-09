请实现两个函数，分别用来序列化和反序列化二叉树
思路：序列化：前序遍历二叉树存入字符串中；反序列化：根据前序遍历重建二叉树。
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
import java.util.*;
public class Solution {
    int now = -1;
    String Serialize(TreeNode root) {
        StringBuffer s = new StringBuffer();
        if (root == null){
            s.append("#,");
            return s.toString();
        }
        s.append(root.val + ",");
        s.append(Serialize(root.left));
        s.append(Serialize(root.right));
        return s.toString();
  }
    
    TreeNode Deserialize(String str) {
        now++;
        String[] s = str.split(",");
        int len = str.length();
        if (now >= len){
            return null;
        }
        TreeNode root = null;
        if (!"#".equals(s[now])){
            //root.val = s[now];
            root = new TreeNode(Integer.valueOf(s[now]));
            root.left = Deserialize(str);
            root.right = Deserialize(str);
        }
        
       return root;
  }
}