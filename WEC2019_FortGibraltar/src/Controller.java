

public class Controller
{
	
	private View theView;
	private OpenWindow openWindow;
	
	public Controller() {}
	
	public void makeView(String s, int size)
	{
		theView = new View(s, size);
		theView.pack();
		theView.setSize(500,500);
		theView.setResizable(false);
		theView.setVisible(true);
	}
	
	
	private int getSize()
	{	
		openWindow = new OpenWindow();
		return openWindow.determineSize();
	}
	
	public static void main(String[] args)
	{
		Controller controller = new Controller();
		// lets get the size
		int size = controller.getSize();
		//int size = controller.getSize();
		controller.makeView("Name of GUI", size); 
	}
	
}