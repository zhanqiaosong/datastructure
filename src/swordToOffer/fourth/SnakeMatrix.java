package swordToOffer.fourth;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiaosong_zhan
 */
public class SnakeMatrix {
    public static void main(String[] args) {
		int[][] xx = {{1,2,3,4,5},{12,13,14,15,6},{11,10,9,8,7}};
		new SnakeMatrix().printSnackMatrix(xx);;
	}
    public List<Integer> printSnackMatrix(int[][] xx) {
    	if(xx==null || xx.length==0) return null;
    	ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int rows = xx.length;//行数
        int cols = xx[0].length;//列数
        int count = ((rows<cols?rows:cols)-1)/2+1;
        System.out.println(count);
        for (int i = 0; i < count; i++) {//循环次数
			//左往右
        	for(int j=i;j<cols-i;j++) System.out.print(xx[i][j]);
        	//上往下
        	for(int k=i+1;k<rows-i;k++) System.out.print(xx[k][cols-i-1]);
        	//右向左 只有一行则不循环
        	for(int m=cols-i-2;m>=i&&i!=rows-i-1;m--) ;
        	//下向上 只有一列则不循环
		}
        return arrayList;
	}
}