class Solution {
    static int board[];
    static int answer = 0;
    public void dfs(int depth, int n, boolean[] check, int[] res) {
        if (depth == n) {
            answer++;
            return ;
        }
        else {
            for (int i = 0; i < n; i++) {
                if (!check[i]) {
                    boolean flag = true;
                    for (int j = 0; j < depth; j++) {
                        if (Math.abs(depth - j) == Math.abs(res[j] - i)) flag = false;
                    }
                    if (flag) {
                        res[depth] = i;
                        check[i] = true;
                        dfs(depth + 1, n, check, res);
                        check[i] = false;
                    }
                    
                }
            }
        }
        
    }
    public int solution(int n) {
        board = new int[n];
        boolean[] check = new boolean[n];
        int[] res = new int[n];
        dfs(0, n, check, res);
        return answer;
    }
}