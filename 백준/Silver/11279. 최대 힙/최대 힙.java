import java.util.*;
import java.io.*;

public class Main {
	public static ArrayList<Integer> heap = new ArrayList<Integer>();
	
	static void push(int x) {
		heap.add(x);
		int n = heap.size() - 1;
		while (n > 1 && heap.get(n / 2) < heap.get(n)) {
			int temp = heap.get(n / 2);
			heap.set(n / 2, x);
			heap.set(n, temp);
			n /= 2;
		}
	}
	
	static int pop() {
		if (heap.size() - 1 < 1) {
			return 0;
		}
		
		int deleteItem = heap.get(1);
		
		heap.set(1,  heap.get(heap.size() - 1));
		heap.remove(heap.size() - 1);
		
		int pos = 1;
		
		while ((pos * 2) < heap.size()) {
			int max = heap.get(pos * 2);
			int maxPos = pos * 2;
			
			if (((pos * 2 + 1) < heap.size()) && max < heap.get(pos * 2 + 1)) {
				max = heap.get(pos * 2 + 1);
				maxPos = pos * 2 + 1;
			}
			
			if (max < heap.get(pos)) break;
			int temp = heap.get(pos);
			heap.set(pos, heap.get(maxPos));
			heap.set(maxPos, temp);
			pos = maxPos;
		}
		return deleteItem;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		heap.add(0);
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) sb.append(pop() + "\n");
			else push(n);
		}
		System.out.println(sb);
		
	}
}