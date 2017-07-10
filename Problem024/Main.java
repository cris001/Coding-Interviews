输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
思路：先找到右子树的开始位置，然后分别进行左右子树递归处理。
代码实现：
  import java.util.*;
public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0){
              return false;
        }
        if (sequence.length == 1){
              return true;
        }
        int root = sequence[sequence.length - 1];
        int k =0;
        for (int i = 0;i<sequence.length;i++){
            if (sequence[i] >= root){
                k = i;
                break;
            }
        }
        if (k == sequence.length - 1){
            return true;
        }
       
        if (k == 0){
            for (int i = k;i<sequence.length-1;i++){
                if (sequence[i] <= root){
                    return false;
                }
            }
            return VerifySquenceOfBST(Arrays.copyOfRange(sequence,0,sequence.length-1));
        }else{
            for (int i = k;i<sequence.length-1;i++){
                if (sequence[i] < root){
                    return false;
                }
            }
            
            return VerifySquenceOfBST(Arrays.copyOfRange(sequence,0,k))
                    && VerifySquenceOfBST(Arrays.copyOfRange(sequence,k,sequence.length-1));
        }
        //return true;
    }
}