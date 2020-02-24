package D3;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class yet_SE_D3_7853_오타 {
	static int ans;
	static StringBuilder sb;
	static StringBuilder result;
	static Set<String> set;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = Integer.parseInt(sc.nextLine());
		
		for (int t = 1; t <= T; t++) {
			ans = 1;
			
			set = new HashSet<>();
			sb = new StringBuilder();
			result = new StringBuilder();
			sb.append(sc.nextLine());
			
			if(sb.length() == 1 || sb.length() == 0) {
				ans = sb.length();
			}else {
				perm(1);
				ans = set.size();
			}
			
//			if(sb.length() == 1 || sb.length() == 0) {
//				ans = sb.length();
//			}else {
//				for (int i = 0; i < sb.length(); i++) {
//					if(i == 0) {
//						if(sb.charAt(i) != sb.charAt(i+1))
//							ans *= 2;
//					}else if(i == sb.length()-1) {
//						if(sb.charAt(i) != sb.charAt(i-1))
//							ans *= 2;
//					}else {
//						int count = 1;
//						if(sb.charAt(i-1) != sb.charAt(i))
//							count++;
//						if(sb.charAt(i+1) != sb.charAt(i))
//							count++;
//						if(sb.charAt(i+1) == sb.charAt(i-1) && sb.charAt(i+1) != sb.charAt(i))
//							count--;
//						ans *= count;
//					}
//				}
//			}
			
			
			System.out.println("#"+t+" "+ans);
		}
	}
	private static void perm(int d) {
		if(d == sb.length()-1) {
			makeSentance();
			return;
		}
			result.append(sb.charAt(d));
			perm(d+1);
			result.deleteCharAt(result.length()-1);
			result.append(sb.charAt(d-1));
			perm(d+1);
			result.deleteCharAt(result.length()-1);
			result.append(sb.charAt(d+1));
			perm(d+1);
			result.deleteCharAt(result.length()-1);
		
	}
	private static void makeSentance() {
		set.add(sb.charAt(0)+result.toString()+sb.charAt(sb.length()-2));
		set.add(sb.charAt(1)+result.toString()+sb.charAt(sb.length()-1));
		set.add(sb.charAt(0)+result.toString()+sb.charAt(sb.length()-1));
		set.add(sb.charAt(1)+result.toString()+sb.charAt(sb.length()-2));
		//만들어진 result의 앞뒤에 첫번째와 마지막문자열을 더해주고 set에 삽입
	}
}
