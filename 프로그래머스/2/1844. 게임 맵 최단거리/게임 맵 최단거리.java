import java.util.*;

class Solution {
    static int N, M;
    public static void bfs(int[][] maps, boolean[][] check, int[][] dist) {
        Queue<int[]> q = new LinkedList<>();
        int[] dx = new int[] {0, 1, -1, 0};
        int[] dy = new int[] {1, 0, 0, -1};
        q.offer(new int[] {0, 0});
        check[0][0] = true;
        dist[0][0] = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if (nx == N || ny == M || nx == -1 || ny == -1) continue;
                if (check[nx][ny] || maps[nx][ny] == 0) continue;
                check[nx][ny] = true;
                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                q.offer(new int[] {nx, ny});
            }
            
        }
    }
    public int solution(int[][] maps) {
        int answer = -1;
        N = maps.length;
        M = maps[0].length;
        boolean[][] check = new boolean[N][M];
        int[][] dist = new int[N][M];
        bfs(maps, check, dist);
        if (dist[N - 1][M - 1] != 0) answer = dist[N - 1][M - 1];
        return answer;
    }
}