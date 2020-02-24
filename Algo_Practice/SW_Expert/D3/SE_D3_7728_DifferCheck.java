package D3;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SE_D3_7728_DifferCheck {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int ans = 0;
			
			String input = scan.next();
			
			Map<Character, Integer> map = new HashMap<>();
			
			for (int i = 0; i < input.length(); i++) {
				if(!map.containsKey(input.charAt(i))) {
					map.put(input.charAt(i), 0);
				}
			}
			
			ans = map.size();
			
			System.out.println("#"+t+" "+ans);
		}
	}
}
