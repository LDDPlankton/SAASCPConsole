package com.saascp.console.models;

public class UserDomain
{
	private int id;
	private int user_id;
	private int primary_domain;
	private String domain;
	private String dns_zone;
	private String homedir;
	private String documentroot;
	
	public UserDomain()
	{
		this.id = 0;
		this.user_id = 0;
		this.primary_domain = 0;
		this.domain = "";
		this.dns_zone = "";
		this.homedir = "";
		this.documentroot = "";
	}
	
	public void setID(int id) { this.id = id; }
	public void setUserID(int s) { this.user_id = s; }
	public void setPrimaryDomain(int s) { this.primary_domain = s; }
	public void setDomain(String s) { this.domain = s; }
	public void setDNSZone(String s) { this.dns_zone = s; }
	public void setHomeDir(String s) { this.homedir = s; }
	public void setDocumentRoot(String s) { this.documentroot = s; }
	
	public int getID() { return this.id; }
	public int getUserID() { return this.user_id; }
	public int getPrimaryDomain() { return this.primary_domain; }
	public String getDomain() { return this.domain; }
	public String getDNSZone() { return this.dns_zone; }
	public String getHomeDir() { return this.homedir; }
	public String getDocumentRoot() { return this.documentroot; }
	
}
