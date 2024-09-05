import java.util.*;

public class Solution {
    public int[] solution(int []arr) {

        Stack<Integer> st = new Stack<>();
        for (int i : arr) {
            if (!st.isEmpty()) {
                if (st.peek() == i) st.pop(); 
            }
            st.push(i);
        }
        int size = st.size();
        int[] answer = new int[size];
        while (!st.isEmpty()) answer[--size] = st.pop();
        return answer;
    }
}