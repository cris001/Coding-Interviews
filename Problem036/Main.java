在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P
思路：本质是归并排序，在比较时加入全局变量count进行记录逆序对的个数，若data[start] >= data[index] ，则count值为mid+1-start
代码实现：
public class Solution {
    int ans = 0;
    public int InversePairs(int [] array) {
        if (array == null ){
            return 0;
        }
        mergeSort(0,array.length-1, array);
        return ans;
    }
    public void mergeSort(int l, int r, int [] array){
        int mid = (l + r) >> 1;
        if (l<r){
            mergeSort(l, mid, array);
            mergeSort(mid + 1, r, array);
            merge(l,mid,r,array);
        }
    }
    
    public void merge(int l, int mid, int r, int [] array){
        int i = l;
        int j = mid + 1;
        int k = 0;
        int s = l;
        int a[] = new int[r-l+1];
        while(i <= mid && j <= r){
            if (array[i] < array[j]){
                a[k++] = array[i];
                i++;
            }else{
                a[k++] = array[j];
                j++;
                ans += mid + 1 - i;
                ans %= 1000000007;
            }
        }
        while(i <= mid){
            a[k++] = array[i++];
        }
        while(j <= r){
            a[k++] = array[j++];
        }
        for(int t : a){
            array[s++] = t;
        }
    }
}