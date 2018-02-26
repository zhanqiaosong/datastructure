package swordToOffer.fourth;

import java.util.Arrays;

public class VerySequenceOfBST {
	/**
	 * 输入一个整型数组，判断该数组是不是某二叉搜索树后序遍历的结果
	 */
    public Boolean verifySeOfBST(int[] sequence,int length) {
    	//
    	if(sequence==null||length<=0) return false;
    	int root = sequence[length-1];
    	//二叉树中左子树小于根节点
    	int i=0;
    	for(;i<length-1;i++){
    		if(sequence[i]>root) break;
    	}
    	int j = i;
    	//二叉树中右子树大于根节点
    	for(;j<length-1;j++){
    		if(sequence[j]<root) return false;
    	}
    	Boolean left = true;
    	if(i>0) left = verifySeOfBST(Arrays.copyOfRange(sequence, 0, i),i);
    	Boolean right = true;
    	//除去最后一个，已经被取出了--root
    	if(i<length-1) right = verifySeOfBST(Arrays.copyOfRange(sequence, i, length-1),length-i-1);
		return left&&right;
	}
    public static void main(String[] args) {
    	int[] sequence = {5,7,9,11,6,10,8};
    	System.out.println(Arrays.copyOfRange(sequence, 3, sequence.length)[0]);
	    Boolean verifySeOfBST = new VerySequenceOfBST().verifySeOfBST(sequence, sequence.length);	
	    System.out.println(verifySeOfBST);
    }
}
