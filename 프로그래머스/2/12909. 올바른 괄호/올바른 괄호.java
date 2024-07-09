import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        char[] arr = s.toCharArray();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                st.push('(');                
            } else {
                if (st.isEmpty()) {
                    answer = false;
                    break;
                } else {
                    st.pop();
                }
            }
        }
        if (!st.isEmpty()) answer = false;
        return answer;
    }
}