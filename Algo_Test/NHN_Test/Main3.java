import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Player> players = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			players.add(new Player(0));
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int tern = 0;
		int owner = 0;
		boolean[] already = new boolean[N];
		
		while(st.hasMoreTokens()) {
			already = new boolean[N];
			String cmd = st.nextToken();
			switch(cmd) {
				case "K": 
					int flw = Integer.parseInt(st.nextToken());
					players.get(owner).flws.add(flw);
					break;
				case "A":
					players.get(owner).candy++;
					for(Integer i : players.get(owner).flws) {
						if(!already[i]) {
							players.get(i).candy++;
							already[i] = true;
						}
					}
					break;
				case "Q":
					for (int i = 0; i < N; i++) {
						players.get(i).candy++;
					}
					break;
				case "J":
					List<Integer> cdd = new LinkedList<>();
					if(owner == 0) {
						players.get(owner+1).candy++;
						cdd.add(owner+1);
					}else if(owner == N-1) {
						players.get(owner-1).candy++;
						cdd.add(owner-1);
					}else {
						players.get(owner+1).candy++;
						players.get(owner-1).candy++;
						cdd.add(owner-1);
						cdd.add(owner+1);
					}
					for(Integer target : cdd) {
						for(Integer i : players.get(target).flws) {
							if(!already[i]) {
								players.get(i).candy++;
								already[i] = true;
							}
						}
					}
					break;
			}
			tern++;
			owner = tern%N;
		}
		
		for(Player p : players) {
			System.out.print(p.candy+" ");
		}
	}
	
	static class Player{
		int candy;
		List<Integer> flws;
		
		public Player(int candy) {
			this.candy = candy;
			this.flws = new LinkedList<>();
		}
	}
}
