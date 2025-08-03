package creating_a_GUI_bank_balance_application;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.text.DecimalFormat;
import javax.swing.SwingConstants;
import javax.swing.Box;
import javax.swing.JScrollPane;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;




public class Main {
	
	private static final DecimalFormat Money = new DecimalFormat("###,###,##0.00");
	private static double accountBalance = 0.00;
	
	private static JFrame frame = null;
	
	private static JPanel rootPanel = null;
	private static JPanel bankNamePanel = null;
	private static JPanel accountBalancePanel = null;
	private static JPanel transactionPanel = null;
	private static JPanel transactionHeaderPanel = null;
	private static JPanel transactionCenterPanel = null;
	private static JPanel withdrawalPanel = null;
	private static JPanel depositPanel = null;
	private static JPanel transactGridPanel = null;
	private static JPanel transactGridHeaderPanel = null;
	private static JPanel transactGridPanelTable = null;
	private static JPanel headerPanel = null;
	
	private static JButton withdrawalButton = null;
	private static JButton depositButton = null;
	
	private static GridBagConstraints frameLayout = null;
	
	private static JLabel bankNameLabel = null;
	private static JLabel accountBalanceLabel = null;
	private static JLabel withdrawalAmmountLabel = null;
	private static JLabel depositAmmountLabel = null;
	private static JLabel withdrawalDepositLabel = null;
	private static JLabel transactLabel = null;
	
	private static JTextField accountBalanceValue = null;
	private static JTextField withdrawalValue = null;
	private static JTextField depositValue = null;
	
	private static JTable transactions = null;
	
	private static JScrollPane tableScroll = null;
	
	private static Object[][] transactionsArray = null;
	private static final String [] fields = {"Date and Time", "Value"};
	public static DefaultTableModel transactTable = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		/*
		JFrame frame = null;
		
		JPanel rootPanel = null;
		JPanel bankNamePanel = null;
		JPanel accountBalancePanel = null;
		JPanel transactionPanel = null;
		JPanel transactionHeaderPanel = null;
		JPanel transactionCenterPanel = null;
		JPanel withdrawalPanel = null;
		JPanel depositPanel = null;
		JPanel transactGridPanel = null;
		JPanel transactGridHeaderPanel = null;
		JPanel transactGridPanelTable = null;
		JPanel headerPanel = null;
		
		JButton withdrawalButton = null;
		JButton depositButton = null;
		
		GridBagConstraints frameLayout = null;
		
		JLabel bankNameLabel = null;
		JLabel accountBalanceLabel = null;
		JLabel withdrawalAmmountLabel = null;
		JLabel depositAmmountLabel = null;
		JLabel withdrawalDepositLabel = null;
		JLabel transactLabel = null;
		
		JTextField accountBalanceValue = null;
		JTextField withdrawalValue = null;
		JTextField depositValue = null;
		
		JTable transactions = null;
		
		JScrollPane tableScroll = null;
		*/
		
		
		
		//******HEADER SECTION******//
		
		//Build bankName panel
		bankNameLabel = new JLabel("<BankName> Bank");
		bankNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		bankNamePanel = new JPanel(new BorderLayout());
		bankNamePanel.add(bankNameLabel, BorderLayout.CENTER);
		bankNamePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
		
		
		//Build accountBalance panel
		accountBalanceLabel = new JLabel("Account Balance: ");
		accountBalanceLabel.setPreferredSize(null);
		
		accountBalanceValue = new JTextField(Money.format(accountBalance));
		accountBalanceValue.setColumns(20);
		accountBalanceValue.setEditable(false);
		
		accountBalancePanel = new JPanel();
		accountBalancePanel.add(accountBalanceLabel);
		accountBalancePanel.add(accountBalanceValue);
		
		
		//Build header panel
		headerPanel = new JPanel(new GridBagLayout());
		frameLayout = new GridBagConstraints();
		//headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		frameLayout.gridx = 0;
		frameLayout.gridy = 0;
		frameLayout.fill = GridBagConstraints.WEST;
		frameLayout.anchor = GridBagConstraints.WEST;
		frameLayout.weightx = 1.0;
		headerPanel.add(bankNamePanel, frameLayout);
		
		frameLayout.gridx = 1;
		frameLayout.fill = GridBagConstraints.EAST;
		frameLayout.anchor = GridBagConstraints.EAST;
		headerPanel.add(accountBalancePanel, frameLayout);
		
		//******HEADER SECTION******//
		
		
		
		//******INTERACTIVE WITHDRAWL AND DEPOSIT SECTION******//
		
		//Build withdrawalAmmountLabel
		withdrawalAmmountLabel = new JLabel("Enter Withdrawal Ammount");
		withdrawalAmmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
				
		//Build depositAmmountLabel
		depositAmmountLabel = new JLabel("Enter Deposit Ammount");
		depositAmmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		//Build withdrawalLabel
		withdrawalDepositLabel = new JLabel("Withdrawals and Deposits");
				
		//Build depositLabel
		//depositLabel = new JLabel("Deposits");
		
		
		//Build withdrawal panel
		withdrawalValue = new JTextField(15);
		withdrawalButton = new JButton("Withdrawal");
		withdrawalPanel = new JPanel(new GridLayout(0,1));
		withdrawalPanel.add(withdrawalAmmountLabel);
		withdrawalPanel.add(withdrawalValue);
		withdrawalPanel.add(withdrawalButton);
		
		
		//Build deposit panel
		depositValue = new JTextField(15);
		depositButton = new JButton("Deposit");
		depositPanel = new JPanel(new GridLayout(0,1));
		depositPanel.add(depositAmmountLabel);
		depositPanel.add(depositValue);
		depositPanel.add(depositButton);

		//Build transactionHeader panel
		transactionHeaderPanel = new JPanel();
		transactionHeaderPanel.add(withdrawalDepositLabel);
		//transactionHeaderPanel.add(depositLabel);
		
		//Build transactionCenter panel
		transactionCenterPanel = new JPanel();
		transactionCenterPanel.add(withdrawalPanel);
		transactionCenterPanel.add(depositPanel);
		
		//Build transaction panel
		transactionPanel = new JPanel(new BorderLayout());
		transactionPanel.add(transactionHeaderPanel, BorderLayout.NORTH);
		transactionPanel.add(transactionCenterPanel, BorderLayout.CENTER);
		
		//******INTERACTIVE WITHDRAWL AND DEPOSIT SECTION******//
		
		
		
		//******TRANSACTION DISPLAY GRID SECTION******//
		
		//Build transactGridHeader panel
		transactGridHeaderPanel = new JPanel();
		transactLabel = new JLabel("Transaction History");
		transactGridHeaderPanel.add(transactLabel);
		
		//Build transactTable panel
		transactGridPanelTable = new JPanel();
		
		
		//transactTableTable
		transactionsArray = new Object[][] {};
		//fields = {"Date and Time", "Value"};
		transactTable = new DefaultTableModel(transactionsArray, fields);
		
		transactions = new JTable(transactTable);
		tableScroll = new JScrollPane(transactions);
		
		transactGridPanelTable.add(tableScroll);
		
		
		
		
		
		//Build transactGrid panel
		transactGridPanel = new JPanel(new BorderLayout());
		transactGridPanel.add(transactGridHeaderPanel, BorderLayout.NORTH);
		transactGridPanel.add(transactGridPanelTable, BorderLayout.CENTER);
		

		//******TRANSACTION DISPLAY GRID SECTION******//
		
		
		
		
		//Build Frame
		frame = new JFrame("Welcome to your totally legitimate bank application!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//set Frame to root panel
		rootPanel = new JPanel(new GridBagLayout());
		frame.setContentPane(rootPanel);
		frameLayout = new GridBagConstraints();
		
		//set Header
		frameLayout.gridy = 0;
		frameLayout.gridx = 0;
		frameLayout.weightx = 1.0;
		frameLayout.fill = GridBagConstraints.HORIZONTAL;
		frameLayout.anchor = GridBagConstraints.CENTER;
		frameLayout.gridwidth = GridBagConstraints.REMAINDER;
		rootPanel.add(headerPanel, frameLayout);
		
		
		frameLayout = new GridBagConstraints();
		frameLayout.anchor = GridBagConstraints.CENTER;
		frameLayout.fill = GridBagConstraints.HORIZONTAL;
		
		
		//add second row left panel
		frameLayout.gridx = 0;
		frameLayout.gridy = 1;
		rootPanel.add(transactionPanel, frameLayout);
		
		//add second row right panel
		frameLayout.gridx = 1;
		rootPanel.add(transactGridPanel, frameLayout);
		
		
		
		//Set Frame to size of components
		frame.pack();
		//frame.setSize(2000,800);
		frame.setVisible(true);
		
		
		//ActionListener for Deposit Button
		depositButton.addActionListener(e -> {
			try {
				double amount = Double.parseDouble(depositValue.getText().trim());
				
				if (amount < 0) {
					depositValue.setText("Non-Negative Values Only");
					return;
				}
				
				accountBalance = accountBalance + amount;
				accountBalanceValue.setText(Money.format(accountBalance));
				LocalDateTime now = LocalDateTime.now();
				
		        transactTable.addRow(new Object[]{
		            now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
		            String.format("+%.2f", amount)
		        });

		        depositValue.setText("");
				
			} catch (NumberFormatException ex) {
				depositValue.setText("INVALID INPUT");
			}
		});
		
		//ActionListener for Withdrawal Button
		withdrawalButton.addActionListener(e -> {
			try {
				double amount = Double.parseDouble(withdrawalValue.getText().trim());
				
				if (amount < 0) {
					withdrawalValue.setText("Non-Negative Values Only");
					return;
				}
				
				accountBalance = accountBalance - amount;
				accountBalanceValue.setText(Money.format(accountBalance));
				LocalDateTime now = LocalDateTime.now();
				
		        transactTable.addRow(new Object[]{
		            now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
		            String.format("-%.2f", amount)
		        });

		        withdrawalValue.setText("");
				
			} catch (NumberFormatException ex) {
				withdrawalValue.setText("INVALID INPUT");
			}
		});
	}

}
