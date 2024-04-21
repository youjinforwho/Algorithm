import java.util.*;
import java.io.*;

public class Main {
	public static boolean canCut(int[] arr, long length, int N) {
		int cnt = 0;
		for (int i = 0 ; i < arr.length; i++) {
			if ((arr[i] / length) > 0) {
				cnt += (arr[i] / length);
			}
		}
		if (cnt >= N) return true;
		else return false;
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int K = Integer.parseInt(s[0]);
		int N = Integer.parseInt(s[1]);
		long ptl = 1;
		long ptr = 0;
		int[] arr = new int[K];
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			ptr += arr[i];
		}
		ptr /= N;
		long temp = ptr;
		long max = 1;
		if (ptl == ptr) System.out.println(ptr);
		else {
			while (ptl <= ptr) {
				if (canCut(arr, temp, N)) {
					ptl = temp + 1;
					if (temp > max) max = temp;
				}
				else ptr = temp - 1;
				temp = (ptl + ptr) / 2;
			}
			System.out.println(max);
		}
	}
}

