import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static int N, M;
    static int[][] room;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        int[][] dist = new int[N][M];
        boolean[][] check = new boolean[N][M];
        dist[0][0] = room[0][0];
        check[0][0] = true;
        q.add(new int[] {0, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int dir = 0; dir < 2; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (!check[nx][ny]) {
                    check[nx][ny] = true;
                    dist[nx][ny] = dist[cur[0]][cur[1]] + room[nx][ny];
                    q.add(new int[] {nx, ny});
                }
                else if (dist[nx][ny] < dist[cur[0]][cur[1]] + room[nx][ny]) {
                    dist[nx][ny] = dist[cur[0]][cur[1]] + room[nx][ny];
                }
            }

        }
        System.out.println(dist[N - 1][M - 1]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        N = Integer.parseInt(s1[0]);
        M = Integer.parseInt(s1[1]);
        room = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] s2 = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(s2[j]);
            }
        }
        bfs();
    }

}