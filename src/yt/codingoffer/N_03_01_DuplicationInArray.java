package yt.codingoffer;

public class N_03_01_DuplicationInArray {
	private static void duplicate(int[] numbers, int length) {
		if (numbers == null || length <= 0) {
			return ;
		}
		
		for (int i = 0; i < length; i++) {
			if (numbers[i] < 0 || numbers[i] > length - 1) {
				return ;
			}
		}
		
		for (int i = 0; i < length; i++) {
			while (numbers[i] != i) {
				if (numbers[i] == numbers[numbers[i]]) {
					System.out.println(numbers[i]);
					return;
				} else {
					// 交换
					int temp = numbers[i];
					numbers[i] = numbers[temp];
					numbers[temp] = temp;
				}
				
			}
		}
	}
	
	public static void main(String[] args) {
		duplicate(new int[]{2,3,1,0,2,5,3}, 7);
	}
}
