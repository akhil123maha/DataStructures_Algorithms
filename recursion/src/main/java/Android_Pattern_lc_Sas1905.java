import utils.Grid_Block;

import java.util.ArrayList;
import java.util.List;

public class Android_Pattern_lc_Sas1905 {
    static int N=0;
    static int M=0;
    static int[][] visited;
    static int total = 0;

    public static void main(String[] args) {
        int n = 5;
        int m = 3;
        solve_ques(n,m);
    }

    private static void solve_ques(int n, int m) {
        N=n;
        M=m;
        visited = new int[3][3];
        reset();
        for(int i=0;i<3;i++) {
            for (int j = 0; j < 3; j++) {
                List<Grid_Block> blocks = new ArrayList<>();
                blocks.add(new Grid_Block(i, j));
                solve_with_backtracking(i, j, 1, blocks);
            }
        }
    return;
    }

    private static void solve_with_backtracking(int row, int col, int number_keys, List<Grid_Block> blocks) {
        if(number_keys>N){
            return ;
        }
        if(number_keys>= M && number_keys<=N){
            total++;
            System.out.print(total + " possibility ");
            for(int i=0;i<number_keys-1;i++){
                System.out.print("(" + (blocks.get(i).getX()+1) +"," + (blocks.get(i).getY()+1) +") ->" );
            }
            System.out.println("(" + (blocks.get(number_keys-1).getX()+1) +"," + (blocks.get(number_keys-1).getY()+1) +")");
        }
        int x = row;
        int y = col;
        visited[x][y]=1;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                int dx = Math.abs(i - x);
                int dy = Math.abs(j - y);
                boolean jump = dx % 2 == 0 && dy % 2 == 0;
                if (visited[i][j]==0 && (!jump || visited[(i + x) / 2][(j + y) / 2]==1)) {
                    blocks.add(new Grid_Block(i,j));
                    solve_with_backtracking(i,j,number_keys+1,blocks);
                    blocks.remove(blocks.size()-1);
                }
            }
        }
        visited[x][y]=0;
        return;
    }

    private static void reset() {
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                visited[i][j]=0;
            }
        }
    }
}
