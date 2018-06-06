import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Label;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class Warning
/*One Prompt box interface free designed by myself to warn the wrong operation*/
{
	protected static String message;

	protected JFrame Warning;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Warning window = new Warning(message);
					window.Warning.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Warning(String message)
	/*Construct new window with particular message you want to show*/
	{
		initialize(message);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String message) {
		Warning = new JFrame();
		Warning.getContentPane().setBackground(UIManager.getColor("Button.disabledShadow"));
		Warning.setTitle("Information");
		Warning.setBounds(100, 100, 365, 236);
		Warning.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Warning.getContentPane().setLayout(null);
		Warning.setLocation(500, 300);
		
		Label label = new Label();
		label.setFont(new Font("Calibri", Font.BOLD, 23));
		label.setText(message);
		label.setAlignment(Label.CENTER);
		label.setBounds(0, 44, 333, 39);
		Warning.getContentPane().add(label);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Warning.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 24));
		btnNewButton.setBounds(119, 109, 92, 39);
		Warning.getContentPane().add(btnNewButton);
	}
}
