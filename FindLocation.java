import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FindLocation 
/*One Prompt box interface free designed by myself*/
{
	protected static String message;
	protected JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindLocation window = new FindLocation(message);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FindLocation(String message)
	/*Construct method with message shown in the window*/
	{
		initialize(message);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String message) {
		frame = new JFrame();
		frame.setBounds(100, 100, 902, 265);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Label label = new Label();
		label.setText(message);
		label.setFont(new Font("Calibri", Font.BOLD, 18));
		label.setAlignment(Label.CENTER);
		label.setBounds(10, 43, 860, 39);
		frame.getContentPane().add(label);
		
		JButton button = new JButton("OK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		button.setFont(new Font("Calibri", Font.BOLD, 24));
		button.setBounds(396, 132, 92, 39);
		frame.getContentPane().add(button);
	}

}
