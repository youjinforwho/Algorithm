import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        int[] pre = new int[N + 1];
        dp[1] = 0;
        for (int i = 2; i <= N; i++) {
            if (i % 3 == 0) {
                dp[i] = dp[i / 3] + 1;
                pre[i] = i / 3;
            }
            if (i % 2 == 0) {
                if ((dp[i] == 0) || (dp[i] != 0 && dp[i] > dp[i / 2] + 1)) {
                    dp[i] = dp[i / 2] + 1;
                    pre[i] = i / 2;
                }
            }
            if ((dp[i] == 0) || (dp[i] != 0 && dp[i] > dp[i - 1] + 1))
            {
                dp[i] = dp[i - 1] + 1;
                pre[i] = i - 1;
            }

        }
        StringBuilder sb = new StringBuilder();
        sb.append(dp[N] + "\n");
        while (true) {
            sb.append(N + " ");
            if (N == 1) break;
            N = pre[N];
        }
        System.out.println(sb);
    }
}