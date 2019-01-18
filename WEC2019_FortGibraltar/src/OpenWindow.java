import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;import javafx.scene.layout.Border;

public class OpenWindow extends JFrame
{
	
	private JButton small;
	private JButton medium;
	private JButton large;
	
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
		JLabel label = new JLabel("Please Select a Size");
		top.add(label, BorderLayout.CENTER);
		
		this.add(top, BorderLayout.NORTH);
		
		this.setSize(300, 75);
		this.setVisible(true);
		this.setResizable(false);
	}
	
	public int determineSize()
	{
		Object[] options={ "large",  "medium", "small"};
		JPanel panel=new JPanel();
		
		JLabel label=new JLabel("Please Select a Size");
		panel.add(label);
		
		int result = JOptionPane.showOptionDialog(null, panel, "Game Start Menu",
		        JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
		        null, options, null);	
		
		//this is large
		if (result==JOptionPane.YES_OPTION){
			return 30;		
		}
		
		if (result==JOptionPane.NO_OPTION){
			JOptionPane.getRootFrame().dispose();
			System.out.println("in second if");
		}
		
		if (result == JOptionPane.CANCEL_OPTION)
		{
			System.out.println("in cancel object");
		}
		
		if (result == JOptionPane.OK_OPTION)
		{
			System.out.println("in object pain");
		}
		
		return 10;
	}
		
}	
		
