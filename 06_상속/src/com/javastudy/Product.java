
package com.javastudy; //package�� �׻� ���� �־���Ѵ�.
import java.util.Scanner;

public class Product { 
	private String name;
	private int price;

	 public Product(String name, int price) { //public�� �־�� �ٸ� ��Ű������ ��밡��?
		 
		this.name = name;
		this.price = price;
	}

	 public void print() {
		Scanner sc = new Scanner(System.in);
		System.out.println("��ǰ��2:" + name);
		System.out.println("����:" + price);
	}
}
