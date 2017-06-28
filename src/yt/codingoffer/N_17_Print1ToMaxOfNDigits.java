package yt.codingoffer;

import org.junit.Test;

public class N_17_Print1ToMaxOfNDigits {
	private static void print1ToMaxOfNDigits_1(int n) {
		if (n <= 0) {
			return;
		}
		char[] number = new char[n];
		
		for (int i = 0; i < number.length; i++) {
			number[i] = '0';
		}
		
		while (!increment(number)) {
			printNumber(number);
		}
		
	}
	
	private static boolean increment(char[] number) {
		boolean isOverFlow = false;
		int nTalkOver = 0;
		int nLength = number.length;
		for (int i = nLength - 1; i >= 0; i--) {
			int nSum = number[i] - '0' + nTalkOver;
			if (i == nLength - 1) {
				nSum++;
			}
			if (nSum >= 10) {
				if (i == 0) {
					isOverFlow = true;
				} else {
					nSum -= 10;
					nTalkOver = 1;
					number[i] = (char) (nSum + '0');
				}
			} else {
				number[i] = (char) (nSum + '0');
				break;
			}
		}
		return isOverFlow;
	}
	
	private static void printNumber(char[] number) {
		boolean isBeginning0 = true;
		int nLength = number.length;
		for (int i = 0; i < nLength; i++) {
			if (isBeginning0 && number[i] != '0') {
				isBeginning0 = false;
			}
			if (!isBeginning0) {
				System.out.print(number[i]);
			}
		}
		System.out.println();
	}
	
	 
	
	private static void print1ToMaxOfNDigits_2(int n) {
		if (n <= 0) {
			return;
		}
		char[] number = new char[n];
		for (int i = 0; i < number.length; i++) {
			number[i] = '0';
		}
		
		for (int i = 0; i < 10; i++) {
			number[0] = (char) (i + '0');
			print1ToMaxOfNDigitsRecursively(number, n, 0);
		}
	}
	
	private static void print1ToMaxOfNDigitsRecursively(char[] number, int length, int index) {
		if (index == length-1) {
			printNumber(number);
			return ;
		}
		
		for (int i = 0; i < 10; i++) {
			number[index+1] = (char) (i + '0');
			print1ToMaxOfNDigitsRecursively(number, length, index+1);
		}
	}
	
	
	// ====================测试代码====================
	private static void Test(int n)
	{
	    System.out.printf("Test for %d begins:\n", n);

//	    print1ToMaxOfNDigits_1(n);
	    print1ToMaxOfNDigits_2(n);

	    System.out.printf("\nTest for %d ends.\n", n);
	}
	
	public static void main(String[] args) {
//		Test(1);
	    Test(2);
//	    Test(3);
//	    Test(0);
//	    Test(-1);
	}
}
