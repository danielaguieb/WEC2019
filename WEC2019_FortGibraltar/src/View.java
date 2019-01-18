import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class View extends JFrame
{
	
	private JButton[][] gridButtons;
	private JPanel centerGrid;
	
	public View(String s, int n)
	{
		super(s);
		setLayout(new BorderLayout());
		makeCenterGrid(n);
		makeWindowListener();
	}
	
	private void makeCenterGrid(int n)
	{
		centerGrid = new JPanel(new GridLayout(n, n));
		gridButtons = new JButton[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				gridButtons[i][j] = new JButton();
				gridButtons[i][j].setVisible(true);
				//gridButtons[i][j].addActionListener(new ButtonListener());
				centerGrid.add(gridButtons[i][j]);
			}
		}
		
		this.add(centerGrid, BorderLayout.CENTER);
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