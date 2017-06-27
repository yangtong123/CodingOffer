package yt.codingoffer;

public class N_13_RobotMove {
	private static int movingCount(int threshold, int m, int n) {
		if (threshold < 0 || m <= 0 || n <= 0) {
			return 0;
		}
		
		boolean[][] visited = new boolean[m][n];
		
		int count = movingCountCore(threshold, m, n, 0, 0, visited);
		
		return count;
	}
	
	private static int movingCountCore(int threshold, int m, int n, 
			int row, int col, boolean[][] visited) {
		int count = 0;
		if (check(threshold, m, n, row, col, visited)) {
			visited[row][col] = true;
			count = 1 + movingCountCore(threshold, m, n, row-1, col, visited)
					+ movingCountCore(threshold, m, n, row+1, col, visited)
					+ movingCountCore(threshold, m, n, row, col-1, visited)
					+ movingCountCore(threshold, m, n, row, col+1, visited);
		}
		
		return count;
	}
	
	private static boolean check(int threshold, int m, int n, 
			int row, int col, boolean[][] visited) {
		if (row >= 0 && row < m && col >= 0 && col < n
				&& getDigitSum(row) + getDigitSum(col) <= threshold
				&& !visited[row][col]) {
			return true;
		}
		
		return false;
	}
	
	private static int getDigitSum(int number) {
		int sum = 0;
		while (number > 0) {
			sum += number % 10;
			number /= 10;
		}
		return sum;
	}
	
	// ====================测试代码====================
	private static void test(String testName, int threshold, int rows, int cols, int expected)
	{
	    if(testName != null)
	        System.out.printf("%s begins: ", testName);

	    if(movingCount(threshold, rows, cols) == expected)
	    	System.out.printf("Passed.\n");
	    else
	    	System.out.printf("FAILED.\n");
	}

	// 方格多行多列
	private static void test1()
	{
	    test("Test1", 5, 10, 10, 21);
	}

	// 方格多行多列
	private static void test2()
	{
	    test("Test2", 15, 20, 20, 359);
	}

	// 方格只有一行，机器人只能到达部分方格
	private static void test3()
	{
	    test("Test3", 10, 1, 100, 29);
	}

	// 方格只有一行，机器人能到达所有方格
	private static void test4()
	{
	    test("Test4", 10, 1, 10, 10);
	}

	// 方格只有一列，机器人只能到达部分方格
	private static void test5()
	{
	    test("Test5", 15, 100, 1, 79);
	}

	// 方格只有一列，机器人能到达所有方格
	private static void test6()
	{
	    test("Test6", 15, 10, 1, 10);
	}

	// 方格只有一行一列
	private static void test7()
	{
	    test("Test7", 15, 1, 1, 1);
	}

	// 方格只有一行一列
	private static void test8()
	{
	    test("Test8", 0, 1, 1, 1);
	}

	// 机器人不能进入任意一个方格
	private static void test9()
	{
	    test("Test9", -10, 10, 10, 0);
	}

	
	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		test5();
		test6();
		test7();
		test8();
		test9();
	}
}
