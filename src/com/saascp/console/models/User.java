package com.saascp.console.models;

import java.util.Date;

public class User
{
	private int id; 
	private String username; 
	private int backup; 
	private int dkim; 
	private int spf; 
	private String ip; 
	private String email;
	private String pkg; 
	private Date create_date; 
	private Date mod_time;
	
	public User()
	{
		this.id = 0;
		this.username = "";
		this.backup = 0;
		this.dkim = 0;
		this.spf = 0;
		this.ip = "";
		this.email = "";
		this.pkg = "";
		this.create_date = new Date();
		this.mod_time = new Date();
	}
	
	public void setID(int id) { this.id = id; }
	public void setUserName(String username) { this.username = username; }
	public void setBackup(int backup) { this.backup = backup; }
	public void setDkim(int dkim) { this.dkim = dkim; }
	public void setSpf(int spf) { this.spf = spf; }
	public void setIp(String ip) { this.ip = ip; }
	public void setEmail(String email) { this.email = email; }
	public void setPackage(String pkg) { this.pkg = pkg; }
	public void setCreateDate(Date ndate) { this.create_date = ndate; }
	public void setModificationDate(Date ndate) { this.mod_time = ndate; }
	
	public int getID() { return this.id; }
	public String getUserName() { return this.username; }
	public int getBackup() { return this.backup; }
	public int getDkim() { return this.dkim; }
	public int getSpf() { return this.spf; }
	public String getIp() { return this.ip; }
	public String getEmail() { return this.email; }
	public String getPackage() { return this.pkg; }
	public Date getCreateDate() { return this.create_date; }
	public Date getModificationDate() { return this.mod_time; }
}
