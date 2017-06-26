package yt.codingoffer;

public class N_10_Fibonacci {
	private static long fibonacci(int n) {
		if (n < 2) {
			return n;
		}
		long fibOne = 0;
		long fibTwo = 1;
		long fibN = 1;
		for (int i = 2; i <= n; i++) {
			fibN = fibOne + fibTwo;
			
			fibOne = fibTwo;
			fibTwo = fibN;
		}
		
		return fibN;
	}
	
	public static void main(String[] args) {
		System.out.println(fibonacci(10));
	}
}
