package com.saascp.console.models;

public class Package 
{
	private int id;
	private String name;
	private int diskquota;
	private int bandwidth;
	private int maxsql;
	private int maxpop;
	private int maxsub;
	private int dedicated_ip;
	private String feature_list;
	private int hasshell;
	
	public Package()
	{
		this.id = 0;
		this.name = "";
		this.diskquota = 0;
		this.bandwidth = 0;
		this.maxsql = 0;
		this.maxpop = 0;
		this.maxsub = 0;
		this.dedicated_ip = 0;
		this.feature_list = "";
		this.hasshell = 0;			//SET AS NUMERIC AND NOT INT ... IF ISSUES CHECK/CHANGE
	}
	
	public void setID(int id) { this.id = id; }
	public void setName(String s) { this.name = s; }
	public void setDiskQuota(int s) { this.diskquota = s; }
	public void setBandwidth(int s) { this.bandwidth = s; }
	public void setMaxSQL(int s) { this.maxsql = s; }
	public void setMaxPop(int s) { this.maxpop = s; }
	public void setMaxSub(int s) { this.maxsub = s; }
	public void setDedicatedIP(int s) { this.dedicated_ip = s; }
	public void setFeatureList(String s) { this.feature_list = s; }
	public void setHasShell(int s) { this.hasshell = s; }
	
	public int getID() { return this.id; }
	public String getName() { return this.name; }
	public int getDiskQuota() { return this.diskquota; }
	public int getBandwidth() { return this.bandwidth; }
	public int getMaxSQL() { return this.maxsql; }
	public int getMaxPop() { return this.maxpop; }
	public int getMaxSub() { return this.maxsub; }
	public int getDedicatedIP() { return this.dedicated_ip; }
	public String getFeatureList() { return this.feature_list; }
	public int getHasShell() { return this.hasshell; }
}
