import javax.swing.JOptionPane;

public class Controller
{
	
	private View theView;
	
	public Controller() {}
	
	public void makeView(String s, int n)
	{
		theView = new View(s, n);
		theView.setSize(500,500);
		theView.setVisible(true);
	}
	
	
	private int getSize()
	{
		return -21;
	}
	
	public static void main(String[] args)
	{
		Controller controller = new Controller();
		// lets get the size
		//int size = controller.getSize();
		controller.makeView("Name of GUI", 10); 
	}
	
}