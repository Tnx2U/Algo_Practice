package D3;
import java.util.Arrays;
import java.util.Scanner;

public class SE_D3_6718 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int ans = 0;
			int input = scan.nextInt();
			
			if(input >= 1000000) {
				ans = 5;
			}else if(input >= 100000) {
				ans = 4;
			}else if(input >= 10000) {
				ans = 3;
			}else if(input >= 1000) {
				ans = 2;
			}else if(input >= 100) {
				ans = 1;
			}else {
				ans = 0;
			}
			
			System.out.println("#"+t+" "+ans);
			
			int[] a = {1,4,6,4,5,3,5};
			Arrays.sort(a);
		}
	}
}
