package yt.codingoffer;

/**
 * @author yangtong.hust@gmail.com
 * @date 2019/3/2 13:02
 */
public class N_04_FindInPartiallySortedMatrix {

    public static boolean find(int[][] matrix, int rows, int columns, int number) {
        boolean flag = false;

        if (matrix != null && rows > 0 && columns > 0) {
            int row = 0;
            int column = columns - 1;
            while (row < rows && column >= 0) {
                if (matrix[row][column] == number) {
                    flag = true;
                    break;
                } else if (matrix[row][column] > number) {
                    column--;
                } else {
                    row++;
                }
            }
        }

        return flag;
    }

    // ====================测试代码====================
    public static void Test(String testName, int[][] matrix, int rows, int columns, int number, boolean expected)
    {
        if(testName != null)
            System.out.printf("%s begins: ", testName);

        boolean result = find(matrix, rows, columns, number);
        if(result == expected) {
            System.out.println("Passed.");
        } else
            System.out.println("Failed.");
    }

    //  1   2   8   9
//  2   4   9   12
//  4   7   10  13
//  6   8   11  15
// 要查找的数在数组中
    public static void Test1()
    {
        int matrix[][] = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        Test("Test1", matrix, 4, 4, 7, true);
    }

    //  1   2   8   9
//  2   4   9   12
//  4   7   10  13
//  6   8   11  15
// 要查找的数不在数组中
    public static void Test2()
    {
        int matrix[][] = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        Test("Test2", matrix, 4, 4, 5, false);
    }

    //  1   2   8   9
//  2   4   9   12
//  4   7   10  13
//  6   8   11  15
// 要查找的数是数组中最小的数字
    public static void Test3()
    {
        int matrix[][] = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        Test("Test3", matrix, 4, 4, 1, true);
    }

    //  1   2   8   9
//  2   4   9   12
//  4   7   10  13
//  6   8   11  15
// 要查找的数是数组中最大的数字
    public static void Test4()
    {
        int matrix[][] = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        Test("Test4", matrix, 4, 4, 15, true);
    }

    //  1   2   8   9
//  2   4   9   12
//  4   7   10  13
//  6   8   11  15
// 要查找的数比数组中最小的数字还小
    public static void Test5()
    {
        int matrix[][] = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        Test("Test5", matrix, 4, 4, 0, false);
    }

    //  1   2   8   9
//  2   4   9   12
//  4   7   10  13
//  6   8   11  15
// 要查找的数比数组中最大的数字还大
    public static void Test6()
    {
        int matrix[][] = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        Test("Test6", matrix, 4, 4, 16, false);
    }

    // 鲁棒性测试，输入空指针
    public static void Test7()
    {
        Test("Test7", null, 0, 0, 16, false);
    }

    public static void main(String[] args) {
        Test1();
        Test2();
        Test3();
        Test4();
        Test5();
        Test6();
        Test7();

    }

}
