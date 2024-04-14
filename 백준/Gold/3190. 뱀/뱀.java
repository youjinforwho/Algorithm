import java.util.*;

public class Main {
	public static boolean move(Deque<Integer> dq, int arr[][], int dx, int dy) {
		int x = dq.poll();
		int y = dq.poll();
		dq.addFirst(y);
		dq.addFirst(x);
		dq.addFirst(y + dy);
		dq.addFirst(x + dx);
		boolean flag = false;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < 2; j++) {
				if ((arr[i][0] == (x + dx)) && (arr[i][1] == (y + dy))) {
					flag = true;
					arr[i][0] = -1;
					break;
				}
			}
		}
		return flag;
	}
	
	public static boolean isEnd(Deque<Integer> dq, int N, int dx, int dy) {
		int x = dq.poll();
		int y = dq.poll();
		int turn = 0;
		
		boolean flag = false;
		if ((x  > N) || (x  < 1) || (y  > N) || (y  < 1)) return true;
		Iterator<Integer> iterator = dq.iterator();
		while (iterator.hasNext()) {
			if (turn % 2 == 0) {
				int xx = iterator.next();
				int yy = iterator.next();
				if ((xx == x) && (yy == y)) {
					flag = true;
					break;
				}
			} 
			turn++;
		}
		dq.addFirst(y);
		dq.addFirst(x);
		
		return flag;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int arr[][] = new int[K][2];
		for (int i = 0; i < K; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[i][0] = y;
			arr[i][1] = x;
		}
		int L = sc.nextInt();
		HashMap<Integer, String> map = new HashMap<>();
		for (int i = 0; i < L; i++) {
			int X = sc.nextInt();
			String C = sc.next();
			map.put(X, C);
		}
		sc.close();
		Deque<Integer> dq = new LinkedList<>();
		dq.add(1);
		dq.add(1);
		int time = 0;
		int dir_x[] = {1, 0, -1, 0};
		int dir_y[] = {0, 1, 0, -1};
		int num = 0;
		boolean flag;
		while (true) {
			time += 1;
			flag = move(dq, arr, dir_x[num], dir_y[num]);
			if (isEnd(dq, N, dir_x[num], dir_y[num])) break;
			if (!flag) {
				dq.pollLast();
				dq.pollLast();
			}
			if (map.containsKey(time)) {
				char C = map.get(time).charAt(0);
				if (C == 'D') {
					if (num == 3) num = 0;
					else num += 1;
				} else if (C == 'L') {
					if (num == 0) num = 3;
					else num -= 1;
				}
			}
		}
		System.out.println(time);
	}
}
