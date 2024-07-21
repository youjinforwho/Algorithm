import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int[] arr;
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int depth, int start, int[] pick) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(pick[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            pick[depth] = arr[i];
            dfs(depth + 1, i, pick);
        }
    }
    public static void main(String[] args) throws IOException {
        HashSet<Integer> set = new HashSet<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        String[] s1 = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(s1[i]);
            if (set.contains(temp)) continue;
            set.add(temp);
        }
        N = set.size();
        arr = new int[N];
        int idx = 0;
        for (int i : set) {
            arr[idx++] = i;
        }
        Arrays.sort(arr);
        int[] pick = new int[M];
        dfs(0, 0, pick);
        System.out.println(sb);
    }
}