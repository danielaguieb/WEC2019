
public class Controller
{
	
	private View theView;
	
	public Controller()
	{
		
	}
	
	public void makeView(String s)
	{
		theView = new View(s);
	}
	
	public static void main(String[] args)
	{
		
		Controller controller = new Controller();
		// if its a small size
		controller.makeView("Name of GUI"); 
	}
}