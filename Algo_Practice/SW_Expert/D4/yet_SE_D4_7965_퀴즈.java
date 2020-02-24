package D4;

import java.math.BigInteger;
import java.util.Scanner;

public class yet_SE_D4_7965_퀴즈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			long ans = 0;
			long N = sc.nextLong();
			BigInteger result = new BigInteger("0");
			
			for (long i = 1; i <= N; i++) {
				BigInteger a = new BigInteger(Long.toString(i));
				BigInteger b = new BigInteger(Long.toString(i));
				for (long j = 1; j < i; j++) {
					if(a.compareTo(new BigInteger("100000000000")) >= 1) {
						String str = a.toString();
						a = new BigInteger(str.substring(str.length()-12,str.length()));
					}
					a = a.multiply(b);
					
				}
				if(result.compareTo(new BigInteger("100000000000")) >= 1) {
					String str = result.toString();
					result = new BigInteger(str.substring(str.length()-12,str.length()));
				}
				result = result.add(a);
			}
			
			ans = result.remainder(new BigInteger("1000000007")).longValue();
			
			System.out.println("#"+tc+" "+ans);
		}
	}
}
