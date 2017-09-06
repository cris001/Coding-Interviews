一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
思路：两个相同的数异或后为0，将所有数异或后得到一个数，然后求得1在该数最右边出现的index，然后判断每个数右移index后是不是1。
代码实现：
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class Solution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int s = 0;
        for(int k:array){
            s^=k;
        }
        int k = 0;
        while((s & 1) == 0){
            s>>=1;
            k++;
        }
        for(int t:array){
            if ((t & (1<<k)) == 0){
                num1[0]^=t;
            }else{
                num2[0]^=t;
            }
        }
    }
}