package D2;

import java.util.Scanner;

public class SE_D2_1986_지그재그숫자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int ans = 0;
			int input = sc.nextInt();
			
			for (int i = 1; i <= input; i++) {
				if(i%2 == 0)
					ans -= i;
				else 
					ans += i;
			}
			
			
		
			System.out.println("#"+t+" "+ans);
		}
	}
}
