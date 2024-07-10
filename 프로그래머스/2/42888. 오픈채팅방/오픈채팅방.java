import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        int len = 0;
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < record.length; i++) {
            String[] s = record[i].split(" ");
            String mode = s[0];
            String uid = s[1];
            if (mode.equals("Enter") || mode.equals("Change")) map.put(uid, s[2]);
            if (mode.equals("Enter") || mode.equals("Leave")) len++;

        }
        String[] answer = new String[len];
        int idx = 0;
        for (int i = 0; i < record.length; i++) {
            String[] s = record[i].split(" ");
            String mode = s[0];
            String uid = s[1];
            if (mode.equals("Change")) continue;
            if (mode.equals("Enter")) {
                answer[idx++] = map.get(uid) + "님이 들어왔습니다.";
            } else {
                answer[idx++] = map.get(uid) + "님이 나갔습니다.";
            }
        }
    
        return answer;
    }
}