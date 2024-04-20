import java.util.*;
import java.io.*;
import java.io.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] s1  = br.readLine().split(" ");
		StringBuilder sb = new StringBuilder();
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(s1[i]);
			if (map.containsKey(temp)) map.put(temp, map.get(temp) + 1);
			else map.put(temp, 1);
		}
		int M = Integer.parseInt(br.readLine());
		String[] s2 = br.readLine().split(" ");
		for (int i = 0; i < M; i++) {
			int temp = Integer.parseInt(s2[i]);
			if (map.containsKey(temp)) sb.append(map.get(temp) + " ");
			else sb.append("0 ");
		}
		System.out.println(sb);
	}
}

