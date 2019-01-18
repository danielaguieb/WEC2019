
public class Controller
{
	
	private View theView;
	private OpenWindow openWindow;
	private Grid theGrid;
	
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
		int size = -1;
		while (size == -1) {
			size = openWindow.size;
			System.out.println("waiting");
		}
		openWindow.close();
		return size;
	}
	
	public static void main(String[] args)
	{
		Controller controller = new Controller();
		int size = controller.getSize();
		//controller.theGrid = new Grid(size);
		controller.makeView("Name of GUI", size); 
	}
	
}