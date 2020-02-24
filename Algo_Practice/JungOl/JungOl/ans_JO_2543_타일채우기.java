package JungOl;

import java.util.Scanner;

public class ans_JO_2543_타일채우기 {
	static int N;
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int hi = sc.nextInt(); // 하수구 i
		int hj = sc.nextInt(); // 하수구 j
		
		map = new int[N][N];
		
		divide(0,0,N,N,hi,hj);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.println(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	static void divide(int si, int sj, int ei, int ej, int hi, int hj) {
		if(ei-si==1)
			return;
		int block = check(si,sj,ei,ej,hi,hj);
		int mi = (si+ej)/2;
		int mj = (sj+ej)/2;
		
		switch(block) {
		case 1: // _|
			map[mi][mj] = map[mi-1][mj] = map[mi][mj-1] = block;
			divide(si,sj,mi,mj,hi,hj);
			divide(si,mj,mi,ej,mi-1,mj);
			divide(mi,sj,ei,mj,mi,mj-1);
			divide(mi,mj,ei,ej,mi,mj);
			break;
		case 2: // |_
			map[mi][mj] = map[mi][mj-1] = map[mi-1][mj] = block;
			divide(si,sj,mi,mj,mi-1,mj-1);
			divide(si,mj,mi,ej,hi,hj);
			divide(mi,sj,ei,mj,mi,mj-1);
			divide(mi,mj,ei,ej,mi,mj);
			break;
		case 3: // `|
			map[mi][mj] = map[mi-1][mj] = map[mi-1][mj-1] = block;
			divide(si,sj,mi,mj,mi-1,mj-1);
			divide(si,mj,mi,ej,mi-1,mj);
			divide(mi,sj,ei,mj,hi,hj);
			divide(mi,mj,ei,ej,mi,mj);
			break;
		case 4: // |`
			map[mi-1][mj] = map[mi-1][mj-1] = map[mi][mj-1] = block;
			divide(si,sj,mi,mj,mi-1,mj-1);
			divide(si,mj,mi,ej,mi-1,mj);                                     
			divide(mi,sj,ei,mj,mi,mj-1);
			divide(mi,mj,ei,ej,hi,hj);
			break;
		}
	}
	
	//si,sj에서 ei,ej 영역 내부를 4분할해서 어떤 영역에 hi,hj가 있는지 리턴한는 메소드
	//s : 맨 왼위쪽, m : 중간, e : 끝쪽
	static int check(int si, int sj, int ei, int ej, int hi, int hj) {
		int mi = (si+ei)/2;
		int mj = (sj+ej)/2;
		
		if(si<=hi && hi<mi && sj<=hj && hj<mj) // 주어진 영역에서 하수구가 1번 구간에 있음
			return 1;
		else if(si<=hi && hi<mi && mj<= hj && hj<ej)
			return 2;
		else if(mi<=hi && hi<ei && sj<=hj && hj<mj)
			return 3;
		else
			return 4;
	}
}
