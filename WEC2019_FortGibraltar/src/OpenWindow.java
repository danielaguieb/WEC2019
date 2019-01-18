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
	
	private JButton xsmall;
	private JButton small;
	private JButton medium;
	private JButton large;
	public int size = -1;
	
	public OpenWindow() {
		super("Simulation Start-Up Menu");
		setLayout(new BorderLayout());
		JPanel buttonArray = new JPanel();
		
		xsmall = new JButton("3by3");
		small = new JButton("small");
		medium = new JButton("medium");
		large = new JButton("large");
		buttonArray.add(xsmall);
		buttonArray.add(small);
		buttonArray.add(medium);
		buttonArray.add(large);
		this.add(buttonArray, BorderLayout.CENTER);
		
		JPanel top = new JPanel(new BorderLayout());
		JLabel label = new JLabel("Please Select a Size", SwingConstants.CENTER);
		top.add(label, BorderLayout.CENTER);
		
		this.add(top, BorderLayout.NORTH);
		
		addButtonListeners();
		
		this.setSize(380, 80);
		this.setVisible(true);
		this.setResizable(false);
	}
	
	private void addButtonListeners()
	{
		xsmall.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				size = 3;
			}
		});
		
		small.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				size = 10;
			}
		});
		
		medium.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				size = 20;
			}
		});
		
		large.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				size = 30;
			}
		});
		
	}
	
	public void close()
	{
		this.dispose();
	}
		
}	
		
