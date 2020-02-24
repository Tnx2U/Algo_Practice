package lv1;

public class Solution2 {
	public static void main(String[] args) {
		System.out.println(solution("z", 1));
	}
	
	public static String solution(String s, int n) {
		StringBuffer answer = new StringBuffer();
		
		char[] input = s.toCharArray();
		
		for(char c : input) {
			if(c == ' ') {
				answer.append(" ");
			}else if(c >=97 && (c+n) > 122){ //家巩磊 贸府
				char append = (char) (96 + ((c+n) - 122));
				answer.append(append);
			}else if(c < 91 && (char) (c+n) > 90){ // 措巩磊 贸府
				char append = (char) (64 + ((c+n) - 90));
				answer.append(append);
			}else {
				char append = (char) (c+n);
				answer.append(append);
			}
		}
		
		return answer.toString();
	}
}
