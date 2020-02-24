package D2;
import java.util.Scanner;

public class SE_D2_2005_PhascalTriangle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[56];
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int ans = 0;
			
			int N = sc.nextInt();
			int idx = 0;
			
			System.out.println("#"+t);
			
			for (int i = 1; i <= N; i++) {
				for (int j = 0; j < i; j++) {
					if(j==0 || j==i-1 || i == 1) {
						arr[idx++] = 1;
						System.out.print(1+" ");
					}else {
						arr[idx] = arr[idx-i]+arr[idx-(i-1)];
						System.out.print(arr[idx]+" ");
						idx++;
					}
					
				}
				System.out.println();
			}
		}
	}
}
