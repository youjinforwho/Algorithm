import java.util.*;

class Main{
    public static void main(String[] args) {
	    int cnt = 0;    
		
		Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] arr = new int[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int v = sc.nextInt();
        for (int i = 0; i < N; i++) {
        	if (arr[i] == v) {
        		cnt += 1;
        	}
        }
        sc.close();
        
        System.out.println(cnt);
    }
}