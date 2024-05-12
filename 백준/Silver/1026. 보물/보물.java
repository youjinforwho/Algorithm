import java.io.*;
import java.util.Arrays;

public class Main {
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] s1 = br.readLine().split(" ");
		int[] arr1 = new int[N];
		for (int i = 0; i < N; i++) {
			arr1[i] = Integer.parseInt(s1[i]);
		}
		Arrays.sort(arr1);
		String[] s2 = br.readLine().split(" ");
		int[] arr2 = new int[N];
		for (int i = 0; i < N; i++) {
			arr2[i] = Integer.parseInt(s2[i]);
		}
		Arrays.sort(arr2);
		int res = 0;
		for (int i = 0; i < N; i++) {
			res += arr1[i] * arr2[N - i - 1];
		}
		System.out.println(res);
	}
 
}