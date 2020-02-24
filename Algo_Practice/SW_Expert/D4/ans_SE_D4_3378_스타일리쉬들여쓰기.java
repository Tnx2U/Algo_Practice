package D4;

import java.util.Arrays;
import java.util.Scanner;

public class ans_SE_D4_3378_스타일리쉬들여쓰기 {
	static int p,q;
	static char[][] master;
	static char[][] me;
	static int[] result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			p = sc.nextInt();
			q = sc.nextInt();
			
			result = new int[q];
			Arrays.fill(result, -2);
			master = new char[p][];
			me = new char[q][];
			
			for (int i = 0; i < p; i++) {
				master[i] = sc.next().toCharArray();
			}
			
			for (int i = 0; i < q; i++) {
				me[i] = sc.next().toCharArray();
			}
			
			for (int r = 1; r <= 20; r++) {
				for (int c = 1; c <=20; c++) {
					for (int s = 1; s <= 20; s++) {
						if(isOK(r,c,s)) { //r,c,s 경우 하나 만들어쓰면 마스터 코드에 적용되는지 확인
							// 내 코드에 적용시켜서 내 코드의 줄에 r,c,s 대입해서 들여쓰기 수 계산.
							useRCS(r,c,s);
						}
					}
				}
			}
			System.out.print("#"+tc+" ");
			for (int r: result) {
				System.out.print(r+" ");
			}
			System.out.println();
		}
	}
	
	static boolean isOK(int r, int c, int s) {
		int rCnt=0, cCnt=0, sCnt=0;
		
		for(int i = 0; i < p; i++) {
			int dotCnt = 0;
			
			for(int j=0; j < master[i].length; j++) {
				if(master[i][j] == '.')
					dotCnt++;
				else
					break;
			} // i번 행의 들여쓰기 갯수 카운트 함.
			
			int tab = r*rCnt + c*cCnt + s*sCnt;
			if(tab != dotCnt)
				return false;
			
			for (int j = 0; j < master[i].length; j++) {
				switch(master[i][j]) {
				case '(': rCnt++; break;
				case ')': rCnt--; break;
				case '{': cCnt++; break;
				case '}': cCnt--; break;
				case '[': sCnt++; break;
				case ']': sCnt--; break;
				}
			}
		}
		return true; //마스터의 p개 행에 모두 대입해봐도 괜찮은 r,c,s다.
	}
	
	static void useRCS(int r, int c, int s) {
		int rCnt=0, cCnt=0, sCnt=0;
		
		for (int i = 0; i < q; i++) {
			if(result[i]==-2) { // 해당 라인에 들여쓰기 계산 처음하네?
				result[i] = r*rCnt + c*cCnt + s*sCnt; // 주어진 r,c,s 와 괄호 갯수로 들여쓰기 계산
			}else {
				if(result[i] != (r*rCnt + c*cCnt + s*sCnt)) {
					result[i] = -1;
				}
			}
			
			for (int j = 0; j < me[i].length; j++) {
				switch(me[i][j]) {
				case '(': rCnt++; break;
				case ')': rCnt--; break;
				case '{': cCnt++; break;
				case '}': cCnt--; break;
				case '[': sCnt++; break;
				case ']': sCnt--; break;
				}
			}
		}
	}
}
