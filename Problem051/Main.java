请实现一个函数用来匹配包括’.’和’‘的正则表达式。模式中的字符’.’表示任意一个字符，而’‘表示它前面的字符可以出现任意次（包含0次）
思路：当字符串只有一个字符时，进行判断，否则就有两种递归情况，（1）当模式中的第二个字符不是“”时：如果字符串第一个字符和模式中的第一个字符相匹配或是点那么字符串和模式都后移一个字符，然后匹配剩余的；如果 字符串第一个字符和模式中的第一个字符相不匹配，直接返回false。（2）当模式中的第二个字符是“”时：如果字符串第一个字符跟模式第一个字符不匹配，则模式后移2个字符，继续匹配；如果字符串第一个字符跟模式第一个字符匹配或是点，可以有3种匹配方式：1 >模式后移2字符，相当于x*被忽略；2>字符串后移1字符，模式后移2字符；3>字符串后移1字符，模式不变，即继续匹配字符下一位，因为 * 可以匹配多位；
代码实现：
public class Solution {
    public boolean match(char[] str, char[] pattern)
    {
        if (str == null || pattern == null){
            return false;
        }
        if (pattern.length == 0 && str.length == 0 ){
            return true;
        }
        int ls = str.length;
        int lp = pattern.length;
        if (ls == 1 && lp == 1){
            if (str[0] == pattern[0] || pattern[0] == '.'){
                return true;
            }else{
                return false;
            }
            
        }
        return matchStr(0,0,str,pattern);
    }
    
    public boolean matchStr(int i, int j,char[] str, char[] pattern){
        if (i == str.length && j == pattern.length){
            return true;
        }
        if (i < str.length && j == pattern.length){
            return false;
        }
        if (j+1 < pattern.length && pattern[j+1] == '*'){
            if (i < str.length && pattern[j] == '.' || i < str.length && pattern[j] == str[i]){
                return matchStr(i,j+2,str,pattern) 
                     || matchStr(i+1,j+2,str,pattern)
                    || matchStr(i+1,j,str,pattern);
            }else{
                return matchStr(i,j+2,str,pattern);
            }
            
        }
        if (i < str.length && str[i] == pattern[j] || i < str.length && pattern[j] == '.'){
            return matchStr(i+1,j+1,str,pattern);
        }
        return false;
    }
}