扑克牌的顺子
思路：用数组记录五张扑克牌，将数组调整为有序的，若0出现的次数>=顺子的差值，即为顺子。
代码实现：
import java.util.*;
public class Solution {
    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length<=0){
            return false;
        }
        int k=0;
        int t=0;
        Arrays.sort(numbers);
        
        for (int i=0;i<numbers.length - 1;i++){
            if (numbers[i]==0){
                k++;
                continue;
            }
            if (numbers[i+1]-numbers[i]>1){
                t+=numbers[i+1]-numbers[i]-1;
            }else if (numbers[i+1]==numbers[i]){
                return false;
            }
            
        }
        if (t>k){
            return false;
        }
        return true;
    }
}