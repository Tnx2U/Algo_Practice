package D3;
import java.util.Scanner;

public class SE_D3_5356_RowReading {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = Integer.parseInt(sc.nextLine());
		
		for (int t = 1; t <= T; t++) {
			String[] inputs = new String[5];
			int max_len = 0;
			
			for (int i = 0; i < inputs.length; i++) {//입력값을 배열에 삽입
				inputs[i] = sc.nextLine();
				if(max_len < inputs[i].length()) //자릿수가 가장 긴 문자열의 길이저장
					max_len = inputs[i].length();
			}
			
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < max_len; i++) {//i번째 자리의 문자를 확인
				for (int j = 0; j < inputs.length; j++) { // j번째줄의 문자열을 확인
					if(i < inputs[j].length())//j번째 줄의 문자열의 길이가 i보다 짧을 경우 예외처리
						sb.append(inputs[j].charAt(i)); //sb에 차례대로 더해준다.
				}
			}
			
			System.out.println("#"+t+" "+sb.toString());
		}
	}
}
