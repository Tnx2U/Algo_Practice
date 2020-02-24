package D5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class yet_SE_D5_6782_현주가좋아하는제곱근놀이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			int ans = 0;
			
			long input = Integer.parseInt(br.readLine());
			
			while(true) {
				if(input == 2)
					break;
				
				if(isInt(Math.sqrt(input)))
					input = (long) Math.sqrt(input);
				else {
					input++;
				}
				ans++;
			}
			
			System.out.println("#"+tc+" "+ans);
		}
	}

	private static boolean isInt(double sqrt) {
		long a = (long) sqrt;
		if((sqrt - a) == 0)
			return true;
		else
			return false;
	}
}
