package D4;

import java.util.Scanner;

public class yet_SE_D4_3459_승자예측하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			long N = sc.nextLong();
			long x = 1;
			
			boolean isAlice = false;
			
			while(true) {
				if(x > N/2) {
					break;
				}
				if(x > (double)(N/8.0 - 3.0/4.0)) {
					x = 2*x;
				}else {
					x = 2*x+1;
				isAlice = !isAlice;
				}
			}
			String ans = isAlice?"Alice":"Bob";
			System.out.println("#"+tc+" "+ans);
		}
	}
}
