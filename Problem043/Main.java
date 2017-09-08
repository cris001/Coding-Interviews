对于一个给定的字符序列S，请你把其循环左移K位后的序列输出
思路：拼接或反转三次字符串
代码实现：
public String LeftRotateString(String str,int n) {
    if (str == null || str.length() == 0)
        return str;
    String s1 = reverse(str.substring(0,n));
    String s2 = reverse(str.substring(n,str.length()));
    return reverse(s2)+reverse(s1);
}