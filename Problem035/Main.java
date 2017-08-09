在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
思路：利用LinkedHashMap保存字符和出现次数。
代码实现：
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0){
            return -1;
        }
        int len = str.length();
        int[] f = new int[256];
        char[] c = str.toCharArray();
        for(char ch : c){
            f[ch]++;
        }
        int k = 0;
        for(int i=0;i<c.length;i++){
            if (f[c[i]] == 1){
                k = i;
                break;
            }
        }
        
        return k;
    }
}