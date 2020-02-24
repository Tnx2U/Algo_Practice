package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class yet_SE_D3_7732_시간개념 {
	static int ans;
	static int total;
	static int H,W,N;
	//static List<Square> list = new ArrayList<>();
	static Square[] sqr_arr;
	static boolean[] visit;
	static boolean alright;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(br.readLine());
		sqr_arr = new Square[N];
		ans = 0;
		visit = new boolean[N];
		
		// 스티커 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			sqr_arr[i] = new Square(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		
		doComb(0,0); // 스티커 2개씩 뽑는 조합
		
		System.out.println(ans);
	}
	
	private static void doComb(int count, int target) {
		if(count == 2) {
			getPlain();
			return;
		}
		if(target == N) 
			return;
		
		visit[target] = true;
		doComb(count+1,target+1);
		visit[target] = false;
		doComb(count,target+1);
	}

	private static void getPlain() {
		Square[] cdd = new Square[2];
		int idx = 0;
		
		for (int i = 0; i < N; i++) {
			if(visit[i])
				cdd[idx++] = sqr_arr[i];
		}
		
		// 모눈종이 양 대칭 모서리에 배치하여 돌리기
		alright = false;
		putSticker(cdd[0].height,cdd[0].width,cdd[1].height,cdd[1].width);
		if(alright) {
			ans = Math.max(ans, cdd[0].plain+cdd[1].plain);
			return;
		}
		putSticker(cdd[0].width,cdd[0].height,cdd[1].height,cdd[1].width);
		if(alright) {
			ans = Math.max(ans, cdd[0].plain+cdd[1].plain);
			return;
		}
		putSticker(cdd[0].height,cdd[0].width,cdd[1].width,cdd[1].height);
		if(alright) {
			ans = Math.max(ans, cdd[0].plain+cdd[1].plain);
			return;
		}
		putSticker(cdd[0].width,cdd[0].height,cdd[1].width,cdd[1].height);
		
		if(alright) {
			ans = Math.max(ans, cdd[0].plain+cdd[1].plain);
			return;
		}
	}

	//스티커 붙일 수 있는지 확인
	private static void putSticker(int height, int width, int height2, int width2) {
		if(height > H || height2 > H || width > W || width2 > W) {
			alright = false;
			return;
		}
		boolean widOK = true;
		boolean heiOK = true;
		
		if(height+height2 > H)
			heiOK = false;
		if(width+width2 > W)
			widOK = false;
		
		if(heiOK || widOK)
			alright = true;
	}

	static class Square{
		int width;
		int height;
		int plain;
		
		public Square(int height, int width) {
			this.width = width;
			this.height = height;
			this.plain = width * height;
		}
	}
}
