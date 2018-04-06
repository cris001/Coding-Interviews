地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
思路：利用递归实现，每次只能走上下左右四个点，进行判断点的位置是否越界，点数之和是否大于K，是否已经走过了。
代码实现：
public class Solution {
    int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};
    int ans = 0;

    public int movingCount(int threshold, int rows, int cols)
    {
        int[][] vis = new int[rows][cols];
        //vis[0][0] = 1;
        dfs(0,0,threshold,rows,cols,vis);
        return ans;
        
    }
    public void dfs(int x,int y, int threshold, int rows, int cols, int[][] vis){
        if (x < 0 || y < 0 || x >= rows || y >= cols){
            return;
        }
        if (vis[x][y] == 1){
            return;
        }
        if (!canWalk(x,y,threshold)){
            return;
        }
        vis[x][y] = 1;
        ans++;
        for (int i=0;i<3;i++){
            dfs(x+d[i][0],y+d[i][1],threshold,rows,cols,vis);
        }
        
    }
    public boolean canWalk(int x,int y, int threshold){
        int a = getSum(x);
        int b = getSum(y);
        if (a + b > threshold){
            return false;
        }
        return true;
    }
    public int getSum(int x){
        int t = 0;
        while(x !=0){
            t += x % 10;
            x/=10;
        }
        return t;
    }
    
}