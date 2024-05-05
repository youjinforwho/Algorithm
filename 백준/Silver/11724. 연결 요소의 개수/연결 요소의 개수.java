import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
 
public class Main {
 
	public static void bfs(boolean[] check, LinkedList<Integer>[] node) {
		Queue<Integer> q = new LinkedList<>();
		int ans = 0;
		boolean flag;
		for (int i = 0; i < check.length; i++) {
			q.offer(i);
			flag = false;
			check[i] = true;
			while (!q.isEmpty()) {
				int cur = q.poll();
				Iterator<Integer> iter = node[cur].listIterator();
				if (!iter.hasNext()) ans += 1;
				while (iter.hasNext()) {
					int n = iter.next();
					if (check[n]) continue;
					flag = true;
					check[n] = true;
					q.offer(n);
				}
			}
			if (flag) ans += 1;
		}
		System.out.println(ans);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s1 = br.readLine().split(" ");
		int N = Integer.parseInt(s1[0]);
		int M = Integer.parseInt(s1[1]);
		
		LinkedList<Integer>[] node = new LinkedList[N];
		for (int i = 0; i < N; i++) {
			node[i] = new LinkedList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			String[] s2 = br.readLine().split(" ");
			int x = Integer.parseInt(s2[0]) - 1;
			int y = Integer.parseInt(s2[1]) - 1;
			node[x].add(y);
			node[y].add(x);
		}
		
		boolean[] check = new boolean[N];
		bfs(check, node);
	}
}