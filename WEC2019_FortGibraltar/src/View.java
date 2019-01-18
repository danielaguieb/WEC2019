import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javafx.scene.layout.Border;
import java.awt.event.*;

public class View extends JFrame
{
	
	private GridButton[][] gridButtons;
	private JPanel centerGrid;
	private int size;
	private Status status;
	public int row;
	public int col;
	private Grid theGrid;
	private int wincounter;
	
	public View(String s, int n)
	{
		super(s);
		size = n;
		wincounter = 0;
		status = Status.getInstance();
		theGrid = new Grid(n);
		setLayout(new BorderLayout());
		makeCenterGrid(n);
		makeWindowListener();
	}
	
	private void makeCenterGrid(int n)
	{
		centerGrid = new JPanel(new GridLayout(n, n));
		gridButtons = new GridButton[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				gridButtons[i][j] = new GridButton();
				gridButtons[i][j].row = i;
				gridButtons[i][j].col = j;
				gridButtons[i][j].setVisible(true);
				buttonListener(gridButtons[i][j]);
				centerGrid.add(gridButtons[i][j]);
			}
		}
		
		this.add(centerGrid, BorderLayout.CENTER);
		System.out.println("Adding ceneter panel");
	}
	
	public void buttonListener(GridButton button)
	{
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int num = theGrid.check(button.row, button.col);
				String temp = "";
				if (num == -1) {
					status.setRunning(false);
					terminate();
				}
				else {
					temp = Integer.toString(num);
					wincounter++;
					if (wincounter == size*size - size)
						victory();
				}
				button.setText(temp);
				button.setEnabled(false);
				System.out.println("Row is " + button.row + " Col is " + button.col);
			}
		});
	}
	
	private void victory()
	{
		Object[] option={ "Reset"};
		JPanel panel=new JPanel();
		JLabel label = new JLabel("You have won the simulation!", SwingConstants.CENTER);
		panel.add(label, BorderLayout.CENTER);
		int result = JOptionPane.showOptionDialog(null, panel, "Simulation is Over",
                JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, option, null);
		if (result==JOptionPane.YES_OPTION){
			JOptionPane.getRootFrame().dispose();
		}
		
		reset();
	}
	
	private void terminate()
	{
		Object[] option={ "Reset"};
		JPanel panel=new JPanel();
		JLabel label = new JLabel("You have lost the simulation", SwingConstants.CENTER);
		panel.add(label, BorderLayout.CENTER);
		int result = JOptionPane.showOptionDialog(null, panel, "Simulation is Over",
                JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, option, null);
		if (result==JOptionPane.YES_OPTION){
			JOptionPane.getRootFrame().dispose();
		}
		
		reset();
	}
	
	public void reset()
	{
		
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				gridButtons[i][j].enable();
				gridButtons[i][j].setText("");
			}
		}
		
		theGrid = null;
		theGrid = new Grid(size);
	}
		
	private void makeWindowListener()
	{
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog((JFrame) e.getSource(), "Are you sure you want to exit the application?",
						"Exit Application", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION)
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				if (result==JOptionPane.NO_OPTION)
					setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
		});
	}
	
}