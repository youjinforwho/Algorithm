import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[N];
		int[] sort = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(s[i]);
			sort[i] = arr[i];
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		Arrays.sort(sort);
		int before = -2147483648;
		int rank = -1;
		for (int a : sort) {
			if (before != a) rank++;
			map.put(a, rank);
			before = a;
		}
		for (int i = 0; i < N; i++) {
			sb.append(map.get(arr[i]) + " ");
		}
		System.out.println(sb);
	}
}