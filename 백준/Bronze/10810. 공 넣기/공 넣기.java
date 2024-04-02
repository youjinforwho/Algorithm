import java.util.Scanner;
 
class Main {
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        int[] arr = new int[N];
        
        for(int idx = 0; idx < M; idx++) {
            int i = sc.nextInt() - 1;
            int j = sc.nextInt() - 1;
            int k = sc.nextInt();
            
            for (int ball = i; ball <= j; ball++) {
                arr[ball] = k;
            }
        }
        
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
