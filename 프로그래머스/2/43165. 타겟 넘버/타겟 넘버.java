class Solution {
    static int answer = 0;
    public static void dfs(int depth, int[] numbers, int target, boolean[] check, int N) {
        if (depth == N) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if (check[i]) sum += numbers[i] * (-1);
                else sum += numbers[i];
            }
            if (sum == target) answer += 1;
            return ;
            
        }
        check[depth] = true;
        dfs(depth + 1, numbers, target, check, N);
        check[depth] = false;
        dfs(depth + 1, numbers, target, check, N);
        
    }
    public int solution(int[] numbers, int target) {
        int N = numbers.length;
        boolean[] check = new boolean[N];
        dfs(0, numbers, target, check, N);
        return answer;
    }
}