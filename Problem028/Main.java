输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
思路：将当前位置的字符和前一个字符位置交换，递归。
代码实现：
import java.util.*;
public class Solution {
    ArrayList<String> ans = new ArrayList<String>();
    TreeSet<String> st = new TreeSet<String>();
    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0){
            return ans;
        }
        char[] c = str.toCharArray();
        dfs(0,c);
        ans.addAll(st);
        return ans;
    }
    public void dfs(int t, char[] c){
        if (t>=c.length){
            return;
        }
        st.add(String.valueOf(c));
        for(int i = t + 1;i < c.length;i++){
            swap(t,i,c);
            dfs(t+1,c);
            swap(t,i,c);
        }
        dfs(t+1,c);
    }
    
    public void swap(int i,int t, char[] c){
        char p = c[i];
        c[i] = c[t];
        c[t] =p;
    }
}