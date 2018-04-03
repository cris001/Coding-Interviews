请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
思路：回溯法，双层for循环，判断每一个点，每次递归调用上下左右四个点，用flag标志是否已经匹配（return），进行判断点的位置是否越界，是否已经正确匹配，判断矩阵的路径与模式串的第index个字符是否匹配。
代码实现：
import java.util.*;
public class Solution {
    int[][] d = {{0,0},{1,0},{-1,0},{0,1},{0,-1}};
    boolean flag = false;
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        int[][] vis = new int[rows][cols];
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                dfs(i,j,matrix,rows,cols,str,vis,0);
            }
        }
        
        return flag;
    }
    public void dfs(int x,int y,char[] matrix, int rows, int cols, char[] str,int[][] vis,int now){
        if (now == str.length){
            flag=true;
            return;
        }
        if (x < 0 || y < 0 || x >= rows || y >= cols){
            return;
        }
        /*if (vis[x][y] == 1){
            return;
        }*/
        
        for(int i = 0;i <= 4;i++){
            if (flag){
                return;
            }
            int xx = x+d[i][0];
            int yy = y+d[i][1];
            if (xx <0 || yy < 0 || xx >= rows || yy >= cols || vis[xx][yy] == 1){
                continue;
            }
            char c = str[now];
            if (matrix[(x+d[i][0])*cols + y+d[i][1]] == c){
                vis[x+d[i][0]][y+d[i][1]] = 1;
                dfs(x+d[i][0],y+d[i][1],matrix,rows,cols,str,vis,now+1);
                vis[x+d[i][0]][y+d[i][1]] = 0;
            }
            
        }  
    }
}