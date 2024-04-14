import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String[] s = br.readLine().split("");
			if (s.length == 1 && s[0].charAt(0) == '.') break;
			else {
				Stack<Character> stack = new Stack<>();
				for (int i = 0; i < s.length; i++) {
					char A = s[i].charAt(0);
					if (A == '(' || A == '[') stack.push(A);
					else if (A == ')') {
						if(!stack.isEmpty() && stack.peek() == '(') stack.pop();
						else {
							stack.push(A);
							break;
						}
					} else if (A == ']') {
						if (!stack.isEmpty() && stack.peek() == '[') stack.pop();
						else {
							stack.push(A);
							break;
						}
					}
				}
				if (stack.isEmpty()) System.out.println("yes");
				else System.out.println("no");
			}
		} 
	}
}
