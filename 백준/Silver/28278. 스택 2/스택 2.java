import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Stack<Integer> st = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			if (s.length == 1) {
				switch (Integer.parseInt(s[0])) {
				case 2:
					if (!st.isEmpty()) sb.append(st.pop()+"\n");
					else sb.append("-1\n");
					break;
				case 3:
					sb.append(st.size()+"\n");
					break;
				case 4:
					if (!st.isEmpty()) sb.append("0\n");
					else sb.append("1\n");
					break;
				case 5:
					if (!st.isEmpty()) sb.append(st.peek() + "\n");
					else sb.append("-1\n");
					break;
				}
				
			} else {
				st.push(Integer.parseInt(s[1]));
			}
		}
		System.out.println(sb);
	}
}