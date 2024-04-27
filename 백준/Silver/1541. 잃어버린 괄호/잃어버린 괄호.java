import java.util.Scanner;
import java.util.Stack;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> st = new Stack<>();
		String[] s = br.readLine().split("(?=[\\+\\-])");
		String flag = "plus";
		int res = 0;
		for (int i = 0; i < s.length; i++) {
			int num= Integer.parseInt(s[i]);
			if (num > 0) {
				if (flag.equals("minus")) flag = "plus";
				if (st.isEmpty()) res += num;
				else st.push(num);
			} else {
				if (flag.equals("plus")) flag = "minus";
				while(!st.isEmpty()) {
					res += -1 * st.pop();
				}
				st.push(num * -1);
			}
		}
		while (!st.isEmpty()) {
			res += -1 * st.pop();
		}
		System.out.println(res);
	}
}