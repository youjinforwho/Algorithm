import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[1000];
		int cnt = 0;
		
		//한수 구하기
		for (int i = 1; i <= 99; i++) {
			arr[cnt++] = i;
		}
		
		for (int i = 100; i<= 999; i++) {
			int num1 = i / 100;
			int num2 = (i % 100)/ 10;
			int num3 = i % 10;
			if (num1 - num2 == num2 - num3) {
				arr[cnt++] = i;
			}
		}
		int answer = 0;
		for (int i = 0; arr[i] <= N && arr[i] != 0; i++) {
			answer++;
		}
		System.out.println(answer);
        sc.close();
	}
}
