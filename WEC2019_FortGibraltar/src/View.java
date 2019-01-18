import java.awt.*;
import javax.swing.*;
import javax.swing.event.MenuListener;

import java.awt.event.*;

public class View extends JFrame
{
	
	private JButton[][] gridButtons;
	private JPanel centerGrid;
	private JMenuBar menuBar;
	private JMenu size;
	private JMenuItem small;
	private JMenuItem medium;
	private JMenuItem large;
	
	public View(String s, int n)
	{
		super(s);
		setLayout(new BorderLayout());
		makeCenterGrid(n);
		makeMenuBar();
		makeWindowListener();
	}
	
	private void makeCenterGrid(int n)
	{
		JPanel temp = new JPanel(new GridLayout(n, n));
		
		//centerGrid = new JPanel(new GridLayout(n, n));
		gridButtons = new JButton[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				gridButtons[i][j] = new JButton();
				gridButtons[i][j].setVisible(true);
				//gridButtons[i][j].addActionListener(new ButtonListener());
				centerGrid.add(gridButtons[i][j]);
			}
		}
		
		centerGrid = temp;
		
		this.add(centerGrid, BorderLayout.CENTER);
		System.out.println("Adding ceneter panel");
	}
	
	private void makeMenuBar()
	{
		menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		size = new JMenu("Size");
		menuBar.add(size);
		
		small = new JMenuItem("Small");
		small.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(centerGrid);
				makeCenterGrid(10);
				System.out.println("yeet");
			}
		});
		size.add(small);
		
		medium = new JMenuItem("Medium");
		medium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(centerGrid);
				makeCenterGrid(20);
				System.out.println("yeet");
			}
		});
		size.add(medium);
		
		large = new JMenuItem("Large");
		large.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(centerGrid);
				makeCenterGrid(30);
				System.out.println("yeet");
			}
		});
		size.add(large);
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