import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static char[][] board;
    static boolean[][] check;
    static int max = 1;
    static int R, C;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void dfs(int i, int j, int depth, HashSet<Character> set) {
        boolean flag = false;
        for (int dir = 0; dir < 4; dir++) {
            int nx = i + dx[dir];
            int ny = j + dy[dir];
            if (nx == R || ny == C || nx == -1 || ny == -1) continue;
            if (!check[nx][ny] && !set.contains(board[nx][ny])) {
                set.add(board[nx][ny]);
                flag = true;
                dfs(nx, ny, depth + 1, set);
                set.remove(board[nx][ny]);
            }
        }
        if (!flag) {
            if (depth > max) max = depth;
            return ;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        HashSet<Character> set = new HashSet<>();
        R = Integer.parseInt(s[0]);
        C = Integer.parseInt(s[1]);
        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            String[] s2 = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                board[i][j] = s2[j].charAt(0);
            }
        }
        check = new boolean[R][C];
        set.add(board[0][0]);
        check[0][0] = true;
        dfs(0, 0, 1, set);
        System.out.println(max);
    }
}