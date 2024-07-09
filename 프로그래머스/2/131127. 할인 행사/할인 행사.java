import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int total = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
            total += number[i];
        }
        if (discount.length < total) return answer;
        for (int i = 0; i <= discount.length - total; i++) {
            HashMap<String, Integer> check = new HashMap<>(map);
            boolean flag = true;
            for (int j = i; j < i + 10; j++) {
                int cur = check.getOrDefault(discount[j], 0);
                if (cur > 1) {
                    check.put(discount[j], cur - 1);
                } else if (cur == 1) {
                    check.remove(discount[j]);
                }
            }
            if (check.isEmpty()) answer++;
        }
        return answer;
    }
}