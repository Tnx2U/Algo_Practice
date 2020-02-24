package 하반기_2018;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

//https://www.welcomekakao.com/learn/courses/30/lessons/42890

public class 후보키 {
	static boolean[] selected;
	static HashSet<HashSet> exceptSet;
	static HashSet<Integer> set;
	static String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
	static int result;
	public static void main(String[] args) {
		// 1. �� col�� ����ũ ���� üũ > ����ũ�ϸ� result + 1 , ���� ���� �߰�
		// 2. ���մ�� col���� �����Ͽ� �ߺ��Ǵ��� Ȯ�� > ����ũ�ϸ� result + 1, ���� ���� �߰�
		System.out.println(solution(relation));
	}
	
	public static int solution(String[][] relation) {
		exceptSet = new HashSet<HashSet>();
		result = 0;
        int row_N = relation.length;
        int col_N = 0;
        
        if(relation.length != 0) {
        	col_N = relation[0].length;
        }
        	
        for (int i = 1; i <= col_N; i++) {
        	selected = new boolean[col_N];
        	set = new HashSet<>();
			doCombination(relation, i, col_N, 0);
		}
        return result;
    }

	private static void doCombination(String[][] relation, int remain, int length, int target) {
		if(remain == 0) { //�� �̾��� ���
			set = new HashSet<>();
			for (int i = 0; i < selected.length; i++) {
				if(selected[i])
					set.add(i);
			}
			if(!isContainSet()) {//���� �������� ���ܴ���� �ƴ϶��
				checkKey(relation);
			}
			return;
		}else if(target == length) { // ����
			return;
		}
		
		selected[target] = true;
		doCombination(relation, remain-1, length, target+1);
		selected[target] = false;
		doCombination(relation, remain, length, target+1);
	}

	private static boolean isContainSet() {
		List exceptList = new ArrayList(exceptSet);
		List targetList = new ArrayList(set);
		targetList.sort(null);
		
		for (int i = 0; i < exceptList.size(); i++) {
			List temp = new ArrayList((HashSet<Integer>)exceptList.get(i));
			temp.sort(null);
			for (int j = 0; j < temp.size(); j++) {
				if(!temp.get(j).equals(targetList.get(j))) {
					break;
				}else if(j == temp.size()-1) {
					return true;
				}
			}
		}
		return false;
	}

	private static void checkKey(String[][] relation) {
		//1.
		StringBuffer br;
		HashSet<String> row = new HashSet<String>();
		for (int j = 0; j < relation.length; j++) {
			br = new StringBuffer();
			for(Integer i : set) {
				br.append(relation[j][i]);
				br.append("+");
			}
			if(row.contains(br.toString())) {
				return;
			}else {
				row.add(br.toString());
			}
		}
		result++;
		exceptSet.add(set);
	}
}
