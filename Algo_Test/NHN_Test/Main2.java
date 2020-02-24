import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		FQ fq = new FQ();
		for (int idx = 0; idx < N; idx++) {
			String cmd = br.readLine();
			if(cmd.charAt(0) == 'e') {
				fq.enqueue(Integer.parseInt(cmd.split(" ")[1]));
			}else {
				System.out.print(fq.dequeue()+" ");
			}
		}
	}
	
	static class FQ{
		LinkedList<Integer> list = new LinkedList<>();
		int[] cnt = new int[101];
		
		public void enqueue(int input) {
			list.add(input);
			cnt[input]++;
		}

		public int dequeue() {
			if(this.isEmpty())
				return -1;
			
			for(int i=0; i<list.size(); i++) {
				if(this.getMaxCnt() == list.get(i)) { //해당 값이 빈도수 최고이면
					cnt[list.get(i)]--;
					return list.remove(i);
				}
			}
			return -1;
		}
		
		public int getMaxCnt() {
			if(this.isEmpty())
				return -1;
			
			int max = -1;
			int max_idx = -1;
			for (int i = 0; i < cnt.length; i++) {
				if(max < cnt[i]) {
					max = cnt[i];
					max_idx = i;
				}
			}
			return max_idx;
		}
		
		public boolean isEmpty() {
			return (list.size()==0) ? true : false;
		}
	}
}
