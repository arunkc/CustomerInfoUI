/**
 * Author: Arun Kumar Konduru Chandra
 * NetID: axk138230
 * Date : 02/04/2014
 * Class: CS6301.013
 * Purpose: Assignment 2 for UI Design course.
 * Description: This module is used to design the UI.*/

package custPackage;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import javax.swing.border.EtchedBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;


@SuppressWarnings("serial")
public class UI extends JFrame {
	
	protected JPanel contentPane;
	protected static JTextField txt_fname;
	protected static JTextField txt_minit;
	protected static JTextField txt_lname;
	protected static JTextField txt_email;
	protected static JTextField txt_phone;
	protected static JTextField txt_addr1;
	protected static JTextField txt_addr2;
	protected static JTextField txt_city;
	protected static JTextField txt_state;
	protected static JTextField txt_country;
	protected static JTextField txt_zip;
	protected static JButton btnSave;
	protected static JButton btnDelete;
	protected static JButton btnClear;
	protected static JTable table;
	protected static JLabel lblStatus;
	protected static DefaultTableModel tableModel;
	DocumentListener myDocListener = new MyDocListener();

	//Adds rectangles into JFrame while execution. Used for frame decoration.
	public void paint(Graphics g) {
        super.paint(g);  
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D rect1 = new Rectangle2D.Float(40,50,620,70);
        Rectangle2D rect2 = new Rectangle2D.Float(40,120,620,80);
        Rectangle2D rect3 = new Rectangle2D.Float(40,200,620,160);
        g2.draw(rect1);
        g2.draw(rect2);
        g2.draw(rect3);
    }
	
	
	//This function limits the lengths of text fields.
			class JTextFieldLimit extends PlainDocument {
				  private int limit;
				  JTextFieldLimit(int limit) {
				    super();
				    this.limit = limit;
				  }

				  JTextFieldLimit(int limit, boolean upper) {
				    super();
				    this.limit = limit;
				  }
				  
				  public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
				    if (str == null)
				      return;

				    if ((getLength() + str.length()) <= limit) {
				      super.insertString(offset, str, attr);
				    }
				  }
				}

	// Create frame and add components in it.
	public UI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 30, 700, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name *");
		lblName.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblName.setHorizontalAlignment(JLabel.RIGHT);
		lblName.setBounds(67, 48, 51, 14);
		contentPane.add(lblName);
		
		JLabel lblEmail = new JLabel("EMail *");
		lblEmail.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblEmail.setHorizontalAlignment(JLabel.RIGHT);
		lblEmail.setBounds(72, 130, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblPhone = new JLabel("Phone *");
		lblPhone.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblPhone.setHorizontalAlignment(JLabel.RIGHT);
		lblPhone.setBounds(451, 130, 68, 14);
		contentPane.add(lblPhone);
		
		JLabel lblAddress1 = new JLabel("Address  *");
		lblAddress1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblAddress1.setHorizontalAlignment(JLabel.RIGHT);
		lblAddress1.setBounds(50, 208, 68, 14);
		contentPane.add(lblAddress1);
		
		JLabel lblCity = new JLabel("City *");
		lblCity.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblCity.setHorizontalAlignment(JLabel.RIGHT);
		lblCity.setBounds(473, 250, 46, 14);
		contentPane.add(lblCity);
		
		JLabel lblState = new JLabel("State *");
		lblState.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblState.setHorizontalAlignment(JLabel.RIGHT);
		lblState.setBounds(72, 295, 46, 14);
		contentPane.add(lblState);
		
		JLabel lblCountry = new JLabel("Country  *");
		lblCountry.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblCountry.setHorizontalAlignment(JLabel.RIGHT);
		lblCountry.setBounds(195, 295, 68, 14);
		contentPane.add(lblCountry);
		
		JLabel lblZipCode = new JLabel("Zip Code  *");
		lblZipCode.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblZipCode.setHorizontalAlignment(JLabel.RIGHT);
		lblZipCode.setBounds(433, 297, 86, 14);
		contentPane.add(lblZipCode);
		
		txt_fname = new JTextField();
		txt_fname.setToolTipText("Use [a-z] , [A-Z] , ['  -] to fill .");
		txt_fname.setBackground(Color.LIGHT_GRAY);
		txt_fname.setBounds(130, 47, 210, 20);
		contentPane.add(txt_fname);
		txt_fname.setColumns(10);
		txt_fname.setDocument(new JTextFieldLimit(20));
		txt_fname.getDocument().addDocumentListener(myDocListener);
		
		txt_minit = new JTextField();
		txt_minit.setToolTipText("Use [a-z] or [A-Z] to fill . This field can be empty.");
		txt_minit.setBackground(Color.WHITE);
		txt_minit.setBounds(365, 47, 30, 20);
		contentPane.add(txt_minit);
		txt_minit.setColumns(10);
		txt_minit.setDocument(new JTextFieldLimit(1));
		txt_minit.getDocument().addDocumentListener(myDocListener);
		
		txt_lname = new JTextField();
		txt_lname.setToolTipText("Use [a-z] , [A-Z] , ['  -] to fill .");
		txt_lname.setBackground(Color.LIGHT_GRAY);
		txt_lname.setBounds(420, 47, 210, 20);
		contentPane.add(txt_lname);
		txt_lname.setColumns(10);
		txt_lname.setDocument(new JTextFieldLimit(20));
		txt_lname.getDocument().addDocumentListener(myDocListener);

		txt_email = new JTextField();
		txt_email.setToolTipText("Use proper E-Mail format to fill .");
		txt_email.setBackground(Color.LIGHT_GRAY);
		txt_email.setBounds(128, 127, 277, 20);
		contentPane.add(txt_email);
		txt_email.setColumns(10);
		txt_email.setDocument(new JTextFieldLimit(100));
		txt_email.getDocument().addDocumentListener(myDocListener);

		txt_phone = new JTextField();
		txt_phone.setToolTipText("Use American format.Must be of length 10 to 21. ");
		txt_phone.setBackground(Color.LIGHT_GRAY);
		txt_phone.setBounds(529, 127, 101, 20);
		contentPane.add(txt_phone);
		txt_phone.setColumns(10);
		txt_phone.setDocument(new JTextFieldLimit(21));
		txt_phone.getDocument().addDocumentListener(myDocListener);

		txt_addr1 = new JTextField();
		txt_addr1.setToolTipText("Use any character to fill .");
		txt_addr1.setBackground(Color.LIGHT_GRAY);
		txt_addr1.setBounds(128, 207, 277, 20);
		contentPane.add(txt_addr1);
		txt_addr1.setColumns(10);
		txt_addr1.setDocument(new JTextFieldLimit(35));
		txt_addr1.getDocument().addDocumentListener(myDocListener);

		txt_addr2 = new JTextField();
		txt_addr2.setToolTipText("Field can be empty.");
		txt_addr2.setBackground(Color.WHITE);
		txt_addr2.setBounds(128, 249, 277, 20);
		contentPane.add(txt_addr2);
		txt_addr2.setColumns(10);
		txt_addr2.setDocument(new JTextFieldLimit(35));
		txt_addr2.getDocument().addDocumentListener(myDocListener);

		txt_city = new JTextField();
		txt_city.setToolTipText("Use [a-z] , [A-Z] , ['  -] to fill .");
		txt_city.setBackground(Color.LIGHT_GRAY);
		txt_city.setBounds(529, 249, 110, 20);
		contentPane.add(txt_city);
		txt_city.setColumns(10);
		txt_city.setDocument(new JTextFieldLimit(25));
		txt_city.getDocument().addDocumentListener(myDocListener);

		txt_state = new JTextField();
		txt_state.setToolTipText("Use [a-z] or [A-Z] to fill .");
		txt_state.setBackground(Color.LIGHT_GRAY);
		txt_state.setBounds(130, 294, 43, 20);
		contentPane.add(txt_state);
		txt_state.setColumns(10);
		txt_state.setDocument(new JTextFieldLimit(2));
		txt_state.getDocument().addDocumentListener(myDocListener);

		txt_country = new JTextField();
		txt_country.setToolTipText("Use [a-z] , [A-Z] , ['  -] to fill .");
		txt_country.setBackground(Color.LIGHT_GRAY);
		txt_country.setBounds(273, 294, 132, 20);
		contentPane.add(txt_country);
		txt_country.setColumns(10);
		txt_country.setDocument(new JTextFieldLimit(30));
		txt_country.getDocument().addDocumentListener(myDocListener);

		txt_zip = new JTextField();
		txt_zip.setToolTipText("Use [0-9] to fill .");
		txt_zip.setBackground(Color.LIGHT_GRAY);
		txt_zip.setBounds(529, 294, 110, 20);
		contentPane.add(txt_zip);
		txt_zip.setColumns(10);
		txt_zip.setDocument(new JTextFieldLimit(9));
		txt_zip.getDocument().addDocumentListener(myDocListener);

		btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UIApplication.validateTextFields();
				if(!UIApplication.textFieldHasRedColor())
					TextFileOperations.addNewRecord();
				TextFileOperations.addRecordsIntoTable();
			}
		});
		btnSave.setEnabled(false);
		btnSave.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnSave.setBounds(83, 370, 90, 23);
		contentPane.add(btnSave);
		
		btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextFileOperations.removeRecord();
				TextFileOperations.addRecordsIntoTable();
			}
		});
		btnDelete.setEnabled(false);
		btnDelete.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnDelete.setBounds(297, 370, 90, 23);
		contentPane.add(btnDelete);
		
		btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UIApplication.clearTextFields();
				btnClear.setEnabled(false);
			}
		});
		btnClear.setEnabled(false);
		btnClear.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnClear.setBounds(510, 370, 90, 23);
		contentPane.add(btnClear);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(29, 426, 619, 192);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
	
		String[] columnName = {"NAME","PHONE"};
		tableModel = new DefaultTableModel(columnName,0);
		table = new JTable(tableModel);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRowSelectionAllowed(true);
		table.setFont(new Font("Segoe UI", Font.BOLD, 12));
		JScrollPane scrollPane = new JScrollPane(table);
		panel.add(scrollPane);
		TextFileOperations.addRecordsIntoTable();
		ListSelectionModel cellSelectionModel = table.getSelectionModel();
		cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
		      public void valueChanged(ListSelectionEvent e) {
		        TextFileOperations.fillTextFieldsOnRowSelection();
		        btnDelete.setEnabled(true);
		      }

		    });
		
		JPanel statusPanel = new JPanel();
		statusPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		statusPanel.setBounds(29, 629, 619, 21);
		contentPane.add(statusPanel);
		statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
		
		lblStatus = new JLabel("Ready");
		lblStatus.setBounds(29, 629, 619, 21);
		statusPanel.add(lblStatus);
		
		
	}
	
	//This class listens for change in text. Useful to enable or disable buttons.
	public class MyDocListener implements DocumentListener  
	{ 
		
	  public void changedUpdate(DocumentEvent e)  
	  {  
	    UIApplication.checkTextFields();
	  }  

	  public void insertUpdate(DocumentEvent e)  
	  {  
		  UIApplication.checkTextFields();
	  }  

	  public void removeUpdate(DocumentEvent e)  
	  {  
		  UIApplication.checkTextFields(); 
	  }  

	}  
}

