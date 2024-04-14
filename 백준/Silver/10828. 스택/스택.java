import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<String> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		while (N-- > 0) {
			String[] s = br.readLine().split(" ");
			if (s.length == 2) stack.push(s[1]);
			else {
				switch(s[0]) {
				case "top":
					if (stack.isEmpty()) sb.append("-1\n");
					else sb.append(stack.peek() + "\n");
					break;
				case "size":
					sb.append(stack.size() + "\n");
					break;
				case "empty":
					if (stack.isEmpty()) sb.append("1\n");
					else sb.append("0\n");
					break;
				case "pop":
					if (stack.isEmpty()) sb.append("-1\n");
					else sb.append(stack.pop() + "\n");
					break;
				}
			}
		}
		System.out.println(sb.toString());
		
	}
}
