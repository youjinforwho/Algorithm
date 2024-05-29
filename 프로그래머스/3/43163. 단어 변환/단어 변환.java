import java.util.*;
class Solution {
    static int answer;
    static boolean[] check;
    static boolean calDiff(String s1, String s2) {
        int cnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) cnt++;
        }
        if (cnt == 1) return true;
        return false;
    }
    static void dfs(int depth, int N, String begin, String target, String[] words) {
        if (begin.equals(target)) {
            if (answer > depth) answer = depth;
            return ;
        }
        for (int i = 0; i < N; i++) {
            if (!(check[i]) && calDiff(begin, words[i])) {
                check[i] = true;
                dfs(depth + 1, N, words[i], target, words);
                check[i] = false;
            } 
        }
    }
    public int solution(String begin, String target, String[] words) {
        check = new boolean[words.length];
        answer = 2147483647;
        dfs(0, words.length, begin, target, words);
        if (answer == 2147483647) answer = 0;
        return answer;
    }
}