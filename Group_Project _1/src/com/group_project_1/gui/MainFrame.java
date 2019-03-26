package com.project.gui;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import com.project.Study.*;
import com.project.fileIO.*;

public class MainFrame {

	private JFrame frame;
	private JTextField readingValueField;
	private JTextField readingIDField;
	private JTextField siteIDField;
	private JTextField startStopCollectionsTextField;
	private JTextField readingDateField;

	private JComboBox studyComboBox;
	private JTextArea inProgressCollectionsTextArea;
	private JTextArea notInProgressCollectionsTextArea;

	private ArrayList<Study> studyList = new ArrayList<>();

	//private ArrayList<Site> siteList = new ArrayList<>();


	private JTextField addStudyNameTxtField;
	private JTextField studyIDTxtField;

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

		JLabel studyNameLbl = new JLabel("");
		studyNameLbl.setBounds(780, 7, 190, 44);
		frame.getContentPane().add(studyNameLbl);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 353, 148, 237);
		frame.getContentPane().add(scrollPane_1);

		notInProgressCollectionsTextArea = new JTextArea();
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

		studyComboBox = new JComboBox();
		studyComboBox.setBounds(612, 17, 140, 22);
		frame.getContentPane().add(studyComboBox);

		studyComboBox.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		        updateInProgressList();
		        for (Study study : studyList) {
					if(Integer.parseInt(study.getStudyID()) == Integer.parseInt(studyComboBox.getSelectedItem().toString())){
						studyNameLbl.setText(study.getStudyName());
					}
				}
		    }
		});

		inProgressCollectionsTextArea = new JTextArea();
		inProgressCollectionsTextArea.setEditable(false);
		collectionsScrollPane.setViewportView(inProgressCollectionsTextArea);

		JButton addReadingButton = new JButton("Add Reading");
		addReadingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Reading reading = new Reading();

				    reading.setSite_id(siteIDField.getText());
					reading.setReading_date(readingDateField.getText());
					reading.setReading_id(readingIDField.getText());
					String value = readingTypeComboBox.getSelectedItem().toString();
					reading.setReading_type(value);
					reading.setReading_value(readingValueField.getText());


				for (Study study : studyList) {
					if(Integer.parseInt(study.getStudyID()) == Integer.parseInt(studyComboBox.getSelectedItem().toString())) {
						for (Site site : study.getSites()) {
							if(Integer.parseInt(site.getId()) == Integer.parseInt(siteIDField.getText())) {
								if(site.isCollecting()) {
									site.addReading(reading);
									mainTextArea.append("Reading added");
								}else {
									mainTextArea.append("Site not collecting. Start site collection to add reading.\n");
								}
							}
						}
					}
				}

				readingIDField.setText(null);
				readingValueField.setText(null);

			}



		});
		addReadingButton.setBounds(780, 271, 109, 23);
		frame.getContentPane().add(addReadingButton);

		JButton exportButton = new JButton("Export");
		exportButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    ReadWriteJSON rwJSON = new ReadWriteJSON();
			    AcceptFile af = new AcceptFile();

				for ( Study study : studyList ) {
				    String path = af.chooseFile().getAbsolutePath();
                    for ( Site site : study.getSites() ) {
                        rwJSON.writeJSON(site.getReadings(), path);
                    }
                }
			}
		});
		exportButton.setBounds(892, 77, 89, 23);
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



		JButton importJSONButton = new JButton("Import JSON");
		importJSONButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {




			    ReadWriteJSON rwJSON = new ReadWriteJSON();

			    AcceptFile af = new AcceptFile();



			   ArrayList<Site> siteList = new ArrayList<>();

	            for (Reading reading : rwJSON.readJSON(af.chooseFile().getAbsolutePath()) ) {

	                if(reading.getSite_id() == null) {
	                    System.out.println("Reading id missing");
	                }else {


	                    Site newSite = new Site(reading.getSite_id());
	                    newSite.addReading(reading);

	                    siteList.add(newSite);
	                    mainTextArea.append(reading.getSite_id() + "\n");
	                    mainTextArea.append(reading.getReading_type() + "\n");
	                    mainTextArea.append(reading.getReading_value() + "\n");
	                    mainTextArea.append(reading.getReading_date() + "\n");


	                }

	            }

	            for ( Study study : studyList ) {
                    if(Integer.parseInt(study.getStudyID()) == Integer.parseInt(studyComboBox.getSelectedItem().toString())) {
                        for ( Site site : siteList ) {
                            study.addSite(site);

                        }
                    }
                }







			}
		});
		importJSONButton.setBounds(761, 77, 119, 23);
		frame.getContentPane().add(importJSONButton);


		startStopCollectionsTextField = new JTextField();
		startStopCollectionsTextField.setBounds(198, 78, 148, 20);
		frame.getContentPane().add(startStopCollectionsTextField);
		startStopCollectionsTextField.setColumns(10);

		JButton startCollectionsButton = new JButton("Start");
		startCollectionsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userEnteredID = startStopCollectionsTextField.getText();
				if(userEnteredID.isEmpty()) {// check text field not empty before doing work on text field
					mainTextArea.append("Invalid site ID\n");
				}

				for (Study study : studyList) {
					if(Integer.parseInt(study.getStudyID()) == Integer.parseInt(studyComboBox.getSelectedItem().toString())) {
						for (Site site : study.getSites()) {
							if(Integer.parseInt(site.getId()) == Integer.parseInt(userEnteredID)) {
								if(site.isCollecting()) {
									mainTextArea.append("Site already collecting\n");

								}else {
									site.setCollecting(true);
									mainTextArea.append("Site collection started\n");
								}
							}
						}
					}
					startStopCollectionsTextField.setText(null);


				}
				updateInProgressList();
			}
		});
		startCollectionsButton.setBounds(463, 77, 73, 23);
		frame.getContentPane().add(startCollectionsButton);

		JButton stopCollectionsButton = new JButton("Stop");
		stopCollectionsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userEnteredID = startStopCollectionsTextField.getText();
				if(userEnteredID.isEmpty()) {// check text field not empty before doing work on text field
					mainTextArea.append("Invalid site ID\n");
				}

				for (Study study : studyList) {
					if(Integer.parseInt(study.getStudyID()) == Integer.parseInt(studyComboBox.getSelectedItem().toString())) {
						for (Site site : study.getSites()) {
							if(Integer.parseInt(site.getId()) == Integer.parseInt(userEnteredID)) {
								if(site.isCollecting()) {
									site.setCollecting(false);
									mainTextArea.append("Site collection stopped\n");

								}else {

									mainTextArea.append("Site already not collecting\n");
								}
							}
						}
					}
					startStopCollectionsTextField.setText(null);
				}
				updateInProgressList();

			}
		});
		stopCollectionsButton.setBounds(548, 77, 73, 23);
		frame.getContentPane().add(stopCollectionsButton);

		JButton addSiteCollectionButton = new JButton("Add Site");
		addSiteCollectionButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				String userEnteredID = startStopCollectionsTextField.getText();

				Site newSite = new Site(userEnteredID);


					boolean found = false;


					for (Study study : studyList) {
						if(Integer.parseInt(study.getStudyID()) == Integer.parseInt(studyComboBox.getSelectedItem().toString())) {
							for (Site site : study.getSites()) {
								if(Integer.parseInt(site.getId()) == Integer.parseInt(userEnteredID)) {

									mainTextArea.append("Site already exists\n");
									found = true;
								}
							}

							if(!found) {
								mainTextArea.append("New site added\n");
								study.addSite(newSite);
							}
						}
					}

				startStopCollectionsTextField.setText(null);

				updateInProgressList();

			}
		});
		addSiteCollectionButton.setBounds(363, 77, 89, 23);
		frame.getContentPane().add(addSiteCollectionButton);

		JButton showAllButton = new JButton("Show All Readings");
		showAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				mainTextArea.setText(null); // clear main text box before displaying all readings

				for (Study study : studyList) {// display all readings in main text box
						for (Site site : study.getSites()) {
								for (Reading reading : site.getReadings()) {
									if(!site.getReadings().isEmpty()) {
										mainTextArea.append(reading.toString());
									}

								}


						}



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

		JButton addStudyButton = new JButton("Add Study");
		addStudyButton.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent arg0) {

				studyNameLbl.setText(addStudyNameTxtField.getText().toString());

				if((studyIDTxtField.getText().isEmpty()) || addStudyNameTxtField.getText().isEmpty()) {
					mainTextArea.append("Invalid study entry\n");
				}else {
					Study newStudy = new Study(studyIDTxtField.getText().toString(), addStudyNameTxtField.getText().toString());
					Boolean found = false;
					if(studyList.isEmpty()) {

					}else {
						for (Study study : studyList) {
							if(Integer.parseInt(study.getStudyID()) == Integer.parseInt(studyIDTxtField.getText().toString())) {
								mainTextArea.append("Study already added\n");
								found = true;
								break;
							}
						}
					}

					if(found == false) {
						studyList.add(newStudy);
						studyComboBox.addItem(newStudy.getStudyID());
					}
				}



				studyIDTxtField.setText(null);
				addStudyNameTxtField.setText(null);


			}
		});
		addStudyButton.setBounds(492, 16, 97, 25);
		frame.getContentPane().add(addStudyButton);



		addStudyNameTxtField = new JTextField();
		addStudyNameTxtField.setToolTipText("Study Name");
		addStudyNameTxtField.setBounds(364, 17, 116, 22);
		frame.getContentPane().add(addStudyNameTxtField);
		addStudyNameTxtField.setColumns(10);

		studyIDTxtField = new JTextField();
		studyIDTxtField.setToolTipText("Study ID");
		studyIDTxtField.setBounds(230, 17, 116, 22);
		frame.getContentPane().add(studyIDTxtField);
		studyIDTxtField.setColumns(10);

		JButton importXMLBtn = new JButton("Import XML");
		importXMLBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    ReadXML read = new ReadXML();

			    AcceptFile af = new AcceptFile();
			    studyList.add(read.xmlRead(af.chooseFile().getAbsolutePath()));


			}
		});
		importXMLBtn.setBounds(640, 76, 109, 25);
		frame.getContentPane().add(importXMLBtn);

		JLabel studyNameLbl1 = new JLabel("");
		studyNameLbl1.setBounds(780, 7, 190, 44);
		frame.getContentPane().add(studyNameLbl1);




	}

	public void updateInProgressList() {
		inProgressCollectionsTextArea.setText(null);
		notInProgressCollectionsTextArea.setText(null);

		for (Study study : studyList) {

			if(Integer.parseInt(study.getStudyID()) == Integer.parseInt(studyComboBox.getSelectedItem().toString())) {
				for (Site site : study.getSites()) {
					if(site.isCollecting()) {
						inProgressCollectionsTextArea.append(site.getId() + "\n");
					}else {
						notInProgressCollectionsTextArea.append(site.getId() + "\n");
					}
				}
			}
		}
	}
}