请实现一个函数用来判断字符串是否表示数值（包括整数和小数）
思路：逐个字符进行判断，e或E和小数点最多出现一次，而e或E的前一个必须是数字，且不能是第一个或最后一个字符，符号的前一个字符不能是e或E。也可用正则表达式判断！
代码实现：
public class Solution {
    public boolean isNumeric(char[] str) {
        int k = 0;
        int e = 0;
        int p = 0;
        if (str[0] == '+' || str[0] == '-'){
            k++;
        }
        for(int i = k;i<str.length;i++){
            if (str[i] == 'e' || str[i] == 'E'){
                e++;
                if (e > 1){
                    return false;
                }
                if (!( (i>=1 && i<str.length - 1) && str[i-1] >= '0' && str[i-1] <= '9' )){
                    return false;
                }
                p++;
                continue;
            }
            
            if (str[i] == '.'){
                p++;
                if (p > 1){
                    return false;
                }
                continue;
            }
            if (str[i] == '+' || str[i] == '-'){
                if (!(i>=1 && (str[i-1] == 'e' || str[i-1] == 'E'))){
                    return false;
                }
                continue;
            }
            if (!(str[i] >= '0' && str[i] <= '9' )){
                return false;
            }
            
        }
        return true;
    }
}