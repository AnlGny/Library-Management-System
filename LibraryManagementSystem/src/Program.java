//****************************** GROUP MEMBERS ******************************
//---------------------------------------------------------------------------
//------ ID ------------ NAME SURNAME ------------------- MAIL --------------
//---------------------------------------------------------------------------
//-- 20761913234 -- Burak Güçlü				-- burak.guclu@tedu.edu.tr
//-- 11782105296 -- Hüseyin Anıl Günay		-- hanil.gunay@tedu.edu.tr
//-- 14699041510 -- Gizem Yüksel			-- gizem.yuksel@tedu.edu.tr
//-- 44905315944 -- Zeynep Bakanoğulları 	-- zeynep.bakanogullari@tedu.edu.tr
//***************************************************************************
// This is the Java code that is used for our application.
//***************************************************************************

import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import javax.swing.JDesktopPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JToggleButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Program {

	private JFrame frmTeduLibraryManagement;

	DefaultTableModel myModel_Author = new DefaultTableModel();
	DefaultTableModel myModel_Book = new DefaultTableModel();
	DefaultTableModel myModel_Lecture = new DefaultTableModel();
	DefaultTableModel myModel_Librarian = new DefaultTableModel();
	DefaultTableModel myModel_Publisher = new DefaultTableModel();
	DefaultTableModel myModel_Student = new DefaultTableModel();
	DefaultTableModel myModel_Teacher = new DefaultTableModel();

	Object[] cols_Author = { "Name", "Gender", "Date_of_Birth", "Num_of_Books", "Name_Publisher" };
	Object[] rows_Author = new Object[20];
	Object[] cols_Book = { "Title", "ISBN", "Num_of_Pages", "Year", "Date", "Type", "Department", "Author_Name",
			"Publisher_Name", "Librarian_ID", "Teacher_ID", "Student_ID", };
	Object[] rows_Book = new Object[20];
	Object[] cols_Lecture = { "ID", "Title", "Num_of_Hours_Per_Week", "Credit", "Department" };
	Object[] rows_Lecture = new Object[20];
	Object[] cols_Librarian = { "ID", "Name", "Date_of_Birth", "Gender" };
	Object[] rows_Librarian = new Object[20];
	Object[] cols_Publisher = { "Name", "Address", "Type" };
	Object[] rows_Publisher = new Object[20];
	Object[] cols_Student = { "Name", "ID", "Department", "ID_Lecture", "ISBN_Book", "Date_of_Birth", "Gender" };
	Object[] rows_Student = new Object[20];
	Object[] cols_Teacher = { "Name", "ID", "Department", "ID_Lecture", "ISBN_Book", "Date_of_Birth", "Gender" };
	Object[] rows_Teacher = new Object[20];

	private JTabbedPane tabbedPane;
	private JPanel Author_TAB;
	private JButton btnNewButton;
	private JPanel panel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel;
	private JTable table;
	private JTextField textField_6;
	private JTextField txtTitle;
	private JTextField txtGen;
	private JTextField txtDate;
	private JTextField txtIsbn;
	private JTextField txtYear;
	private JTextField textField_15;
	private JTextField txtId;
	private JTextField txtTitle_1;
	private JTextField txtNumberOfHours;
	private JTextField txtCredits;
	private JTextField txtDepartment_1;
	private JTextField txtId_1;
	private JTextField txtName;
	private JTextField textField_27;
	private JTextField txtGender;
	private JTextField col_name;
	private JTextField textField_34;
	private JTextField txtAddress;
	private JTextField txtType_1;
	private JTextField textField_43;
	private JTextField textField_44;
	private JTextField textField_45;
	private JTextField textField_46;
	private JTextField textField_47;
	private JTextField textField_52;
	private JTextField textField_53;
	private JTextField textField_54;
	private JTextField textField_55;
	private JTextField textField_56;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTable table_4;
	private JTable table_5;
	private JTable table_6;
	private JTextField txtDepartment;
	private JTextField txtType;
	private JTextField txtAuthorName;
	private JTextField txtPublisherName;
	private JTextField txtLibrarianId;
	private JTextField textField_5;
	private JTextField Author_data_for_Name;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField Year1;
	private JTextField Year2;
	private JTextField Page_number;
	private JTextField youngest_teacher;
	private JTextField Pagenum1;
	private JTextField Pagenum2;
	private JTextField LibrarianGender;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Program window = new Program();
					window.frmTeduLibraryManagement.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws SQLException
	 */
	public Program() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws SQLException
	 */
	private void initialize() throws SQLException {

		myConnection myConnection = new myConnection();

		frmTeduLibraryManagement = new JFrame();
		frmTeduLibraryManagement.getContentPane().setBackground(new Color(240, 240, 240));
		frmTeduLibraryManagement.setTitle("TEDU Library Management System");
		frmTeduLibraryManagement.setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\Burak\\eclipse-workspace\\LibraryManagementSystem\\src\\131747871_4336456563048176_1244024346933912217_n.jpg"));
		frmTeduLibraryManagement.setBounds(100, 100, 944, 761);
		frmTeduLibraryManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTeduLibraryManagement.getContentPane().setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 910, 704);
		frmTeduLibraryManagement.getContentPane().add(tabbedPane);

		Author_TAB = new JPanel();
		tabbedPane.addTab("Author", null, Author_TAB, null);
		Author_TAB.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 905, 373);
		Author_TAB.add(scrollPane_1);

		table = new JTable();
		myModel_Author.setColumnIdentifiers(cols_Author);

		ResultSet myRS_Author = myConnection.showTable("Author");

		try {
			while (myRS_Author.next()) {
				rows_Author[0] = myRS_Author.getString("Name");
				rows_Author[1] = myRS_Author.getString("Gender");
				rows_Author[2] = myRS_Author.getString("Date_of_Birth");
				rows_Author[3] = myRS_Author.getString("Num_of_Books");
				rows_Author[4] = myRS_Author.getString("Name_Publisher");
				myModel_Author.addRow(rows_Author);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		myModel_Author.setColumnIdentifiers(cols_Author);

		table.setModel(myModel_Author);

		scrollPane_1.setViewportView(table);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 383, 317, 77);
		Author_TAB.add(panel);

		textField = new JTextField();
		textField.setText("Name");
		textField.setColumns(10);
		textField.setBounds(10, 22, 96, 19);
		panel.add(textField);

		textField_1 = new JTextField();
		textField_1.setText("Gender");
		textField_1.setColumns(10);
		textField_1.setBounds(111, 22, 96, 19);
		panel.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setText("Date of Birth");
		textField_2.setColumns(10);
		textField_2.setBounds(212, 22, 96, 19);
		panel.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setText("Number of Books");
		textField_3.setColumns(10);
		textField_3.setBounds(10, 47, 96, 19);
		panel.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setText("Publisher Name");
		textField_4.setColumns(10);
		textField_4.setBounds(111, 47, 96, 19);
		panel.add(textField_4);

		btnNewButton_1 = new JButton("Add Author");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addAuthor();
			}
		});
		btnNewButton_1.setBounds(212, 46, 96, 21);
		panel.add(btnNewButton_1);

		lblNewLabel = new JLabel("Adding Author");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(111, 0, 96, 19);
		panel.add(lblNewLabel);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBounds(327, 383, 317, 52);
		Author_TAB.add(panel_2_1);

		JLabel lblNewLabel_2_1 = new JLabel("Average Book Numbers of Authors");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBounds(10, 0, 297, 19);
		panel_2_1.add(lblNewLabel_2_1);

		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(157, 23, 150, 19);
		panel_2_1.add(textField_6);

		JButton btnNewButton_1_2_1 = new JButton("Show Average");
		btnNewButton_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showAverageAuthor();
			}
		});
		btnNewButton_1_2_1.setBounds(10, 22, 137, 21);
		panel_2_1.add(btnNewButton_1_2_1);

		JButton btnNewButton_1_9 = new JButton("Refresh Table");
		btnNewButton_1_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh_AuthorTable();
			}
		});
		btnNewButton_1_9.setBounds(776, 383, 119, 21);
		Author_TAB.add(btnNewButton_1_9);

		JButton btnNewButton_1_9_1_1_1_1 = new JButton("Update Table");
		btnNewButton_1_9_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update_AuthorTable();
			}
		});
		btnNewButton_1_9_1_1_1_1.setBounds(776, 414, 119, 21);
		Author_TAB.add(btnNewButton_1_9_1_1_1_1);

		JPanel panel_2_1_7 = new JPanel();
		panel_2_1_7.setLayout(null);
		panel_2_1_7.setBounds(0, 470, 317, 52);
		Author_TAB.add(panel_2_1_7);

		JLabel lblNewLabel_2_1_7 = new JLabel("Show Author by Using Name");
		lblNewLabel_2_1_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_7.setBounds(62, 0, 193, 19);
		panel_2_1_7.add(lblNewLabel_2_1_7);

		Author_data_for_Name = new JTextField();
		Author_data_for_Name.setColumns(10);
		Author_data_for_Name.setBounds(157, 23, 150, 19);
		panel_2_1_7.add(Author_data_for_Name);

		JButton btnNewButton_1_2_1_6 = new JButton("Show Author");
		btnNewButton_1_2_1_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showAuthor_usingName();
			}
		});
		btnNewButton_1_2_1_6.setBounds(10, 22, 137, 21);
		panel_2_1_7.add(btnNewButton_1_2_1_6);

		JPanel panel_2_1_7_1 = new JPanel();
		panel_2_1_7_1.setLayout(null);
		panel_2_1_7_1.setBounds(0, 532, 317, 52);
		Author_TAB.add(panel_2_1_7_1);

		JLabel lblNewLabel_2_1_7_1 = new JLabel("Show Number of Authors According to Their Types");
		lblNewLabel_2_1_7_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_7_1.setBounds(10, 0, 297, 19);
		panel_2_1_7_1.add(lblNewLabel_2_1_7_1);

		JButton btnNewButton_1_2_1_6_2 = new JButton("Show Result");
		btnNewButton_1_2_1_6_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showAuthors_withType();
			}
		});
		btnNewButton_1_2_1_6_2.setBounds(10, 22, 297, 21);
		panel_2_1_7_1.add(btnNewButton_1_2_1_6_2);

		JPanel Book_TAB = new JPanel();
		Book_TAB.setLayout(null);
		tabbedPane.addTab("Book", null, Book_TAB, null);

		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(0, 0, 905, 373);
		Book_TAB.add(scrollPane_1_1);

		table_1 = new JTable();
		myModel_Book.setColumnIdentifiers(cols_Book);

		ResultSet myRS_Book = myConnection.showTable("Book");

		try {
			while (myRS_Book.next()) {

				if (myRS_Book.getString("ISBN").equals("-"))
					continue;

				rows_Book[0] = myRS_Book.getString("Title");
				rows_Book[1] = myRS_Book.getString("ISBN");
				rows_Book[2] = myRS_Book.getString("Num_of_Pages");
				rows_Book[3] = myRS_Book.getString("Year");
				rows_Book[4] = myRS_Book.getString("Date");
				rows_Book[5] = myRS_Book.getString("Type");
				rows_Book[6] = myRS_Book.getString("Department");
				rows_Book[7] = myRS_Book.getString("Author_Name");
				rows_Book[8] = myRS_Book.getString("Publisher_Name");
				rows_Book[9] = myRS_Book.getString("Librarian_ID");
				rows_Book[10] = myRS_Book.getString("Teacher_ID");
				rows_Book[11] = myRS_Book.getString("Student_ID");
				myModel_Book.addRow(rows_Book);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		myModel_Book.setColumnIdentifiers(cols_Book);

		table_1.setModel(myModel_Book);

		scrollPane_1_1.setViewportView(table_1);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(10, 382, 233, 198);
		Book_TAB.add(panel_3);

		txtTitle = new JTextField();
		txtTitle.setText("Title");
		txtTitle.setColumns(10);
		txtTitle.setBounds(10, 29, 96, 19);
		panel_3.add(txtTitle);

		txtGen = new JTextField();
		txtGen.setText("Number of Pages");
		txtGen.setColumns(10);
		txtGen.setBounds(10, 83, 96, 19);
		panel_3.add(txtGen);

		txtDate = new JTextField();
		txtDate.setText("Date");
		txtDate.setColumns(10);
		txtDate.setBounds(10, 141, 96, 19);
		panel_3.add(txtDate);

		txtIsbn = new JTextField();
		txtIsbn.setText("ISBN");
		txtIsbn.setColumns(10);
		txtIsbn.setBounds(10, 58, 96, 19);
		panel_3.add(txtIsbn);

		txtYear = new JTextField();
		txtYear.setText("Year");
		txtYear.setColumns(10);
		txtYear.setBounds(10, 112, 96, 19);
		panel_3.add(txtYear);

		JLabel lblNewLabel_3 = new JLabel("Adding Book");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(66, 0, 96, 19);
		panel_3.add(lblNewLabel_3);

		txtDepartment = new JTextField();
		txtDepartment.setText("Department");
		txtDepartment.setColumns(10);
		txtDepartment.setBounds(116, 141, 96, 19);
		panel_3.add(txtDepartment);

		txtType = new JTextField();
		txtType.setText("Type");
		txtType.setColumns(10);
		txtType.setBounds(116, 29, 96, 19);
		panel_3.add(txtType);

		txtAuthorName = new JTextField();
		txtAuthorName.setText("Author Name");
		txtAuthorName.setColumns(10);
		txtAuthorName.setBounds(116, 54, 96, 19);
		panel_3.add(txtAuthorName);

		txtPublisherName = new JTextField();
		txtPublisherName.setText("Publisher Name");
		txtPublisherName.setColumns(10);
		txtPublisherName.setBounds(116, 83, 96, 19);
		panel_3.add(txtPublisherName);

		txtLibrarianId = new JTextField();
		txtLibrarianId.setToolTipText("");
		txtLibrarianId.setText("Librarian ID");
		txtLibrarianId.setColumns(10);
		txtLibrarianId.setBounds(116, 112, 96, 19);
		panel_3.add(txtLibrarianId);

		JButton btnNewButton_1_3 = new JButton("Add Book");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBook();
			}
		});
		btnNewButton_1_3.setBounds(47, 170, 128, 21);
		panel_3.add(btnNewButton_1_3);

		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBounds(253, 383, 317, 52);
		Book_TAB.add(panel_2_1_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("Show Book by Using Title");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setBounds(62, 0, 193, 19);
		panel_2_1_1.add(lblNewLabel_2_1_1);

		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(157, 23, 150, 19);
		panel_2_1_1.add(textField_15);

		JButton btnNewButton_1_2_1_1 = new JButton("Show Book");
		btnNewButton_1_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showBook_withTitle();
			}
		});
		btnNewButton_1_2_1_1.setBounds(10, 22, 137, 21);
		panel_2_1_1.add(btnNewButton_1_2_1_1);

		JButton btnNewButton_1_9_1_1_1_3 = new JButton("Refresh Table");
		btnNewButton_1_9_1_1_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh_BookTable();
			}
		});
		btnNewButton_1_9_1_1_1_3.setBounds(776, 383, 119, 21);
		Book_TAB.add(btnNewButton_1_9_1_1_1_3);

		JButton btnNewButton_1_9_1_1_1_4 = new JButton("Update Table");
		btnNewButton_1_9_1_1_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update_BookTable();
			}
		});
		btnNewButton_1_9_1_1_1_4.setBounds(776, 414, 119, 21);
		Book_TAB.add(btnNewButton_1_9_1_1_1_4);

		JPanel panel_2_1_7_2 = new JPanel();
		panel_2_1_7_2.setLayout(null);
		panel_2_1_7_2.setBounds(253, 445, 317, 52);
		Book_TAB.add(panel_2_1_7_2);

		JLabel lblNewLabel_2_1_7_2 = new JLabel("Show Book by Using ISBN");
		lblNewLabel_2_1_7_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_7_2.setBounds(62, 0, 193, 19);
		panel_2_1_7_2.add(lblNewLabel_2_1_7_2);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(157, 23, 150, 19);
		panel_2_1_7_2.add(textField_7);

		JButton btnNewButton_1_2_1_6_3 = new JButton("Show Book");
		btnNewButton_1_2_1_6_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showBook_withISBN();
			}
		});
		btnNewButton_1_2_1_6_3.setBounds(10, 22, 137, 21);
		panel_2_1_7_2.add(btnNewButton_1_2_1_6_3);

		JPanel panel_2_1_8 = new JPanel();
		panel_2_1_8.setLayout(null);
		panel_2_1_8.setBounds(253, 507, 317, 52);
		Book_TAB.add(panel_2_1_8);

		JLabel lblNewLabel_2_1_8 = new JLabel("Total Number Book in the Library");
		lblNewLabel_2_1_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_8.setBounds(10, 0, 297, 19);
		panel_2_1_8.add(lblNewLabel_2_1_8);

		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(157, 23, 150, 19);
		panel_2_1_8.add(textField_8);

		JButton btnNewButton_1_2_1_7 = new JButton("Show Result");
		btnNewButton_1_2_1_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showTotalNum_Book();
			}
		});
		btnNewButton_1_2_1_7.setBounds(10, 22, 137, 21);
		panel_2_1_8.add(btnNewButton_1_2_1_7);

		JPanel panel_2_1_8_1 = new JPanel();
		panel_2_1_8_1.setLayout(null);
		panel_2_1_8_1.setBounds(580, 445, 317, 52);
		Book_TAB.add(panel_2_1_8_1);

		JLabel lblNewLabel_2_1_8_1 = new JLabel("Check Statement of Book If it is available (ISBN)");
		lblNewLabel_2_1_8_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_8_1.setBounds(10, 0, 297, 19);
		panel_2_1_8_1.add(lblNewLabel_2_1_8_1);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(157, 23, 150, 19);
		panel_2_1_8_1.add(textField_9);

		JButton btnNewButton_1_2_1_7_1 = new JButton("Check");
		btnNewButton_1_2_1_7_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkBook_ISBN();
			}
		});
		btnNewButton_1_2_1_7_1.setBounds(10, 22, 137, 21);
		panel_2_1_8_1.add(btnNewButton_1_2_1_7_1);

		JPanel panel_2_1_8_2 = new JPanel();
		panel_2_1_8_2.setLayout(null);
		panel_2_1_8_2.setBounds(580, 507, 317, 52);
		Book_TAB.add(panel_2_1_8_2);

		JLabel lblNewLabel_2_1_8_2 = new JLabel("Check Statement of Book If it is taken (Title)");
		lblNewLabel_2_1_8_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_8_2.setBounds(10, 0, 297, 19);
		panel_2_1_8_2.add(lblNewLabel_2_1_8_2);

		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(157, 23, 150, 19);
		panel_2_1_8_2.add(textField_10);

		JButton btnNewButton_1_2_1_7_2 = new JButton("Check");
		btnNewButton_1_2_1_7_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkBook_Title();
			}
		});
		btnNewButton_1_2_1_7_2.setBounds(10, 22, 137, 21);
		panel_2_1_8_2.add(btnNewButton_1_2_1_7_2);

		JPanel panel_2_1_8_3 = new JPanel();
		panel_2_1_8_3.setLayout(null);
		panel_2_1_8_3.setBounds(0, 590, 243, 77);
		Book_TAB.add(panel_2_1_8_3);

		JLabel lblNewLabel_2_1_8_3 = new JLabel("Show the Books Written");
		lblNewLabel_2_1_8_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_8_3.setBounds(10, 0, 231, 19);
		panel_2_1_8_3.add(lblNewLabel_2_1_8_3);

		Year1 = new JTextField();
		Year1.setText("1900");
		Year1.setColumns(10);
		Year1.setBounds(10, 29, 101, 19);
		panel_2_1_8_3.add(Year1);

		Year2 = new JTextField();
		Year2.setText("2000");
		Year2.setColumns(10);
		Year2.setBounds(121, 29, 101, 19);
		panel_2_1_8_3.add(Year2);

		JButton btnNewButton_1_2_1_7_3 = new JButton("Show Result");
		btnNewButton_1_2_1_7_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showBooksWrittenBetweenYears();
			}
		});
		btnNewButton_1_2_1_7_3.setBounds(10, 58, 212, 19);
		panel_2_1_8_3.add(btnNewButton_1_2_1_7_3);

		JLabel lblNewLabel_2_1_8_3_2 = new JLabel("Between Two Specified Years");
		lblNewLabel_2_1_8_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_8_3_2.setBounds(10, 10, 231, 19);
		panel_2_1_8_3.add(lblNewLabel_2_1_8_3_2);

		JPanel panel_2_1_8_3_1 = new JPanel();
		panel_2_1_8_3_1.setLayout(null);
		panel_2_1_8_3_1.setBounds(580, 569, 315, 87);
		Book_TAB.add(panel_2_1_8_3_1);

		Pagenum1 = new JTextField();
		Pagenum1.setText("x");
		Pagenum1.setColumns(10);
		Pagenum1.setBounds(10, 34, 136, 19);
		panel_2_1_8_3_1.add(Pagenum1);

		Pagenum2 = new JTextField();
		Pagenum2.setText("y");
		Pagenum2.setColumns(10);
		Pagenum2.setBounds(156, 34, 149, 19);
		panel_2_1_8_3_1.add(Pagenum2);

		JButton btnNewButton_1_2_1_7_3_1 = new JButton("Show Result");
		btnNewButton_1_2_1_7_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showBooksWithPages();
			}
		});
		btnNewButton_1_2_1_7_3_1.setBounds(10, 63, 295, 21);
		panel_2_1_8_3_1.add(btnNewButton_1_2_1_7_3_1);
		
				JLabel lblNewLabel_2_1_8_3_1 = new JLabel("Show Books with Numbers of Pages More Than x");
				lblNewLabel_2_1_8_3_1.setBounds(0, 0, 315, 19);
				panel_2_1_8_3_1.add(lblNewLabel_2_1_8_3_1);
				lblNewLabel_2_1_8_3_1.setHorizontalAlignment(SwingConstants.CENTER);
				
				JLabel lblNewLabel_2_1_8_3_1_1 = new JLabel("Less Than y");
				lblNewLabel_2_1_8_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_2_1_8_3_1_1.setBounds(0, 7, 315, 27);
				panel_2_1_8_3_1.add(lblNewLabel_2_1_8_3_1_1);

		JPanel panel_2_1_8_3_2 = new JPanel();
		panel_2_1_8_3_2.setLayout(null);
		panel_2_1_8_3_2.setBounds(253, 569, 317, 45);
		Book_TAB.add(panel_2_1_8_3_2);

		JLabel lblNewLabel_2_1_8_3_3 = new JLabel("Show Types That Have More Than Average 300 Pages");
		lblNewLabel_2_1_8_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_8_3_3.setBounds(0, 0, 317, 19);
		panel_2_1_8_3_2.add(lblNewLabel_2_1_8_3_3);

		JButton btnNewButton_1_2_1_7_3_2 = new JButton("Show Result");
		btnNewButton_1_2_1_7_3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showTypeMoreThan300();
			}
		});
		btnNewButton_1_2_1_7_3_2.setBounds(10, 20, 307, 19);
		panel_2_1_8_3_2.add(btnNewButton_1_2_1_7_3_2);

		JPanel Lecture_TAB = new JPanel();
		Lecture_TAB.setLayout(null);
		tabbedPane.addTab("Lecture", null, Lecture_TAB, null);

		JScrollPane scrollPane_1_2 = new JScrollPane();
		scrollPane_1_2.setBounds(0, 0, 905, 373);
		Lecture_TAB.add(scrollPane_1_2);

		table_2 = new JTable();
		myModel_Lecture.setColumnIdentifiers(cols_Lecture);

		ResultSet myRS_Lecture = myConnection.showTable("Lecture");

		try {
			while (myRS_Lecture.next()) {
				rows_Lecture[0] = myRS_Lecture.getString("ID");
				rows_Lecture[1] = myRS_Lecture.getString("Title");
				rows_Lecture[2] = myRS_Lecture.getString("Num_of_Hours_Per_Week");
				rows_Lecture[3] = myRS_Lecture.getString("Credits");
				rows_Lecture[4] = myRS_Lecture.getString("Department");
				myModel_Lecture.addRow(rows_Lecture);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		myModel_Lecture.setColumnIdentifiers(cols_Lecture);

		table_2.setModel(myModel_Lecture);

		scrollPane_1_2.setViewportView(table_2);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(0, 383, 317, 77);
		Lecture_TAB.add(panel_4);

		txtId = new JTextField();
		txtId.setText("ID");
		txtId.setColumns(10);
		txtId.setBounds(10, 22, 96, 19);
		panel_4.add(txtId);

		txtTitle_1 = new JTextField();
		txtTitle_1.setText("Title");
		txtTitle_1.setColumns(10);
		txtTitle_1.setBounds(111, 22, 96, 19);
		panel_4.add(txtTitle_1);

		txtNumberOfHours = new JTextField();
		txtNumberOfHours.setText("Number of Hours Per Week");
		txtNumberOfHours.setColumns(10);
		txtNumberOfHours.setBounds(212, 22, 96, 19);
		panel_4.add(txtNumberOfHours);

		txtCredits = new JTextField();
		txtCredits.setText("Credits");
		txtCredits.setColumns(10);
		txtCredits.setBounds(10, 47, 96, 19);
		panel_4.add(txtCredits);

		txtDepartment_1 = new JTextField();
		txtDepartment_1.setText("Department");
		txtDepartment_1.setColumns(10);
		txtDepartment_1.setBounds(111, 47, 96, 19);
		panel_4.add(txtDepartment_1);

		JButton btnNewButton_1_4 = new JButton("Add Lecture");
		btnNewButton_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addLecture();
			}
		});
		btnNewButton_1_4.setBounds(212, 46, 96, 21);
		panel_4.add(btnNewButton_1_4);

		JLabel lblNewLabel_4 = new JLabel("Adding Lecture");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(111, 0, 96, 19);
		panel_4.add(lblNewLabel_4);

		JButton btnNewButton_1_9_1_1_1_5 = new JButton("Refresh Table");
		btnNewButton_1_9_1_1_1_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh_LectureTable();
			}
		});
		btnNewButton_1_9_1_1_1_5.setBounds(776, 383, 119, 21);
		Lecture_TAB.add(btnNewButton_1_9_1_1_1_5);

		JButton btnNewButton_1_9_1_1_1_6 = new JButton("Update Table");
		btnNewButton_1_9_1_1_1_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update_LectureTable();
			}
		});
		btnNewButton_1_9_1_1_1_6.setBounds(776, 414, 119, 21);
		Lecture_TAB.add(btnNewButton_1_9_1_1_1_6);

		JPanel Librarian_TAB = new JPanel();
		Librarian_TAB.setLayout(null);
		tabbedPane.addTab("Librarian", null, Librarian_TAB, null);

		JScrollPane scrollPane_1_3 = new JScrollPane();
		scrollPane_1_3.setBounds(0, 0, 905, 373);
		Librarian_TAB.add(scrollPane_1_3);

		table_3 = new JTable();
		myModel_Librarian.setColumnIdentifiers(cols_Librarian);

		ResultSet myRS_Librarian = myConnection.showTable("Librarian");
		ResultSetMetaData columnname = (ResultSetMetaData) myRS_Librarian.getMetaData();
		int col_count = columnname.getColumnCount();
		cols_Librarian = new Object[col_count];

		for (int a = 0; a < col_count; a++)
			cols_Librarian[a] = columnname.getColumnName(a + 1);

		try {
			while (myRS_Librarian.next()) {
				int i = 0;

				while (i < col_count) {
					String temp = String.valueOf(cols_Librarian[i]);
					rows_Librarian[i] = myRS_Librarian.getString(temp);
					i++;
				}

				myModel_Librarian.addRow(rows_Librarian);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		myModel_Librarian.setColumnIdentifiers(cols_Librarian);

		table_3.setModel(myModel_Librarian);

		refresh_LibrarianTable();

		scrollPane_1_3.setViewportView(table_3);

		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBounds(0, 383, 317, 77);
		Librarian_TAB.add(panel_5);

		txtId_1 = new JTextField();
		txtId_1.setText("ID");
		txtId_1.setColumns(10);
		txtId_1.setBounds(10, 22, 96, 19);
		panel_5.add(txtId_1);

		txtName = new JTextField();
		txtName.setText("Name");
		txtName.setColumns(10);
		txtName.setBounds(111, 22, 96, 19);
		panel_5.add(txtName);

		textField_27 = new JTextField();
		textField_27.setText("Date of Birth");
		textField_27.setColumns(10);
		textField_27.setBounds(212, 22, 96, 19);
		panel_5.add(textField_27);

		txtGender = new JTextField();
		txtGender.setText("Gender");
		txtGender.setColumns(10);
		txtGender.setBounds(10, 47, 96, 19);
		panel_5.add(txtGender);

		JButton btnNewButton_1_5 = new JButton("Add Librarian");
		btnNewButton_1_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addLibrarian();
			}
		});
		btnNewButton_1_5.setBounds(111, 46, 197, 21);
		panel_5.add(btnNewButton_1_5);

		JLabel lblNewLabel_5 = new JLabel("Adding Librarian");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(111, 0, 96, 19);
		panel_5.add(lblNewLabel_5);

		JPanel panel_2_1_3 = new JPanel();
		panel_2_1_3.setLayout(null);
		panel_2_1_3.setBounds(327, 383, 317, 52);
		Librarian_TAB.add(panel_2_1_3);

		JLabel lblNewLabel_2_1_3 = new JLabel("Add New Column to Librarian Table");
		lblNewLabel_2_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_3.setBounds(62, 0, 193, 19);
		panel_2_1_3.add(lblNewLabel_2_1_3);

		col_name = new JTextField();
		col_name.setColumns(10);
		col_name.setBounds(157, 23, 150, 19);
		panel_2_1_3.add(col_name);

		JButton btnNewButton_1_2_1_3 = new JButton("Add Column");
		btnNewButton_1_2_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNewCol_Librarian();
			}
		});
		btnNewButton_1_2_1_3.setBounds(10, 22, 137, 21);
		panel_2_1_3.add(btnNewButton_1_2_1_3);

		JButton btnNewButton_1_9_1_1_1_5_1 = new JButton("Refresh Table");
		btnNewButton_1_9_1_1_1_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh_LibrarianTable();
			}
		});
		btnNewButton_1_9_1_1_1_5_1.setBounds(776, 383, 119, 21);
		Librarian_TAB.add(btnNewButton_1_9_1_1_1_5_1);

		JButton btnNewButton_1_9_1_1_1_6_1 = new JButton("Update Table");
		btnNewButton_1_9_1_1_1_6_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update_LibrarianTable();
			}
		});
		btnNewButton_1_9_1_1_1_6_1.setBounds(776, 414, 119, 21);
		Librarian_TAB.add(btnNewButton_1_9_1_1_1_6_1);

		JPanel panel_2_1_3_1 = new JPanel();
		panel_2_1_3_1.setLayout(null);
		panel_2_1_3_1.setBounds(0, 470, 317, 57);
		Librarian_TAB.add(panel_2_1_3_1);

		JLabel lblNewLabel_2_1_3_1 = new JLabel("Show Librarians and Number of Book");
		lblNewLabel_2_1_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_3_1.setBounds(10, 0, 297, 19);
		panel_2_1_3_1.add(lblNewLabel_2_1_3_1);

		JButton btnNewButton_1_2_1_3_1 = new JButton("Show Result");
		btnNewButton_1_2_1_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showLibrarianCountBook();
			}
		});
		btnNewButton_1_2_1_3_1.setBounds(10, 29, 297, 21);
		panel_2_1_3_1.add(btnNewButton_1_2_1_3_1);

		JLabel lblNewLabel_2_1_3_1_1 = new JLabel("They Are Responsible of");
		lblNewLabel_2_1_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_3_1_1.setBounds(10, 11, 297, 19);
		panel_2_1_3_1.add(lblNewLabel_2_1_3_1_1);
		
		JPanel panel_2_1_2 = new JPanel();
		panel_2_1_2.setLayout(null);
		panel_2_1_2.setBounds(327, 445, 317, 52);
		Librarian_TAB.add(panel_2_1_2);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Show Librarians Accoding to Their Gender");
		lblNewLabel_2_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_2.setBounds(10, 0, 297, 19);
		panel_2_1_2.add(lblNewLabel_2_1_2);
		
		LibrarianGender = new JTextField();
		LibrarianGender.setColumns(10);
		LibrarianGender.setBounds(157, 23, 150, 19);
		panel_2_1_2.add(LibrarianGender);
		
		JButton btnNewButton_1_2_1_2 = new JButton("Show Result");
		btnNewButton_1_2_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showLibrarianGender();
			}
		});
		btnNewButton_1_2_1_2.setBounds(10, 22, 137, 21);
		panel_2_1_2.add(btnNewButton_1_2_1_2);

		JPanel Publisher_TAB = new JPanel();
		Publisher_TAB.setLayout(null);
		tabbedPane.addTab("Publisher", null, Publisher_TAB, null);

		JScrollPane scrollPane_1_4 = new JScrollPane();
		scrollPane_1_4.setBounds(0, 0, 905, 373);
		Publisher_TAB.add(scrollPane_1_4);

		table_4 = new JTable();
		myModel_Publisher.setColumnIdentifiers(cols_Publisher);

		ResultSet myRS_Publisher = myConnection.showTable("Publisher");

		try {
			while (myRS_Publisher.next()) {
				rows_Publisher[0] = myRS_Publisher.getString("Name");
				rows_Publisher[1] = myRS_Publisher.getString("Address");
				rows_Publisher[2] = myRS_Publisher.getString("Type");
				myModel_Publisher.addRow(rows_Publisher);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		myModel_Publisher.setColumnIdentifiers(cols_Publisher);

		table_4.setModel(myModel_Publisher);

		scrollPane_1_4.setViewportView(table_4);

		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBounds(0, 383, 317, 77);
		Publisher_TAB.add(panel_6);

		textField_34 = new JTextField();
		textField_34.setText("Name");
		textField_34.setColumns(10);
		textField_34.setBounds(10, 22, 96, 19);
		panel_6.add(textField_34);

		txtAddress = new JTextField();
		txtAddress.setText("Address");
		txtAddress.setColumns(10);
		txtAddress.setBounds(111, 22, 96, 19);
		panel_6.add(txtAddress);

		txtType_1 = new JTextField();
		txtType_1.setText("Type");
		txtType_1.setColumns(10);
		txtType_1.setBounds(212, 22, 96, 19);
		panel_6.add(txtType_1);

		JButton btnNewButton_1_6 = new JButton("Add Publisher");
		btnNewButton_1_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addPublisher();
			}
		});
		btnNewButton_1_6.setBounds(10, 46, 298, 21);
		panel_6.add(btnNewButton_1_6);

		JLabel lblNewLabel_6 = new JLabel("Adding Publisher");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(10, 0, 297, 19);
		panel_6.add(lblNewLabel_6);

		JButton btnNewButton_1_9_1_1_1_5_2 = new JButton("Refresh Table");
		btnNewButton_1_9_1_1_1_5_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh_PublisherTable();
			}
		});
		btnNewButton_1_9_1_1_1_5_2.setBounds(776, 383, 119, 21);
		Publisher_TAB.add(btnNewButton_1_9_1_1_1_5_2);

		JButton btnNewButton_1_9_1_1_1_6_2 = new JButton("Update Table");
		btnNewButton_1_9_1_1_1_6_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update_PublisherTable();
			}
		});
		btnNewButton_1_9_1_1_1_6_2.setBounds(776, 414, 119, 21);
		Publisher_TAB.add(btnNewButton_1_9_1_1_1_6_2);

		JPanel panel_6_1 = new JPanel();
		panel_6_1.setLayout(null);
		panel_6_1.setBounds(327, 383, 317, 52);
		Publisher_TAB.add(panel_6_1);

		JButton btnNewButton_1_6_1 = new JButton("Show Result");
		btnNewButton_1_6_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				publisherBookRelation();
			}
		});
		btnNewButton_1_6_1.setBounds(10, 21, 298, 21);
		panel_6_1.add(btnNewButton_1_6_1);

		JLabel lblNewLabel_6_1 = new JLabel("Show Book Published by Publisher");
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1.setBounds(10, 0, 298, 19);
		panel_6_1.add(lblNewLabel_6_1);

		JPanel Student_TAB = new JPanel();
		Student_TAB.setLayout(null);
		tabbedPane.addTab("Student", null, Student_TAB, null);

		JScrollPane scrollPane_1_5 = new JScrollPane();
		scrollPane_1_5.setBounds(0, 0, 905, 373);
		Student_TAB.add(scrollPane_1_5);

		table_5 = new JTable();
		myModel_Student.setColumnIdentifiers(cols_Student);

		ResultSet myRS_Student = myConnection.showTable("Student");

		try {
			while (myRS_Student.next()) {

				if (myRS_Student.getString("ID").equals("-"))
					continue;

				rows_Student[0] = myRS_Student.getString("Name");
				rows_Student[1] = myRS_Student.getString("ID");
				rows_Student[2] = myRS_Student.getString("Department");
				rows_Student[3] = myRS_Student.getString("ID_Lecture");
				rows_Student[4] = myRS_Student.getString("ISBN_Book");
				rows_Student[5] = myRS_Student.getString("Date_of_Birth");
				rows_Student[6] = myRS_Student.getString("Gender");
				myModel_Student.addRow(rows_Student);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		myModel_Student.setColumnIdentifiers(cols_Student);

		table_5.setModel(myModel_Student);

		scrollPane_1_5.setViewportView(table_5);

		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBounds(0, 383, 317, 77);
		Student_TAB.add(panel_7);

		textField_43 = new JTextField();
		textField_43.setText("Name");
		textField_43.setColumns(10);
		textField_43.setBounds(10, 22, 96, 19);
		panel_7.add(textField_43);

		textField_44 = new JTextField();
		textField_44.setText("ID");
		textField_44.setColumns(10);
		textField_44.setBounds(111, 22, 96, 19);
		panel_7.add(textField_44);

		textField_45 = new JTextField();
		textField_45.setText("Department");
		textField_45.setColumns(10);
		textField_45.setBounds(212, 22, 96, 19);
		panel_7.add(textField_45);

		textField_46 = new JTextField();
		textField_46.setText("Date of Birth");
		textField_46.setColumns(10);
		textField_46.setBounds(10, 47, 96, 19);
		panel_7.add(textField_46);

		textField_47 = new JTextField();
		textField_47.setText("Gender");
		textField_47.setColumns(10);
		textField_47.setBounds(111, 47, 96, 19);
		panel_7.add(textField_47);

		JButton btnNewButton_1_7 = new JButton("Add Student");
		btnNewButton_1_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addStudent();
			}
		});
		btnNewButton_1_7.setBounds(212, 46, 96, 21);
		panel_7.add(btnNewButton_1_7);

		JLabel lblNewLabel_7 = new JLabel("Adding Student");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(111, 0, 96, 19);
		panel_7.add(lblNewLabel_7);

		JButton btnNewButton_1_9_1 = new JButton("Refresh Table");
		btnNewButton_1_9_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh_StudentTable();
			}
		});
		btnNewButton_1_9_1.setBounds(776, 383, 119, 21);
		Student_TAB.add(btnNewButton_1_9_1);

		JButton btnNewButton_1_9_1_1_1_2 = new JButton("Update Table");
		btnNewButton_1_9_1_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update_StudentTable();
			}
		});
		btnNewButton_1_9_1_1_1_2.setBounds(776, 414, 119, 21);
		Student_TAB.add(btnNewButton_1_9_1_1_1_2);

		JPanel panel_2_1_6_1 = new JPanel();
		panel_2_1_6_1.setLayout(null);
		panel_2_1_6_1.setBounds(327, 383, 317, 52);
		Student_TAB.add(panel_2_1_6_1);

		JLabel lblNewLabel_2_1_6_1 = new JLabel("Number of Books Taken by All Student");
		lblNewLabel_2_1_6_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_6_1.setBounds(10, 0, 297, 19);
		panel_2_1_6_1.add(lblNewLabel_2_1_6_1);

		textField_11 = new JTextField();
		textField_11.setEditable(false);
		textField_11.setColumns(10);
		textField_11.setBounds(172, 23, 135, 19);
		panel_2_1_6_1.add(textField_11);

		JButton btnNewButton_1_2_1_6_1_1 = new JButton("Show Value");
		btnNewButton_1_2_1_6_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numOfTakenBook_Student();
			}
		});
		btnNewButton_1_2_1_6_1_1.setBounds(10, 22, 152, 21);
		panel_2_1_6_1.add(btnNewButton_1_2_1_6_1_1);

		JPanel panel_2_1_6_1_1 = new JPanel();
		panel_2_1_6_1_1.setLayout(null);
		panel_2_1_6_1_1.setBounds(0, 470, 317, 52);
		Student_TAB.add(panel_2_1_6_1_1);

		JLabel lblNewLabel_2_1_6_1_1 = new JLabel("Best Reader Among Students");
		lblNewLabel_2_1_6_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_6_1_1.setBounds(10, 0, 297, 19);
		panel_2_1_6_1_1.add(lblNewLabel_2_1_6_1_1);

		textField_12 = new JTextField();
		textField_12.setEditable(false);
		textField_12.setColumns(10);
		textField_12.setBounds(172, 23, 135, 19);
		panel_2_1_6_1_1.add(textField_12);

		JButton btnNewButton_1_2_1_6_1_1_1 = new JButton("Show Student");
		btnNewButton_1_2_1_6_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showBestReaderStudent();
			}
		});
		btnNewButton_1_2_1_6_1_1_1.setBounds(10, 22, 152, 21);
		panel_2_1_6_1_1.add(btnNewButton_1_2_1_6_1_1_1);

		JPanel panel_2_1_6_1_1_1 = new JPanel();
		panel_2_1_6_1_1_1.setLayout(null);
		panel_2_1_6_1_1_1.setBounds(327, 507, 317, 52);
		Student_TAB.add(panel_2_1_6_1_1_1);

		JLabel lblNewLabel_2_1_6_1_1_1 = new JLabel("Delete Student Record by ID");
		lblNewLabel_2_1_6_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_6_1_1_1.setBounds(10, 0, 297, 19);
		panel_2_1_6_1_1_1.add(lblNewLabel_2_1_6_1_1_1);

		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(172, 23, 135, 19);
		panel_2_1_6_1_1_1.add(textField_13);

		JButton btnNewButton_1_2_1_6_1_1_1_1 = new JButton("Delete Student");
		btnNewButton_1_2_1_6_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteStudent();
			}
		});
		btnNewButton_1_2_1_6_1_1_1_1.setBounds(10, 22, 152, 21);
		panel_2_1_6_1_1_1.add(btnNewButton_1_2_1_6_1_1_1_1);

		JPanel panel_2_1_6_1_1_1_1 = new JPanel();
		panel_2_1_6_1_1_1_1.setLayout(null);
		panel_2_1_6_1_1_1_1.setBounds(0, 532, 317, 52);
		Student_TAB.add(panel_2_1_6_1_1_1_1);

		JLabel lblNewLabel_2_1_6_1_1_1_1 = new JLabel("Remove Student Table");
		lblNewLabel_2_1_6_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_6_1_1_1_1.setBounds(10, 0, 297, 19);
		panel_2_1_6_1_1_1_1.add(lblNewLabel_2_1_6_1_1_1_1);

		JButton btnNewButton_1_2_1_6_1_1_1_1_1 = new JButton("Remove Table");
		btnNewButton_1_2_1_6_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeStudentTable();
			}
		});
		btnNewButton_1_2_1_6_1_1_1_1_1.setBounds(10, 22, 297, 21);
		panel_2_1_6_1_1_1_1.add(btnNewButton_1_2_1_6_1_1_1_1_1);

		JPanel panel_2_1_6_1_1_1_1_1 = new JPanel();
		panel_2_1_6_1_1_1_1_1.setLayout(null);
		panel_2_1_6_1_1_1_1_1.setBounds(0, 594, 317, 52);
		Student_TAB.add(panel_2_1_6_1_1_1_1_1);

		JLabel lblNewLabel_2_1_6_1_1_1_1_1 = new JLabel("Bringing Back Initial Data of Student Table");
		lblNewLabel_2_1_6_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_6_1_1_1_1_1.setBounds(10, 0, 297, 19);
		panel_2_1_6_1_1_1_1_1.add(lblNewLabel_2_1_6_1_1_1_1_1);

		JButton btnNewButton_1_2_1_6_1_1_1_1_1_1 = new JButton("Bring Back");
		btnNewButton_1_2_1_6_1_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				st_Bring_Back();
			}
		});
		btnNewButton_1_2_1_6_1_1_1_1_1_1.setBounds(10, 22, 297, 21);
		panel_2_1_6_1_1_1_1_1.add(btnNewButton_1_2_1_6_1_1_1_1_1_1);

		JPanel panel_2_1_6_1_2 = new JPanel();
		panel_2_1_6_1_2.setLayout(null);
		panel_2_1_6_1_2.setBounds(327, 445, 317, 52);
		Student_TAB.add(panel_2_1_6_1_2);

		JLabel lblNewLabel_2_1_6_1_2 = new JLabel("Total Number of Pages Being Read Now");
		lblNewLabel_2_1_6_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_6_1_2.setBounds(10, 0, 297, 19);
		panel_2_1_6_1_2.add(lblNewLabel_2_1_6_1_2);

		Page_number = new JTextField();
		Page_number.setEditable(false);
		Page_number.setColumns(10);
		Page_number.setBounds(172, 23, 135, 19);
		panel_2_1_6_1_2.add(Page_number);

		JButton btnNewButton_1_2_1_6_1_1_2 = new JButton("Show Value");
		btnNewButton_1_2_1_6_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pagesBeingReadNow();
			}
		});
		btnNewButton_1_2_1_6_1_1_2.setBounds(10, 22, 152, 21);
		panel_2_1_6_1_2.add(btnNewButton_1_2_1_6_1_1_2);

		JPanel Teacher_TAB = new JPanel();
		Teacher_TAB.setLayout(null);
		tabbedPane.addTab("Teacher", null, Teacher_TAB, null);

		JScrollPane scrollPane_1_6 = new JScrollPane();
		scrollPane_1_6.setBounds(0, 0, 905, 373);
		Teacher_TAB.add(scrollPane_1_6);

		table_6 = new JTable();
		myModel_Teacher.setColumnIdentifiers(cols_Teacher);

		ResultSet myRS_Teacher = myConnection.showTable("Teacher");

		try {
			while (myRS_Teacher.next()) {

				if (myRS_Teacher.getString("ID").equals("-"))
					continue;

				rows_Teacher[0] = myRS_Teacher.getString("Name");
				rows_Teacher[1] = myRS_Teacher.getString("ID");
				rows_Teacher[2] = myRS_Teacher.getString("Department");
				rows_Teacher[3] = myRS_Teacher.getString("ID_Lecture");
				rows_Teacher[4] = myRS_Teacher.getString("ISBN_Book");
				rows_Teacher[5] = myRS_Teacher.getString("Date_of_Birth");
				rows_Teacher[6] = myRS_Teacher.getString("Gender");
				myModel_Teacher.addRow(rows_Teacher);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		myModel_Teacher.setColumnIdentifiers(cols_Teacher);

		table_6.setModel(myModel_Teacher);

		scrollPane_1_6.setViewportView(table_6);

		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBounds(0, 383, 317, 77);
		Teacher_TAB.add(panel_8);

		textField_52 = new JTextField();
		textField_52.setText("Name");
		textField_52.setColumns(10);
		textField_52.setBounds(10, 22, 96, 19);
		panel_8.add(textField_52);

		textField_53 = new JTextField();
		textField_53.setText("ID");
		textField_53.setColumns(10);
		textField_53.setBounds(111, 22, 96, 19);
		panel_8.add(textField_53);

		textField_54 = new JTextField();
		textField_54.setText("Deparment");
		textField_54.setColumns(10);
		textField_54.setBounds(212, 22, 96, 19);
		panel_8.add(textField_54);

		textField_55 = new JTextField();
		textField_55.setText("Date of Birth");
		textField_55.setColumns(10);
		textField_55.setBounds(10, 47, 96, 19);
		panel_8.add(textField_55);

		textField_56 = new JTextField();
		textField_56.setText("Gender");
		textField_56.setColumns(10);
		textField_56.setBounds(111, 47, 96, 19);
		panel_8.add(textField_56);

		JButton btnNewButton_1_8 = new JButton("Add Teacher");
		btnNewButton_1_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTeacher();
			}
		});
		btnNewButton_1_8.setBounds(212, 46, 96, 21);
		panel_8.add(btnNewButton_1_8);

		JLabel lblNewLabel_8 = new JLabel("Adding Teacher");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(111, 0, 96, 19);
		panel_8.add(lblNewLabel_8);

		JPanel panel_2_1_6 = new JPanel();
		panel_2_1_6.setLayout(null);
		panel_2_1_6.setBounds(327, 383, 317, 52);
		Teacher_TAB.add(panel_2_1_6);

		JLabel lblNewLabel_2_1_6 = new JLabel("Number of Books Taken by All Teacher");
		lblNewLabel_2_1_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_6.setBounds(10, 0, 297, 19);
		panel_2_1_6.add(lblNewLabel_2_1_6);

		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(172, 23, 135, 19);
		panel_2_1_6.add(textField_5);

		JButton btnNewButton_1_2_1_6_1 = new JButton("Show Value");
		btnNewButton_1_2_1_6_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numOfTakenBook_Teacher();
			}
		});
		btnNewButton_1_2_1_6_1.setBounds(10, 22, 152, 21);
		panel_2_1_6.add(btnNewButton_1_2_1_6_1);

		JButton btnNewButton_1_9_1_1 = new JButton("Refresh Table");
		btnNewButton_1_9_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh_TeacherTable();
			}
		});
		btnNewButton_1_9_1_1.setBounds(776, 383, 119, 21);
		Teacher_TAB.add(btnNewButton_1_9_1_1);

		JButton btnNewButton_1_9_1_1_1 = new JButton("Update Table");
		btnNewButton_1_9_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update_TeacherTable();
			}
		});
		btnNewButton_1_9_1_1_1.setBounds(776, 414, 119, 21);
		Teacher_TAB.add(btnNewButton_1_9_1_1_1);

		JPanel panel_2_1_6_1_1_2 = new JPanel();
		panel_2_1_6_1_1_2.setLayout(null);
		panel_2_1_6_1_1_2.setBounds(0, 470, 317, 52);
		Teacher_TAB.add(panel_2_1_6_1_1_2);

		JLabel lblNewLabel_2_1_6_1_1_2 = new JLabel("Best Reader Among Teachers");
		lblNewLabel_2_1_6_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_6_1_1_2.setBounds(10, 0, 297, 19);
		panel_2_1_6_1_1_2.add(lblNewLabel_2_1_6_1_1_2);

		textField_14 = new JTextField();
		textField_14.setEditable(false);
		textField_14.setColumns(10);
		textField_14.setBounds(172, 23, 135, 19);
		panel_2_1_6_1_1_2.add(textField_14);

		JButton btnNewButton_1_2_1_6_1_1_1_2 = new JButton("Show Teacher");
		btnNewButton_1_2_1_6_1_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showBestReaderTeacher();
			}
		});
		btnNewButton_1_2_1_6_1_1_1_2.setBounds(10, 22, 152, 21);
		panel_2_1_6_1_1_2.add(btnNewButton_1_2_1_6_1_1_1_2);

		JPanel panel_2_1_6_2 = new JPanel();
		panel_2_1_6_2.setLayout(null);
		panel_2_1_6_2.setBounds(0, 532, 317, 52);
		Teacher_TAB.add(panel_2_1_6_2);

		JLabel lblNewLabel_2_1_6_2 = new JLabel("Show the Youngest Teacher");
		lblNewLabel_2_1_6_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_6_2.setBounds(10, 0, 297, 19);
		panel_2_1_6_2.add(lblNewLabel_2_1_6_2);

		youngest_teacher = new JTextField();
		youngest_teacher.setEditable(false);
		youngest_teacher.setColumns(10);
		youngest_teacher.setBounds(172, 23, 135, 19);
		panel_2_1_6_2.add(youngest_teacher);

		JButton btnNewButton_1_2_1_6_1_2 = new JButton("Show Result");
		btnNewButton_1_2_1_6_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showYoungestTeacher();
			}
		});
		btnNewButton_1_2_1_6_1_2.setBounds(10, 22, 152, 21);
		panel_2_1_6_2.add(btnNewButton_1_2_1_6_1_2);

	}

	void addAuthor() {
		String name, gender, date_of_birth, num_Books, name_publisher, sql;
		name = textField.getText();
		gender = textField_1.getText();
		date_of_birth = textField_2.getText();
		num_Books = textField_3.getText();
		name_publisher = textField_4.getText();

		sql = ("INSERT INTO Author (Name, Gender, Date_of_Birth, Num_of_Books, Name_Publisher) " + "VALUES ('" + name
				+ "', '" + gender + "', '" + date_of_birth + "', '" + num_Books + "', '" + name_publisher + "')");

		myConnection.add(sql);
	}

	void showAverageAuthor() {
		String sql = "SELECT AVG(Num_of_Books) AS Num FROM Author;";

		ResultSet avgNumBook = myConnection.executeCode(sql);

		try {
			while (avgNumBook.next())
				textField_6.setText(avgNumBook.getString("Num"));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	void refresh_AuthorTable() {

		myModel_Author.setRowCount(0);

		ResultSet myRS_Author = myConnection.showTable("Author");

		try {
			while (myRS_Author.next()) {
				rows_Author[0] = myRS_Author.getString("Name");
				rows_Author[1] = myRS_Author.getString("Gender");
				rows_Author[2] = myRS_Author.getString("Date_of_Birth");
				rows_Author[3] = myRS_Author.getString("Num_of_Books");
				rows_Author[4] = myRS_Author.getString("Name_Publisher");
				myModel_Author.addRow(rows_Author);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		table.setModel(myModel_Author);

	}

	void update_AuthorTable() {

		String Name = (String) myModel_Author.getValueAt(table.getSelectedRow(), 0);
		String Gender = (String) myModel_Author.getValueAt(table.getSelectedRow(), 1);
		String date_of_birth = (String) myModel_Author.getValueAt(table.getSelectedRow(), 2);
		String Num_of_books = (String) myModel_Author.getValueAt(table.getSelectedRow(), 3);
		String Name_publisher = (String) myModel_Author.getValueAt(table.getSelectedRow(), 4);

		String sql = "UPDATE Author SET " + "Gender = '" + Gender + "', " + "Date_of_Birth = '" + date_of_birth + "', "
				+ "Num_of_Books = '" + Num_of_books + "', " + "Name_Publisher = '" + Name_publisher + "' "
				+ " WHERE Name = '" + Name + "'";
		myConnection.add(sql);

	}

	void showAuthor_usingName() {

		myModel_Author.setRowCount(0);

		ResultSet myRS = myConnection
				.executeCode("SELECT * FROM Author WHERE Author.Name LIKE '%" + Author_data_for_Name.getText() + "%'");

		try {
			while (myRS.next()) {
				rows_Author[0] = myRS.getString("Name");
				rows_Author[1] = myRS.getString("Gender");
				rows_Author[2] = myRS.getString("Date_of_Birth");
				rows_Author[3] = myRS.getString("Num_of_Books");
				rows_Author[4] = myRS.getString("Name_Publisher");
				myModel_Author.addRow(rows_Author);

			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		table.setModel(myModel_Author);

	}

	void showAuthors_withType() {

		DefaultTableModel temp_model = new DefaultTableModel();

		temp_model.setRowCount(0);

		ResultSet myRS = myConnection.executeCode("SELECT Type, COUNT(*) as AuthorCount FROM Book GROUP BY Type;");

		String[] temp_row = new String[2];
		Object[] temp_col = { "Type", "Count" };
		temp_model.setColumnIdentifiers(temp_col);

		try {
			while (myRS.next()) {
				if(myRS.getString("Type").equals("x"))
					continue;
				temp_row[0] = myRS.getString("Type");
				temp_row[1] = myRS.getString("AuthorCount");
				temp_model.addRow(temp_row);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		table.setModel(temp_model);

	}

	void addBook() {

		String Title, ISBN, num_of_pages, Year, Date, Type, Department, Author_name, Publisher_Name, Librarian_ID,
				Teacher_ID, Student_ID, sql;
		Title = txtTitle.getText();
		ISBN = txtIsbn.getText();
		num_of_pages = txtGen.getText();
		Year = txtYear.getText();
		Date = txtDate.getText();
		Type = txtType.getText();
		Department = txtDepartment.getText();
		Author_name = txtAuthorName.getText();
		Publisher_Name = txtPublisherName.getText();
		Librarian_ID = txtLibrarianId.getText();

		sql = ("INSERT INTO Book (Title, ISBN, Num_of_Pages, Year, Date, Type, Department, Author_name, Publisher_Name, Librarian_ID, Teacher_ID, Student_ID) "
				+ "VALUES ('" + Title + "', '" + ISBN + "', '" + num_of_pages + "', '" + Year + "', '" + Date + "', '"
				+ Type + "', '" + Department + "', '" + Author_name + "', '" + Publisher_Name + "', '" + Librarian_ID
				+ "', '-', '-')");

		myConnection.add(sql);
	}

	void showBook_withTitle() {

		myModel_Book.setRowCount(0);

		ResultSet myRS_Book = myConnection
				.executeCode("SELECT * FROM Book WHERE Title like '%" + textField_15.getText() + "%'");

		try {
			while (myRS_Book.next()) {

				if (myRS_Book.getString("ISBN").equals("-"))
					continue;

				rows_Book[0] = myRS_Book.getString("Title");
				rows_Book[1] = myRS_Book.getString("ISBN");
				rows_Book[2] = myRS_Book.getString("Num_of_Pages");
				rows_Book[3] = myRS_Book.getString("Year");
				rows_Book[4] = myRS_Book.getString("Date");
				rows_Book[5] = myRS_Book.getString("Type");
				rows_Book[6] = myRS_Book.getString("Department");
				rows_Book[7] = myRS_Book.getString("Author_Name");
				rows_Book[8] = myRS_Book.getString("Publisher_Name");
				rows_Book[9] = myRS_Book.getString("Librarian_ID");
				rows_Book[10] = myRS_Book.getString("Teacher_ID");
				rows_Book[11] = myRS_Book.getString("Student_ID");
				myModel_Book.addRow(rows_Book);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		myModel_Book.setColumnIdentifiers(cols_Book);

		table_1.setModel(myModel_Book);

	}

	void refresh_BookTable() {

		myModel_Book.setRowCount(0);

		ResultSet myRS_Book = myConnection.showTable("Book");

		try {
			while (myRS_Book.next()) {

				if (myRS_Book.getString("ISBN").equals("-"))
					continue;

				rows_Book[0] = myRS_Book.getString("Title");
				rows_Book[1] = myRS_Book.getString("ISBN");
				rows_Book[2] = myRS_Book.getString("Num_of_Pages");
				rows_Book[3] = myRS_Book.getString("Year");
				rows_Book[4] = myRS_Book.getString("Date");
				rows_Book[5] = myRS_Book.getString("Type");
				rows_Book[6] = myRS_Book.getString("Department");
				rows_Book[7] = myRS_Book.getString("Author_Name");
				rows_Book[8] = myRS_Book.getString("Publisher_Name");
				rows_Book[9] = myRS_Book.getString("Librarian_ID");
				rows_Book[10] = myRS_Book.getString("Teacher_ID");
				rows_Book[11] = myRS_Book.getString("Student_ID");
				myModel_Book.addRow(rows_Book);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		table_1.setModel(myModel_Book);

	}

	void update_BookTable() {
		boolean check = true;
		String sql, new_sql = null, temp_sID = null, temp_tID = null;

		String Title = (String) myModel_Book.getValueAt(table_1.getSelectedRow(), 0);
		String ISBN = (String) myModel_Book.getValueAt(table_1.getSelectedRow(), 1);
		String Num_of_pages = (String) myModel_Book.getValueAt(table_1.getSelectedRow(), 2);
		String Year = (String) myModel_Book.getValueAt(table_1.getSelectedRow(), 3);
		String Date = (String) myModel_Book.getValueAt(table_1.getSelectedRow(), 4);
		String Type = (String) myModel_Book.getValueAt(table_1.getSelectedRow(), 5);
		String Department = (String) myModel_Book.getValueAt(table_1.getSelectedRow(), 6);
		String Author_Name = (String) myModel_Book.getValueAt(table_1.getSelectedRow(), 7);
		String Publisher_Name = (String) myModel_Book.getValueAt(table_1.getSelectedRow(), 8);
		String Librarian_ID = (String) myModel_Book.getValueAt(table_1.getSelectedRow(), 9);
		String Teacher_ID = (String) myModel_Book.getValueAt(table_1.getSelectedRow(), 10);
		String Student_ID = (String) myModel_Book.getValueAt(table_1.getSelectedRow(), 11);

		ResultSet temp_RS = myConnection
				.executeCode("SELECT Teacher_ID as T_ID, Student_ID as S_ID FROM Book WHERE Title ='" + Title + "'");
		try {
			while (temp_RS.next()) {
				temp_tID = temp_RS.getString("T_ID");
				temp_sID = temp_RS.getString("S_ID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Component frame = null;

		if (!Teacher_ID.equals("-")) {

			ResultSet myRS_Book = myConnection.showTable("Book");

			try {
				while (myRS_Book.next()) {

					if (Teacher_ID.equals(myRS_Book.getString("Teacher_ID"))) {
						JOptionPane.showMessageDialog(frame, "Each teacher can take 1 book at once!");
						check = false;
						break;
					}

				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if (!Student_ID.equals("-")) {

			ResultSet myRS_Book = myConnection.showTable("Book");

			try {
				while (myRS_Book.next()) {

					if (Student_ID.equals(myRS_Book.getString("Student_ID"))) {
						JOptionPane.showMessageDialog(frame, "Each student can take 1 book at once!");
						check = false;
						break;
					}

				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if (check) {
			if (Student_ID.equals("-") && Teacher_ID.equals("-")) {
				if (temp_tID.equals("-")) {
					new_sql = "UPDATE Student SET Student.ISBN_Book = '-' WHERE Student.ID = '" + temp_sID + "'";
					myConnection.add(new_sql);
					refresh_StudentTable();

					sql = "UPDATE Book SET " + "Title = '" + Title + "', " + "Num_of_Pages = '" + Num_of_pages + "', "
							+ "Year = '" + Year + "', " + "Date = '" + Date + "', " + "Type = '" + Type + "', "
							+ "Department = '" + Department + "', " + "Author_Name = '" + Author_Name + "', "
							+ "Publisher_Name = '" + Publisher_Name + "', " + "Librarian_ID = '" + Librarian_ID + "', "
							+ "Teacher_ID = '" + "-" + "', " + "Student_ID = '" + "-" + "' " + "WHERE ISBN = '" + ISBN
							+ "'";
					myConnection.add(sql);
				} else if (temp_sID.equals("-")) {
					new_sql = "UPDATE Teacher SET Teacher.ISBN_Book = '-' WHERE Teacher.ID = '" + temp_tID + "'";
					myConnection.add(new_sql);
					refresh_TeacherTable();

					sql = "UPDATE Book SET " + "Title = '" + Title + "', " + "Num_of_Pages = '" + Num_of_pages + "', "
							+ "Year = '" + Year + "', " + "Date = '" + Date + "', " + "Type = '" + Type + "', "
							+ "Department = '" + Department + "', " + "Author_Name = '" + Author_Name + "', "
							+ "Publisher_Name = '" + Publisher_Name + "', " + "Librarian_ID = '" + Librarian_ID + "', "
							+ "Teacher_ID = '" + "-" + "', " + "Student_ID = '" + "-" + "' " + "WHERE ISBN = '" + ISBN
							+ "'";
					myConnection.add(sql);
				}

			} else if (!Student_ID.equals("-") && Teacher_ID.equals("-")) {

				sql = "UPDATE Book SET " + "Title = '" + Title + "', " + "Num_of_Pages = '" + Num_of_pages + "', "
						+ "Year = '" + Year + "', " + "Date = '" + Date + "', " + "Type = '" + Type + "', "
						+ "Department = '" + Department + "', " + "Author_Name = '" + Author_Name + "', "
						+ "Publisher_Name = '" + Publisher_Name + "', " + "Librarian_ID = '" + Librarian_ID + "', "
						+ "Teacher_ID = '" + "-" + "', " + "Student_ID = '" + Student_ID + "' " + "WHERE ISBN = '"
						+ ISBN + "'";
				myConnection.add(sql);
				new_sql = "UPDATE Student SET Student.ISBN_Book = '" + ISBN + "' WHERE Student.ID = '" + Student_ID
						+ "'";
				myConnection.add(new_sql);

				refresh_StudentTable();
			}

			else if (Student_ID.equals("-") && !Teacher_ID.equals("-")) {
				sql = "UPDATE Book SET " + "Title = '" + Title + "', " + "Num_of_Pages = '" + Num_of_pages + "', "
						+ "Year = '" + Year + "', " + "Date = '" + Date + "', " + "Type = '" + Type + "', "
						+ "Department = '" + Department + "', " + "Author_Name = '" + Author_Name + "', "
						+ "Publisher_Name = '" + Publisher_Name + "', " + "Librarian_ID = '" + Librarian_ID + "', "
						+ "Teacher_ID = '" + Teacher_ID + "', " + "Student_ID = '" + "-" + "' " + "WHERE ISBN = '"
						+ ISBN + "'";
				myConnection.add(sql);
				new_sql = "UPDATE Teacher SET Teacher.ISBN_Book = '" + ISBN + "' WHERE Teacher.ID = '" + Teacher_ID
						+ "'";
				myConnection.add(new_sql);
				refresh_TeacherTable();

			} else {
				JOptionPane.showMessageDialog(frame, "A book cannot be taken by two people!");
			}
		}

	}

	void showBook_withISBN() {

		myModel_Book.setRowCount(0);

		ResultSet myRS_Book = myConnection
				.executeCode("SELECT * FROM Book WHERE ISBN like '%" + textField_7.getText() + "%'");

		try {
			while (myRS_Book.next()) {
				if (myRS_Book.getString("ISBN").equals("-"))
					continue;
				rows_Book[0] = myRS_Book.getString("Title");
				rows_Book[1] = myRS_Book.getString("ISBN");
				rows_Book[2] = myRS_Book.getString("Num_of_Pages");
				rows_Book[3] = myRS_Book.getString("Year");
				rows_Book[4] = myRS_Book.getString("Date");
				rows_Book[5] = myRS_Book.getString("Type");
				rows_Book[6] = myRS_Book.getString("Department");
				rows_Book[7] = myRS_Book.getString("Author_Name");
				rows_Book[8] = myRS_Book.getString("Publisher_Name");
				rows_Book[9] = myRS_Book.getString("Librarian_ID");
				rows_Book[10] = myRS_Book.getString("Teacher_ID");
				rows_Book[11] = myRS_Book.getString("Student_ID");
				myModel_Book.addRow(rows_Book);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		myModel_Book.setColumnIdentifiers(cols_Book);

		table_1.setModel(myModel_Book);

	}

	void showTotalNum_Book() {

		String sql = "SELECT COUNT(ISBN) as Count FROM Book", temp = null;
		int item;

		ResultSet NumofBook = myConnection.executeCode(sql);

		try {
			while (NumofBook.next())
				temp = NumofBook.getString("Count");
			item = Integer.parseInt(temp);
			item--;
			textField_8.setText("" + item);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	void checkBook_ISBN() {

		Component frame = null;
		String sql = "SELECT CASE WHEN COUNT(*) > 0 THEN 1 ELSE 0 END AS " + "isAvailable FROM book WHERE ISBN = '"
				+ textField_9.getText() + "'";

		ResultSet result = myConnection.executeCode(sql);

		try {
			while (result.next())
				if (result.getString("isAvailable").equals("1"))
					JOptionPane.showMessageDialog(frame,
							"We have the Book with ISBN '" + textField_9.getText() + "' in our library!");
				else
					JOptionPane.showMessageDialog(frame,
							"We don't have the Book with ISBN '" + textField_9.getText() + "' in our library :(");
		} catch (HeadlessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	void checkBook_Title() {

		boolean control = true;
		Component frame = null;

		String sql = "SELECT Title, CASE WHEN Book.Student_ID = '-' AND Book.Teacher_ID = '-' THEN 'Available' ELSE 'Taken' END AS isTaken "
				+ "FROM Book " + "WHERE Book.Title = '" + textField_10.getText() + "'";

		ResultSet result = myConnection.executeCode(sql);

		try {
			while (result.next()) {
				if (result.getString("isTaken").equals("Available")) {
					JOptionPane.showMessageDialog(frame,
							"Book with Title '" + textField_10.getText() + "' is available!");
					control = false;
					break;
				} else if (result.getString("isTaken").equals("Taken")) {
					JOptionPane.showMessageDialog(frame,
							"Book with Title '" + textField_10.getText() + "' is taken from someone else! :(");
					control = false;
					break;
				}
			}
			if (control) {
				JOptionPane.showMessageDialog(frame,
						"Book with Title '" + textField_10.getText() + "' does not exist in our library! :(");
			}
		} catch (HeadlessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	void showBooksWrittenBetweenYears() {

		DefaultTableModel temp_model = new DefaultTableModel();

		temp_model.setRowCount(0);

		ResultSet myRS = myConnection.executeCode("SELECT Title, Year FROM Book WHERE Year BETWEEN " + Year1.getText()
				+ " AND " + Year2.getText() + " ORDER BY Year DESC");

		String[] temp_row = new String[2];
		Object[] temp_col = { "Title", "Year" };
		temp_model.setColumnIdentifiers(temp_col);

		try {
			while (myRS.next()) {
				if (myRS.getString("Title").equals(""))
					continue;
				temp_row[0] = myRS.getString("Title");
				temp_row[1] = myRS.getString("Year");
				temp_model.addRow(temp_row);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		table_1.setModel(temp_model);

	}

	void showBooksWithPages() {

		DefaultTableModel temp_model = new DefaultTableModel();

		temp_model.setRowCount(0);

		String sql = "SELECT Title, Author_Name, Num_of_Pages FROM book where num_of_pages < " 
				+ Pagenum2.getText() + " EXCEPT select title, author_name, num_of_pages from book where num_of_pages < " + Pagenum1.getText();
		
		ResultSet myRS = myConnection
				.executeCode(sql);

		String[] temp_row = new String[3];
		Object[] temp_col = { "Title", "Author Name", "Num_of_Pages" };
		temp_model.setColumnIdentifiers(temp_col);

		try {
			while (myRS.next()) {
				if (myRS.getString("Title").equals(""))
					continue;
				temp_row[0] = myRS.getString("Title");
				temp_row[1] = myRS.getString("Author_Name");
				temp_row[2] = myRS.getString("Num_of_Pages");
				temp_model.addRow(temp_row);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		table_1.setModel(temp_model);

	}

	void showTypeMoreThan300() {

		DefaultTableModel temp_model = new DefaultTableModel();

		temp_model.setRowCount(0);

		ResultSet myRS = myConnection.executeCode(
				"SELECT Type, AVG(num_of_pages) AS avg FROM book GROUP BY type HAVING AVG(num_of_pages) > (select (num_of_pages) from book where num_of_pages=300);");

		String[] temp_row = new String[2];
		Object[] temp_col = { "Type", "Average Number of Pages" };
		temp_model.setColumnIdentifiers(temp_col);

		try {
			while (myRS.next()) {
				temp_row[0] = myRS.getString("Type");
				temp_row[1] = myRS.getString("avg");
				temp_model.addRow(temp_row);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		table_1.setModel(temp_model);

	}

	void addLecture() {

		String ID, Title, num_of_hours, credits, department, sql;
		ID = txtId.getText();
		Title = txtTitle_1.getText();
		num_of_hours = txtNumberOfHours.getText();
		credits = txtCredits.getText();
		department = txtDepartment_1.getText();

		sql = ("INSERT INTO Lecture (ID, Title, Num_of_Hours_Per_Week, Credits, Department) " + "VALUES ('" + ID
				+ "', '" + Title + "', '" + num_of_hours + "', '" + credits + "', '" + department + "')");

		myConnection.add(sql);

	}

	void refresh_LectureTable() {

		myModel_Lecture.setRowCount(0);

		ResultSet myRS_Lecture = myConnection.showTable("Lecture");

		try {
			while (myRS_Lecture.next()) {
				rows_Lecture[0] = myRS_Lecture.getString("ID");
				rows_Lecture[1] = myRS_Lecture.getString("Title");
				rows_Lecture[2] = myRS_Lecture.getString("Num_of_Hours_Per_Week");
				rows_Lecture[3] = myRS_Lecture.getString("Credits");
				rows_Lecture[4] = myRS_Lecture.getString("Department");
				myModel_Lecture.addRow(rows_Lecture);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		table_2.setModel(myModel_Lecture);

	}

	void update_LectureTable() {

		String ID = (String) myModel_Lecture.getValueAt(table_2.getSelectedRow(), 0);
		String Title = (String) myModel_Lecture.getValueAt(table_2.getSelectedRow(), 1);
		String NumWeek = (String) myModel_Lecture.getValueAt(table_2.getSelectedRow(), 2);
		String Credits = (String) myModel_Lecture.getValueAt(table_2.getSelectedRow(), 3);
		String Department = (String) myModel_Lecture.getValueAt(table_2.getSelectedRow(), 4);

		String sql = "UPDATE Lecture SET " + "Title = '" + Title + "', " + "Num_of_Hours_Per_Week = '" + NumWeek + "', "
				+ "Credits = '" + Credits + "', " + "Department = '" + Department + "' " + " WHERE ID = '" + ID + "'";

		myConnection.add(sql);

	}

	void addLibrarian() {

		String ID, Name, Date_of_Birth, Gender, sql;
		ID = txtId_1.getText();
		Name = txtName.getText();
		Date_of_Birth = textField_27.getText();
		Gender = txtGender.getText();

		sql = ("INSERT INTO Librarian (ID, Name, Date_of_Birth, Gender) " + "VALUES ('" + ID + "', '" + Name + "', '"
				+ Date_of_Birth + "', '" + Gender + "')");

		myConnection.add(sql);

	}

	void addNewCol_Librarian() {

		DefaultTableModel temp_model = new DefaultTableModel();

		int count_num = myModel_Librarian.getColumnCount();

		temp_model.setRowCount(0);
		temp_model.setColumnCount(count_num + 1);

		String[] temp_row = new String[20];
		Object[] temp_col = new Object[20];

		int i;
		for (i = 0; i < cols_Librarian.length; i++) {
			temp_col[i] = cols_Librarian[i];
		}

		myConnection.add("ALTER TABLE Librarian ADD " + col_name.getText() + " VARCHAR(25);");
		temp_col[i] = col_name.getText();
		cols_Librarian = new Object[i + 1];

		for (i = 0; i < cols_Librarian.length; i++) {
			cols_Librarian[i] = temp_col[i];
		}

		temp_model.setColumnIdentifiers(cols_Librarian);
		ResultSet myRS = myConnection.executeCode("SELECT * FROM Librarian");
		String temp = null;

		try {
			while (myRS.next()) {
				i = 0;

				while (i < cols_Librarian.length) {
					temp = String.valueOf(cols_Librarian[i]);
					temp_row[i] = myRS.getString(temp);
					i++;
				}

				temp_model.addRow(temp_row);

			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		table_3.setModel(temp_model);
		myModel_Librarian = temp_model;
	}

	void refresh_LibrarianTable() {

		myModel_Librarian.setRowCount(0);

		ResultSet myRS = myConnection.showTable("Librarian");

		try {
			while (myRS.next()) {
				int i = 0;

				while (i < cols_Librarian.length) {
					String temp = String.valueOf(cols_Librarian[i]);
					rows_Librarian[i] = myRS.getString(temp);
					i++;
				}
				myModel_Librarian.addRow(rows_Librarian);

			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		table_3.setModel(myModel_Librarian);

	}

	void update_LibrarianTable() {

		ResultSet myRS = myConnection.showTable("Librarian");
		String sql = "UPDATE Librarian SET ";
		String id = "";
		int count = 0;

		try {
			while (myRS.next() && count == 0) {
				int i = 0;

				while (i < cols_Librarian.length) {
					String temp = String.valueOf(cols_Librarian[i]);
					rows_Librarian[i] = myRS.getString(temp);
					String item = (String) myModel_Librarian.getValueAt(table_3.getSelectedRow(), i);
					if (item == null) {
						i++;
						continue;
					} else if (!temp.equals("ID"))
						sql = sql + temp + "= '" + item + "', ";
					else if (temp.equals("ID"))
						id = item;
					i++;
				}
				count++;
				sql = sql.substring(0, sql.length() - 2) + " WHERE ID = '" + id + "';\n";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		myConnection.add(sql);

	}

	void showLibrarianCountBook() {

		DefaultTableModel temp_model = new DefaultTableModel();

		temp_model.setRowCount(0);

		ResultSet myRS = myConnection
				.executeCode("SELECT k.Librarian_ID AS Lib_ID, COUNT(*) AS Num_book FROM Book AS k WHERE EXISTS "
						+ "(SELECT 1 FROM Librarian AS b WHERE b.ID = k.Librarian_ID) GROUP BY k.librarian_ID;");

		String[] temp_row = new String[2];
		Object[] temp_col = { "Librarian ID", "Book Count" };
		temp_model.setColumnIdentifiers(temp_col);

		try {
			while (myRS.next()) {
				temp_row[0] = myRS.getString("Lib_ID");
				temp_row[1] = myRS.getString("Num_book");
				temp_model.addRow(temp_row);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		table_3.setModel(temp_model);

	}
	
	void showLibrarianGender() {

		DefaultTableModel temp_model = new DefaultTableModel();

		temp_model.setRowCount(0);

		ResultSet myRS = myConnection
				.executeCode("SELECT ID, Name, Gender FROM Librarian WHERE ID = SOME (SELECT ID FROM Librarian WHERE Gender = '" + LibrarianGender.getText() + "')");

		String[] temp_row = new String[3];
		Object[] temp_col = { "ID", "Name", "Gender" };
		temp_model.setColumnIdentifiers(temp_col);

		try {
			while (myRS.next()) {
				temp_row[0] = myRS.getString("ID");
				temp_row[1] = myRS.getString("Name");
				temp_row[2] = myRS.getString("Gender");
				temp_model.addRow(temp_row);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		table_3.setModel(temp_model);

	}
	
	void addPublisher() {

		String Name, Address, Type, sql;
		Name = textField_34.getText();
		Address = txtAddress.getText();
		Type = txtType_1.getText();

		sql = ("INSERT INTO Publisher (Name, Address, Type) " + "VALUES ('" + Name + "', '" + Address + "', '" + Type
				+ "')");

		myConnection.add(sql);

	}

	void refresh_PublisherTable() {

		myModel_Publisher.setRowCount(0);

		ResultSet myRS_Publisher = myConnection.showTable("Publisher");

		try {
			while (myRS_Publisher.next()) {
				rows_Publisher[0] = myRS_Publisher.getString("Name");
				rows_Publisher[1] = myRS_Publisher.getString("Address");
				rows_Publisher[2] = myRS_Publisher.getString("Type");
				myModel_Publisher.addRow(rows_Publisher);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		table_4.setModel(myModel_Publisher);
	}

	void update_PublisherTable() {

		String Name = (String) myModel_Publisher.getValueAt(table_4.getSelectedRow(), 0);
		String Address = (String) myModel_Publisher.getValueAt(table_4.getSelectedRow(), 1);
		String Type = (String) myModel_Publisher.getValueAt(table_4.getSelectedRow(), 2);

		String sql = "UPDATE Publisher SET " + "Address = '" + Address + "', " + "Type = '" + Type + "' WHERE Name = '"
				+ Name + "'";

		myConnection.add(sql);
	}

	void publisherBookRelation() {

		DefaultTableModel temp_model = new DefaultTableModel();

		temp_model.setRowCount(0);
		ResultSet myRS = null;
		String[] temp_row = null;
		boolean result = true;

		try {
			String Name = (String) myModel_Publisher.getValueAt(table_4.getSelectedRow(), 0);

			myRS = myConnection.executeCode("SELECT DISTINCT Title, Publisher_name FROM Book, Publisher "
					+ "WHERE Publisher_name IN(SELECT Name FROM Publisher p where p.name = '" + Name + "')");
		} catch (Exception e) {
			Component frame = null;
			JOptionPane.showMessageDialog(frame, "Please choose a row on the table!");
			result = false;
		}

		try {
			if (result) {
				temp_row = new String[2];
				Object[] temp_col = { "Title", "Publisher Name" };
				temp_model.setColumnIdentifiers(temp_col);
				while (myRS.next()) {
					temp_row[0] = myRS.getString("Title");
					temp_row[1] = myRS.getString("Publisher_name");
					temp_model.addRow(temp_row);
				}
				table_4.setModel(temp_model);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	void addStudent() {

		String name, ID, department, date_of_birth, gender, sql;
		name = textField_43.getText();
		ID = textField_44.getText();
		department = textField_45.getText();
		date_of_birth = textField_46.getText();
		gender = textField_47.getText();

		sql = ("INSERT INTO Student (Name, ID, Department, Date_of_Birth, Gender) " + "VALUES ('" + name + "', '" + ID
				+ "', '" + department + "', '" + date_of_birth + "', '" + gender + "')");
		myConnection.add(sql);

		sql = "UPDATE Student SET ISBN_Book = '-' WHERE ID = '" + ID + "'";
		myConnection.add(sql);

		sql = "UPDATE Student\r\n" + "INNER JOIN Lecture ON Student.Department = Lecture.Department\r\n"
				+ "SET Student.ID_Lecture = Lecture.ID;\r\n";
		myConnection.add(sql);
	}

	void refresh_StudentTable() {

		myModel_Student.setRowCount(0);

		ResultSet myRS = myConnection.showTable("Student");

		try {
			while (myRS.next()) {

				if (myRS.getString("ID").equals("-"))
					continue;

				rows_Student[0] = myRS.getString("Name");
				rows_Student[1] = myRS.getString("ID");
				rows_Student[2] = myRS.getString("Department");
				rows_Student[3] = myRS.getString("ID_Lecture");
				rows_Student[4] = myRS.getString("ISBN_Book");
				rows_Student[5] = myRS.getString("Date_of_Birth");
				rows_Student[6] = myRS.getString("Gender");
				myModel_Student.addRow(rows_Student);

			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		table_5.setModel(myModel_Student);

	}

	void update_StudentTable() {
		String Name = (String) myModel_Student.getValueAt(table_5.getSelectedRow(), 0);
		String ID = (String) myModel_Student.getValueAt(table_5.getSelectedRow(), 1);
		String Department = (String) myModel_Student.getValueAt(table_5.getSelectedRow(), 2);
		String ID_Lecture = (String) myModel_Student.getValueAt(table_5.getSelectedRow(), 3);
		String ISBN_Book = (String) myModel_Student.getValueAt(table_5.getSelectedRow(), 4);
		String Date_of_Birth = (String) myModel_Student.getValueAt(table_5.getSelectedRow(), 5);
		String Gender = (String) myModel_Student.getValueAt(table_5.getSelectedRow(), 6);

		String book_isbn = null;
		ResultSet temp_RS = myConnection
				.executeCode("SELECT ISBN_Book as book_isbn FROM Student WHERE ID ='" + ID + "'");
		try {
			while (temp_RS.next()) {
				book_isbn = temp_RS.getString("book_isbn");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String teacher_id = null;
		ResultSet new_RS = myConnection
				.executeCode("SELECT Teacher_ID as th_id FROM Book WHERE Book.ISBN ='" + ISBN_Book + "'");
		try {
			while (new_RS.next()) {
				teacher_id = new_RS.getString("th_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String student_id = null;
		ResultSet last_RS = myConnection
				.executeCode("SELECT Student_ID as st_id FROM Book WHERE Book.ISBN ='" + ISBN_Book + "'");
		try {
			while (last_RS.next()) {
				student_id = last_RS.getString("st_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (!teacher_id.equals("-")) {
			Component frame = null;
			JOptionPane.showMessageDialog(frame,
					"Book with ISBN '" + ISBN_Book + "' is already taken by teacher " + teacher_id + "!");
		} else if (!student_id.equals("-")) {
			Component frame = null;
			JOptionPane.showMessageDialog(frame,
					"Book with ISBN '" + ISBN_Book + "' is already taken by student " + student_id + "!");
		} else {
			String sql = "UPDATE Student SET " + "Name = '" + Name + "', " + "Department = '" + Department + "', "
					+ "ID_Lecture = '" + ID_Lecture + "', " + "ISBN_Book = '" + ISBN_Book + "', " + "Date_of_Birth = '"
					+ Date_of_Birth + "', " + "Gender = '" + Gender + "' " + " WHERE ID = '" + ID + "'";

			myConnection.add(sql);

			String newSQL = "UPDATE Book SET Student_ID ='" + ID + "' WHERE Book.ISBN = '" + ISBN_Book + "'";
			myConnection.add(newSQL);
			refresh_BookTable();

			if (ISBN_Book.equals("-")) {
				String new_sql = "UPDATE Book SET Book.Student_ID = '-' WHERE Book.ISBN = '" + book_isbn + "'";
				myConnection.add(new_sql);
				refresh_BookTable();
			}
		}

	}

	void showBestReaderStudent() {

		String sql = "SELECT X.Name, MAX(X.Num) FROM " + "(SELECT A.NAME, COUNT(B.ISBN) AS Num FROM Student A, "
				+ "Book B WHERE A.ID = B.Student_ID AND A.ID <> '-'  GROUP BY A.NAME) AS X GROUP BY X.Name ORDER BY X.Name";

		ResultSet tempSET = myConnection.executeCode(sql);

		try {
			while (tempSET.next()) {
				textField_12.setText(tempSET.getString("Name"));

			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	void numOfTakenBook_Student() {

		String result = "";
		ResultSet myRs = myConnection
				.executeCode("SELECT COUNT(Student_ID) AS Count FROM Book WHERE Student_ID <> '-';");

		try {
			while (myRs.next())
				result = myRs.getString("Count");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		textField_11.setText(result);
	}

	void deleteStudent() {

		String St_ID = textField_13.getText();
		String sql = "DELETE FROM Student WHERE Student.ID = '" + St_ID + "'";

		String control = "SELECT ISBN FROM Book WHERE Book.Student_ID = '" + St_ID + "'";
		ResultSet result = myConnection.executeCode(control);
		int count = 0;

		try {
			while (count == 0 && result.next()) {
				control = "UPDATE Book SET Book.Student_ID = '-' WHERE Book.ISBN = '" + result.getString("ISBN") + "'";
				myConnection.add(control);
				count++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		myConnection.add(sql);
		refresh_StudentTable();
		refresh_BookTable();
	}

	void removeStudentTable() {
		String temp_sql = "ALTER TABLE Book DROP FOREIGN KEY book_ibfk_5";
		myConnection.add(temp_sql);
		String sql = "DROP TABLE Student";
		myConnection.add(sql);
		DefaultTableModel temp_model = new DefaultTableModel();
		table_5.setModel(temp_model);
	}

	void st_Bring_Back() {

		String sql = "CREATE TABLE Student (\r\n" + "  Name VARCHAR(255),\r\n" + "  ID VARCHAR(15) PRIMARY KEY,\r\n"
				+ "  Department VARCHAR(100),\r\n" + "  ID_Lecture VARCHAR(15),\r\n" + "  ISBN_Book VARCHAR(15),\r\n"
				+ "  Date_of_Birth DATE,\r\n" + "  Gender VARCHAR(10)\r\n" + ");";
		myConnection.add(sql);

		sql = "ALTER TABLE Student\r\n" + "ADD FOREIGN KEY (ID_Lecture) REFERENCES Lecture (ID);\r\n";
		myConnection.add(sql);

		sql = "ALTER TABLE Student\r\n" + "ADD FOREIGN KEY (ISBN_Book) REFERENCES Book (ISBN);";
		myConnection.add(sql);

		sql = "INSERT INTO Student (Name, ID, Department, Date_of_Birth, Gender)\r\n" + "VALUES\r\n"
				+ "('Emily Wilson', '-', 'English', '2000-02-15', 'Female'),\r\n"
				+ "('Emily Wilson', 'ST001', 'English', '2000-02-15', 'Female'),\r\n"
				+ "('James Thompson', 'ST002', 'History', '1999-07-28', 'Male'),\r\n"
				+ "('Abigail Davis', 'ST003', 'Computer Science', '2001-04-10', 'Female'),\r\n"
				+ "('Benjamin Martinez', 'ST004', 'Philosophy', '2000-09-22', 'Male'),\r\n"
				+ "('Charlotte Miller', 'ST005', 'Business', '1999-03-08', 'Female'),\r\n"
				+ "('Daniel Johnson', 'ST006', 'Mathematics', '2001-11-18', 'Male'),\r\n"
				+ "('Ella Anderson', 'ST007', 'Psychology', '2000-06-27', 'Female'),\r\n"
				+ "('William Smith', 'ST008', 'Sociology', '1999-10-05', 'Male'),\r\n"
				+ "('Grace Harris', 'ST009', 'Biology', '2001-01-12', 'Female'),\r\n"
				+ "('Henry Taylor', 'ST010', 'Electrical Engineering', '2000-05-25', 'Male');";
		myConnection.add(sql);

		sql = "UPDATE Student\r\n" + "INNER JOIN Lecture ON Student.Department = Lecture.Department\r\n"
				+ "SET Student.ID_Lecture = Lecture.ID;\r\n";
		myConnection.add(sql);

		sql = "UPDATE Student\r\n" + "INNER JOIN Book ON Student.ID = Book.Student_ID\r\n"
				+ "SET Student.ISBN_Book = Book.ISBN;\r\n";
		myConnection.add(sql);

		sql = "UPDATE Student\r\n" + "SET ISBN_Book = '-'\r\n" + "WHERE ISBN_Book IS NULL;";
		myConnection.add(sql);

		sql = "ALTER TABLE Book ADD CONSTRAINT book_ibfk_5 FOREIGN KEY (Student_ID) REFERENCES student (ID);";
		myConnection.add(sql);

		refresh_StudentTable();
	}

	void pagesBeingReadNow() {
		String result = "";
		ResultSet myRs = myConnection.executeCode(
				"SELECT SUM(Num_of_Pages) AS Pages FROM Book, Student WHERE Book.ISBN = Student.ISBN_Book;");

		try {
			while (myRs.next())
				result = myRs.getString("Pages");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Page_number.setText(result);
	}

	void addTeacher() {

		String name, ID, department, date_of_birth, gender, sql;
		name = textField_52.getText();
		ID = textField_53.getText();
		department = textField_54.getText();
		date_of_birth = textField_55.getText();
		gender = textField_56.getText();

		sql = ("INSERT INTO Teacher (Name, ID, Department, Date_of_Birth, Gender) " + "VALUES ('" + name + "', '" + ID
				+ "', '" + department + "', '" + date_of_birth + "', '" + gender + "')");
		myConnection.add(sql);

		sql = "UPDATE Teacher SET ISBN_Book = '-' WHERE ID = '" + ID + "'";
		myConnection.add(sql);

		sql = "UPDATE Teacher\r\n" + "INNER JOIN Lecture ON Teacher.Department = Lecture.Department\r\n"
				+ "SET Teacher.ID_Lecture = Lecture.ID;\r\n";
		myConnection.add(sql);
	}

	void refresh_TeacherTable() {

		myModel_Teacher.setRowCount(0);

		ResultSet myRS = myConnection.showTable("Teacher");

		try {
			while (myRS.next()) {

				if (myRS.getString("ID").equals("-"))
					continue;

				rows_Teacher[0] = myRS.getString("Name");
				rows_Teacher[1] = myRS.getString("ID");
				rows_Teacher[2] = myRS.getString("Department");
				rows_Teacher[3] = myRS.getString("ID_Lecture");
				rows_Teacher[4] = myRS.getString("ISBN_Book");
				rows_Teacher[5] = myRS.getString("Date_of_Birth");
				rows_Teacher[6] = myRS.getString("Gender");
				myModel_Teacher.addRow(rows_Teacher);

			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		table_6.setModel(myModel_Teacher);
	}

	void update_TeacherTable() {
		String Name = (String) myModel_Teacher.getValueAt(table_6.getSelectedRow(), 0);
		String ID = (String) myModel_Teacher.getValueAt(table_6.getSelectedRow(), 1);
		String Department = (String) myModel_Teacher.getValueAt(table_6.getSelectedRow(), 2);
		String ID_Lecture = (String) myModel_Teacher.getValueAt(table_6.getSelectedRow(), 3);
		String ISBN_Book = (String) myModel_Teacher.getValueAt(table_6.getSelectedRow(), 4);
		String Date_of_Birth = (String) myModel_Teacher.getValueAt(table_6.getSelectedRow(), 5);
		String Gender = (String) myModel_Teacher.getValueAt(table_6.getSelectedRow(), 6);

		String book_isbn = null;
		ResultSet temp_RS = myConnection
				.executeCode("SELECT ISBN_Book as book_isbn FROM Teacher WHERE ID ='" + ID + "'");
		try {
			while (temp_RS.next()) {
				book_isbn = temp_RS.getString("book_isbn");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String student_id = null;
		ResultSet new_RS = myConnection
				.executeCode("SELECT Student_ID as st_id FROM Book WHERE Book.ISBN ='" + ISBN_Book + "'");
		try {
			while (new_RS.next()) {
				student_id = new_RS.getString("st_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String teacher_id = null;
		ResultSet last_RS = myConnection
				.executeCode("SELECT Teacher_ID as th_id FROM Book WHERE Book.ISBN ='" + ISBN_Book + "'");
		try {
			while (last_RS.next()) {
				teacher_id = last_RS.getString("th_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (!student_id.equals("-")) {
			Component frame = null;
			JOptionPane.showMessageDialog(frame,
					"Book with ISBN '" + ISBN_Book + "' is already taken by student " + student_id + "!");
		} else if (!teacher_id.equals("-")) {
			Component frame = null;
			JOptionPane.showMessageDialog(frame,
					"Book with ISBN '" + ISBN_Book + "' is already taken by teacher " + teacher_id + "!");
		} else {
			String sql = "UPDATE Teacher SET " + "Name = '" + Name + "', " + "Department = '" + Department + "', "
					+ "ID_Lecture = '" + ID_Lecture + "', " + "ISBN_Book = '" + ISBN_Book + "', " + "Date_of_Birth = '"
					+ Date_of_Birth + "', " + "Gender = '" + Gender + "' " + " WHERE ID = '" + ID + "'";

			myConnection.add(sql);

			String newSQL = "UPDATE Book SET Teacher_ID ='" + ID + "' WHERE Book.ISBN = '" + ISBN_Book + "'";
			myConnection.add(newSQL);
			refresh_BookTable();

			if (ISBN_Book.equals("-")) {
				String new_sql = "UPDATE Book SET Book.Teacher_ID = '-' WHERE Book.ISBN = '" + book_isbn + "'";
				myConnection.add(new_sql);
				refresh_BookTable();
			}
		}

	}

	void numOfTakenBook_Teacher() {

		String result = "";
		ResultSet myRs = myConnection
				.executeCode("SELECT COUNT(Teacher_ID) AS Count FROM Book WHERE Teacher_ID <> '-';");

		try {
			while (myRs.next())
				result = myRs.getString("Count");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		textField_5.setText(result);

	}

	void showBestReaderTeacher() {
		String sql = "SELECT X.Name, MAX(X.Num) FROM " + "(SELECT A.NAME, COUNT(B.ISBN) AS Num FROM Teacher A, "
				+ "Book B WHERE A.ID = B.Teacher_ID AND A.ID <> '-'  GROUP BY A.NAME) AS X GROUP BY X.Name ORDER BY X.Name";

		ResultSet tempSET = myConnection.executeCode(sql);

		try {
			while (tempSET.next()) {
				textField_14.setText(tempSET.getString("Name"));

			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	void showYoungestTeacher() {

		ResultSet myRS = myConnection.executeCode("SELECT X.Name " + "FROM teacher AS X "
				+ "WHERE X.Date_of_Birth > ALL (SELECT Y.Date_of_Birth FROM teacher AS Y WHERE Y.ID <> X.ID);");

		try {
			while (myRS.next()) {
				String name = myRS.getString("Name");
				youngest_teacher.setText(name);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
