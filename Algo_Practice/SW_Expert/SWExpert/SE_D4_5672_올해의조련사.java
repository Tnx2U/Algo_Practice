package SWExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SE_D4_5672_올해의조련사 {
	static StringBuilder sb;
	static StringBuilder sb2;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			sb = new StringBuilder();
			sb2 = new StringBuilder();
			
			for (int i = 0; i < N; i++) {
				sb.append(br.readLine());
			}
			
			for (int i = 0; i < N; i++) {
				if(sb.charAt(0) > sb.charAt(sb.length()-1)) { //뒤쪽이 더 빠를 경우
					sb2.append(sb.charAt(sb.length()-1));
					sb.deleteCharAt(sb.length()-1);
				}else if(sb.charAt(0) < sb.charAt(sb.length()-1)){ //앞쪽이 더 빠를 경우
					sb2.append(sb.charAt(0));
					sb.deleteCharAt(0);
				}else { // 앞뒤가 같은 알파벳일 경우
					if(findFaster(0,sb.length()-1)) {
						sb2.append(sb.charAt(0));
						sb.deleteCharAt(0);
					}else {
						sb2.append(sb.charAt(sb.length()-1));
						sb.deleteCharAt(sb.length()-1);
					}
				}
			}
			
			System.out.println("#"+tc+" "+sb2.toString());
		}
	}
	//장래 가능성을 보고 어느 알파벳을 뽑아야 하는지 알려주는 함수 true리턴시 앞쪽, false시 뒤쪽
	private static boolean findFaster(int i, int j) { 
		if(i >= j) { //앞쪽 인덱스가 더 크거나같은 경우
			return true;
		}
		
		if(sb.charAt(i) < sb.charAt(j)) {
			return true;
		}else if(sb.charAt(i) > sb.charAt(j)) {
			return false;
		}else {
			return findFaster(i+1, j-1);
		}
	}
}
