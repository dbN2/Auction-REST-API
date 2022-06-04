package com;

public class Buyer {

private final long id;
private String name;
	
	public Buyer(long id) {
		this.id = id;
	}

	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
}
