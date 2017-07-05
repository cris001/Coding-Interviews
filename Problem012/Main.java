打印1到最大的n位数
思路：考虑大数问题，使用字符串或数组表示。
代码实现：
public void printToMaxOfNDigits(int n) {
    int[] array=new int[n];
    if(n <= 0)
        return;
    printArray(array, 0);
}

private void printArray(int[] array,int n) {
    for(int i = 0; i < 10; i++) {
        if(n != array.length) {
            array[n] = i;
            printArray(array, n+1);
        } else {
            boolean isFirstNo0 = false;
            for(int j = 0; j < array.length; j++) {
                if(array[j] != 0) {
                    System.out.print(array[j]);
                    if(!isFirstNo0)
                        isFirstNo0 = true;
                } else {
                    if(isFirstNo0)
                        System.out.print(array[j]);
                }
            }
            System.out.println();
            return ;
        }
    }
}