package yt.datastruct.sort;

import java.util.Arrays;
import java.util.Comparator;

class Person implements Comparable<Person> {
	private String name;
	public Person(String name) {
		this.name = name;
	}
	@Override
	public int compareTo(Person o) {
		return this.name.compareTo(o.name);
	}
	public String toString() {
		return this.name;
	}
}

public class InsertSort {
	
	/**
	 * 插入排序
	 * @param a
	 */
	public static <T extends Comparable<? super T>> void insertionSort(T[] a) {
		int j;
		
		for (int i = 1; i < a.length; i++) {
			T tmp = a[i];
			for (j = i; j > 0 && tmp.compareTo(a[j-1]) < 0; j--) {
				a[j] = a[j-1];
			}
			a[j] = tmp;
		}
	}
	
	/**
	 * 插入排序使用二叉查找法
	 * @param a
	 */
	public static void insertionSortWithBinary1(Object[] a) { // 对于基本数据类型，不需要实现Comparator接口
		int lo = 0;
		int hi = a.length;
		int start = 1; // 未排序的开始下标
		
        for ( ; start < hi; start++) {
            Comparable pivot = (Comparable) a[start]; 

            int left = lo;
            int right = start;
            
            // 使用二分查找算法
            while (left < right) {
                int mid = (left + right) >>> 1; // >>>是无符号右移一位，就相当于除以2
                if (pivot.compareTo(a[mid]) < 0) 
                    right = mid;
                else
                    left = mid + 1;
            }
           
            int n = start - left;  // 需要移动的位数
            switch (n) {
                case 2:  a[left + 2] = a[left + 1]; // 如果是只需要移动1位或者2位，就直接移
                case 1:  a[left + 1] = a[left];
                         break;
                default: System.arraycopy(a, left, a, left + 1, n); // 如果超过两位就调用这个方法，因为是naive方法执行很快
            }
            a[left] = pivot; // 插入
        }
	}
	
	
	
	public static <T extends Comparable<? super T>> void insertionSortWithBinary2(T[] a) {
		int lo = 0;
		int hi = a.length;
		int start = 1; // 未排序的开始下标
		
        for ( ; start < hi; start++) {
            T pivot =  a[start]; 

            int left = lo;
            int right = start;
            
            // 使用二分查找算法
            while (left < right) {
                int mid = (left + right) >>> 1; // >>>是无符号右移一位，就相当于除以2
                if (pivot.compareTo(a[mid]) < 0) // compare是传递过来的Comparator的自定义比较方法
                    right = mid;
                else
                    left = mid + 1;
            }
           
            int n = start - left;  // 需要移动的位数
            switch (n) {
                case 2:  a[left + 2] = a[left + 1]; // 如果是只需要移动1位或者2位，就直接移
                case 1:  a[left + 1] = a[left];
                         break;
                default: System.arraycopy(a, left, a, left + 1, n); // 如果超过两位就调用这个方法，因为是naive方法执行很快
            }
            a[left] = pivot; // 插入
        }
		
	}
	
	
	
	public static void main(String[] args) {
		Integer[] a = new Integer[]{1,23,234,234,22,1,-1,0,3};
		Person[] p1 = new Person[]{ new Person("Tom"), new Person("Alice") };
		System.out.println("直接插入排序测试(基本数据类型)：");
		insertionSort(a);
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		System.out.println("直接插入排序测试(类)：");
		insertionSort(p1);
		for (Person p : p1) {
			System.out.print(p + " ");
		}
		System.out.println();
		
		Integer[] b = new Integer[]{1,23,234,234,22,1,-1,0,3};
		System.out.println("二叉查找插入排序测试(基本数据类型)：");
		insertionSortWithBinary1(b);
		for (int i : b) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		Person[] p2 = new Person[]{ new Person("Tom"), new Person("Alice") };
		System.out.println("二叉查找插入排序测试(类)：");
		insertionSort(p2);
		for (Person p : p2) {
			System.out.print(p + " ");
		}
		
	}
}
