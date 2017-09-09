圆圈中最后剩下的数字（约瑟夫环）
思路：利用循环链表实现
代码实现：
public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        if (n == 0){
            return -1;
        }
        return circle(n,m);
    }
    public int circle(int n, int m) {
        if (n == 0 || n==1){
            return 0;
        }
        return (circle(n-1,m) + m ) % n;
    }
}