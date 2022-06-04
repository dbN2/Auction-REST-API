package com;

public class Project {

	private final long id;
	private long bid;
	
	public Project(long id) {
		this.id = id;
	}
	
	public Project(long id, long bid) {
		this.id = id;
		this.bid = bid;
	}
	
	public long getId() {
		return id;
	}
	public long getBid() {
		return bid;
	}
	public void setBid(long bid) {
		this.bid = bid;
	}
}


