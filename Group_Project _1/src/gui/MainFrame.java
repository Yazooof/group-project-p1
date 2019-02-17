package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import collection.Site;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class MainFrame {

	private JFrame frame;
	private JTextField readingValueField;
	private JTextField readingIDField;
	private JTextField siteIDField;
	private JTextField startStopCollectionsTextField;
	private JTextField readingDateField;

	private ArrayList<Site> siteList = new ArrayList<>();// holds all sites in an arrayList
	
	private ArrayList<String> inProgressSiteIDList = new ArrayList<>();// list holds siteIDs that have collection in progress
	private ArrayList<String> notInProgressSiteIDList = new ArrayList<>();// list holds siteIDs with no collections in progress
	
	
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
		frame.setBounds(100, 100, 1024, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel CollectionsLabel = new JLabel("Collections In Progress");
		CollectionsLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		CollectionsLabel.setBounds(10, 11, 220, 30);
		frame.getContentPane().add(CollectionsLabel);
		
		String[] comboBoxOptions = {"Humidity", "Particulate", "Temp", "Bar_Press"};
		@SuppressWarnings({ "unchecked", "rawtypes" })
		JComboBox readingTypeComboBox = new JComboBox(comboBoxOptions);
		readingTypeComboBox.setBounds(381, 203, 155, 20);
		frame.getContentPane().add(readingTypeComboBox);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 353, 148, 237);
		frame.getContentPane().add(scrollPane_1);
		
		JTextArea notInProgressCollectionsTextArea = new JTextArea();
		notInProgressCollectionsTextArea.setEditable(false);
		scrollPane_1.setViewportView(notInProgressCollectionsTextArea);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(203, 353, 756, 237);
		frame.getContentPane().add(scrollPane);
		
		JTextArea mainTextArea = new JTextArea();
		scrollPane.setViewportView(mainTextArea);
		
		JScrollPane collectionsScrollPane = new JScrollPane();
		collectionsScrollPane.setBounds(10, 52, 148, 246);
		frame.getContentPane().add(collectionsScrollPane);
		
		JTextArea inProgressCollectionsTextArea = new JTextArea();
		inProgressCollectionsTextArea.setEditable(false);
		collectionsScrollPane.setViewportView(inProgressCollectionsTextArea);
		
		JButton addReadingButton = new JButton("Add Reading");
		addReadingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Site addReadingSite = new Site();
				addReadingSite.setSiteID(siteIDField.getText());  
				
					addReadingSite.setReadingDate(readingDateField.getText());
					addReadingSite.setReadingID(readingIDField.getText());
					String value = readingTypeComboBox.getSelectedItem().toString();
					addReadingSite.setReadingType(value);
					addReadingSite.setReadingValue(readingValueField.getText());
				
					
				if(inProgressSiteIDList.contains(siteIDField.getText())) {
					siteList.add(addReadingSite);
					mainTextArea.append("Added Reading\n");
				}else {
				
				mainTextArea.append("Error: did not find site or site collection not in progress\n");
				
				}
				readingIDField.setText(null);
				readingValueField.setText(null);
				
			}
			

			
		});
		addReadingButton.setBounds(780, 271, 109, 23);
		frame.getContentPane().add(addReadingButton);
		
		JButton exportButton = new JButton("Export");
		exportButton.setBounds(870, 54, 89, 23);
		frame.getContentPane().add(exportButton);
		
		JLabel siteLable = new JLabel("Site ID");
		siteLable.setBounds(249, 142, 46, 14);
		frame.getContentPane().add(siteLable);
		
		JLabel readingTypeLabel = new JLabel("Reading Type");
		readingTypeLabel.setBounds(249, 206, 81, 14);
		frame.getContentPane().add(readingTypeLabel);
		
		JLabel readingIDLabel = new JLabel("Reading ID");
		readingIDLabel.setBounds(599, 142, 65, 14);
		frame.getContentPane().add(readingIDLabel);
		
		JLabel readingValueLabel = new JLabel("Reading Value");
		readingValueLabel.setBounds(599, 206, 81, 14);
		frame.getContentPane().add(readingValueLabel);
		
		JLabel readingDateLabel = new JLabel("Reading Date");
		readingDateLabel.setBounds(249, 275, 97, 14);
		frame.getContentPane().add(readingDateLabel);
		
		readingValueField = new JTextField();
		readingValueField.setBounds(734, 203, 155, 20);
		frame.getContentPane().add(readingValueField);
		readingValueField.setColumns(10);
		
		readingIDField = new JTextField();
		readingIDField.setBounds(734, 139, 155, 20);
		frame.getContentPane().add(readingIDField);
		readingIDField.setColumns(10);
		
		siteIDField = new JTextField();
		siteIDField.setBounds(381, 139, 155, 20);
		frame.getContentPane().add(siteIDField);
		siteIDField.setColumns(10);
		
		
		
		JButton importButton = new JButton("Import"); 
		importButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		importButton.setBounds(734, 54, 97, 23);
		frame.getContentPane().add(importButton);
		
		
		startStopCollectionsTextField = new JTextField();
		startStopCollectionsTextField.setBounds(203, 55, 148, 20);
		frame.getContentPane().add(startStopCollectionsTextField);
		startStopCollectionsTextField.setColumns(10);
		
		JButton startCollectionsButton = new JButton("Start");
		startCollectionsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userEnteredID = startStopCollectionsTextField.getText();
				
				if(userEnteredID.isEmpty()) {// check text field not empty before doing work on text field 
					mainTextArea.append("Invalid site ID\n");
				}else if(inProgressSiteIDList.contains(userEnteredID)) {// check to see that collection is not already started
					mainTextArea.append("Collection already in progress\n");
					startStopCollectionsTextField.setText(null);

				}else {
					notInProgressCollectionsTextArea.setText(null);
					inProgressCollectionsTextArea.setText(null);
				
					
						notInProgressSiteIDList.remove(userEnteredID);
						inProgressSiteIDList.add(userEnteredID);
					
					for (String s : inProgressSiteIDList) {
						inProgressCollectionsTextArea.append(s);
						inProgressCollectionsTextArea.append("\n");
					}
					
							
					for (String s : notInProgressSiteIDList) {
						notInProgressCollectionsTextArea.append(s);
						notInProgressCollectionsTextArea.append("\n");

					}	
					
					mainTextArea.append("Site collection started\n");
					startStopCollectionsTextField.setText(null);
				}
				
				
			
			}
		});
		startCollectionsButton.setBounds(463, 54, 73, 23);
		frame.getContentPane().add(startCollectionsButton);
		
		JButton stopCollectionsButton = new JButton("Stop");
		stopCollectionsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String userEnteredID = startStopCollectionsTextField.getText();
				
				if(userEnteredID.isEmpty()) {// check text field not empty before doing work on text field 
					mainTextArea.append("Invalid site ID\n");
				}else if(notInProgressSiteIDList.contains(userEnteredID)) {
					mainTextArea.append("Collection already stopped\n");
					startStopCollectionsTextField.setText(null);

				}else {
					notInProgressCollectionsTextArea.setText(null);
					inProgressCollectionsTextArea.setText(null);
				
					inProgressSiteIDList.remove(userEnteredID);
					notInProgressSiteIDList.add(userEnteredID);
					
					for (String s : inProgressSiteIDList) {
						inProgressCollectionsTextArea.append(s);
						inProgressCollectionsTextArea.append("\n");
					}
					
							
					for (String s : notInProgressSiteIDList) {
						notInProgressCollectionsTextArea.append(s);
						inProgressCollectionsTextArea.append("\n");

					}	
					startStopCollectionsTextField.setText(null);
					mainTextArea.append("Site collection stopped\n");
				}
				
				
			}
		});
		stopCollectionsButton.setBounds(546, 54, 73, 23);
		frame.getContentPane().add(stopCollectionsButton);
		
		JButton addSiteCollectionButton = new JButton("Add Site");
		addSiteCollectionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userEnteredID = startStopCollectionsTextField.getText();
				
				if(userEnteredID.isEmpty()) {// check text field not empty before doing work on text field 
					mainTextArea.append("Invalid site ID\n");
				}else {
					if(inProgressSiteIDList.isEmpty() && notInProgressSiteIDList.isEmpty()) {
						notInProgressSiteIDList.add(userEnteredID);
						notInProgressCollectionsTextArea.append(userEnteredID + "\n");
						
						
					}else if(inProgressSiteIDList.contains(userEnteredID) || notInProgressSiteIDList.contains(userEnteredID)) {
						mainTextArea.append("Site already added\n");
					}else {
						notInProgressSiteIDList.add(userEnteredID);
						notInProgressCollectionsTextArea.append(userEnteredID + "\n");
						
						
						
					}
					startStopCollectionsTextField.setText(null);
				}
				
				
			}
		});
		addSiteCollectionButton.setBounds(361, 54, 89, 23);
		frame.getContentPane().add(addSiteCollectionButton);
		
		JButton showAllButton = new JButton("Show All Readings");
		showAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mainTextArea.setText(null); // clear main text box before displaying all readings
				
				for (Site s : siteList) {
					
					mainTextArea.append(s.toString());
					
				}
				
				if(mainTextArea.getText().isEmpty()) {
					mainTextArea.append("No readings to show");
				}
				mainTextArea.append("\n");
			}
		});
		showAllButton.setBounds(819, 319, 140, 23);
		frame.getContentPane().add(showAllButton);
		
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainTextArea.setText(null);
			}
		});
		clearButton.setBounds(720, 319, 89, 23);
		frame.getContentPane().add(clearButton);
		
		readingDateField = new JTextField();
		readingDateField.setBounds(381, 272, 155, 20);
		frame.getContentPane().add(readingDateField);
		readingDateField.setColumns(10);
		
		JLabel collections2Label = new JLabel("Stopped Collections");
		collections2Label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		collections2Label.setBounds(10, 312, 164, 30);
		frame.getContentPane().add(collections2Label);
		
		
		
		
	}
}
