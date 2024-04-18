import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		int num = 665;
		while (N != cnt) {
			num++;
			if (Integer.toString(num).contains("666")) cnt++;
		}
		System.out.println(num);
	}
}
