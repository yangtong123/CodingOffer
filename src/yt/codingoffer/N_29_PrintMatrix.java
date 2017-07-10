package yt.codingoffer;

public class N_29_PrintMatrix {
	private static void printMatrixClockwisely(int[][] numbers) {
		if (numbers == null || numbers.length <= 0 || numbers[0].length <= 0) {
			return;
		}
		int rows = numbers.length;
		int columns = numbers[0].length;
		int start = 0;

		while (columns > start * 2 && rows > start * 2) {
			printMatrixInCircle(numbers, columns, rows, start);
			start++;
		}

	}

	private static void printMatrixInCircle(int[][] numbers, int columns, int rows, int start) {
		int endX = columns - 1 - start;
		int endY = rows - 1 - start;

		// 从左到右打印一行
		for (int i = start; i <= endX; i++) {
			int number = numbers[start][i];
			printNumber(number);
		}

		// 从上到下打印
		if (start < endY) {
			for (int i = start + 1; i <= endY; i++) {
				int number = numbers[i][endX];
				printNumber(number);
			}
		}

		// 从右到左
		if (start < endX && start < endY) {
			for (int i = endX - 1; i >= start; i--) {
				int number = numbers[endY][i];
				printNumber(number);
			}
		}

		// 从下到上
		if (start < endX && start < endY - 1) {
			for (int i = endY - 1; i >= start + 1; i--) {
				int number = numbers[i][start];
				printNumber(number);
			}
		}
	}

	private static void printNumber(int number) {
		System.out.print(number + "\t");
	}

	// ====================测试代码====================
	private static void Test(int columns, int rows) {
		System.out.printf("Test Begin: %d columns, %d rows.\n", columns, rows);

		if (columns < 1 || rows < 1)
			return;

		int[][] numbers = new int[rows][columns];
		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < columns; ++j) {
				numbers[i][j] = i * columns + j + 1;
			}
		}

		printMatrixClockwisely(numbers);
		// printf("\n");
		System.out.println();
	}
	
	public static void main(String[] args) {
		/*
	    1    
	    */
	    Test(1, 1);

	    /*
	    1    2
	    3    4
	    */
	    Test(2, 2);

	    /*
	    1    2    3    4
	    5    6    7    8
	    9    10   11   12
	    13   14   15   16
	    */
	    Test(4, 4);

	    /*
	    1    2    3    4    5
	    6    7    8    9    10
	    11   12   13   14   15
	    16   17   18   19   20
	    21   22   23   24   25
	    */
	    Test(5, 5);

	    /*
	    1
	    2
	    3
	    4
	    5
	    */
	    Test(1, 5);

	    /*
	    1    2
	    3    4
	    5    6
	    7    8
	    9    10
	    */
	    Test(2, 5);

	    /*
	    1    2    3
	    4    5    6
	    7    8    9
	    10   11   12
	    13   14   15
	    */
	    Test(3, 5);

	    /*
	    1    2    3    4
	    5    6    7    8
	    9    10   11   12
	    13   14   15   16
	    17   18   19   20
	    */
	    Test(4, 5);

	    /*
	    1    2    3    4    5
	    */
	    Test(5, 1);

	    /*
	    1    2    3    4    5
	    6    7    8    9    10
	    */
	    Test(5, 2);

	    /*
	    1    2    3    4    5
	    6    7    8    9    10
	    11   12   13   14    15
	    */
	    Test(5, 3);

	    /*
	    1    2    3    4    5
	    6    7    8    9    10
	    11   12   13   14   15
	    16   17   18   19   20
	    */
	    Test(5, 4);
	}
}
