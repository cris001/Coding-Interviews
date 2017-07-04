一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
public class Solution {
    public int JumpFloor(int target) {
        int[] f = new int[500];
        f[1]=1;
        f[2]=2;
        for (int i=3;i<=target;i++){
            f[i] = f[i-1] + f[i-2];
        }
        return f[target];
    }
}