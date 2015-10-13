package com.saascp.console.models;

public class Config
{
	private int id;
	private String key;			//ACTUALLY SEEMS TO BE SET AS [key] SO IF ISSUES CHECK
	private String value;
	
	public Config()
	{
		this.id = 0;
		this.key = "";
		this.value = "";
	}
	
	public void setID(int id) { this.id = id; }
	public void setKey(String s) { this.key = s; }
	public void setValue(String s) { this.value = s; }
	
	public int getID() { return this.id; }
	public String getKey() { return this.key; }
	public String getValue() { return this.value; }
}
