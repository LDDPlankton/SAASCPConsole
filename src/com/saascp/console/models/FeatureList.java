package com.saascp.console.models;

public class FeatureList
{
	private int id;
	private String name;
	
	public FeatureList()
	{
		this.id = 0;
		this.name = "";
	}
	
	public void setID(int id) { this.id = id; }
	public void setName(String s) { this.name = s; }
	
	public int getID() { return this.id; }
	public String getName() { return this.name; }
}
