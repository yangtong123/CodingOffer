package yt.datastruct.sort;

public class QuickSort {
	public static void quickSort(int[] a, int lo, int hi) {
		if (hi <= lo) {
			return;
		}
		
		int j = partition(a, lo, hi);
		
		quickSort(a, lo, j - 1);
		quickSort(a, j + 1, hi);
	}
	
	public static int partition(int[] a, int lo, int hi) {
		int k = a[lo];
		
		while (lo < hi) {
			while (a[hi] >= k && lo < hi) {
				hi--;
			}
			a[lo] = a[hi];
			while (a[lo] <= k && lo < hi) {
				lo++;
			}
			a[hi] = a[lo];
		}
		a[hi] = k;
		
		return hi;
	}
}
