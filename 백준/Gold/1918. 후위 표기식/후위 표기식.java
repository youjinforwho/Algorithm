import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		String line = br.readLine();
		Stack<Character> s = new Stack<>();
		for (int i = 0; i < line.length(); i++) {
			char A = line.charAt(i);
			if (A == '(') s.push(A);
			else if (A == ')') {
				while (s.peek() != '(') {
					sb.append(s.pop());
				}
				s.pop();
			}
			else if (A == '+' || A == '-') {
				while (!s.isEmpty() && s.peek() != '(') {
					sb.append(s.pop());
				}
				s.push(A);
			}
			else if (A == '*' || A == '/') {
				if (!s.isEmpty() && (s.peek() == '*' || s.peek() == '/')) {
					sb.append(s.pop());
				}
				s.push(A);
			}
			else {
				sb.append(A);
			}
		}
		while (!s.isEmpty()) {
			sb.append(s.pop());
		}
		System.out.println(sb.toString());
	}
	
}
