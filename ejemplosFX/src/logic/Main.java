package logic;

import java.util.*;

public class Main {

	private static Scanner input;
	private static AndNode and;

	public static void main(String[] args) {
		
		String fix= "parte-3";
		String parts[]= fix.split("-");
		String part1= parts[0];
		String part2= parts[1];
		System.out.println(part1);
		System.out.println(part2);
		
		
		//fix.split(regex)
		/*
		Factory.newNode("and");
		Factory.newNode("nand");
		Factory.newNode("xor");
		Factory.newNode("nor");
		Factory.newNode("not");
		Factory.newNode("or");
		System.out.println("Largo de la lista es: " + Lista.getSize());
		System.out.println("El nodo en la posición 2 es: " + Lista.getNodo(0));
		//Node temp= Lista.pos(1);
		//temp.getValue1;
		*/
		//El problema que lanza la consola con un null pointer es
		//Exception in thread "main" java.lang.NullPointerException
		//          at logic.Main.main(Main.java:12)
		
		 
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
