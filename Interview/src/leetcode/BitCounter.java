package leetcode;

public class BitCounter {
	//Count how many 1 in num's binary display
    public static int countBits(int num) {
       int count = 0;
       while(num !=0)
       {
    	   num &= (num -1);
    	   count++;
       }
       return count;
    }
    
    public static void main(String[] args) {
    	System.out.println(countBits(15));
    	System.out.println(countBits(7));
    	System.out.println(countBits(5));
    	System.out.println(countBits(2));
    	System.out.println(countBits(0));
	}
}
