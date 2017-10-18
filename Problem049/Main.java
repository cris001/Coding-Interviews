在一个长度为n的数组里的所有数字都在0到n-1的范围内，找出数组中任意一个重复的数字
思路：若下标大于length，则减去length，最后再加上length，若下标的数组值大于length，则返回true。或使用辅助空间（HashSet）
代码实现：
public boolean duplicate(int numbers[],int length,int [] duplication) {
    if (numbers == null || length == 0 || length == 1)
        return false;
    for (int i = 0; i < length; i++) {
        int index = numbers[i];
        if (index >= length)
            index -= length;
        if (numbers[index] >= length) {
            duplication[0] = index;
            return true;
        }
        numbers[index] += length;
    }
    return false;
}