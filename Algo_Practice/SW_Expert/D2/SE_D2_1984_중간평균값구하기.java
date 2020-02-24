package D2;

import java.util.Arrays;
import java.util.Scanner;

public class SE_D2_1984_중간평균값구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			double ans = 0;
			
			int[] arr = new int[10];
			
			for (int i = 0; i < 10; i++) {
				arr[i] = sc.nextInt();
			}
			
			Arrays.sort(arr);
			
			for (int i = 1; i < arr.length-1; i++) {
				ans += arr[i];
			}
			
			System.out.println("#"+t+" "+Math.round(ans/8));
		}
	}
}
