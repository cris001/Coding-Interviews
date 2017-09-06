输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
思路：定义两个指针，分别递增，寻找和为s的序列。
代码实现：
 import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer> > ans = new ArrayList<>();
        ArrayList<Integer > list = new ArrayList<>();
        int i = 1;
        int j = 2;
        while(i < sum){
            int s = 0;
            for (int k = i;k<=j;k++){
                s+=k;
            }
            if (s == sum){
                for (int k = i;k<=j;k++){
                    list.add(k);
                }
                ans.add(new ArrayList(list));
                list.clear();
                i++;
            }else if (s > sum){
                i++;
            }else{
                j++;
            }
            
            
        }
        return ans;
       
    }
}