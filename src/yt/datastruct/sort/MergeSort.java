package yt.datastruct.sort;

public class MergeSort {
	public static void mergeSort(int[] a, int left, int right) {
		if (left < right) {
			int center = (left + right) / 2;
			mergeSort(a, left, center);
			mergeSort(a, center+1, right);
			merge(a, left, center, right);
		}
	}

	public static void merge(int[] a, int left, int mid, int right) {
		int[] tmp = new int[right - left + 1];
		int i = left;
		int j = mid + 1;
		int k = 0;
		
		while (i <= mid && j <= right) {
			if (a[i] < a[j]) {
				tmp[k++] = a[i++];
			} else {
				tmp[k++] = a[j++];
			}
		}
		
		while (i <= mid) {
			tmp[k++] = a[i++];
		}
		while (j <= right) {
			tmp[k++] = a[j++];
		}
		
		// 新数组覆盖旧数组
		for (int m = 0; m < tmp.length; m++) {
			a[m + left] = tmp[m];
		}
		
	}
}
