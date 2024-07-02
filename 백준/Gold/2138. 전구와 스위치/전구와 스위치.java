import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void changeLight(String[] s, int target) {
        int st = target - 1;
        int ed = target + 1;
        if (target == 0) st = 0;
        if (target == N - 1) ed = N - 1;

        for (int i = st; i <= ed; i++) {
            if (s[i].equals("0")) s[i] = "1";
            else s[i] = "0";
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] s1 = br.readLine().split("");
        String[] s2 = Arrays.copyOf(s1, N);

        int res1 = 0, res2 = 1;
        String[] ans = br.readLine().split("");
        for (int i = 1; i < N; i++) {
            if (!s1[i - 1].equals(ans[i - 1])) {
                changeLight(s1, i);
                res1++;
            }
        }

        changeLight(s2, 0);
        for (int i = 1; i < N; i++) {
            if (!s2[i - 1].equals(ans[i - 1])) {
                changeLight(s2, i);
                res2++;
            }
        }

        for (int i = 0; i < N; i++) {
            if (!s1[i].equals(ans[i])) {
                res1 = -1;
                break;
            }
        }

        for (int i = 0; i < N; i++) {
            if (!s2[i].equals(ans[i])) {
                res2 = -1;
                break;
            }
        }

        if (res1 != -1 && res2 != -1) {
            System.out.println(Math.min(res1, res2));
        } else if (res1 != -1) {
            System.out.println(res1);
        } else {
            System.out.println(res2);
        }

    }
}