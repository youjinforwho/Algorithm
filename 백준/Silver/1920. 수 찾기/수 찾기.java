import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		HashSet<Integer> array = new HashSet<>();
		String[] s1 = br.readLine().split(" ");
		for (int i = 0; i < s1.length; i++) {
			array.add(Integer.parseInt(s1[i]));
		}
		int M = Integer.parseInt(br.readLine());
		String[] s2 = br.readLine().split(" ");
		for (int i = 0; i < s2.length; i++) {
			if (array.contains(Integer.parseInt(s2[i]))) {
				sb.append("1\n");
			} else sb.append("0\n");
		} 
		System.out.println(sb);
	}
}
