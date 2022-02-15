package test;

public class Exam메모리연습 {
	
	public static final double PI = 3.14;
	
	public static void main(String[] args) {	
		// printAddNumber(3, 5);
		new Exam메모리연습().print_add(3,5);
		
		Exam메모리연습 ex = new Exam메모리연습();	
	}
	
	public void print_add(int num1, int num2) {
		System.out.println("두 수의 합은 " + (num1 + num2) + "입니다.");
		
	}
}