
import java.util.Scanner;

public class BJ_14888_연산자끼워넣기 {
	static int[] opa;
	static int[] num;
	static int[] ans;
	static int N;
	static long Max = Long.MAX_VALUE*-1;
	static long Min = Long.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		num = new int[N];
		ans = new int[N-1];
		opa = new int[4];
		
		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}
		
		for (int i = 0; i < 4; i++) {
			opa[i] = sc.nextInt();
		}
		//입력 끝
		
		doPermutation(0);
		
		System.out.println(Max);
		System.out.println(Min);
	}

	private static void doPermutation(int num_idx) {
		if(num_idx >= N) {
			getMinMax();
			return;
		}
//		doPermutation(num_idx, opa_idx+1);
//		
//		if(opa[opa_idx] != 0) {
//			ans[num_idx] = opa[opa_idx];
//			opa[opa_idx]--;
//			doPermutation(num_idx+1, opa_idx);
//		}
		
		if(opa[0] > 0) {
			opa[0]--;
			ans[num_idx] = 0;
			doPermutation(num_idx+1);
			opa[0]++;
		}
		if(opa[1] > 0) {
			opa[1]--;
			ans[num_idx] = 1;
			doPermutation(num_idx+1);
			opa[1]++;
		}
		if(opa[2] > 0) {
			opa[2]--;
			ans[num_idx] = 2;
			doPermutation(num_idx+1);
			opa[2]++;
		}
		if(opa[3] > 0) {
			opa[3]--;
			ans[num_idx] = 3;
			doPermutation(num_idx+1);
			opa[3]++;
		}
	}

	private static void getMinMax() {
		int result = num[0];
		
		for (int i = 1; i < N; i++) {
			switch(opa[i-1]) {
				case 0:
					result += num[i];
					break;
				case 1:
					result -= num[i];
					break;
				case 2:
					result *= num[i];
					break;
				case 3:
					result /= num[i];
					//음수 나눗셈 주의
					break;
			}
		}
		
		if(Min >= result)
			Min = result;
		if(Max <= result)
			Max = result;
	}
}
