输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变
思路：每次只和前面一个数交换位置。或者利用辅助数组
代码实现：
public class Solution {
    public void reOrderArray(int [] array) {
        if (array == null || array.length == 0){
            return;
        }
        for (int i = 0;i<array.length;i++){
            if ((array[i] & 1) == 1){
                int t = array[i];
                int j = i-1;
                while(j>=0 && (array & 1) == 0){
                    array[j+1] = array[j];
                    j--;
                }
                array[j+1] = t;
            }
        }
    }
}