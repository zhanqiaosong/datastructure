package structure.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SomeSort{
    private int nElem;
    private Long[] s;
	public SomeSort(int length) {
		s = new Long[length];
		nElem = 0;
	}
    /**
     * 1.冒泡排序O(n^2)
     */
	public void bubbleSort() {
		for(int i=nElem-1;i>0;i--){
			for(int j=0;j<i;j++){
				if(s[j]>s[j+1]) swap(j,j+1);
			}
		}
	}
    /**
     * 2.选择排序O(n^2) 交换次数少
     */
	public void selectionSort() {
		for(int i=0;i<nElem-1;i++){
			int tmp = i;
			for(int j=i+1;j<nElem;j++){
				if(s[j]<s[tmp]){
					tmp = j;
				}
			}
			swap(i,tmp);
		}
	}
	/**
	 * 3.插入排序
	 */
	public void insertionSort() {
	    for(int i=1;i<nElem;i++){
	    	int j = i;
	    	Long tmp = s[i];
	    	while(j>0 && s[j-1]>tmp){
	    		s[j] = s[j-1];
	    		j--;
	    	}
	    	s[j] = tmp;
	    }
	}
    /**
     * 4.希尔排序 插入排序的改进
     */
	public void shelSort() {
		int gap = nElem/2;
		while (gap>=1) {
			for (int i = gap; i < nElem; i++) {
				int j = i;
				Long tmp = s[i];
				while (j >= gap && s[j - gap] > tmp) {
					s[j] = s[j - gap];
					j -= gap;
				}
				s[j] = tmp;
			}
			gap /= 2;
		}
	}
	/**
	 * 5.快速排序 很玄妙
	 */
	public void quickSort(int start,int end) {
		if(start>=end) return;
		int low = start;
		int high = end;
		Long mid = s[low];
		while(low<high){
			//应为中间值取首个，所以从右边开始
			//右边
			while(low<high && s[high]>=mid) high -= 1;
			if(low<high) s[low++] = s[high]; 
			//左边
			while(low<high && s[low]<mid) low += 1;
			if(low<high) s[high--] = s[low]; 
		}
		//最后low=high
		s[low] = mid;
		quickSort(start,low-1);
		quickSort(high+1,end);
	}
	/**
	 * 6.归并排序 O(nlog(n)) 空间复杂度大点
	 *  先拆再合并
	 *  递归过程
	 */
	public void mergeSort() {
		s = mergeSortDuan(s);
	}
    public Long[] mergeSortDuan(Long[] s1){
    	if(s1.length<=1) return s1;
    	int mid = s1.length/2;
    	//left 采用归并后形成的有序的数组
    	Long[] left_s1 = mergeSortDuan(Arrays.copyOfRange(s1, 0, mid));//0->mid; 
    	//left 采用归并后形成的有序的数组
    	Long[] right_s1 = mergeSortDuan(Arrays.copyOfRange(s1, mid, s1.length));//mid->end; 
    	int left_point=0,right_point=0;
    	Long[] result = new Long[s1.length];
    	int i = 0;
    	while(left_point<left_s1.length && right_point < right_s1.length){
    		if(left_s1[left_point]<=right_s1[right_point]) {
    			result[i++] = left_s1[left_point++];
    		}else{
    			result[i++] = right_s1[right_point++];
    		}
    	}
    	//没有被放入的全部放入
    	while(left_point<left_s1.length){
    		result[i++] = left_s1[left_point++];
    	}
    	while(right_point<right_s1.length){
    		result[i++] = right_s1[right_point++];
    	}
    	return result;
    }
	public void display() {
		for (int i = 0; i < s.length; i++) {
			System.out.print(s[i]+" ");
		}
	}

	public void insert(Long x) {
		s[nElem++] = x;
	}
	/**
	 * 交换数据
	 */
	public void swap(int first , int end){
		Long tmp = s[first];
		s[first] = s[end];
		s[end] = tmp;
	}

}