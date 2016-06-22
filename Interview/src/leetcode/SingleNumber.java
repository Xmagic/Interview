package leetcode;

public class SingleNumber {
	public static void main(String[] args) {
		System.out.println(singleNumber(new int[]{1,1,2,2,3}));
	}
	
	//There's only one number in the array is not in pairs, find it. 
    public static int singleNumber(int[] nums) {
        int result = 0;
    	for (int i = 0; i < nums.length; i++) {
			result ^=nums[i];
		}
    	return result;
    }
}
