package yt.codingoffer;

public class N_11_MinNumberInRotatedArray {
	private static int min(int[] numbers, int length) {
		if (numbers == null || length <= 0) {
			return -1;
		}
		
		int index_1 = 0;
		int index_2 = length - 1;
		int indexMid = index_1;
		
		while (numbers[index_1] >= numbers[index_2]) {
			if (index_2 - index_1 == 1) {
				indexMid = index_2;
				break;
			}
			indexMid = (index_1 + index_2) / 2;
			
			// 如果index_1 index_2 indexMid三个数都相等的话就使用顺序查找法
			if (numbers[index_1] == numbers[index_2] 
					&& numbers[index_1] == numbers[indexMid]) {
				return minInOrder(numbers, index_1, index_2);
			}
			
			if (numbers[indexMid] >= numbers[index_1]) {
				index_1 = indexMid;
			} else if (numbers[indexMid] <= numbers[index_2]) {
				index_2 = indexMid;
			}
		}
		
		return numbers[indexMid];
	}
	
	private static int minInOrder(int numbers[], int index_1, int index_2) {
		int min = numbers[index_1];
		for (int i = index_1 + 1; i <= index_2; i++) {
			if (min > numbers[i]) {
				min = numbers[i];
			}
		}
		return min;
	}
	
	public static void main(String[] args) {
		// 典型输入，单调升序的数组的一个旋转
		int[] array1 = { 3, 4, 5, 1, 2 };
		System.out.println("典型输入，单调升序的数组的一个旋转: ");
		System.out.println(min(array1, 5));
		
		// 有重复数字，并且重复的数字刚好的最小的数字
	    int array2[] = { 3, 4, 5, 1, 1, 2 };
	    System.out.println("有重复数字，并且重复的数字刚好的最小的数字: ");
	    System.out.println(min(array2, 6));
	    
	    // 有重复数字，但重复的数字不是第一个数字和最后一个数字
	    int array3[] = { 3, 4, 5, 1, 2, 2 };
	    System.out.println("有重复数字，但重复的数字不是第一个数字和最后一个数字: ");
	    System.out.println(min(array3, 6));
	    
	    // 有重复的数字，并且重复的数字刚好是第一个数字和最后一个数字
	    int array4[] = { 1, 0, 1, 1, 1 };
	    System.out.println("有重复的数字，并且重复的数字刚好是第一个数字和最后一个数字: ");
	    System.out.println(min(array4, 5));
	    
	    // 单调升序数组，旋转0个元素，也就是单调升序数组本身
	    int array5[] = { 1, 2, 3, 4, 5 };
	    System.out.println("单调升序数组，旋转0个元素，也就是单调升序数组本身: ");
	    System.out.println(min(array5, 5));
	    
	    // 数组中只有一个数字
	    int array6[] = { 2 };
	    System.out.println("数组中只有一个数字");
	    System.out.println(min(array6, 1));
	    
	    
	}
}
