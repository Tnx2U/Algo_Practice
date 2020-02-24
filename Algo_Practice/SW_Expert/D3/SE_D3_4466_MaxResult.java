package D3;
import java.util.Arrays;
import java.util.Scanner;

public class SE_D3_4466_MaxResult {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int ans = 0;
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			int[] arr = new int[N];
			
			for (int i = 0; i < arr.length; i++) { //성적값 입력
				arr[i] = sc.nextInt();
			}
			
			Arrays.sort(arr);//정렬
			
			for (int i = N-1; i >= N-K; i--) { //가장 큰 값부터 찾기위해 뒤에서부터 순회한다.
				ans += arr[i];//K번 만큼 더해준다.
			}
			
			System.out.println("#"+t+" "+ans);
		}
	}
}
