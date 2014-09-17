/**
 * Author: Arun Kumar Konduru Chandra
 * NetID: axk138230
 * Date : 02/04/2014
 * Class: CS6301.013
 * Purpose: Assignment 2 for UI Design course.
 * Description: This is the main module.Loads UI onto screen.*/

package custPackage;

import java.awt.EventQueue;


public class Main 
{
	//Launch the application.
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						UI frame = new UI();
						frame.setVisible(true);
						frame.setResizable(false);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
}