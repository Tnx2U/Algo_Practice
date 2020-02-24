package D4;

import java.util.Arrays;
import java.util.Scanner;

public class SE_D4_4408_자기방으로돌아가기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			int ans = 0;
			int N = sc.nextInt();
			int[] duple = new int[201];
			
			for (int i = 0; i < N; i++) {
				int srt = (sc.nextInt()+1)/2;
				int dst = (sc.nextInt()+1)/2;
				
				if(srt < dst) {
					for (int j = srt; j <= dst; j++) 
						duple[j]++;
				}else {
					for (int j = dst; j <= srt; j++) 
						duple[j]++;
				}
			}
			
			Arrays.sort(duple);
			
			ans = duple[duple.length-1];
			
			
			System.out.println("#"+tc+" "+ans);
		}
	}
}
