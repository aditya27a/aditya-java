import java.util.*;
import java.math.*;
class task2prg
{
	public static int tra[]=new int[21],i=0;
	public static int ac;
	public static String str;
	public static void main(String Arg[])
	{
		System.out.println("Banking System\n");
		init();
	}
	public static void init()
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Press 1 for Current Account");
		System.out.println("Press 2 for Savings Account");
		int c=s.nextInt();
		switch (c)
		{
			case 1:
				Bank(1);
				break;
			case 2:
				Bank(2);
				break;
			default:
				System.out.println("Please Try Again!!");
		}
	}
	public static void Bank(int b)
	{
		if(b==1)
			System.out.println("\nCurrent Account");
		if(b==2)
			System.out.println("\nSaving Account");
		Random rand = new Random();
		ac=rand.nextInt(10000);
		System.out.println("\nPlease enter name");
		Scanner s=new Scanner(System.in);
		str=s.nextLine();
		trans();
	}
	public static void trans()
	{
		Scanner s=new Scanner(System.in);
		System.out.println("\nEnter the Type of transaction(max 20)");
		System.out.println("Press 1 for Withdraw Amount");
		System.out.println("Press 2 for Deposit Amount");
		System.out.println("Press 3 for Mini-Statement");
		System.out.println("Press 4 for Outstanding Balance\n");
		int c=s.nextInt();
		switch (c)
		{
			case 1:
				Withdraw();
				break;
			case 2:
				Deposit();
				break;
			case 3:
				MS();
				break;
			case 4:
				bal();
				break;
			default:
				System.out.println("Please Try Again!!");
		}
	}
	public static void Withdraw()
	{
		System.out.println("Enter amount to withdraw");
		Scanner s=new Scanner(System.in);
		int a=s.nextInt();
		tra[i++]=-1*a;
		tra[20]=i;
		disp(1);
		trans();
	}
	public static void Deposit()
	{
		System.out.println("Enter amount to deposit");
		Scanner s=new Scanner(System.in);
		int a=s.nextInt();
		tra[i++]=a;
		tra[20]=i;
		disp(2);
		trans();
	}
	public static void disp(int k)
	{
		System.out.println("Account No.::"+ac);
		System.out.println("Name::"+str);
		System.out.print("Type of transaction::");
		if(k==1)
			System.out.println("Withdrawl");
		if(k==2)
			System.out.println("Deposit");
		System.out.println("Amount :: "+Math.abs(tra[i-1]));
		System.out.println("Continue (y/n)");
		Scanner s=new Scanner(System.in);
		char ch=s.next().charAt(0);
		if(ch=='y')
			trans();
		else
			{	
				bal();
				System.exit(0);
			}
	}
	public static void MS()
	{
		System.out.println("\nMini-Statement");
		System.out.println("Credit\tDebit\tTotal");
		int tot=0;
		for(int j=0;j<tra[20];j++)
		{
			tot=tot+tra[j];
			if(tra[j]>0)
				System.out.println(tra[j]+"\t"+"-"+"\t"+tot);
			else
				System.out.println("-"+"\t"+tra[j]+"\t"+tot);
		}
	}
	public static void bal()
	{
		int tot=0;
				for(int j=0;j<tra[20];j++)
				tot=tot+tra[j];
				System.out.println("Outstanding Balance::="+tot);
	}
}