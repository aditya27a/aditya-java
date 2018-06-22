package day8;
import java.io.*;
class Day8A2
{
	public static void main(String args[]) throws IOException
	{
		FileOutputStream fi = new FileOutputStream("File1.txt",true);
		String str ="Aditya\n";
		char c[]=str.toCharArray();
		for(int i=0;i<str.length();i++)
		{
			fi.write(c[i]);
		}
		fi.close();
		FileInputStream f1 = new FileInputStream("File1.txt");
		int ch;
		while((ch=f1.read())!=-1)
		{
			System.out.print((char)ch);
		}
	}
}