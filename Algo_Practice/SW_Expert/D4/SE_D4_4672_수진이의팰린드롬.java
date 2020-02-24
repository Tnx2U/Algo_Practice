package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SE_D4_4672_수진이의팰린드롬 {
	static int ans;
	static StringBuilder origin;
	static StringBuilder fix;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			int[] apb_cnt = new int[26];
			origin = new StringBuilder();
			fix = new StringBuilder();
			ans = 0;
			origin.append(br.readLine());
			// 알파벳 카운트
			for (int i = 0; i < origin.length(); i++) {
				apb_cnt[origin.charAt(i) - 'a']++;
			}
			
			for (int i = 0; i < apb_cnt.length; i++) {
				if(apb_cnt[i] != 0) {
					for (int j = 0; j < apb_cnt[i]; j++) {
						fix.append((char)('a'+i));
					}
				}
			}
			//부분문자열 추출후 펠린드롬 개수 세기
			for (int i = 0; i < fix.length(); i++) {
				for (int j = i; j < fix.length(); j++) {
					if(isPalindrome(fix.substring(i, j+1))) {
						ans++;
					}
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
	}


	private static boolean isPalindrome(String input) {
		for (int i = 0; i <= (input.length()-1)/2; i++) {
			if(input.charAt(0) != input.charAt(input.length()-1-i))
				return false;
		}
		return true;
	}
}
