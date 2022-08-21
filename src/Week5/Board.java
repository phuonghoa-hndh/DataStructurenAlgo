package Week5;
import java.util.*;
//Board
//public class Board {
//public Board(int[][] blocks) // xây dựng ma trận kích thước n*n
//public int dimension() // l y k ấ ướ ủ ậ ích th c n c a ma tr n
//public int manhattan() // tính kho ng c ả ớ ậ đ ách manhattan t i ma tr n ích
//public boolean isGoal() // ki m tra ma tr n n ể ậ đ đ ư ày ã là ích ch a?
//public Board twin() // l y ma tr n s a i b ng c ấ ậ ử đổ ằ ị ách hoán v hai ô khác 0
//public boolean equals(Object y) // ma tr n n ậ ằ ậ ày có b ng ma tr n y?
//public Iterable<Board> neighbors() // l y c ấ ậ ác ma tr n hàng xóm
//public String toString() // l y bi u di n x ấ ể ễ ủ ậ âu c a ma tr n
//}
public class Board {
    private int manhattan = -1;
    private final int N;
    private final int[][] board;
    private int zrow;
    private int zcol;
    //Xây dựng ma trân n*n
    public Board(int[][] blocks) {
        N = blocks.length;
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = blocks[i][j];

                if (blocks[i][j] == 0) {
                    zrow = i;
                    zcol = j;
                }
            }
        }
    }

    // lấy kích thước
    public int dimension() {
        return N;
    }

    // tong manhattan cua blocks so voi goal
    public int manhattan() {
        int manhattan = 0;
        for(int i = 0; i<N; i++){
            for(int j = 0;j< N; j++) {
                if(board[i][j]!= 0) {
                    int ii = (board[i][j]-1)/N;
                    int jj = (board[i][j]-1)%N;
                    manhattan += Math.abs(i-ii)+ Math.abs(j-jj);
                }
            }
        }
        return manhattan;
    }

    // neu no den dich
    public boolean isGoal() {
        return manhattan() == 0;
    }

    // mot board nhan duoc bang hoan vi giua hai phan tu khac 0 trong cung mot hang 
    public Board twin() {
        Board twin = new Board(board);

        int row = (zrow + 1) % N;
        int tmp = twin.board[row][0];
        twin.board[row][0] = twin.board[row][1];
        twin.board[row][1] = tmp;

        return twin;
    }

    // ma tran nay co bang matran y k
    public boolean equals(Object y) {//object la mot doi tuong cua java, khoi tao object thu vien se goi den board noi rang bang y khac board
        if (y == null)
            return false;

        if (y == this) //y la chinh no
            return true;

        if (y.getClass() != getClass())//neu no kp class board
            return false;

        Board Y = (Board) y;

        if (Y.dimension() != dimension())
            return false;

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (board[i][j] != Y.board[i][j])
                    return false;

        return true;
    }

    // TAT CA CAC MA TRAN HANG XOM
    public Iterable<Board> neighbors() {
        int[] offsets = {-1, 1, 0, 0};
        Queue<Board> neighbors = new LinkedList<Board>();

        for (int i = 0, j = offsets.length - 1; i < offsets.length; i++, j--) {
            int row = zrow + offsets[i];
            int col = zcol + offsets[j];

            if (row < 0 || row >= N || col < 0 || col >= N)
                continue;

            Board neighbor = new Board(board);
            neighbor.board[zrow][zcol] = neighbor.board[row][col];
            neighbor.board[row][col] = 0;
            neighbor.zrow = row;
            neighbor.zcol = col;

            neighbors.add(neighbor);
        }

        return neighbors;
    }

    public int[][] copyMatrix(int[][] m){
        int[][] clone = new int[m.length][m[0].length];
        for(int i =0; i<m.length; i++){
            for(int j =0; j<m.length; j++){
                clone [i][j] = m[i][j];
            }
        }
        return clone;
    }
    public void swap(int[][] m, int i, int j, int x, int y){
        int t = m[i][j];
        m[i][j] = m[x][y];
        m[x][y] =t;

    }


    // bieu dien
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(N + "\n");

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                str.append(String.format("%2d ", board[i][j]));
            str.append("\n");
        }

        return str.toString();
    }
}