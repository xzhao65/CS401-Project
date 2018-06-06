import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Panel;
import java.awt.Label;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


/*Main interface shown in the face of user*/
public class Project401 {
	protected SortedDataCollection list=new SortedDataCollection();

	protected JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Project401 window = new Project401();
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
	public Project401() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Insert Coupon");
		frame.getContentPane().setBackground(new Color(250, 250, 210));
		frame.getContentPane().setForeground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 1112, 747);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		JButton btnNewButton = new JButton("Search Coupon");
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			       Search search=new Search();
			       search.list=list;
			       search.frame.setVisible(true);
			       
			}
		});
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 24));
		btnNewButton.setBounds(711, 361, 224, 52);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Input your text file name:");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.ORANGE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 26));
		lblNewLabel.setBounds(43, 30, 310, 69);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lbltxt = new JLabel(".txt");
		lbltxt.setHorizontalAlignment(SwingConstants.LEFT);
		lbltxt.setForeground(Color.BLACK);
		lbltxt.setFont(new Font("Calibri", Font.BOLD, 24));
		lbltxt.setBackground(Color.ORANGE);
		lbltxt.setBounds(522, 30, 44, 69);
		frame.getContentPane().add(lbltxt);
		
		textField = new JTextField();
		textField.setFont(new Font("Calibri", Font.BOLD, 24));
		textField.setBounds(351, 46, 166, 35);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Calibri", Font.BOLD, 24));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Redeemed", "Unused"}));
		comboBox.setBounds(269, 563, 297, 35);
		frame.getContentPane().add(comboBox);
		
		
		/*Click on button to add new coupon record into library*/
		JButton btnNewButton_1 = new JButton("Add New Coupon");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_1.getText().length()==0||textField_2.getText().length()==0||textField_3.getText().length()==0||textField_4.getText().length()==0||textField_5.getText().length()==0) 
				{
					Warning form=new Warning("Please Fill in the Information");
				    form.Warning.setVisible(true); 
					return;
				}
				String part1=textField_1.getText();
				String part2=textField_2.getText();
				float part3=Float.parseFloat(textField_3.getText());
				int part4=Integer.parseInt(textField_4.getText());
				int part5=Integer.parseInt(textField_5.getText());
				String part6=comboBox.getSelectedItem().toString();
				
				Coupon coupon = new Coupon(part1, part2, part3, part4, part5,part6);
				list.add(coupon);
				Warning form=new Warning("Added Successfully!");
			    form.Warning.setVisible(true); 
			}
		});
		btnNewButton_1.setBackground(Color.ORANGE);
		btnNewButton_1.setFont(new Font("Calibri", Font.BOLD, 24));
		btnNewButton_1.setBounds(711, 271, 224, 52);
		frame.getContentPane().add(btnNewButton_1);
		
		/*Click on button to add new coupons in text file into library*/
		JButton btnNewButton_2 = new JButton("Confirm");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String filename=textField.getText()+".txt";
				try {
					list.PurchaseCoupon(filename);
					Warning form=new Warning("Added Successfully!");
				    form.Warning.setVisible(true);
				} catch (FileNotFoundException e1) {
					Warning form=new Warning("Please input correct file name");
				    form.Warning.setVisible(true);
					return;
				}
				
			}
		});
		btnNewButton_2.setBackground(Color.ORANGE);
		btnNewButton_2.setFont(new Font("Calibri", Font.BOLD, 24));
		btnNewButton_2.setBounds(606, 49, 123, 32);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblInputNewCoupons = new JLabel("Fill New Coupon's Information in the blanks :");
		lblInputNewCoupons.setHorizontalAlignment(SwingConstants.CENTER);
		lblInputNewCoupons.setForeground(Color.BLACK);
		lblInputNewCoupons.setFont(new Font("Calibri", Font.BOLD, 24));
		lblInputNewCoupons.setBackground(Color.ORANGE);
		lblInputNewCoupons.setBounds(25, 140, 450, 69);
		frame.getContentPane().add(lblInputNewCoupons);
		
		JLabel lblProviderName = new JLabel("Provider Name");
		lblProviderName.setHorizontalAlignment(SwingConstants.CENTER);
		lblProviderName.setForeground(Color.BLACK);
		lblProviderName.setFont(new Font("Calibri", Font.BOLD, 24));
		lblProviderName.setBackground(Color.ORANGE);
		lblProviderName.setBounds(43, 224, 224, 69);
		frame.getContentPane().add(lblProviderName);
		
		JLabel lblProdoctName = new JLabel("Prodoct Name");
		lblProdoctName.setHorizontalAlignment(SwingConstants.CENTER);
		lblProdoctName.setForeground(Color.BLACK);
		lblProdoctName.setFont(new Font("Calibri", Font.BOLD, 24));
		lblProdoctName.setBackground(Color.ORANGE);
		lblProdoctName.setBounds(43, 290, 224, 69);
		frame.getContentPane().add(lblProdoctName);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setForeground(Color.BLACK);
		lblPrice.setFont(new Font("Calibri", Font.BOLD, 24));
		lblPrice.setBackground(Color.ORANGE);
		lblPrice.setBounds(43, 350, 224, 69);
		frame.getContentPane().add(lblPrice);
		
		JLabel lblDiscountrate = new JLabel("DiscountRate");
		lblDiscountrate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiscountrate.setForeground(Color.BLACK);
		lblDiscountrate.setFont(new Font("Calibri", Font.BOLD, 24));
		lblDiscountrate.setBackground(Color.ORANGE);
		lblDiscountrate.setBounds(43, 418, 224, 69);
		frame.getContentPane().add(lblDiscountrate);
		
		JLabel lblExpirationperiod = new JLabel("Expirationperiod");
		lblExpirationperiod.setHorizontalAlignment(SwingConstants.CENTER);
		lblExpirationperiod.setForeground(Color.BLACK);
		lblExpirationperiod.setFont(new Font("Calibri", Font.BOLD, 24));
		lblExpirationperiod.setBackground(Color.ORANGE);
		lblExpirationperiod.setBounds(43, 481, 224, 69);
		frame.getContentPane().add(lblExpirationperiod);
		
		/*Click on button to show new window of "ListCoupons" to show sorted coupon list */
		JButton btnListCoupons = new JButton("List Coupons");
		btnListCoupons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListCoupons sort=new ListCoupons();
				sort.list=list;
			    sort.frame.setVisible(true);
			}
		});
		btnListCoupons.setFont(new Font("Calibri", Font.BOLD, 24));
		btnListCoupons.setBackground(Color.ORANGE);
		btnListCoupons.setBounds(711, 454, 224, 47);
		frame.getContentPane().add(btnListCoupons);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Calibri", Font.BOLD, 24));
		textField_1.setColumns(10);
		textField_1.setBounds(269, 239, 291, 35);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Calibri", Font.BOLD, 24));
		textField_2.setColumns(10);
		textField_2.setBounds(269, 306, 291, 35);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Calibri", Font.BOLD, 24));
		textField_3.setColumns(10);
		textField_3.setBounds(269, 370, 224, 35);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Calibri", Font.BOLD, 24));
		textField_4.setColumns(10);
		textField_4.setBounds(269, 434, 224, 35);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Calibri", Font.BOLD, 24));
		textField_5.setColumns(10);
		textField_5.setBounds(269, 497, 224, 35);
		frame.getContentPane().add(textField_5);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setForeground(Color.BLACK);
		lblStatus.setFont(new Font("Calibri", Font.BOLD, 24));
		lblStatus.setBackground(Color.ORANGE);
		lblStatus.setBounds(43, 547, 224, 69);
		frame.getContentPane().add(lblStatus);
		
		JLabel label = new JLabel("Days");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Calibri", Font.BOLD, 24));
		label.setBackground(Color.ORANGE);
		label.setBounds(499, 479, 61, 69);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("%");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Calibri", Font.BOLD, 24));
		label_1.setBackground(Color.ORANGE);
		label_1.setBounds(490, 422, 61, 61);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("$");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Calibri", Font.BOLD, 24));
		label_2.setBackground(Color.ORANGE);
		label_2.setBounds(490, 357, 61, 61);
		frame.getContentPane().add(label_2);
		
		
	}
}
