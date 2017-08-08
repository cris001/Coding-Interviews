输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个
思路：先将整型数组转换成String数组，然后将String数组排序，最后将排好序的字符串数组拼接出来。关键就是制定排序规则。或使用比较和快排的思想，将前面的数和最后的数比较，若小则放到最前面，最后再递归调用。
代码实现：
import java.util.*;

public class Solution {
    public String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length == 0){
            return "";
        }
        int len = numbers.length;
        String[] s = new String[len];
        for(int i = 0;i < len ;i++){
            s[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(s,new Comparator<String>(){
            @Override
            public int compare(String o1,String o2){
                String a1 = o1 + o2;
                String a2 = o2 + o1;
                return a1.compareTo(a2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(String str : s){
            sb.append(str);
        }
        return sb.toString();

    }
}