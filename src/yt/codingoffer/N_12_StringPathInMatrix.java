package yt.codingoffer;

public class N_12_StringPathInMatrix {
	
	static int pathLength = 0;
	
	private static boolean hasPath(char[][] matrix, String str) {
		if (matrix == null || str == null || str.length() < 0) {
			return false;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		char[] chs = str.toCharArray();
		
		boolean[][] visited = new boolean[rows][cols];
		
		pathLength = 0;
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (hasPathCore(matrix, i, j, visited, chs)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	private static boolean hasPathCore(char[][] matrix, int row, int col, boolean[][] visited, char[] chs) {
		
		if (pathLength == chs.length) {
			return true;
		}
		
		boolean isValid = false;
		if (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length
				&& matrix[row][col] == chs[pathLength] && !visited[row][col]) {
			pathLength++;
			visited[row][col] = true;
			
			isValid = hasPathCore(matrix, row, col-1, visited, chs)
					|| hasPathCore(matrix, row, col+1, visited, chs)
					|| hasPathCore(matrix, row-1, col, visited, chs)
					|| hasPathCore(matrix, row+1, col, visited, chs);
			
			if (!isValid) {
				pathLength--;
				visited[row][col] = false;
			}
		}
		
		return isValid;
	}
	
	
	// ====================测试代码====================
	private static void test(String testName, char[][] matrix, String str, boolean expected)
	{
	    if(testName != null)
	        System.out.printf("%s begins: ", testName);

	    if(hasPath(matrix, str) == expected)
	    	System.out.printf("Passed.\n");
	    else
	    	System.out.printf("FAILED.\n");
	}

	//ABTG
	//CFCS
	//JDEH

	//BFCE
	private static void test1()
	{
	    char[][] matrix = {{'A', 'B', 'T', 'G'}, {'C', 'F', 'C', 'S'}, {'J', 'D', 'E', 'H'}};
	    String str = "BFCE";

	    test("Test1", matrix, str, true);
	}

	//ABCE
	//SFCS
	//ADEE

	//SEE
	private static void test2()
	{
		char[][] matrix = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
	    String str = "SEE";

	    test("Test2", matrix, str, true);
	}

	//ABTG
	//CFCS
	//JDEH

	//ABFB
	private static void test3()
	{
		char[][] matrix = {{'A', 'B', 'T', 'G'}, {'C', 'F', 'C', 'S'}, {'J', 'E', 'D', 'H'}};
	    String str = "ABFB";

	    test("Test3", matrix, str, false);
	}

	//ABCEHJIG
	//SFCSLOPQ
	//ADEEMNOE
	//ADIDEJFM
	//VCEIFGGS

	//SLHECCEIDEJFGGFIE
	private static void test4()
	{
		char[][] matrix = {{'A', 'B', 'C', 'E', 'H', 'J', 'I', 'G'}, 
				{'S', 'F', 'C', 'S', 'L', 'O', 'P', 'Q'}, 
				{'A', 'D', 'E', 'E', 'M', 'N', 'O', 'E'},
				{'A', 'D', 'I', 'D', 'E', 'J', 'F', 'M'},
				{'V', 'C', 'E', 'I', 'F', 'G', 'G', 'S'}};
	    String str = "SLHECCEIDEJFGGFIE";

	    test("Test4", matrix, str, true);
	}

	//ABCEHJIG
	//SFCSLOPQ
	//ADEEMNOE
	//ADIDEJFM
	//VCEIFGGS

	//SGGFIECVAASABCEHJIGQEM
	private static void test5()
	{
		char[][] matrix = {{'A', 'B', 'C', 'E', 'H', 'J', 'I', 'G'}, 
				{'S', 'F', 'C', 'S', 'L', 'O', 'P', 'Q'}, 
				{'A', 'D', 'E', 'E', 'M', 'N', 'O', 'E'},
				{'A', 'D', 'I', 'D', 'E', 'J', 'F', 'M'},
				{'V', 'C', 'E', 'I', 'F', 'G', 'G', 'S'}};
	    String str = "SGGFIECVAASABCEHJIGQEM";

	    test("Test5", matrix, str, true);
	}

	//ABCEHJIG
	//SFCSLOPQ
	//ADEEMNOE
	//ADIDEJFM
	//VCEIFGGS

	//SGGFIECVAASABCEEJIGOEM
	private static void test6()
	{
		char[][] matrix = {{'A', 'B', 'C', 'E', 'H', 'J', 'I', 'G'}, 
				{'S', 'F', 'C', 'S', 'L', 'O', 'P', 'Q'}, 
				{'A', 'D', 'E', 'E', 'M', 'N', 'O', 'E'},
				{'A', 'D', 'I', 'D', 'E', 'J', 'F', 'M'},
				{'V', 'C', 'E', 'I', 'F', 'G', 'G', 'S'}};
	    String str = "SGGFIECVAASABCEEJIGOEM";

	    test("Test6", matrix, str, false);
	}

	//ABCEHJIG
	//SFCSLOPQ
	//ADEEMNOE
	//ADIDEJFM
	//VCEIFGGS

	//SGGFIECVAASABCEHJIGQEMS
	private static void test7()
	{
		char[][] matrix = {{'A', 'B', 'C', 'E', 'H', 'J', 'I', 'G'}, 
				{'S', 'F', 'C', 'S', 'L', 'O', 'P', 'Q'}, 
				{'A', 'D', 'E', 'E', 'M', 'N', 'O', 'E'},
				{'A', 'D', 'I', 'D', 'E', 'J', 'F', 'M'},
				{'V', 'C', 'E', 'I', 'F', 'G', 'G', 'S'}};
	    String str = "SGGFIECVAASABCEHJIGQEMS";

	    test("Test7", matrix, str, false);
	}

	//AAAA
	//AAAA
	//AAAA

	//AAAAAAAAAAAA
	private static void test8()
	{
	    char[][] matrix = {{'A', 'A', 'A', 'A'}, {'A', 'A', 'A', 'A'}, {'A', 'A', 'A', 'A'}};
	    String str = "AAAAAAAAAAAA";

	    test("Test8", matrix, str, true);
	}

	//AAAA
	//AAAA
	//AAAA

	//AAAAAAAAAAAAA
	private static void test9()
	{
		char[][] matrix = {{'A', 'A', 'A'}, {'A', 'A', 'A'}, {'A', 'A', 'A'}};
		String str = "AAAAAAAAAAAAA";

	    test("Test9", matrix, str, false);
	}

	//A

	//A
	private static void test10()
	{
	    char[][] matrix = {{'A'}};
	    String str = "A";

	    test("Test10", matrix, str, true);
	}

	//A

	//B
	private static void test11()
	{
		char[][] matrix = {{'A'}};
	    String str = "B";

	    test("Test11", matrix, str, false);
	}

	private static void test12()
	{
		test("Test12", null, null, false);
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
		test10();
		test11();
		test12();
	}
}
