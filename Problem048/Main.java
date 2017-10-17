将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
思路：若为负数，则输出负数，字符0对应48,9对应57，不在范围内则返回false。
代码实现：
public class Solution {
    public int StrToInt(String str) {
        if (str==null || str.length() <= 0){
            return 0;
        }
        int sign = 1;
        char[] ch= str.toCharArray();
        int index = 0;
        if (ch[0] == '-'){
            sign = 0;
            index++;
        }else if (ch[0] == '+'){
            index++;
        }
        int ans = 0;
        for (int i = index;i<ch.length;i++){
            if (!(ch[i]>='0' && ch[i] <= '9')){
                return 0;
            }
            ans=ans*10+(ch[i]-'0');
        }
        if (sign == 1){
            return ans;
        }else{
            return -ans;
        }
    }
}