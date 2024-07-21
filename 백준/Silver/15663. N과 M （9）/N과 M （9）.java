import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static HashSet<String> set = new HashSet<>();
    static int N, M;
    static boolean[] check;
    static int[] arr;
    static StringBuilder sb;

    public static void dfs(int depth, int[] pick) {
        if (depth == M) {
            String sum = "";
            for (int i = 0; i < M; i++){
                sum += ""+ pick[i] + " ";
            }
            if (!set.contains(sum)) {
                sb.append(sum + "\n");
                set.add(sum);
            }
            return ;
        }
        for (int i = 0; i < N; i++) {
            if (!check[i]) {
                check[i] = true;
                pick[depth] = arr[i];
                dfs(depth + 1, pick);
                check[i] = false;
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        sb = new StringBuilder();
        arr = new int[N];
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        Arrays.sort(arr);
        check = new boolean[N];
        int[] pick = new int[M];
        dfs(0, pick);
        System.out.println(sb);
    }
}