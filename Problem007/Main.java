现在要求输入一个整数n，请你输出斐波那契数列的第n项。n<=39
思路：递归的效率低，使用循环方式。
代码实现：
public class Solution {
    public int Fibonacci(int n) {
        int[] f = new int[40];
        f[1]=1;
        f[2]=1;
        for(int i = 3;i<=n;i++){
            f[i] = f[i-1]+f[i-2];
        }
        return f[n];
    }
}