

import java.util.Arrays;
import java.util.Scanner;

public class BJ_1931_회의실배정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ans = 0;
		
		int N = sc.nextInt();
		
		Meeting[] meetings = new Meeting[N];
		int idx = 0;
		
		for (int i = 0; i < N; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int during = end -start;
			meetings[i] = new Meeting(start, end, during);
		}
		
		Arrays.sort(meetings);
		//System.out.println(Arrays.toString(meetings));
		
		int end = meetings[0].end;
		ans++;
		for (int i = 1; i < meetings.length; i++) {
			if(meetings[i].start >= end) {
				end = meetings[i].end;
				ans++;
			}
		}
		System.out.println(ans);
		
	}
	
	static class Meeting implements Comparable<Meeting>{
		int start;
		int end;
		int during;
		
		public Meeting(int start, int end, int during) {
			this.start = start;
			this.end = end;
			this.during = during;
		}

		@Override
		public int compareTo(Meeting o) {
//			if(this.end == o.end)
//				return this.start - o.start;
//			return this.during - o.during;
			if(end < o.end) {
				return -1;
			}else if(end > o.end) {
				return 1;
			}else {
				return this.start - o.start;
			}
		}
	}
}
