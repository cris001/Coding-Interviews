翻转字符串
思路：先将整个字符串翻转，然后将每个单词翻转。
代码实现：
import java.util.*;
public class Solution {
    public String LeftRotateString(String str,int n) {
        if (str==null ||str.length() == 0){
            return str;
        }
        int len = str.length();
        String s1 = reverse(str,0,n-1);
        String s2 = reverse(str,n,len-1);
        String ret = reverse(s1+s2,0,len-1);

        return ret;
    }
    
    public String reverse(String str,int l,int r) {
        StringBuilder s = new StringBuilder();
        for (int i =r;i>=l;i--){
            s.append(str.charAt(i));
        }
        return String.valueOf(s);
    }
}