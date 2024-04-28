import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int M = Integer.parseInt(br.readLine());
    	HashSet<String> set = new HashSet<>();
    	StringBuilder sb = new StringBuilder();
    	List<String> all = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"));
    	while (M-- > 0) {
    		String[] s = br.readLine().split(" ");
    		switch(s[0]) {
    		case "all":
    			set.clear();
    			set.addAll(all);
    			break;
    		case "empty":
    			set.clear();
    			break;
    		case "add":
    			set.add(s[1]);
    			break;
    		case "remove":
    			set.remove(s[1]);
    			break;
    		case "check":
    			if (set.contains(s[1])) sb.append("1\n");
    			else sb.append("0\n");
    			break;
    		case "toggle":
    			if (!set.contains(s[1]))set.add(s[1]);
    			else set.remove(s[1]);
    			break;
    		}
    	
    	}
    	System.out.println(sb);
    }
}