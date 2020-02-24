import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_3090_MinimumSub {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int[] input = new int[N];
		int[] copy_arr = new int[N];
		
		st = new StringTokenizer(br.readLine()); 
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			copy_arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = Integer.MAX_VALUE;
		
		while(left <= right) {
			int mid = (right - left)/2;
			int cnt = 0;
			System.arraycopy(input, 0, copy_arr, 0, N);
			
			for (int i = 0; i < copy_arr.length-1; i++) {
				if(copy_arr[i+1] - copy_arr[i] > mid) {
					cnt += copy_arr[i+1] - (copy_arr[i] - mid);
					copy_arr[i+1] = copy_arr[i] + mid;
				}
			}
			
			for (int i = N-1; i >= 1; i--) {
				if(copy_arr[i-1] - copy_arr[i] > mid) {
					cnt += copy_arr[i-1] - (copy_arr[i] - mid);
					copy_arr[i-1] = copy_arr[i] + mid;
				}
			}
			
			if(cnt > T) {
				left = mid +1;
			}else {
				right = mid -1;
			}
		}
		
		
		
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
		
	}
	
	
}
