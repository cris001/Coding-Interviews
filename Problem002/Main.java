将一个字符串中的空格替换成“%20”。 
例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
思路：从后往前复制，数组长度会增加，或使用StringBuilder、StringBuffer类
代码实现：
public class Solution {
    public String replaceSpace(StringBuffer str) {
    	String s = str.toString();
        return s.replaceAll(" ","%20");
    }
}