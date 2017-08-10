统计一个数字在排序数组中出现的次数。
思路：利用二分查找+递归思想，进行寻找。当目标值与中间值相等时进行判断
代码实现：
import java.util.*;
public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        if (array == null || array.length == 0){
            return 0;
        }
        int l=0;
        int r=array.length-1;
        int mid =(l + r)/2;
        int lcount = -1;
        int rcount = -1;
        if (array[mid] == k && array[l] == k){
            lcount =  mid - l;
        }
        if (array[mid] == k && array[r] == k){
            rcount = r - mid;
        }
        int p = 0;
        if (array[mid] == k){
            p = 1;
        }
        if (lcount != -1 && rcount != -1 ){
            return lcount + rcount + p;
        }
        if (lcount != -1 && rcount == -1 ){
            return lcount+GetNumberOfK(Arrays.copyOfRange(array,mid+1,r+1),k)+p;
        }
        if (lcount == -1 && rcount != -1 ){
            return GetNumberOfK(Arrays.copyOfRange(array,0,mid),k)+rcount+p;
        }
        return GetNumberOfK(Arrays.copyOfRange(array,0,mid),k)
            +GetNumberOfK(Arrays.copyOfRange(array,mid+1,r+1),k)+p;
    }
}