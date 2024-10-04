class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                bfs(n, computers, i);
                answer++;
            }
        }
        return answer;
    }
    
    public static void bfs(int n, int[][] computers, int i) {
        for (int idx = 0; idx < n; idx++) {
            if (!visited[idx] && computers[idx][i] == 1) {
                visited[idx] = true;
                bfs(n, computers, idx);
            }
        }
        return ;
    }
}