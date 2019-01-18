
public class Status
{
	private boolean running;
	static Status status = null;
	
	private Status()
	{
		running = false;
	}
	
	public static Status getInstance()
	{
		if (status == null)
			status = new Status();
		return status;
	}
	
	public boolean isRunning()
	{
		return running;
	}
	
	public void setRunning(boolean b)
	{
		running = b;
	}
	
}