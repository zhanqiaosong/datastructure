package structure.other;

public class Countzero {
    public static void main(String[] args) {
		System.out.println(countZero(2008));
	}
    /**
     * ����n! ĩβ0�ĸ���
     * @param n
     * @return ĩβ0�ĸ���
     * ��10�� 2�ĸ����ܱ�5�� 5 10 ��2��0
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
