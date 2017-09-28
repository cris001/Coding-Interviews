给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值
思路：两个for循环，第一个for循环滑动窗口，第二个for循环滑动窗口中的值，寻找最大值。还可以使用时间复杂度更低的双端队列求解。
代码实现：
import java.util.*;
public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> list = new ArrayList<>();
        if (num == null || num.length <= 0 || size > num.length || size <= 0){
            return list;
        }
        for (int i = 0;i<num.length && i+size-1<num.length;i++){
            int max = num[i];
            for (int j = i+1;j<num.length && j<i+size;j++){
                max = Math.max(max, num[j]);
            }
            list.add(max);
        }
        return list;
    }
}