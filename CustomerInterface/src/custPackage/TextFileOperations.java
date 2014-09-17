/**
 * Author: Arun Kumar Konduru Chandra
 * NetID: axk138230
 * Date : 02/10/2014
 * Class: CS6301.013
 * Purpose: Assignment 2 for UI Design course.
 * Description: This module performs operation on text file.*/

package custPackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;


@SuppressWarnings("serial")
public class TextFileOperations extends UI
{
	public static FileReader fr;
    public static Scanner scanner;
	public static File txt_file;
    public static boolean exists;
   
    //Adds new record into the text file.
	//Create new file if file does not exist.
    public static void createFile()
	{
		try{
            txt_file = new File("CustomerDetails.txt"); 
            if(!txt_file.exists())
                txt_file.createNewFile();
		}
		catch(Exception e)
		{
			lblStatus.setText("File creation unsuccessful.");
		}
	}
	
	//Adds new record into the text file.
	public static void addNewRecord()
	{
		createFile();
		exists = false;
		try
		{
			fr = new FileReader(txt_file);
            scanner = new Scanner(txt_file);
			while (scanner.hasNextLine()) 
			{
				String line = scanner.nextLine();
				String[] info = line.split("\t");
				if(UIApplication.name().replaceAll("\\s+","").contentEquals((info[0]+info[1]+info[2]).trim()))
			        exists = exists||true;	//Checks if user already exits.
			}
			fr.close();
			scanner.close();
			if(!exists)	//Add record if the user does not exist.
			{
				
				PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(txt_file.getAbsolutePath(),true)));	
				out.println(UIApplication.name()+"\t"+txt_phone.getText()+"\t"+txt_email.getText()+"\t"+UIApplication.address());
				lblStatus.setText("Record was succesfully added to the text file.");
				out.close();
			}
			else	//Modify record if the user exists.
			{
				if(table.getSelectedRow()!=-1)//If any row is selected then go to modify mode. 
					modifyRecord();
				else
					lblStatus.setText("User already exists.");
			}
		}
		catch(Exception e)
		{
			lblStatus.setText("File Error : Writing into file failed.");
		}
	}

	//Modifies a record if it is already available in the file.
	public static void modifyRecord()
	{
			removeRecord();
			addNewRecord();
			lblStatus.setText("Record was modified.");
	}
	
	//Removes a selected record from the text file.
	public static void removeRecord()
	{
		try 
		{
			File tempFile = new File("TextInfo.tmp");
	        if(txt_file.exists())
	        {
	        	BufferedReader reader = new BufferedReader(new FileReader(txt_file));
                PrintWriter writer = new PrintWriter(new FileWriter(tempFile));
                String strLine;
                String info[];
                while((strLine = reader.readLine())!= null)
                {
                	info = strLine.split("\t");
                	if(!UIApplication.name().replaceAll("\\s+","").contentEquals((info[0]+info[1]+info[2]).trim()))
                	{
                		writer.println(strLine);	//Writes all those lines that do not match the name to be deleted into temporary file.
                	}
                }
                reader.close();
                writer.close();
                if(txt_file.delete()){	//Deletes the text file.
                    if(!tempFile.renameTo(txt_file))	//Temporary file is renamed to the text file.
                    	lblStatus.setText("Unable to delete the text file.");
                    else
                       	lblStatus.setText("Record was deleted from the text file.");
                }
	        }
	        else
	        	lblStatus.setText("File is empty.");
		}
		catch(Exception e)
		{
			lblStatus.setText("File Error: Unable to load the record.");
		}
	        
	}
	
	//Adds the records from text file into JTable.
	public static void addRecordsIntoTable()
	{
		createFile();
		try
		{
			FileInputStream fstream = new FileInputStream(txt_file.getAbsolutePath());
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			while(tableModel.getRowCount()>0)	//Clears all records in the table.
				tableModel.removeRow(0);
			while ((strLine = br.readLine()) != null)
			{
				String[] elements = strLine.split("\t");
				String row[] = {elements[0]+" "+elements[1]+" "+elements[2],elements[3]};
				tableModel.addRow(row);	//Loads all records from text file into table.
			}
			br.close();
			in.close();
			fstream.close();
		}
		catch(Exception e)
		{
			lblStatus.setText("File Error: Unable to load the record.");
		}
	}	
	
	//Fills the text fields when a row in the JTable is selected.
	public static void fillTextFieldsOnRowSelection()
	{
		if(table.getSelectedRow()!=-1)
		{
			String selectedData = null;
	        int selectedRow = table.getSelectedRow();
	       	selectedData = (String) table.getValueAt(selectedRow,0);
	        createFile();
			try
			{
				FileInputStream fstream = new FileInputStream(txt_file.getAbsolutePath());
				DataInputStream in = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				String strLine;
				//Find the record in text file and load its information into the text fields.
				while ((strLine = br.readLine()) != null){
					String[] info = strLine.split("\t");
					if(selectedData.trim().replaceAll("\\s+","").contentEquals((info[0]+info[1]+info[2]).trim()))
					{
						txt_fname.setText(info[0]);
						txt_minit.setText(info[1]);
						txt_lname.setText(info[2]);
						txt_phone.setText(info[3]);
						txt_email.setText(info[4]);
						txt_addr1.setText(info[5]);
						txt_addr2.setText(info[6]);
						txt_city.setText(info[7]);
						txt_state.setText(info[8]);
						txt_country.setText(info[9]);
						txt_zip.setText(info[10]);
					}
				}
				br.close();
				in.close();
				fstream.close();
				}
			catch(Exception e)
			{
				lblStatus.setText("File Error : Unable to locate the file.");
			}
		}
	}
	
	
}
