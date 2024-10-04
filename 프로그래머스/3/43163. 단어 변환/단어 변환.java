import java.util.*;
class Solution {
    static char[][] arr;
    static int R, C, N;
    static boolean[] check;
    static int[] dist;
    public static boolean wordCount(String s1, String s2) {
        int cnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) cnt++;
        }
        if (cnt == 1) return true;
        return false;
    }
    public static int bfs(String begin, String target, String[] words) {
       Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            if (wordCount(words[i], begin)) {
                q.add(i);
                check[i] = true;
                dist[i] = 1;
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (words[cur].equals(target)) {
                return dist[cur];
            }
            for (int i = 0; i < N; i++) {
                if (check[i]) continue;
                if (wordCount(words[i], words[cur])) {
                    q.add(i);
                    check[i] = true;
                    dist[i] = dist[cur] + 1;
                }
            }
       }
        return 0;
    }
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        R = words.length;
        C = words[0].length();
        N = R;
        dist = new int[N];
        check = new boolean[N];

        return bfs(begin, target, words);
    }
}