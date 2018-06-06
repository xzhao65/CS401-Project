import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Label;
import java.awt.Rectangle;

import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ListSelectionModel;

public class Search extends Project401 /* Window for Search function and show coupons' details in table */
{

	protected JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	protected SortedDataCollection list = new SortedDataCollection();
	private JTable table;
	int rowindex = -1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) /* Start the window interface */ {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search window = new Search();
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
	public Search() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Search the Coupon");
		frame.getContentPane().setBackground(SystemColor.info);
		frame.setBounds(100, 100, 1173, 796);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(Color.ORANGE);
		btnExit.setFont(new Font("Calibri", Font.BOLD, 24));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnExit.setBounds(977, 635, 128, 48);
		frame.getContentPane().add(btnExit);

		JLabel label = new JLabel("Provider Name");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Calibri", Font.BOLD, 24));
		label.setBackground(Color.ORANGE);
		label.setBounds(35, 205, 224, 69);
		frame.getContentPane().add(label);

		textField = new JTextField();
		textField.setText("365");
		textField.setFont(new Font("Calibri", Font.BOLD, 24));
		textField.setColumns(10);
		textField.setBounds(261, 478, 146, 35);
		frame.getContentPane().add(textField);

		JLabel label_1 = new JLabel("Prodoct Name");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Calibri", Font.BOLD, 24));
		label_1.setBackground(Color.ORANGE);
		label_1.setBounds(35, 271, 224, 69);
		frame.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("Price");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Calibri", Font.BOLD, 24));
		label_2.setBackground(Color.ORANGE);
		label_2.setBounds(35, 331, 224, 69);
		frame.getContentPane().add(label_2);

		textField_1 = new JTextField();
		textField_1.setText("2000");
		textField_1.setFont(new Font("Calibri", Font.BOLD, 24));
		textField_1.setColumns(10);
		textField_1.setBounds(261, 351, 146, 35);
		frame.getContentPane().add(textField_1);

		textField_2 = new JTextField();
		textField_2.setText("80");
		textField_2.setFont(new Font("Calibri", Font.BOLD, 24));
		textField_2.setColumns(10);
		textField_2.setBounds(261, 415, 146, 35);
		frame.getContentPane().add(textField_2);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Calibri", Font.BOLD, 24));
		textField_3.setColumns(10);
		textField_3.setBounds(261, 287, 206, 35);
		frame.getContentPane().add(textField_3);

		textField_4 = new JTextField();
		textField_4.setFont(new Font("Calibri", Font.BOLD, 24));
		textField_4.setColumns(10);
		textField_4.setBounds(261, 220, 206, 35);
		frame.getContentPane().add(textField_4);

		JLabel label_3 = new JLabel("DiscountRate");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Calibri", Font.BOLD, 24));
		label_3.setBackground(Color.ORANGE);
		label_3.setBounds(35, 399, 224, 69);
		frame.getContentPane().add(label_3);

		JLabel label_4 = new JLabel("Expirationperiod");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("Calibri", Font.BOLD, 24));
		label_4.setBackground(Color.ORANGE);
		label_4.setBounds(35, 462, 224, 69);
		frame.getContentPane().add(label_4);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Calibri", Font.BOLD, 24));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Unused", "Redeemed" }));
		comboBox.setBounds(261, 546, 203, 35);
		frame.getContentPane().add(comboBox);

		JLabel lblFillInCoupons = new JLabel("Fill Coupon's Information in the blanks :");
		lblFillInCoupons.setHorizontalAlignment(SwingConstants.CENTER);
		lblFillInCoupons.setForeground(Color.BLACK);
		lblFillInCoupons.setFont(new Font("Calibri", Font.BOLD, 24));
		lblFillInCoupons.setBackground(Color.ORANGE);
		lblFillInCoupons.setBounds(46, 121, 418, 69);
		frame.getContentPane().add(lblFillInCoupons);

		JLabel lblSearchTheCoupon = new JLabel("Search the Coupon");
		lblSearchTheCoupon.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchTheCoupon.setForeground(Color.BLACK);
		lblSearchTheCoupon.setFont(new Font("Calibri", Font.BOLD, 28));
		lblSearchTheCoupon.setBackground(Color.ORANGE);
		lblSearchTheCoupon.setBounds(65, 27, 388, 69);
		frame.getContentPane().add(lblSearchTheCoupon);

		JButton btnStartSearch = new JButton("Search");
		btnStartSearch.addActionListener(new ActionListener() {
			/*
			 * Click on search button and then start search meanwhile show coupons in the
			 * table
			 */
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				rowindex = -1;
				for (int index = model.getRowCount() - 1; index >= 0; index--) {
					model.removeRow(index);
				}
				for (int i = 0; i <= list.index; i++)/*add all records in library into table*/
				{

					Object[] row = { list.get(i).info.ProviderName, list.get(i).info.ProductName,
							list.get(i).info.Price, list.get(i).info.DiscountRate, list.get(i).info.ExpirationPeriod,
							list.get(i).info.Status,
							list.get(i).info.Price * (100 - list.get(i).info.DiscountRate) / 100 };

					model.addRow(row);

				}
				/*remove the records don't satisfy the limited condition set by user*/
				if (textField_1.getText().length() == 0 || textField_2.getText().length() == 0
						|| textField.getText().length() == 0) {
					Warning form = new Warning("Please Fill in the blank.");
					form.Warning.setVisible(true);
					return;
				}

				for (int i = 0; i <= model.getRowCount() - 1; i++) {
					if ((!textField_4.getText().equals(table.getValueAt(i, 0)) && !textField_4.getText().equals(""))
							|| (!textField_3.getText().equals(table.getValueAt(i, 1))
									&& !textField_3.getText().equals(""))
							|| (Float.parseFloat(
									textField_1.getText()) < (Float.parseFloat(table.getValueAt(i, 2).toString()))
									&& !textField_1.getText().equals(""))
							|| (Integer.parseInt(
									textField_2.getText()) < (Integer.parseInt(table.getValueAt(i, 3).toString()))
									&& !textField_2.getText().equals(""))
							|| (Integer.parseInt(
									textField.getText()) < (Integer.parseInt(table.getValueAt(i, 4).toString()))
									&& !textField.getText().equals(""))
							|| (!comboBox.getSelectedItem().equals(table.getValueAt(i, 5))
									&& !comboBox.getSelectedItem().equals(""))) {
						model.removeRow(i);
						i--;
					}
					/*if there is no record satisfying the limited condition, show the warning window*/
					if (model.getRowCount() == 0) {

						FindLocation form = new FindLocation("No Coupon is found: index of " + (list.index + 1)
								+ " by Linear Seach and in index of " + list.list.search(list.index) + " by BST");
						list.list.temp = 1;
						form.frame.setVisible(true);
					}
				}

			}
		});
		btnStartSearch.setFont(new Font("Calibri", Font.BOLD, 24));
		btnStartSearch.setBackground(Color.ORANGE);
		btnStartSearch.setBounds(201, 635, 171, 48);
		frame.getContentPane().add(btnStartSearch);

		JLabel lblCouponShownAs = new JLabel("Coupons shown as below: ");
		lblCouponShownAs.setHorizontalAlignment(SwingConstants.CENTER);
		lblCouponShownAs.setForeground(Color.BLACK);
		lblCouponShownAs.setFont(new Font("Calibri", Font.BOLD, 28));
		lblCouponShownAs.setBackground(Color.ORANGE);
		lblCouponShownAs.setBounds(581, 27, 418, 69);
		frame.getContentPane().add(lblCouponShownAs);

		JLabel lblStatus = new JLabel("Status");
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setForeground(Color.BLACK);
		lblStatus.setFont(new Font("Calibri", Font.BOLD, 24));
		lblStatus.setBackground(Color.ORANGE);
		lblStatus.setBounds(35, 526, 224, 69);
		frame.getContentPane().add(lblStatus);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(482, 121, 654, 456);
		frame.getContentPane().add(scrollPane_1);

		table = new JTable(new DefaultTableModel(new Object[][] {}, new String[] { "ProviderName", "ProductName",
				"Price", "DiscountRate", "ExpirationPeriod", "Status", "FinalPrice" }) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] { Object.class, String.class, Float.class, Integer.class, Integer.class,
					String.class, Float.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(table);
		table.setEnabled(true);
		table.setFont(new Font("Calibri", Font.PLAIN, 19));
		table.setRowSelectionAllowed(true);
		table.getTableHeader().setFont(new Font("Calibri", Font.PLAIN, 14));
		table.addMouseListener(new MouseAdapter() 
		/*To detect the click action by user */
		{
			public void mouseClicked(MouseEvent e) {
				rowindex = table.getSelectedRow();
				table.setSelectionBackground(Color.orange);
			}
		});

		JLabel label_5 = new JLabel("$");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.BLACK);
		label_5.setFont(new Font("Calibri", Font.BOLD, 24));
		label_5.setBackground(Color.ORANGE);
		label_5.setBounds(389, 335, 61, 69);
		frame.getContentPane().add(label_5);

		JLabel label_6 = new JLabel("%");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(Color.BLACK);
		label_6.setFont(new Font("Calibri", Font.BOLD, 24));
		label_6.setBackground(Color.ORANGE);
		label_6.setBounds(389, 401, 61, 69);
		frame.getContentPane().add(label_6);

		JLabel lblDays = new JLabel("Days");
		lblDays.setHorizontalAlignment(SwingConstants.CENTER);
		lblDays.setForeground(Color.BLACK);
		lblDays.setFont(new Font("Calibri", Font.BOLD, 24));
		lblDays.setBackground(Color.ORANGE);
		lblDays.setBounds(406, 462, 61, 69);
		frame.getContentPane().add(lblDays);

		/*
		 * Select the coupon user's interested in and Click on "find location" to show
		 * the search index by BST Search and Linear Search
		 */
		JButton btnFindLocation = new JButton("Find Location");
		btnFindLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rowindex != -1) {
					list.SearchCoupon(table.getValueAt(rowindex, 0).toString(),
							table.getValueAt(rowindex, 1).toString(),
							Float.parseFloat(table.getValueAt(rowindex, 2).toString()),
							Integer.parseInt(table.getValueAt(rowindex, 3).toString()),
							Integer.parseInt(table.getValueAt(rowindex, 4).toString()),
							table.getValueAt(rowindex, 0).toString());
					if (list.Linearindex != -1) {
						FindLocation form = new FindLocation("Found in index of " + list.BSTindex
								+ " by BST and in index of " + list.Linearindex + " by Linear Search");
						form.frame.setVisible(true);
						list.list.temp = 1;
					} else {
						FindLocation form = new FindLocation("No Coupon is found: index of " + list.index
								+ " by Linear Seach and in index of " + list.list.temp + " by BST");
						form.frame.setVisible(true);
						list.list.temp = 1;
					}

				} else 
					/*if user didn't choose any record, show the warning window*/{
					Warning window = new Warning("Please Select One Coupon.");
					window.Warning.setVisible(true);
				}
			}
		});
		btnFindLocation.setFont(new Font("Calibri", Font.BOLD, 24));
		btnFindLocation.setBackground(Color.ORANGE);
		btnFindLocation.setBounds(527, 635, 192, 48);
		frame.getContentPane().add(btnFindLocation);

		/*
		 * Delete the selected record in the table and corresponding coupon in library
		 */
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rowindex != -1) {
					list.SearchCoupon(table.getValueAt(rowindex, 0).toString(),
							table.getValueAt(rowindex, 1).toString(),
							Float.parseFloat(table.getValueAt(rowindex, 2).toString()),
							Integer.parseInt(table.getValueAt(rowindex, 3).toString()),
							Integer.parseInt(table.getValueAt(rowindex, 4).toString()),
							table.getValueAt(rowindex, 0).toString());

					if (list.Linearindex != -1) {
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						list.remove(list.Linearindex - 1);
						model.removeRow(rowindex);
						Warning form = new Warning("Deleted Successfully!");
						form.Warning.setVisible(true);

					}
				} else/*if user didn't choose any record, show the warning window*/
				{
					Warning form = new Warning("Please Select One Coupon.");
					form.Warning.setVisible(true);
				}
				rowindex = -1;
			}
		});
		btnDelete.setFont(new Font("Calibri", Font.BOLD, 24));
		btnDelete.setBackground(Color.ORANGE);
		btnDelete.setBounds(776, 635, 153, 48);
		frame.getContentPane().add(btnDelete);

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
