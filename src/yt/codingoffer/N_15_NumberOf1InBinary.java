package yt.codingoffer;

/**
 * 面试题15: 二进制中1的个数
 * @author yangtong
 *
 */
public class N_15_NumberOf1InBinary {
	
	private static int NumberOf1_Solution1(int n) {
		int count = 0;
		int flag = 1 & 0xffff;
		while (flag != 0) {
			if ((n & flag) != 0) {
				count++;
			}
			flag = flag << 1;
		}
		return count;
	}
	
	private static int NumberOf1_Solution2(int n) {
		int count = 0;
		while (n != 0) {
			++count;
			n = (n - 1) & n;
		}
		return count;
	}
	
	// ====================测试代码====================
	private static void test(int number, int expected)
	{
	    int actual = NumberOf1_Solution1(number);
	    if (actual == expected)
	        System.out.printf("Solution1: Test for %s passed.\n", Integer.toBinaryString(number));
	    else
	    	System.out.printf("Solution1: Test for %s failed.\n", Integer.toBinaryString(number));

	    actual = NumberOf1_Solution2(number);
	    if (actual == expected)
	    	System.out.printf("Solution2: Test for %s passed.\n", Integer.toBinaryString(number));
	    else
	    	System.out.printf("Solution2: Test for %s failed.\n", Integer.toBinaryString(number));

	    System.out.printf("\n");
	}
	
	public static void main(String[] args) {
		// 输入0，期待的输出是0
	    test(0, 0);

	    // 输入1，期待的输出是1
	    test(1, 1);

	    // 输入10，期待的输出是2
	    test(10, 2);

	    // 输入0x7FFFFFFF，期待的输出是31
	    test(0x7FFFFFFF, 31);

	    // 输入0xFFFFFFFF（负数），期待的输出是32
	    test(0xFFFFFFFF, 32);

	    // 输入0x80000000（负数），期待的输出是1
	    test(0x80000000, 1);
	}
}
