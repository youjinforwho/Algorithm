import java.util.*;
import java.io.*;
 
public class Main {
	public static boolean checkDq(Deque<Integer> dq) {
		if (dq.isEmpty()) return false;
		return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> dq = new ArrayDeque<>();
		while (N-- > 0) {
			String[] s = br.readLine().split(" ");
			switch(s[0]) {
			case "push_front":
				dq.addFirst(Integer.parseInt(s[1]));
				break;
			case "push_back":
				dq.addLast(Integer.parseInt(s[1]));
				break;
			case "pop_front":
				if (checkDq(dq)) sb.append(dq.poll()+"\n");
				else sb.append("-1\n");
				break;
			case "pop_back":
				if (checkDq(dq)) sb.append(dq.pollLast()+"\n");
				else sb.append("-1\n");
				break;
			case "size":
				if (checkDq(dq)) sb.append(dq.size()+"\n");
				else sb.append("0\n");
				break;
			case "empty":
				if (checkDq(dq)) sb.append("0\n");
				else sb.append("1\n");
				break;
			case "front":
				if (checkDq(dq)) sb.append(dq.peek()+"\n");
				else sb.append("-1\n");
				break;
			case "back":
				if (checkDq(dq)) sb.append(dq.peekLast()+"\n");
				else sb.append("-1\n");
				break;
			}
		}
		System.out.println(sb);
	}
}

