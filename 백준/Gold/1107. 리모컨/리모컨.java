import java.util.Scanner;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int channel = Integer.parseInt(br.readLine());
		int case1;
		int case2;
		int case3;
		int M = Integer.parseInt(br.readLine());
		if (M ==0) {
			case1 = Math.abs(100 - channel);
			case2 = (channel+"").length();
			System.out.println(case1 < case2 ? case1 : case2);
			System.exit(0);
		}
		
		String[] broken = br.readLine().split(" ");
		
		if (channel > 100) case1= channel - 100;
		else case1 = 100 - channel;
		int temp = channel;
		int cnt1 = 0;
		int cnt2 = 0;
		
		//가까운 버튼으로 이동 후 + 버튼 누르는 방법
		while (temp != -1 && cnt1 != case1) {
			String check = temp+"";
			boolean flag = true;
			for (String b : broken) {
				if (check.contains(b)) {
					flag = false;
					break;
				}
			}
			if (flag) break;
			cnt1++;
			temp--;
		}
		if (temp != -1) case2 = (temp+"").length() + channel - temp;
		else case2 = 2147483647;
		
		temp = channel;
		//가까운 버튼으로 이동 후 - 버튼 누르는 방법
		while (cnt2 != case1) {
			String check = temp+"";
			boolean flag = true;
			for (String b : broken) {
				if (check.contains(b)) {
					flag = false;
					break;
				}
			}
			if (flag) break;
			temp++;
			cnt2++;
		}
		case3 = (temp+"").length() + temp - channel;
		case1 = (case1 < case2)? case1 : case2;
		case1 = (case1 < case3)? case1 : case3;
		System.out.println(case1);
	}

}