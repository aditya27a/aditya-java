package day8;
import java.io.*;
class Day8A3
{
	public static void main(String args[]) throws IOException
	{
		BufferedWriter buf = new BufferedWriter(new FileWriter("FIle2.txt",true));
		String s = "Sarcasm \n";
		buf.write(s);
		buf.close();
		BufferedReader buf1 = new BufferedReader(new FileReader("FIle2.txt"));
		String str;
		while((str=buf1.readLine())!=null)
		{
			System.out.println(str);
		}
	}
}