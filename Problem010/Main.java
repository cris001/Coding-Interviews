输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
思路：a&(a-1)的结果会将a最右边的1变为0，直到a = 0，还可以先将a&1 != 0，然后右移1位，但不能计算负数的值，

代码实现：
public class Solution {
    public int NumberOf1(int n) {
        int ans = 0;
        while(n != 0){
            n = n & (n-1);
            ans++;
        }
        return ans;
    }
}