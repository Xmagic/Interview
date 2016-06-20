package Fibonacci;

public class Fibonacci {
	private int sum;

	// public int fib(int n)
	// {
	// if (n <= 1)
	// return n;
	// int low = 0;
	// int high = 1;
	// sum = 0;
	// for (int i = 1; i < n; i++)
	// {
	// sum = low + high;
	// low = high;
	// high = sum;
	// }
	//
	// return sum;
	// }

	public int fib(int n) {
		if (n <= 1)
			return n;
		return fib(n - 1) + fib(n - 2);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fibonacci fi = new Fibonacci();
		System.out.println(fi.fib(0));
		System.out.println(fi.fib(1));
		System.out.println(fi.fib(2));
		System.out.println(fi.fib(10));
		System.out.println(fi.fib(3));
		System.out.println(fi.fib(4));
		System.out.println(fi.fib(5));
		System.out.println(fi.fib(6));
		System.out.println(fi.fib(7));
		System.out.println(fi.fib(8));
		System.out.println(fi.fib(9));
	}

}
