丑数是只包含因子2、3和5的数，求从小到大的第N个丑数。
思路：乘2或3或5，之后比较取最小值。
代码实现：
public class Solution {
	public int GetUglyNumber_Solution(int index) {
        if (index <= 0){
            return 0;
        }
        if (index == 1){
            return 1;
        }
        int i = 0;
        int j = 0;
        int k = 0;
        int count = 0;
        int a[] = new int[index];
        a[0] = 1; 
        while(count < index - 1){
            int m = Math.min(Math.min(a[i]*2, a[j]*3), a[k]*5);
            if (m == a[i]*2){
                i++;
            }
            if (m == a[j]*3){
            	System.out.println("aa");
            	j++;
            }
            if (m == a[k]*5){
            	k++;
            }
            count++;
            a[count] = m;
            if (count == index - 1){
                return m;
            }
        }
        
        return 0;
    }
}