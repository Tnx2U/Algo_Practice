package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class yet_SE_D4_3378_스타일리쉬들여쓰기 {
	static int[] ans;
	static StringBuilder[] master;
	static StringBuilder[] mycode;
	static int[] brc_cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			List<Formula> list = new ArrayList<>();
			brc_cnt = new int[3];
			int[] brc_rst = new int[3];
			String pq = br.readLine();
			int P = Integer.parseInt(pq.split(" ")[0]);
			int Q = Integer.parseInt(pq.split(" ")[1]);

			int[] answer = new int[Q];
			master = new StringBuilder[P];

			for (int i = 0; i < P; i++) {
				master[i] = new StringBuilder();
				master[i].append(br.readLine());
			}

			mycode = new StringBuilder[Q];

			for (int i = 0; i < Q; i++) {
				mycode[i] = new StringBuilder();
				mycode[i].append(br.readLine());
			}
			// 입력 끝

			for (int i = 0; i < master.length; i++) {
				int p_cnt = 0;
				
				//.개수 세기
				if(master[i].charAt(0) == '.') {
					for (int j = 0; j < master[i].length(); j++) {
						if(master[i].charAt(0) == '.')
							p_cnt++;
						else
							break;
					}
				}
				
				// 방정식 추가 : 바로 앞 줄에서의 괄호 개수에 대한 .의 개수이므로 순서에 주의
				if(brc_cnt[0]+brc_cnt[1]+brc_cnt[2] != 0 && p_cnt != 0) {
					list.add(new Formula(brc_cnt[0], brc_cnt[0], brc_cnt[0], p_cnt));
				}
				
				//괄호 개수 세기
				for (int j = 0; j < master[i].length(); j++) {
					char now = master[i].charAt(j);
					switch (now) {
					case '(':
						brc_cnt[0]++;
						break;
					case '{':
						brc_cnt[1]++;
						break;
					case '[':
						brc_cnt[2]++;
						break;
					case ')':
						brc_cnt[0]--;
						break;
					case '}':
						brc_cnt[1]--;
						break;
					case ']':
						brc_cnt[2]--;
						break;
					}
				}
			}
			
			// R, C, S 구하기
			for (int a = 1; a <= 20; a++) {
				for (int b = 1; b <= 20; b++) {
					for (int c = 1; c <= 20; c++) {
						boolean fit = true;
						for (int i = 0; i < list.size(); i++) {
							if(list.get(i).a_coe*a + list.get(i).b_coe*b + list.get(i).a_coe*a != list.get(i).result) {
								fit = false;
								break;
							}
							if(i == list.size()-1) {
								brc_rst[0] = a;
								brc_rst[1] = b;
								brc_rst[2] = c;
							}
						}
					}
				}
			}
			
			brc_cnt = new int[3];
			//내 코드에 적용
			for (int i = 0; i < mycode.length; i++) {
				answer[i] = brc_rst[0]*brc_cnt[0] + brc_rst[1]*brc_cnt[1] + brc_rst[2]*brc_cnt[2];
				
				for (int j = 0; j < mycode[i].length(); j++) {
					char now = mycode[i].charAt(j);
					switch (now) {
					case '(':
						brc_cnt[0]++;
						break;
					case '{':
						brc_cnt[1]++;
						break;
					case '[':
						brc_cnt[2]++;
						break;
					case ')':
						brc_cnt[0]--;
						break;
					case '}':
						brc_cnt[1]--;
						break;
					case ']':
						brc_cnt[2]--;
						break;
					}
				}
			}
			
			// -1일때 예외처리 코드 추가하셈
			
			System.out.print("#" + " " + tc);
			for (int i = 0; i < answer.length; i++) {
				System.out.print(" "+answer[i]);
			}
			System.out.println();
		}
	}
	
	static class Formula{
		int a_coe, b_coe, c_coe;
		int result;

		public Formula(int a_coe, int b_coe, int c_coe, int result) {
			this.a_coe = a_coe;
			this.b_coe = b_coe;
			this.c_coe = c_coe;
			this.result = result;
		}
	}
}
