求连续子数组（包含负数）的最大和
思路：若和小于0，则将最大和置为当前值，否则计算最大和。
代码实现：
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0){
            return 0;
        }
        int ans = array[0];
        int sum = array[0];
        for(int i = 1;i<array.length;i++){
            sum +=array[i];
            if (sum > ans){
                ans = sum;
            }
            if (sum < 0){
                sum = 0;
            }
        }
        return ans;
    }
}