import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class OpenWindow extends JFrame
{
	
	private JButton small;
	private JButton medium;
	private JButton large;
	public int size = -1;
	
	public OpenWindow() {
		super("Simulation Start-Up Menu");
		setLayout(new BorderLayout());
		JPanel buttonArray = new JPanel();
		
		small = new JButton("small");
		medium = new JButton("medium");
		large = new JButton("large");
		buttonArray.add(small);
		buttonArray.add(medium);
		buttonArray.add(large);
		this.add(buttonArray, BorderLayout.CENTER);
		
		JPanel top = new JPanel(new BorderLayout());
		JLabel label = new JLabel("Please Select a Size", SwingConstants.CENTER);
		top.add(label, BorderLayout.CENTER);
		
		this.add(top, BorderLayout.NORTH);
		
		addButtonListeners();
		
		this.setSize(300, 75);
		this.setVisible(true);
		this.setResizable(false);
	}
	
	private void addButtonListeners()
	{
		small.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				size = 10;
				System.out.println("a");
			}
		});
		
		medium.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				size = 20;
				System.out.println("b");
			}
		});
		
		large.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				size = 30;
				System.out.println("c");
			}
		});
		
	}
	
	public void close()
	{
		this.dispose();
	}
		
}	
		
