package structure.sort;

import java.util.Random;

public class TestSort {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testSpeed1();
		/*int[] s = {6,5,9,3,7,1,3,4,5,8,2};
		SomeSort bubbleSort = new SomeSort(s.length);
		for (int i = 0; i < s.length; i++) {
			bubbleSort.insert((long) s[i]);
		}
		bubbleSort.mergeSort();
		bubbleSort.display();*/
	}
	public static void testSpeed1(){
		//int[] s = {6,5,9,3,7,1,3,4,5,8,2};
		//SomeSort bubbleSort = new SomeSort(s.length);
		SomeSort bubbleSort = new SomeSort(2000);
		SomeSort selectionSort = new SomeSort(2000);
		SomeSort insertionSort = new SomeSort(2000);
		SomeSort shelSort = new SomeSort(2000);
		SomeSort quickSort = new SomeSort(2000);
		SomeSort mergeSort = new SomeSort(2000);
		for (int i = 0; i < 2000; i++) {
			Long tmp = (long) new Random().nextInt(2000);
			bubbleSort.insert(tmp);
			selectionSort.insert(tmp);
			insertionSort.insert(tmp);
			shelSort.insert(tmp);
			quickSort.insert(tmp);
			mergeSort.insert(tmp);
		}
		long tmie1 = System.currentTimeMillis();
		bubbleSort.bubbleSort();
		long tmie2 = System.currentTimeMillis();
		selectionSort.selectionSort();
		long tmie3 = System.currentTimeMillis();
		insertionSort.insertionSort();
		long tmie4 = System.currentTimeMillis();
		shelSort.shelSort();
		long tmie5 = System.currentTimeMillis();
		quickSort.quickSort(0, 1000-1);
		long tmie6 = System.currentTimeMillis();
		mergeSort.quickSort(0, 1000-1);
		long tmie7 = System.currentTimeMillis();
		System.out.println("bubbleSort用时："+(tmie2-tmie1)+"ms");
		System.out.println("selectionSort用时："+(tmie3-tmie2)+"ms");
		System.out.println("insertionSort用时："+(tmie4-tmie3)+"ms");
		System.out.println("shelSort用时："+(tmie5-tmie4)+"ms");
		System.out.println("quickSort用时："+(tmie6-tmie5)+"ms");
		System.out.println("mergeSort用时："+(tmie7-tmie6)+"ms");
	}
	public void testSpeed() {
		//int[] s = {6,5,9,3,7,1,3,4,5,8,2};
		//SomeSort bubbleSort = new SomeSort(s.length);
		SomeSort bubbleSort = new SomeSort(1000);
		for (int i = 0; i < 1000; i++) {
			bubbleSort.insert((long) new Random().nextInt(1000));
		}
		//bubbleSort.bubbleSort();
		//bubbleSort.selectionSort();
		//bubbleSort.insertionSort();
		//bubbleSort.shelSort();
		//bubbleSort.quickSort(0, s.length-1);
		long sta = System.currentTimeMillis();
		bubbleSort.quickSort(0, 1000-1);
		long end = System.currentTimeMillis();
		System.out.println("用时："+(end-sta)+"ms");
		//bubbleSort.display();
	}
}
