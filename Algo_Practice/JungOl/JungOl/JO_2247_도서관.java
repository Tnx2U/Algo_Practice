package JungOl;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class JO_2247_도서관 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int during = 0;
		int extract = 0;
		
		PriorityQueue<Time> pq = new PriorityQueue<>();
		
		for (int i = 1; i <= N; i++) {
			int left = sc.nextInt();
			int right = sc.nextInt();
			
			pq.add(new Time(left, right));
		}
		
		int in = 0;
		int out = 0;
		boolean using = false;
		
		while(!pq.isEmpty()) {
			Time now = pq.poll();
			if(now.left <= out) { // 입장시간이 이전 사람의 퇴장시간 전이면(겹치면)
				out = Math.max(out, now.right);//퇴장 시간이 더 긴걸로 수정
				during = Math.max(during, out-in);//가장 긴 사용시간 갱신
			}else { // 입장시간이 이전 사람 퇴장시간 이후(아무도 사용 안하는공백 발생)
				extract = Math.max(extract, now.left-out);
				during = Math.max(during, now.length);
				in = now.left;
				out = now.right;
			}
		}
		
		System.out.println(during+" "+extract);
	}
	
	static class Time implements Comparable<Time>{
		int left,right,length;

		public Time(int left, int right) {
			this.left = left;
			this.right = right;
			this.length = right - left;
		}

		@Override
		public int compareTo(Time o) {
			return this.left - o.left;
		}
	}
}
