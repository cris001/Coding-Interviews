给定一个数组A[0,1,…,n-1],请构建一个数组B[0,1,…,n-1],其中B中的元素B[i]=A[0]A[1]…A[i-1]*A[i+1]…*A[n-1]。其中A[i] = 1。不能使用除法，
思路：使用矩阵法求解，将矩阵分为上三角矩阵和下三角矩阵，分别求乘积
代码实现：
import java.util.ArrayList;
public class Solution {
    public int[] multiply(int[] A) {

        int len = A.length;
        int[] B = new int[len];

        for (int i = 0;i<len;i++){
            int m =1;
            for (int j = 0;j<len;j++){
                if (i!=j){
                    m*=A[j];
                }
            }
            B[i]=m;
        }
        return B;
    }
}