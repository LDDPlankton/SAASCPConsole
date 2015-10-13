package com.saascp.console.models;

public class UserSubDomain
{
	private int id;
	private int user_id;
	private String subname;
	private String documentroot;
	
	public UserSubDomain()
	{
		this.id = 0;
		this.user_id = 0;
		this.subname = "";
		this.documentroot = "";
	}
	
	public void setID(int id) { this.id = id; }
	public void setUserID(int s) { this.user_id = s; }
	public void setSubName(String s) { this.subname = s; }
	public void setDocumentRoot(String s) { this.documentroot = s; }
	
	public int getID() { return this.id; }
	public int getUserID() { return this.user_id; }
	public String getSubName() { return this.subname; }
	public String getDocumentRoot() { return this.documentroot; }
}
