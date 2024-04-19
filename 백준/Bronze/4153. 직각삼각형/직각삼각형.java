import java.util.*;
import java.io.*;
import java.io.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			String[] s = br.readLine().split(" ");
			int[] arr = new int[3];
			arr[0] = Integer.parseInt(s[0]);
			arr[1] = Integer.parseInt(s[1]);
			arr[2] = Integer.parseInt(s[2]);
			if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0) break;
			Arrays.sort(arr);
			if (Math.pow(arr[0], 2) + Math.pow(arr[1], 2) == Math.pow(arr[2], 2)) {
				sb.append("right\n");
			} else sb.append("wrong\n");
		}
		System.out.println(sb.toString());
	}
}

