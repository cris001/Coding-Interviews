求1+2+3+…+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
思路：巧用递归（返回值类型为Boolean）
代码实现：
public class Solution {
    int sum = 0;
    public int Sum_Solution(int n) {
        boolean t = calSum(n);
        return sum;
    }
    public boolean calSum(int n) {
        sum += n;
        return (n>0) && (calSum(n-1));
    }
}