数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字
思路：将首次出现的数count+1，与之后的数进行比较，相等则+1，否则—1，最后进行校验是否超过长度的一半。
代码实现：
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0){
            return 0;
        }
        int k = -1;
        int count = 0;
        for(int t : array){
            if (count == 0){
                k = t;
                count++;
            }else{
                if (k == t){
                    count++;
                }else{
                    count--;
                }
            }
        }
        int n = 0;
        for(int t:array){
            if (t == k){
                n++;
            }
        }
        if (n > array.length / 2){
            return k;
        }
        return 0;
    }
}