package leetcode;

public class ReverseString {
	public static void main(String[] args) {
		System.out.println(reverseString("<123456>"));
	}
	
	public static String reverseString(String s) {
        char[] a = s.toCharArray();
        for (int i = 0; i < a.length/2; i++) {
			
        	a[i] = (char) (a[i] + a[a.length - 1 - i]);
        	a[a.length - 1 - i] = (char) (a[i] - a[a.length - 1 - i]);
        	a[i] = (char) (a[i] - a[a.length - 1 - i]);
		}
        return String.valueOf(a);
    }
}
