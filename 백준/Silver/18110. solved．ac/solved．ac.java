import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		if (arr.length == 0) System.out.println(0);
		else {
			int other = (int)((arr.length * 0.15) + 0.5);
			if (other * 2 >= arr.length) System.out.println(0);
			else {
				Arrays.sort(arr);
				int sum = 0;
				for (int i = other; i < arr.length - other; i++) {
					sum += arr[i];
				}
				System.out.println((int)(((double)sum / (arr.length - other * 2)) + 0.5));
			}
		}
	}
}

