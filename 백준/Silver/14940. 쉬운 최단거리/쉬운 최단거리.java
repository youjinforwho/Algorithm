import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        boolean flag = false;
        String[] size = reader.readLine().split(" ");
        int n = Integer.parseInt(size[0]);
        int m = Integer.parseInt(size[1]);
        int x = -1;
        int y = -1;
        
        int[][] map = new int[n][m];
        int[][] distance = new int[n][m];
        boolean[][] check = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (!flag) 
                for (int j = 0; j < m; j++) 
                    if (map[i][j] == 2) {
                        flag = true;
                        x = i;
                        y = j;
                        break;
                    }
        }
        
        bfs(x, y, check, map, distance, n, m);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) 
                if (!check[i][j] && map[i][j] == 1)
                    builder.append(-1 + " ");
                else 
                    builder.append(distance[i][j] + " ");
            builder.append("\n");
        }
        
        System.out.print(builder.toString());
    }
    
    private static void bfs(int x, int y, boolean[][] check, int[][] map, int[][] distance, int n, int m) {
    	int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, -1, 0, 1 };
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        check[x][y] = true;
        
        while (!queue.isEmpty()) {
            int cur[] = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (map[nx][ny] == 0) continue;
                if (check[nx][ny]) continue;

                queue.add(new int[] {nx, ny});
                distance[nx][ny] = distance[cur[0]][cur[1]] + 1;
                check[nx][ny] = true;
            }
        }
    }
}
