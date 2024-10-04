import java.util.*;

class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] map = new int[101][101];

        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2, y1 = rect[1] * 2;
            int x2 = rect[2] * 2, y2 = rect[3] * 2;
            
            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    if (i == x1 || i == x2 || j == y1 || j == y2) {
                        if (map[i][j] == 0) map[i][j] = 1;
                    } else {
                        map[i][j] = 2;
                    }
                }
            }
        }

        // BFS로 최단 경로 찾기
        return bfs(map, characterX * 2, characterY * 2, itemX * 2, itemY * 2);
    }
    
    public int bfs(int[][] map, int startX, int startY, int endX, int endY) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[101][101];
        q.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;
        
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            int dist = current[2];
            
            if (x == endX && y == endY) return dist / 2;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && nx <= 100 && ny >= 0 && ny <= 100 && map[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, dist + 1});
                }
            }
        }
        
        return -1;
    }
}
