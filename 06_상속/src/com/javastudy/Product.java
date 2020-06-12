
package com.javastudy; //package가 항상 위에 있어야한다.
import java.util.Scanner;

public class Product { 
	private String name;
	private int price;

	 public Product(String name, int price) { //public이 있어야 다른 패키지에서 사용가능?
		 
		this.name = name;
		this.price = price;
	}

	 public void print() {
		Scanner sc = new Scanner(System.in);
		System.out.println("제품명2:" + name);
		System.out.println("가격:" + price);
	}
}
