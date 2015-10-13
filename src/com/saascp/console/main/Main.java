package com.saascp.console.main;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.systemlibrary.appmanager.Account;
import com.systemlibrary.appmanager.Database;
import com.systemlibrary.appmanager.Mail;
import com.systemlibrary.system.UnixSystem;

public class Main
{
	private static final String VERSION = "1.0.0";
	
	public static void printMenu()
	{
		String[] options = new String[]
				{
						"addaccount <USER> <PWD> <EMAIL> <DOMAIN> <NS1> <NS2> <IP>",
						"delaccount <USER> <DOMAIN>",
						"addemailaccount <EMAIL> <PWD>",
						"delemailaccount <EMAIL>",
						"addmysqluser <USER> <HOST> <PWD>",
						"delmysqluser <USER> <HOST>",
						"addmysqldb <DB_NAME>",
						"delmysqldb <DB_NAME>",
						"addmysqldbtouser <USER> <HOST> <DB>",
						"delmysqldbfromuser <USER> <HOST> <DB>"
				};
		
		String[] descriptions = new String[]
				{
						"Create new Account.",
						"Delete Account.",
						"Add email account.",
						"Delete email account.",
						"Add MySQL User.",
						"Delete MySQL User.",
						"Add MySQL DB.",
						"Delete MySQL DB.",
						"Add MySQL User to DB. (GRANT)",
						"Delete MySQL from DB (REVOKE)."
				};
		
		System.out.println("SAASConsole App " + VERSION + "\n"
				+ "Usage: java -jar <program> <option> <args...>\n");
		for(int i = 0; i < options.length; i++)
			System.out.println(String.format("%-59s: %s", options[i], descriptions[i]));				
	}
	
	public static void requireNumberOfArguments(String args[], int required)
	{
		if(args.length != required)
		{
			System.out.println("Invalid Number of Arguments!");
			System.exit(-1);
		}
	}
	
	public static void main(String[] args)
	{
		Account account = new Account();
		Mail mail = new Mail();
		Database database = new Database();

		//ENSURE ARGUMENTS PASSED
		if(args.length < 1)
		{
			printMenu();
			System.exit(-1);
		}
		
		//DOES NOT ADD DNS RECORDS FOR NS's.
		//java -jar console.jar addaccount luser1 password123 none@domain1.com domain1.com ns1.domain1.com ns2.domain2.com 127.0.0.10
		//java -jar console.jar delaccount luser1 domain1.com
		
		//IF FAILED TO ESTABLISH DB CONN
		if(!database.establishMySQLConnection())
		{
			System.out.println(database.getErrorInformation().getErrorMessage());
			System.exit(-1);
		}
		
		//HANDLE BASED ON COMMAND
		switch(args[0])
		{
			case "addaccount":
				//HAVE REQUIRED ARGS OR DIE
				requireNumberOfArguments(args, 8);

				//ASSIGN VARIABLES
				String user1 = args[1];
				String passwd1 = args[2];
				String email1 = args[3];
				String domain1 = args[4];
				String ns11 = args[5];
				String ns21 = args[6];
				String ip1 = args[7];

				//ADD ACCOUNT
				boolean status1 = account.addAccount(user1, passwd1, email1, domain1, ns11, ns21, ip1);
				if(!status1)
				{
					System.out.println(account.getErrorInformation().getErrorMessage());
				}
				else
				{
					System.out.println("Account Created!");
				}
				
				break;
				
			case "delaccount":
				//HAVE REQUIRED ARGS OR DIE
				requireNumberOfArguments(args, 3);

				//ASSIGN VARIABLES
				String user2 = args[1];
				String domain2 = args[2];
				
				//DELETE ACCOUNT
				boolean status2 = account.deleteAccount(user2, domain2);
				if(!status2)
				{
					System.out.println(account.getErrorInformation().getErrorMessage());
				}
				else
				{
					System.out.println("Account Deleted!");
				}
				
				break;
				
			case "addemailaccount":
				//HAVE REQUIRED ARGS OR DIE
				requireNumberOfArguments(args, 3);

				//ASSIGN VARIABLES
				String email3 = args[1];
				String passwd3 = args[2];
				
				//ADD EMAIL
				boolean status3 = mail.addEmailAccount(email3, passwd3);
				if(!status3)
				{
					System.out.println(mail.getErrorInformation().getErrorMessage());
				}
				else
				{
					System.out.println("Email Account Created!");
				}
				
				break;
				
			case "delemailaccount":
				//HAVE REQUIRED ARGS OR DIE
				requireNumberOfArguments(args, 2);

				//ASSIGN VARIABLES
				String email4 = args[1];
				
				boolean status4 = mail.deleteEmailAccount(email4);
				if(!status4)
				{
					System.out.println(mail.getErrorInformation().getErrorMessage());
				}
				else
				{
					System.out.println("Email Account Deleted!");
				}
				
				break;
				
			case "addmysqluser":	
				//HAVE REQUIRED ARGS OR DIE
				requireNumberOfArguments(args, 4);

				//ASSIGN VARIABLES
				String user5 = args[1];
				String host5 = args[2];
				String pwd5 = args[3];
				
				//ADD MYSQL USER
				boolean status5 = database.addMySQLUser(user5, host5, pwd5);
				if(!status5)
				{
					System.out.println(database.getErrorInformation().getErrorMessage());
				}
				else
				{
					System.out.println("MySQL User Created!");
				}
				
				break;
				
			case "delmysqluser":	
				//HAVE REQUIRED ARGS OR DIE
				requireNumberOfArguments(args, 3);

				//ASSIGN VARIABLES
				String user6 = args[1];
				String host6 = args[2];
				
				//DELETE MYSQL USER
				boolean status6 = database.deleteMySQLUser(user6, host6);
				if(!status6)
				{
					System.out.println(database.getErrorInformation().getErrorMessage());
				}
				else
				{
					System.out.println("MySQL User Deleted!");
				}
				
				break;
				
			case "addmysqldb":	
				//HAVE REQUIRED ARGS OR DIE
				requireNumberOfArguments(args, 2);

				//ASSIGN VARIABLES
				String db7 = args[1];
				
				//ADD MYSQL DB
				boolean status7 = database.addMySQLDatabase(db7);
				if(!status7)
				{
					System.out.println(database.getErrorInformation().getErrorMessage());
				}
				else
				{
					System.out.println("MySQL DB Created!");
				}
				
				break;
				
			case "delmysqldb":	
				//HAVE REQUIRED ARGS OR DIE
				requireNumberOfArguments(args, 2);

				//ASSIGN VARIABLES
				String db8 = args[1];
				
				//DELETE MYSQL DB
				boolean status8 = database.deleteMySQLDatabase(db8);
				if(!status8)
				{
					System.out.println(database.getErrorInformation().getErrorMessage());
				}
				else
				{
					System.out.println("MySQL DB Deleted!");
				}
				
				break;
				
			case "addmysqldbtouser":
				//HAVE REQUIRED ARGS OR DIE
				requireNumberOfArguments(args, 4);

				//ASSIGN VARIABLES
				String user9 = args[1];
				String host9 = args[2];
				String db9 = args[3];
				
				//ADD MYSQL USER TO DB
				boolean status9 = database.addMySQLUserToDB(user9, host9, db9);
				if(!status9)
				{
					System.out.println(database.getErrorInformation().getErrorMessage());
				}
				else
				{
					System.out.println("MySQL User Assigned to DB!");
				}
				
				break;
				
			case "delmysqldbfromuser":	
				//HAVE REQUIRED ARGS OR DIE
				requireNumberOfArguments(args, 4);

				//ASSIGN VARIABLES
				String user10 = args[1];
				String host10 = args[2];
				String db10 = args[3];
				
				//DELETE MYSQL USER FROM DB
				boolean status10 = database.deleteMySQLUserToDB(user10, host10, db10);
				if(!status10)
				{
					System.out.println(database.getErrorInformation().getErrorMessage());
				}
				else
				{
					System.out.println("MySQL User Access Revoked From DB!");
				}
				
				break;		

			default:
				printMenu();
		}

	}

}
