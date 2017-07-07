输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
思路：终止行号大于起始行号，终止列号大于起始列号，
代码实现：
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
       ArrayList<Integer> list = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0){
            return list;
        }
        int top = 0;
        int left = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;
        while(top <= bottom && left <= right){
            for(int i = left;i<=right;i++){
                list.add(matrix[top][i]);
            }
            for(int i = top + 1;i<=bottom;i++){
                list.add(matrix[i][right]);
            }
            if (top < bottom){
                for(int i = right - 1;i>=left;i--){
                    list.add(matrix[bottom][i]);
                }
            }
            if (left < right){
                for(int i = bottom - 1;i>top;i--){
                    list.add(matrix[i][left]);
                }
            }
            top++;left++;
            bottom--;right--;
        }
        return list;
    }
}