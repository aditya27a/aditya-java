package SimpleApp;

public interface Account 
{
	public void credit(float camount, int user);
	public void debit(float damount, int user);
	public void miniStatement(int user);
}
