import java.io.*;
import java.util.*;

public class Main {
    //0인 값 위치 기억
    //올 수 있는 값 후보 모두 저장

    static int[][] board;
    static Deque<int []> q =new LinkedList<>();
    static int N = 0;

    public static boolean checkBoard(int x, int y, int num) {
        //TODO: board[x][y]가 가능한 값인지 확인하기
        //세로 검사
        for (int i = 0; i < 9; i++) {
            if (board[x][i] == num) return false;
        }

        //가로 검사
        for (int i = 0; i < 9; i++) {
            if (board[i][y] == num) return false;
        }

        // 3 x 3 상자 검사
        int nx = ((int) (x / 3)) * 3;
        int ny = ((int) (y / 3)) * 3;
        for (int i = nx; i < nx + 3; i++) {
            for (int j = ny; j < ny + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }

        return true;
    }
    // 0의 개수 => depth
    public static void backtracking(int depth) {

        if (depth == N) {
            //TODO: 완성된 스도쿠 출력
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
            System.exit(0);
        }
        int[] cur = q.peek();
        int nx = cur[0];
        int ny = cur[1];

        for (int num = 1; num <= 9; num++) {
            if (checkBoard(nx, ny, num)) {
                q.poll();
                board[nx][ny] = num;
                backtracking(depth + 1);
                board[nx][ny] = 0;
                q.addFirst(cur);
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(line[j]);
                if (board[i][j] == 0) {
                    N++;
                    q.add(new int[] {i, j});
                }
            }
        }
        backtracking(0);



    }
}