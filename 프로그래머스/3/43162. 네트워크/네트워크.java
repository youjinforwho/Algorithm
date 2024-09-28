class Solution {
    static boolean[] visited;
    public static void dfs(int[][] computers, int n, int next) {
        visited[next] = true;
        for (int i = 0; i < n; i++) {
            if (i != next && computers[next][i] == 1) {
                if (!visited[i]) {
                    dfs(computers, n, i);
                }
            }
        }
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i]) continue;
                if (i != j && computers[i][j] == 1) {
                    dfs(computers, n, i);
                    answer++;
                }
            }
            
        }
        for (int i = 0; i < n; i++) if (!visited[i]) answer++;
        return answer;
    }
}