import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int temp;
		
		sc.close();
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}
		while (q.size() != 1) {
			q.remove();
			temp = q.element();
			if (q.size() != 1) {
				q.remove();
				q.add(temp);
			}
		}
		System.out.println(q.element());
	}
}
