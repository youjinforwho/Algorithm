import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] top = new int[N];
        for (int i = 0; i < N; i++) {
            top[i] = Integer.parseInt(s[i]);
        }
        StringBuilder sb = new StringBuilder();
        
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < N; i++) {
            int temp = top[i];
            if (st.isEmpty()) {
                sb.append("0 ");
                st.push(i);
                continue;
            }
            while (!st.isEmpty()) {
                if (top[st.peek()] >= temp) {
                    sb.append((st.peek() + 1) + " ");
                    st.push(i);
                    break;
                }
                st.pop();
            }
            if (st.isEmpty()) {
                sb.append("0 ");
                st.push(i);
            }
        }
        System.out.println(sb);
    }
}