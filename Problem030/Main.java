输入n个整数，找出其中最小的K个数。
思路：先将前K个数放入数组，进行堆排序，若之后的数比它还小，则进行调整
代码实现：
import java.util.*;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
         ArrayList<Integer> list = new  ArrayList<Integer>();
        if (input == null || input.length == 0 || k == 0 || k>input.length){
            return list;
        }
        PriorityQueue<Integer> maxHeap = new  PriorityQueue<Integer>(k , new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o2.compareTo(o1);
            }
        });
        for(int i=0;i<input.length;i++){
            if (maxHeap.size()<k){
                maxHeap.offer(input[i]);
            }else if (maxHeap.peek() > input[i]){
                maxHeap.poll();
                maxHeap.offer(input[i]);
            }
        }
        for(Integer t : maxHeap){
            list.add(t);
        }
        
        return list;
    }
}