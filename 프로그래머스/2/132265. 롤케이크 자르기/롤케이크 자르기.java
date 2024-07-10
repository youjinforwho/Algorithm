import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> chul = new HashMap<>();
        HashMap<Integer, Integer> dong = new HashMap<>();
        for (int i = 0; i < topping.length; i++) {
            dong.put(topping[i], dong.getOrDefault(topping[i], 0) + 1);
        }
        
        for (int i = 0; i < topping.length; i++) {
            int num = dong.getOrDefault(topping[i] ,0);
            if (num == 1) dong.remove(topping[i]);
            else if (num > 1) dong.put(topping[i], dong.get(topping[i]) - 1);
            chul.put(topping[i], chul.getOrDefault(topping[i], 0) + 1);
            if (chul.size() == dong.size()) answer++;
        }
        return answer;
    }
}