import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] s1 = s.split("");
        int idx = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (idx < s1.length) {
            String n1 = s1[idx++];
            int temp = idx;
            if (n1.equals("{") || n1.equals("}") || n1.equals(",")) continue;
            for (int j = temp; j < s1.length; j++) {
                String n2 = s1[j];
                if (n2.equals("{") || n2.equals("}") || n2.equals(",")) break;
                n1 += n2;
                idx++;
            }
            map.put(Integer.parseInt(n1), map.getOrDefault(Integer.parseInt(n1), 0) + 1);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (o1, o2) -> map.get(o2) - map.get(o1));
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}