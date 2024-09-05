import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        String answer = "";
        for (String s : participant) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String s : completion) {
            map.put(s, map.getOrDefault(s, 0) - 1);
        }
        for (String s : map.keySet()) {
            if (map.get(s) == 1) answer = s;
        }
        return answer;
    }
}