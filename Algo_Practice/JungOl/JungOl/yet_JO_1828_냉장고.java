package JungOl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class yet_JO_1828_냉장고 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int ans = 0;

		List<Range> list = new ArrayList<>();
		int[] range = new int[10271];
		
		for (int i = 0; i < N; i++) {
			int low = sc.nextInt();
			int high = sc.nextInt();
			list.add(new Range(low, high));
			
			for (int j = low+270; j <= high+270; j++) {
				range[j]++;
			}
		}
		
		boolean inNum = false;
		for (int i = 0; i < range.length-1; i++) {
			if(range[i] > range[i+1]) {
				ans++;
				for (int j = 0; j < list.size(); j++) {
					if(i <= list.get(j).high+270 && i >= list.get(j).low+270) {
						for (int srt = list.get(j).low+270; srt <= list.get(j).high+270; srt++) {
							range[srt]--;
						}
					}
				}
			}
			
//			if(inNum) {
//				if(range[i]!=range[i+1]) {
//					inNum = false;
//				}
//			}else {
//				if(range[i]!=range[i+1]) {
//					inNum = true;
//					ans++;
//				}
//			}
			
		}
		
//		List<Range> list = new ArrayList<>();
//		list.add(new Range(sc.nextInt(), sc.nextInt()));
//		
//		for (int i = 0; i < N-1; i++) {
//			int low = sc.nextInt();
//			int high = sc.nextInt();
//			int idx = list.size();
//			for (int j = 0; j < idx; j++) {
//				
//			}
//			
//			for (int j = 0; j < idx; j++) {
//				if(list.get(j).low > low || list.get(j).high < high) {
//					list.add(new Range(low, high));
//				}
//			}
//		}
		
		System.out.println(ans);
	}
	
	static class Range{
		int low;
		int high;
		public Range(int low, int high) {
			this.low = low;
			this.high = high;
		}
	}
}
