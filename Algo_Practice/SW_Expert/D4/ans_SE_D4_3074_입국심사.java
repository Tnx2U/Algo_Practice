package D4;

import java.util.Arrays;
import java.util.Scanner;

public class ans_SE_D4_3074_입국심사 {
	static int N;
	static int M;
	static int[] checker;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			checker = new int[N];
			for (int i = 0; i < N; i++) {
				checker[i] = sc.nextInt();
			}
			
			Arrays.sort(checker);
			
			long ans = (long) checker[0]*M; //가정 할 수 있는 최악의 상황중 최솟값
			long left = 0, right= ans;
			
			while(left <= right) {
				long mid = (left+right)/2;
				long people = 0;
				
				for(int time : checker) {
					people += mid/time;
				}
				
				if(people >= M) { //시간이 남으니 너 높은 쪽에 범위잡아야함
					if(ans > mid) //기존의 정답보다 더 짧은 시간안에 가능하면 갱신!
						ans = mid;
					right = mid-1;
				}else {//시간 모자라영
					left = mid +1;
				}
			}
			
			System.out.println("#"+tc+" "+ans);
		}
	}
}
