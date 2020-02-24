package D6;

import java.util.Scanner;

public class SE_D6_1266_소수완제품확률 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			double ans = 0;
			double A = sc.nextDouble();
			double B = sc.nextDouble();
			
			double AP = 0;
			double BP = 0;
			
			
			for (int i = 0; i <= 18; i++) {
				if(!isPrime(i)) {
					AP += Math.pow(A/100.0, i)*Math.pow(1-A/100.0, 18-i)*getComb(i);
				}
			}
			for (int i = 0; i <= 18; i++) {
				if(!isPrime(i)) {
					BP += Math.pow(B/100.0, i)*Math.pow(1-B/100.0, 18-i)*getComb(i);
				}
			}
			
			ans = 1.0 - AP*BP;
			
			
			System.out.println("#" + t + " "+String.format("%.6f", ans));
		}
	}

	private static long getComb(long i) {
		return factorial(18)/(factorial(i)*factorial(18-i));
	}
	
	private static long factorial(long i) {
		long ans = 1;
		for (long j = 1; j <= i; j++) {
			ans *= j;
		}
		return ans;
	}

	private static boolean isPrime(int i) {
		if(i == 0 || i == 1)
			return false;
		for (int j = 2; j < i; j++) {
			if(i%j==0)
				return false;
		}
		return true;
	}
}

