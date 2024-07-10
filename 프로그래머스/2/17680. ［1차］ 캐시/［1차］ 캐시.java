import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        ArrayList<String> arr = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        int answer = 0;
        if (cacheSize == 0) return cities.length * 5;
        for (int i = 0; i < cities.length; i++) {
            String s = cities[i].toUpperCase();
            if (set.contains(s)) {
                answer += 1;
                arr.remove(s);
            } else {
                answer += 5;
                if (arr.size() == cacheSize) {
                    set.remove(arr.get(0));
                    arr.remove(0);        
                }
            
            }
            set.add(s);
            arr.add(s);
        }
        
        return answer;
    }
}