
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
	static Queue<Integer> q = new LinkedList<>();
	static int N, M;
	static int[][] party;
	static boolean[] check_party;
	static boolean[] check_people;
	static int ans = 0;
	
	public static void bfs() {
		while(!q.isEmpty()) {
			//거짓말을 아는 사람
			int cur = q.poll();
			
			for (int i = 0; i < M; i++) {
				
				//아는 사람이 파티에 갔는지 확인
				if (party[cur][i] == 1 && !check_party[i]) {
					check_party[i] = true;
					ans++;
					
					//파티에 갔던 사람을 모두 조사
					for (int j = 0; j < N; j++) {
						if (!check_people[j] && party[j][i] == 1) {
							check_people[j] = true;
							q.offer(j);
						}
					}
				}
				
			}
			
		}
	}
	
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		
		party = new int[N][M];
		check_people = new boolean[N];
		check_party = new boolean[M];
		
		String[] s1 = br.readLine().split(" ");
		int who = Integer.parseInt(s1[0]);
		for (int i = 0; i < who; i++) {
			int know = Integer.parseInt(s1[i + 1]) - 1;
			q.offer(know);
			check_people[know] = true;
		}
		for (int i = 0; i < M; i++) {
			String[] s2 = br.readLine().split(" ");
			int come = Integer.parseInt(s2[0]);
			for (int j = 0; j < come; j++) {
				int num = Integer.parseInt(s2[j + 1]) - 1;
				party[num][i] = 1;
			}
		}
		bfs();
		System.out.println(M - ans);
		
	}
}