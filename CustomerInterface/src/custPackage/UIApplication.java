/**
 * Author: Arun Kumar Konduru Chandra
 * NetID: axk138230
 * Date : 02/07/2014
 * Class: CS6301.013
 * Purpose: Assignment 2 for UI Design course.
 * Description: This module is used to perform operations in UI like clear and validation.*/

package custPackage;

import java.awt.Color;
import java.util.regex.Pattern;


@SuppressWarnings("serial")
public class UIApplication extends UI
{	
	public static String address;
	public static String name;
	
	//Get text from name fields and concatenate them. 
	public static String name()
	{
		name = txt_fname.getText()+"\t"+txt_minit.getText()+"\t"+txt_lname.getText();
		return name;
	}
	
	//Get text from address fields and concatenate them.
	public static String address()
	{
		String address = txt_addr1.getText()+"\t"
				+txt_addr2.getText()+"\t"+txt_city.getText()+"\t"
				+txt_state.getText()+"\t"+txt_country.getText()+"\t"+txt_zip.getText();
		return address;
	}
	
	//Clears the text in JTextFields and reset their colors.
	public static void clearTextFields()
	{
		txt_fname.setText("");
		txt_fname.setBackground(Color.LIGHT_GRAY);
        txt_minit.setText("");
        txt_minit.setBackground(Color.WHITE);
        txt_lname.setText("");
        txt_lname.setBackground(Color.LIGHT_GRAY);
        txt_phone.setText("");
        txt_phone.setBackground(Color.LIGHT_GRAY);
        txt_email.setText("");
        txt_email.setBackground(Color.LIGHT_GRAY);
        txt_addr1.setText("");
        txt_addr1.setBackground(Color.LIGHT_GRAY);
        txt_addr2.setText("");
        txt_addr2.setBackground(Color.WHITE);
        txt_city.setText("");
        txt_city.setBackground(Color.LIGHT_GRAY);
        txt_state.setText("");
        txt_state.setBackground(Color.LIGHT_GRAY);
        txt_country.setText("");
        txt_country.setBackground(Color.LIGHT_GRAY);
        txt_zip.setText("");
        txt_zip.setBackground(Color.LIGHT_GRAY);
	}
	
	//Check text fields if required information is completed to enable buttons.
	public static void checkTextFields()  
	  {    
	      if(!txt_fname.getText().isEmpty()&&!txt_lname.getText().isEmpty()&&!txt_phone.getText().isEmpty()
	    		  &&!txt_email.getText().isEmpty()&&!txt_addr1.getText().isEmpty()&&!txt_city.getText().isEmpty()
	    		  &&!txt_state.getText().isEmpty()&&!txt_country.getText().isEmpty()&&!txt_zip.getText().isEmpty()) 
	    	  btnSave.setEnabled(true);		//Enable SAVE button if all required text are filled.
	      else
	    	  btnSave.setEnabled(false);
	      if(name().isEmpty()&&address.isEmpty()&&txt_phone.getText().isEmpty()&&txt_email.getText().isEmpty())
	    	  btnClear.setEnabled(false);	//Enable CLEAR button if any text field is not empty.
	      else
	    	  btnClear.setEnabled(true);
	  }  
	
	//Validate JTextFields before saving it into text file.
	public static void validateTextFields()
	{
		if(!Pattern.matches("^[\\p{L} .'-]+$", txt_fname.getText()))
		{
			txt_fname.setBackground(Color.RED);
			lblStatus.setText("Fill the required information correctly.");
		}
		else
			txt_fname.setBackground(Color.LIGHT_GRAY);
		if(!Pattern.matches("[a-zA-Z]+", txt_minit.getText())&&!txt_minit.getText().isEmpty())
		{
			txt_minit.setBackground(Color.RED);
			lblStatus.setText("Fill the required information correctly.");
		}
		else
			txt_minit.setBackground(Color.WHITE);
		if(!Pattern.matches("^[\\p{L} .'-]+$", txt_lname.getText()))
		{
			txt_lname.setBackground(Color.RED);
			lblStatus.setText("Fill the required information correctly.");
		}
		else
			txt_lname.setBackground(Color.LIGHT_GRAY);
		if(!Pattern.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", txt_email.getText()))
		{
			txt_email.setBackground(Color.RED);
			lblStatus.setText("Fill the required information correctly.");
		}
		else
			txt_email.setBackground(Color.LIGHT_GRAY);
		if(!Pattern.matches("^\\+?[0-9. ()-]{10,21}$", txt_phone.getText()))
		{
			txt_phone.setBackground(Color.RED);
			lblStatus.setText("You must fill the required information correctly.");
		}
		else
			txt_phone.setBackground(Color.LIGHT_GRAY);
		if(!Pattern.matches("^[\\p{L} .'-]+$", txt_city.getText()))
		{
			txt_city.setBackground(Color.RED);
			lblStatus.setText("Fill the required information correctly.");
		}
		else
			txt_city.setBackground(Color.LIGHT_GRAY);
		if(!Pattern.matches("[a-zA-Z]+", txt_state.getText()))
		{
			txt_state.setBackground(Color.RED);
			lblStatus.setText("Fill the required information correctly.");
		}
		else
			txt_state.setBackground(Color.LIGHT_GRAY);
		if(!Pattern.matches("^[\\p{L} .'-]+$", txt_country.getText()))
		{
			txt_country.setBackground(Color.RED);
			lblStatus.setText("Fill the required information correctly.");
		}
		else
			txt_country.setBackground(Color.LIGHT_GRAY);
		if(!Pattern.matches("[0-9]+", txt_zip.getText()))
		{
			txt_zip.setBackground(Color.RED);
			lblStatus.setText("Fill the required information correctly.");
		}
		else
			txt_zip.setBackground(Color.LIGHT_GRAY);
	}
	
	//Check if any JTextField has red color to identify errors.
	public static boolean textFieldHasRedColor()
	{
		if(txt_fname.getBackground()==Color.RED||txt_minit.getBackground()==Color.RED||txt_lname.getBackground()==Color.RED
				||txt_email.getBackground()==Color.RED||txt_phone.getBackground()==Color.RED||txt_city.getBackground()==Color.RED
				||txt_city.getBackground()==Color.RED||txt_state.getBackground()==Color.RED||txt_country.getBackground()==Color.RED)
			return true;
		else
			return false;
	}
}
