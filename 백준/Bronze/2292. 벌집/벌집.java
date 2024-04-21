import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int i = 0;
		int j = 0;
		int cnt = 1;
		while (N > (6 * i + 1)) {
			cnt++;
			i += ++j;
		}
		System.out.println(cnt);
		sc.close();
	}
}

