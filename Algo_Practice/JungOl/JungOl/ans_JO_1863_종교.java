package JungOl;

public class ans_JO_1863_종교 {
	static int[] stu;
	static int ans;
	
	public static void main(String[] args) {
		ans = 0;
	}
	
	
	
	static void union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);
		
		if(p1 != p2)
			stu[p2] = p1;
	}
	
	static int find(int n) {
		if(stu[n] == n)
			return n;
		
		int p = find(stu[n]);
		
		return -1;
	}
}
