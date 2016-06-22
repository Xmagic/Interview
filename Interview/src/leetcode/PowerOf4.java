package leetcode;

public class PowerOf4 {
	
	public static void main(String[] args) {
		System.out.println(isPowerOfFour(8));
	}
	
	public static boolean isPowerOfFour(int num) {
		int x = num;
		if ( (x & (x - 1)) != 0 ) //8421
            return false;  
        return (x & 0x55555555) != 0;
    }
	
}
