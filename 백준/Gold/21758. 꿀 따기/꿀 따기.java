import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int[] sum_arr;
    static int max = 0;

    public static void calculateSumArray() {
        sum_arr = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
            sum_arr[i] = sum;
        }
    }
    public static void getHoney(int b1, int b2, int honeypot) {
        int sum = 0;
        int n1, n2;

        n1 = Math.max(b1, honeypot);
        n2 = Math.min(b1, honeypot);
        //b1이 수확하는 꿀 먼저 계산
        if (n2 == 0) sum = sum_arr[n1];
        else sum = (sum_arr[n1] - sum_arr[n2 - 1]);

        if (b2 > n2 && b2 < n1) sum -= arr[b2];
        sum -= arr[b1];

        n1 = Math.max(b2, honeypot);
        n2 = Math.min(b2, honeypot);
        //b2가 수확하는 꿀 계산
        if (n2 == 0) sum += sum_arr[n1];
        else sum += (sum_arr[n1] - sum_arr[n2 - 1]);

        if (b1 > n2 && b1 < n1) sum -= arr[b1];
        sum -= arr[b2];

        if (sum > max) max = sum;


    }


    //순서 상관없이 2개 고르기
    public static void dfs(int depth, int start, boolean[] check, int[] cur) {
        //case 1 : 벌

        if (depth == 2) {

            for (int i = 0; i < N; i++) {
                if (i != cur[0] && i != cur[1]) {
                    getHoney(cur[0], cur[1], i);
                }
            }
            return ;
        }

        for (int i = start; i < N; i++) {
            if (!check[i]) {
                check[i] = true;
                cur[depth] = i;
                dfs(depth + 1, i + 1, check, cur);
                check[i] = false;
            }
        }


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        boolean[] check = new boolean[N];
        int[] cur = new int[2];
        calculateSumArray();
        cur[0] = 0;
        check[0] = true;
        dfs(1, 0, check, cur);
        check[0] = false;

        cur[0] = N - 1;
        check[N - 1] = true;
        dfs(1, 1, check, cur);
        System.out.println(max);
    }
}