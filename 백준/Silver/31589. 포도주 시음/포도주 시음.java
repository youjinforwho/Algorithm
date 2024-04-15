import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s1 = br.readLine().split(" ");
		int N = Integer.parseInt(s1[0]);
		int K = Integer.parseInt(s1[1]);
		int[] arr = new int[N];
		String[] s2 = br.readLine().split(" ");
		for (int i = 0; i < s2.length; i++) arr[i] = Integer.parseInt(s2[i]);
		Arrays.sort(arr);
		int turn = 0;
		long sum = 0;
		int last = 0;
		int idx = 0;
		int size = arr.length - 1;
		while (K-- > 0) {
			if (turn == 0) {
				last = arr[size];
				sum = arr[size--];
			}
			else if (turn % 2 == 0) {
				sum += (arr[size] - last);
				last = arr[size--];
			}
			else {
				last = arr[idx++];
			}
			turn++;
		}
		System.out.println(sum);
	}
}
