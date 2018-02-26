package structure.other;

public class Countzero {
    public static void main(String[] args) {
		System.out.println(countZero(2008));
	}
    /**
     * 计算n! 末尾0的个数
     * @param n
     * @return 末尾0的个数
     * 如10！ 2的个数总比5多 5 10 的2个0
     * 10/5=2
     * 2/5=0
     * 2+0=2
     */
    public static int countZero(int n) {
    	int x = 0;
    	while((n=n/5) != 0) {
    		x +=n;
    	}
		return x;
    }
}
