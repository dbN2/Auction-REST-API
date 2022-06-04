package com;


public class Seller {
	
	private final long id;
	private String name;

	public Seller(long id) {
		this.id = id;
	}

	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
}
