import java.util.*;
import java.io.*;

public class Main {
	static Queue<Integer> q = new LinkedList<>();
	public static void bfs(boolean[] check, LinkedList<Integer>[] node, int start) {
		
		int[] ans = new int[check.length];
		int idx = 1;
		StringBuilder sb = new StringBuilder();
		q.offer(start);
		check[start] = true;
		ans[start] = idx++;
		while (!q.isEmpty()) {
			int cur = q.poll();
			Iterator<Integer> iter = node[cur].listIterator();
			while (iter.hasNext()) {
				int n = iter.next();
				if (check[n]) continue;
				check[n] = true;
				ans[n] = idx++;
				q.offer(n);

			}
		}
		for (int i = 0; i < check.length; i++) {
			sb.append(ans[i] + "\n");
		}
		System.out.println(sb);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s1 = br.readLine().split(" ");
		int N = Integer.parseInt(s1[0]);
		int M = Integer.parseInt(s1[1]);
		int V = Integer.parseInt(s1[2]);
		//int[][] node = new int[N][N];
		LinkedList<Integer>[] node = new LinkedList[N];
		for (int i = 0; i < N; i++) node[i] = new LinkedList<Integer>();
		boolean[] check = new boolean[N];
		for (int i = 0; i < M; i++) {
			String[] s2 = br.readLine().split(" ");
			int x = Integer.parseInt(s2[0]) - 1;
			int y = Integer.parseInt(s2[1]) - 1;
			//node[x][y] = 1;
			//node[y][x] = 1;
			node[x].add(y);
			node[y].add(x);
		}
		for (int i = 0; i < N; i++) {
			Collections.sort(node[i]);
		}
		bfs(check, node, V - 1);
	}
}

