import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ListCoupons {

	protected JFrame frame;
	private JTable table;
	protected SortedDataCollection list = new SortedDataCollection();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListCoupons window = new ListCoupons();
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
	public ListCoupons() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Sort the Coupon List");
		frame.getContentPane().setBackground(SystemColor.info);
		frame.setBounds(100, 100, 1112, 747);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JButton btnNewButton = new JButton("Exit");
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 24));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(479, 585, 123, 39);
		frame.getContentPane().add(btnNewButton);

		JLabel lblListTheCoupon = new JLabel("Coupon List");
		lblListTheCoupon.setHorizontalAlignment(SwingConstants.CENTER);
		lblListTheCoupon.setForeground(Color.BLACK);
		lblListTheCoupon.setFont(new Font("Calibri", Font.BOLD, 38));
		lblListTheCoupon.setBackground(Color.ORANGE);
		lblListTheCoupon.setBounds(340, 17, 388, 69);
		frame.getContentPane().add(lblListTheCoupon);

		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setFont(new Font("Calibri", Font.BOLD, 24));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "ProviderName", "ProductName", "Price",
				"DiscountRate", "Expirationpeiod", "Status", "FinalPrice" }));
		comboBox.setBounds(420, 101, 232, 39);
		frame.getContentPane().add(comboBox);

		JButton button = new JButton("Search");
		button.addActionListener(new ActionListener()
		/* Click "Search" button to show the sorted list based on selected condition */
		{
			public void actionPerformed(ActionEvent e) {

				if (comboBox.getSelectedIndex() == 0) {
					list.ListCoupons(Which.PROVIDER);
				}
				if (comboBox.getSelectedIndex() == 1) {
					list.ListCoupons(Which.NAME);
				}
				if (comboBox.getSelectedIndex() == 2) {
					list.ListCoupons(Which.PRICE);
				}
				if (comboBox.getSelectedIndex() == 3) {
					list.ListCoupons(Which.DISCOUNTRATE);
				}
				if (comboBox.getSelectedIndex() == 4) {
					list.ListCoupons(Which.EXPIRATIONPERIOD);
				}
				if (comboBox.getSelectedIndex() == 5) {
					list.ListCoupons(Which.USED);
				}
				if (comboBox.getSelectedIndex() == 6) {
					list.ListCoupons(Which.FINALPRICE);
				}
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				for (int index = model.getRowCount() - 1; index >= 0; index--) {
					model.removeRow(index);
				}
				for (int i = 0; i <= list.index; i++) {

					Object[] row = { list.get(i).info.ProviderName, list.get(i).info.ProductName,
							list.get(i).info.Price, list.get(i).info.DiscountRate, list.get(i).info.ExpirationPeriod,
							list.get(i).info.Status,
							list.get(i).info.Price * (100 - list.get(i).info.DiscountRate) / 100 };

					model.addRow(row);

				}
			}
		});
		button.setFont(new Font("Calibri", Font.BOLD, 24));
		button.setBackground(Color.ORANGE);
		button.setBounds(683, 96, 171, 48);
		frame.getContentPane().add(button);

		JLabel lblSelectThe = new JLabel("Select the Term List Sorted by :");
		lblSelectThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectThe.setForeground(Color.BLACK);
		lblSelectThe.setFont(new Font("Calibri", Font.BOLD, 24));
		lblSelectThe.setBackground(Color.ORANGE);
		lblSelectThe.setBounds(87, 86, 318, 69);
		frame.getContentPane().add(lblSelectThe);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(87, 165, 891, 391);
		frame.getContentPane().add(scrollPane);
		table = new JTable(new DefaultTableModel(new Object[][] {}, new String[] { "ProviderName", "ProductName",
				"Price", "DiscountRate", "ExpirationPeriod", "Status", "FinalPrice" }) {
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
		scrollPane.setViewportView(table);
		table.setEnabled(false);
		table.setFont(new Font("Calibri", Font.PLAIN, 18));

	}
}
