import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		int[] arr = new int[N];
		int max = arr[0];
		int sum = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(s[i]);
			sum += arr[i];
			if (max < arr[i]) max = arr[i];
		}
		System.out.println((double) (sum * 100) / (N * max));
	}
}
