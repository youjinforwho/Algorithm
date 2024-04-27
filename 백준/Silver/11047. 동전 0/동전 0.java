import java.util.Stack;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		int idx = N - 1;
		int sum = 0;
		int left = K;
		int cnt = 0;
		while (idx != -1) {
			while (arr[idx] > left) idx--;
			sum += arr[idx] * (left / arr[idx]);
			cnt += (left / arr[idx]);
			left = K - sum;
			if (sum == K) break;
		}
		System.out.println(cnt);
	}
}