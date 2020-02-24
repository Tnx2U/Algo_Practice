package D4;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SE_D4_4050_재관이의대량할인 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			int ans=0;
			int N = sc.nextInt();
			
			int[] clothes = new int[N];
			
			for (int i = 0; i < N; i++) {
				clothes[i] = sc.nextInt();
			}
			
			Arrays.sort(clothes);
			
			int discount = 1;
			for (int i = N-1; i >= 0; i--) {
				if(discount == 3) {
					discount = 1;
					continue;
				}else {
					ans+=clothes[i];
					discount++;
				}
			}

			System.out.println("#"+tc+" "+ans);
		}
	}
}
