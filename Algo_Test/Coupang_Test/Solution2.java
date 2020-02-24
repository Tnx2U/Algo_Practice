
public class Solution2 {
	static int answer;
	static boolean[] selected;
	public static void main(String[] args) {
		int[] arr = {1,2,3,2};
		int k = 2;
		int t = 2;
		System.out.println(solution(arr, k, t));
	}
	
	public static long solution(int[] arr, int k, int t) {
		answer = 0;
		
		for (int i = k; i <= arr.length; i++) {
			selected = new boolean[arr.length];
			doCombination(arr, i, 0, t);
		}
		
		return answer;
	}

	private static void doCombination(int[] arr, int remain, int target, int t) {
		if(remain == 0) { //다 뽑았을 경우
			int price = 0;
			for (int i = 0; i < arr.length; i++) {
				if(selected[i]) {
					price += arr[i];
				}
			}
			if(price <= t)
				answer++;
			return;
		}else if(target == arr.length) { // 실패
			return;
		}
		
		selected[target] = true;
		doCombination(arr, remain-1, target+1,t);
		selected[target] = false;
		doCombination(arr, remain, target+1,t);
	}
}
