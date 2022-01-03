package com.kh.spring05.model.vo;

public class Menu {

	private String name;
	private int price;
	
	
	public Menu() {
		super();
	}


	public Menu(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Menu [name=" + name + ", price=" + price + "]";
	}
	
	
	
	
}
