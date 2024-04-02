import java.util.Scanner;
import java.util.ArrayList;

class Main {
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();
        
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (num < X) {
                arr.add(num);
            }
        }
        sc.close();
        
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
    }
}