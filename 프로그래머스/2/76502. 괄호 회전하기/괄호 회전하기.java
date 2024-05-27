import java.util.*;

class Solution {
    public static boolean check(int idx, char[] arr) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            char cur = arr[idx % arr.length];
            idx++;
            if (!s.isEmpty()) {
                char top = s.pop();
                switch(top) {
                    case '[':
                        if (cur != ']') {
                            s.push(top);
                            s.push(cur);
                        }
                        break;
                    case '(':
                        if (cur != ')') {
                            s.push(top);
                            s.push(cur);
                        }
                        break;
                    case '{':
                        if (cur != '}') {
                            s.push(top);
                            s.push(cur);
                        }
                        break;
                    default:
                        return false;
                }
            } else s.push(cur);
        }
        if (!s.isEmpty()) return false;
        return true;
    }
    public int solution(String s) {
        int answer = 0;
        char[] arr = new char[s.length()];
        for (int i = 0;i < s.length(); i++) {
            arr[i] = s.charAt(i);
        }
        for (int i = 0; i < s.length(); i++) {
            if (check(i, arr)) answer++;
            
        }
        return answer;
    }
}