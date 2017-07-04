package yt.codingoffer;

public class N_21_ReorderArray {
	private static void reorder(int[] data) {
		if (data == null || data.length <= 0) {
			return;
		}
		int begin = 0;
		int end = data.length - 1;
		while (begin < end) {
			if (begin < end && !isEven(data[begin])) {
				begin++;
			}
			if (begin < end && isEven(data[end])) {
				end--;
			}
			if (begin < end) {
				int temp = data[begin];
				data[begin] = data[end];
				data[end] = temp;
			}
		}
		
	}
	
	private static boolean isEven(int n) {
		return (n & 1) == 0;
	}
	
	// ====================测试代码====================
	static void PrintArray(int numbers[], int length)
	{
	    if(length < 0)
	        return;

	    for(int i = 0; i < length; ++i)
	        System.out.printf("%d\t", numbers[i]);

	    System.out.printf("\n");
	}

	static void Test(String testName, int[] numbers)
	{
	    if(testName != null)
	        System.out.printf("%s begins:\n", testName);

	    if (numbers == null)
	    	return;
	    
	    int length = numbers.length;
	    
	    int[] copy = new int[length];
	    for(int i = 0; i < length; ++i)
	    {
	        copy[i] = numbers[i];
	    }

	    System.out.printf("Test for solution 1:\n");
	    PrintArray(numbers, length);
	    reorder(numbers);
	    PrintArray(numbers, length);

	    
	}

	static void Test1()
	{
	    int numbers[] = {1, 2, 3, 4, 5, 6, 7};
	    Test("Test1", numbers);
	}

	static void Test2()
	{
	    int numbers[] = {2, 4, 6, 1, 3, 5, 7};
	    Test("Test2", numbers);
	}

	static void Test3()
	{
	    int numbers[] = {1, 3, 5, 7, 2, 4, 6};
	    Test("Test3", numbers);
	}

	static void Test4()
	{
	    int numbers[] = {1};
	    Test("Test4", numbers);
	}

	static void Test5()
	{
	    int numbers[] = {2};
	    Test("Test5", numbers);
	}

	static void Test6()
	{
	    Test("Test6", null);
	}
	
	public static void main(String[] args) {
		Test1();
		Test2();
		Test3();
		Test4();
		Test5();
		Test6();
	}
}
