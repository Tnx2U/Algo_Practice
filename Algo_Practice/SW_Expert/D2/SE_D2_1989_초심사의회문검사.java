package D2;

import java.util.Scanner;

public class SE_D2_1989_초심사의회문검사 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = Integer.parseInt(sc.nextLine());
		
		for (int t = 1; t <= T; t++) {
			int ans = 0;
			String inputs = sc.nextLine();
			String reverse = (new StringBuilder(inputs).reverse().toString());
			
			if(inputs.equals(reverse))
				ans = 1;
			
			
			System.out.println("#"+t+" "+ans);
		}
	}
}
