
public class Controller 
{
	
	private View theView;
	private OpenWindow openWindow;
	private Grid theGrid;
	private Status status; 
	
	public Controller() {
		status = Status.getInstance();
	}
	
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
	
	public void start(int n)
	{
		while (true) {
			boolean running = status.isRunning();
			if (!running) {
				System.out.println("Making GUI");
				makeView("Catch Basin Detection Simulation", n); 
				status.setRunning(true);
			}
		}
	}
	
	public static void main(String[] args)
	{
		Controller controller = new Controller();
		int size = controller.getSize();
		//controller.theGrid = new Grid(size);
		controller.start(size);
		
		
		//controller.makeView("Name of GUI", size); 
	}
	
}