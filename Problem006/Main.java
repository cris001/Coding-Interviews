把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0
思路：利用二分法，找到中间的数，然后和最左边的值进行比较，若大于最左边的数，则最左边从mid开始，若小于最右边值，则最右边从mid开始。若左中右三值相等，则取mid前后值中较小的数。

public class Solution {
    public int minNumberInRotateArray(int [] array) {
        int low = 0 ; int high = array.length - 1;    
        while(low < high){
            int mid = low + (high - low) / 2;         
            if(array[mid] > array[high]){
                low = mid + 1;
            }else if(array[mid] == array[high]){
                high = high - 1;
            }else{
                high = mid;
            }    
        } 
        return array[low];
    }
}