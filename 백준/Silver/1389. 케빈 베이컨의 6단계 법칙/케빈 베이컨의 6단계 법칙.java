import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] link;
	
	public static int bfs(int who) {
		int[] dist = new int[N];
		boolean[] check = new boolean[N];
		
		int kavin = 0;
		Queue<Integer> q = new LinkedList<>();
		q.offer(who);
		check[who] = true;
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 0; i < N; i++) {
				if (!check[i] && link[cur][i] == 1) {
					check[i] = true;
					dist[i] = dist[cur] + 1;
					q.offer(i);
				}
			}
		}
		for (int i = 0; i < N; i++) {
			kavin += dist[i];
		}
		return kavin;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		link = new int[N][N];
		
		for (int i = 0; i < M; i++) {
			String[] s1 = br.readLine().split(" ");
			int x = Integer.parseInt(s1[0]) - 1;
			int y = Integer.parseInt(s1[1]) - 1;
			
			link[x][y] = 1;
			link[y][x] = 1;
		}
		int kavin = 2147483647;
		int temp;
		int res = 0;
		for (int i = 0; i < N; i++) {
			temp = bfs(i);
			if (kavin > temp) {
				kavin = temp;
				res = i + 1;
			}
		}
		System.out.println(res);
	}
	
} 