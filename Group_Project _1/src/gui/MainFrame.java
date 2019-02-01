package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextArea;

import inputOutputFromFile.AcceptFile;
import jsonRead.Readings;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;

import com.google.gson.JsonSyntaxException;

import java.awt.Font;

public class MainFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
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
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 726, 576);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAddJsonFile = new JButton("Add Json File");
		btnAddJsonFile.setBounds(20, 30, 117, 40);
		frame.getContentPane().add(btnAddJsonFile);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 275, 651, 235);
		frame.getContentPane().add(scrollPane);
		
		JTextArea textAreaFileOutput = new JTextArea();
		textAreaFileOutput.setText("No File selected");
		textAreaFileOutput.setFont(new Font("LiHei Pro", Font.PLAIN, 16));
		scrollPane.setViewportView(textAreaFileOutput);
		textAreaFileOutput.setBackground(Color.WHITE);
		textAreaFileOutput.setEditable(false);
		
		
		
		frame.setLocationRelativeTo(null);
		
		btnAddJsonFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcceptFile acceptFile = new AcceptFile();
				try {
					textAreaFileOutput.setText(acceptFile.chooseFile().getAllSitesFormated().toString());

				}catch (NullPointerException fileNull)
				{
					//when cancel is clicked 
				}catch (JsonSyntaxException jsonSyntaxError) {
					JOptionPane.showMessageDialog(frame, "Something wrong with the json file \n check if file formatted correctly", "File error", 1);
				}
				
			}
		});
	}
}
