package SimpleApp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Bank implements Account 
{

	static float[] currentBal = new float[5];
	static String[][]operations = new String[10][4];
	static int top;
	
	public void credit(float camount,int user)
	{
		currentBal[user-1] += camount;
		System.out.println("Amount Credited : "+camount);
		System.out.println("New Balance     : "+currentBal[user-1]);
		
		operations[top][0] = String.valueOf(user);
		operations[top][1] = "Credit";
		operations[top][2] = String.valueOf(camount);
		operations[top][3] = String.valueOf(currentBal[user-1]);
		top++;
		
		System.out.println("-----------------------------------------");
	}
	
	public void debit(float damount,int user)
	{
		currentBal[user-1] -= damount;
		System.out.println("Amount Debited : "+damount);
		System.out.println("New Balance    : "+currentBal[user-1]);
		
		operations[top][0] = String.valueOf(user);
		operations[top][1] = "Debit";
		operations[top][2] = String.valueOf(damount);
		operations[top][3] = String.valueOf(currentBal[user-1]);
		top++;
		
		System.out.println("-----------------------------------------");
	}
	
	public void miniStatement(int user)
	{
		System.out.println();
		System.out.println("Operations performed on user "+user +" account are:");
		System.out.println("Current Balance= Rs" +currentBal[user-1]);
		System.out.println();
		for(int i=0;i<top;i++)
		{
			if(operations[i][0].equals(String.valueOf(user)))
				System.out.println(operations[i][1]+" " +" Rs "+operations[i][2]+"|| Total Amount= "+"Rs "+operations[i][3]);
		}
		System.out.println("-------------------");
	}
	
	public void process(int user) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Press 1 to Credit money");
		System.out.println("Press 2 to Debit money");
		System.out.println("Press 3 to create mini statement");
		try 
		{
			int choice = Integer.parseInt(br.readLine()); 
			
			switch(choice)
			{
				case 1: 
						System.out.println("Enter the crediting amount");
						float camount = Float.parseFloat(br.readLine());
						if(camount < 0.0f)
							throw new Exception("Amount can't be negative");
						else
								this.credit(camount, user);
						break;
						
				case 2: 
						if(currentBal[user-1]==0.0f)
							System.out.println("You don't have enough balance to debit");
						else 
						{
							System.out.println("Enter the debiting amount");
							float damount = Float.parseFloat(br.readLine());
							
							if(currentBal[user-1]<damount)
								throw new Exception("You dont have enough balance");
							else if(damount < 0.0f)
								throw new Exception("No transaction with -ve amount is permitted");
							else if(damount >30000.0f)
								throw new Exception("Maximum amount that can be withdrawn is 30,000");
							else
								this.debit(damount, user);
						}
						break;
						
				case 3: this.miniStatement(user);
						break;
						
			}
			System.out.println("Press 1 to continue with current user");
			System.out.println("Press 2 to start new user's transaction");
			System.out.println("Press 3 to exit");
			
			choice = Integer.parseInt(br.readLine()); 
			if(choice==1)
				this.process(user);
			else if(choice == 2)
				this.method();
			else
				System.exit(0);
			
		}
		catch(Exception e1) { System.out.println(e1); this.process(user);}
		
		
	}
	
	public void method()throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
			System.out.println("Press 1 to access user 1");
			System.out.println("Press 2 to access user 2");
			System.out.println("Press 3 to access user 3");
			System.out.println("Press 4 to access user 4");
			System.out.println("Press 5 to access user 5");
		     
			int user = Integer.parseInt(br.readLine());
				
			this.process(user);
	}
	
	public static void main(String[] args)throws IOException
	{
		Bank bank = new Bank();
		bank.method();
	}

}
