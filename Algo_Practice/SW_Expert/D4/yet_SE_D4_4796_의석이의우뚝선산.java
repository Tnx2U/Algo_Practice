package D4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class yet_SE_D4_4796_의석이의우뚝선산 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			List<Mount> list = new ArrayList<>();
			int ans = 0;
			int N = sc.nextInt();
			int[] arr = new int[N];
			
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			
			int srt = 0;
			
			for (int i = 0; i < arr.length-1; i++) {
				if(arr[i] < arr[i+1]) {
					srt = i;
					break;
				}
			}
			
			boolean isDesc = false;
			int srt_idx = srt;
			int top_idx = -1;
			int end_idx = -1;
			
			//봉우리 세어서 리스트에 추가
			for (int i = srt; i < arr.length-1; i++) {
				if(!isDesc && arr[i] > arr[i+1]) {//내리막길 시작 == 꼭대기
					top_idx = i;
					isDesc = true;
					if(i == arr.length-2) {
						end_idx = i+1;
						list.add(new Mount(srt_idx, top_idx, end_idx));
						break;
					}
				}else if(isDesc && arr[i] < arr[i+1]) {//오르막길 시작 == 끝,시작
					end_idx = i;
					list.add(new Mount(srt_idx, top_idx, end_idx));
					srt_idx = end_idx;
					isDesc = false;
					if(i == arr.length-2) {
						break;
					}
				}
			}
			
			if(!list.isEmpty()) {
				for (int i = 0; i < list.size(); i++) {
					int a = list.get(i).top - list.get(i).srt;
					int b = list.get(i).end - list.get(i).top;
					ans += a*b;
				}
			}
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	static class Mount{
		int srt,top,end;

		public Mount(int srt, int top, int end) {
			this.srt = srt;
			this.top = top;
			this.end = end;
		}
	}
}
