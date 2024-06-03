import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int C = Integer.parseInt(s[1]);
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int ans = 0;
		Arrays.sort(arr);
		int pl = 1;
		int pr = ((arr[arr.length - 1] - arr[0]) / C) + 1;
		int distance = (pl + pr) / 2;
		if (C == 2) {
			System.out.println(arr[arr.length - 1] - arr[0]);
			System.exit(0);
		}
		while (pl <= pr) {

			int check = 1;
			int st = arr[0];
			for (int i = 1; i < N; i++) {
				if (st + distance <= arr[i]) {
					check++;
					st = arr[i];
				}
				if (check == C) break;
			}
			
			if (check == C) {
				pl = distance + 1;
				ans = distance;
			} else pr =distance - 1;
			distance = (pl + pr) / 2;
			
		}
		System.out.println(ans);
    }
}