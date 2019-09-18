package logic;

import java.util.*;

public class Main {

	private static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);
		
		try {
			System.out.println("Enter the first num");
			int a= input.nextInt();
			
			System.out.println("Enter the second num");
			int b= input.nextInt();
			
			int sum= a/b;
			System.out.println(sum);
			
		} catch(Exception e) {
			System.out.println("dont do that please bitch");
		}
		
		
		
		
	}

}
