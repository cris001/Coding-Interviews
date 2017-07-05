给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。不得使用库函数，不需要考虑大数问题
思路：不能用==比较两个浮点数是否相等，因为有误差。考虑输入值的多种情况。
代码实现：
public class Solution {
    public double Power(double base, int exponent) {
        int mark = 0;
        if (exponent < 0){
            mark = 1;
            exponent = -exponent;
        }
        double ans = 1.0;
        double k = base;
        while(exponent > 0){
            if((exponent & 1) == 1){
                ans *= k;
            }
            k = k * k;
            exponent >>= 1;
        }
        if (mark == 1){
            ans = 1.0/ans;
        }
        return ans;
  }
}