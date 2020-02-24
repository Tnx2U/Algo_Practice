import java.util.LinkedList;
import java.util.Queue;

public class Solution1 {
	public static void main(String[] args) {
		int[][] goods = {{25400, 2}, {10000, 1}, {31600, 1}};
		int[][] coupons = {{5, 3}, {23, 2}, {11, 2}, {9, 5}};
		
		System.out.println(solution(goods, coupons));
	}
	
	public static long solution(int[][] goods, int[][] coupons) {
		long answer = 0;
		LinkedList<Integer> couponList = new LinkedList<>();
		LinkedList<Integer> goodList = new LinkedList<>();
		for (int i = 0; i < coupons.length; i++) {
			for (int j = 0; j < coupons[i][1]; j++) {
				couponList.add(coupons[i][0]);
			}
		}
		
		for (int i = 0; i < goods.length; i++) {
			for (int j = 0; j < goods[i][1]; j++) {
				goodList.add(goods[i][0]);
			}
		}
		
		couponList.sort(null);
		goodList.sort(null);
		
		int numOfgoods = goodList.size();

		for (int i = 0; i < numOfgoods; i++) {
			int price = goodList.remove(goodList.size()-1);
			if(!couponList.isEmpty()) {
				int sale = couponList.remove(couponList.size()-1);
				answer += price * (100 - sale)/100;
			}else {
				answer += price;
			}
		}
		
		return answer;
	}
}
