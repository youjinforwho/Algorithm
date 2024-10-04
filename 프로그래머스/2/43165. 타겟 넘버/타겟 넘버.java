class Solution {
    static int n;
    static int answer = 0;
    public static void dfs(int depth, int[] numbers, int target, int sum) {
        if (depth == n) {
            if (target == sum) answer++;
            return ;
        }
        dfs(depth + 1, numbers, target, sum + numbers[depth]);
        dfs(depth + 1, numbers, target, sum - numbers[depth]);
    }
    public int solution(int[] numbers, int target) {
        n = numbers.length;
        dfs(0, numbers, target, 0);
        return answer;
    }
}