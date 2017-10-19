请实现一个函数用来找出字符流中第一个只出现一次的字符。
思路：借助辅助空间进行判断，如字符数组。
代码实现：
import java.util.*;
public class Solution {
    //Insert one char from stringstream
    int a[] = new int [256];
    StringBuilder s = new StringBuilder();
    public void Insert(char ch)
    {
        s.append(ch);
        a[ch]++;
        
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        //char ch = '#';
        char[] c = s.toString().toCharArray();
        for(char ch:c){
            if (a[ch] == 1){
                return ch;
            }
        }
        return '#';
    }
}