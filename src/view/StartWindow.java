package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridBagLayout;
import java.awt.BorderLayout;

import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.RowFilter;

import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.GridLayout;

import javax.swing.border.TitledBorder;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.Book;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JTable;

import domain.Library;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartWindow {

	private JFrame frame;
	private JTextField txtSuc;
	private JTable table;
	private StartWindowTableModel tableModel; 
	private TableRowSorter<StartWindowTableModel> sorter; 
	private Library library;
	private JCheckBox chckbxNurVerfgbareBcher;
	
	public StartWindow(Library library) {		

		this.library = library;
		initialize();
		this.frame.setVisible(true);

	}
	
	private void newFilter() {  
	    RowFilter< StartWindowTableModel, Object> rf = null;     
	    try  
	    {  
	        rf = RowFilter.regexFilter("(?i)" + txtSuc.getText(), 1 ,2 ,3);    
	        
	    }  
	    catch (java.util.regex.PatternSyntaxException e)  
	    {  
	        return;  
	    }  
	    sorter.setRowFilter(rf);  
	}  
	
	private void openDetailWindow(String bookName){
		
		domain.Book book = library.findByBookTitle(bookName);
		if(book != null) {
			DetailWindow detailFrame = new DetailWindow();
		    detailFrame.setBook(book);			        	 
		}else{
			 System.out.println("Buch nicht gefunden");
		}
		
	}
	
	private void showOnlyAvailable() {
		if (chckbxNurVerfgbareBcher.isSelected()){
			sorter.setRowFilter(new RowFilter< StartWindowTableModel, Object>(){

				@Override
				public boolean include(
					RowFilter.Entry<? extends StartWindowTableModel, ? extends Object> entry) {
					for (int i = entry.getValueCount() - 1; i >= 0; i--) {
					       if (entry.getStringValue(i).startsWith("0")) {
					      
					         return false;
					       }
					     }
					    
					     return true;
						}
					}
				);
		}else{
			sorter.setRowFilter(null);
		}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("rawtypes")
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 980, 534);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JLayeredPane layeredPane = new JLayeredPane();
		tabbedPane.addTab("Bücher", null, layeredPane, null);
		GridBagLayout gbl_layeredPane = new GridBagLayout();
		gbl_layeredPane.columnWidths = new int[]{395, 0};
		gbl_layeredPane.rowHeights = new int[]{47, 0, 0};
		gbl_layeredPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_layeredPane.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		layeredPane.setLayout(gbl_layeredPane);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.anchor = GridBagConstraints.NORTH;
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		layeredPane.add(panel, gbc_panel);
		panel.setBorder(new TitledBorder(null, "Inventar Statistiken", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblAnzahlBcher = new JLabel("Anzahl Bücher:");
		panel.add(lblAnzahlBcher);
		
		JLabel label = new JLabel("842");
		panel.add(label);
		
		JLabel lblAnzahlExemplare = new JLabel("Anzahl Exemplare:");
		panel.add(lblAnzahlExemplare);
		
		JLabel lblNewLabel = new JLabel("2200");
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Buch-Inventar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		layeredPane.add(panel_1, gbc_panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.NORTH);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 248, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		txtSuc = new JTextField();
		txtSuc.setText("Bücher suchen");
		txtSuc.getDocument().addDocumentListener(  
		  new DocumentListener()  
		   {  
		      public void changedUpdate(DocumentEvent e)  
		      {  
		          newFilter();  
		      }  
		      public void insertUpdate(DocumentEvent e)  
		      {  
		          newFilter();  
		      }  
		      public void removeUpdate(DocumentEvent e)  
		      {  
		         newFilter();  
		      }  
		   }  
		);
		
		
		
		GridBagConstraints gbc_txtSuc = new GridBagConstraints();
		gbc_txtSuc.insets = new Insets(0, 0, 0, 5);
		gbc_txtSuc.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSuc.gridx = 1;
		gbc_txtSuc.gridy = 0;
		panel_2.add(txtSuc, gbc_txtSuc);
		txtSuc.setColumns(10);
		
		chckbxNurVerfgbareBcher = new JCheckBox("nur verfügbare Bücher anzeigen");
		chckbxNurVerfgbareBcher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showOnlyAvailable();
				
			}
		});
		GridBagConstraints gbc_chckbxNurVerfgbareBcher = new GridBagConstraints();
		gbc_chckbxNurVerfgbareBcher.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxNurVerfgbareBcher.gridx = 8;
		gbc_chckbxNurVerfgbareBcher.gridy = 0;
		panel_2.add(chckbxNurVerfgbareBcher, gbc_chckbxNurVerfgbareBcher);
		
		JButton btnSelektierteAnzeigen = new JButton("Selektierte Anzeigen");
		btnSelektierteAnzeigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] rows = table.getSelectedRows();
				for (int row: rows){
					String bookName = (String) table.getValueAt(row, 1);
					openDetailWindow(bookName);
				}
		
			}
		});
		GridBagConstraints gbc_btnSelektierteAnzeigen = new GridBagConstraints();
		gbc_btnSelektierteAnzeigen.insets = new Insets(0, 0, 0, 5);
		gbc_btnSelektierteAnzeigen.gridx = 13;
		gbc_btnSelektierteAnzeigen.gridy = 0;
		panel_2.add(btnSelektierteAnzeigen, gbc_btnSelektierteAnzeigen);
		
		JButton btnNeuesBuchHinzufgen = new JButton("Neues Buch hinzufügen");
		GridBagConstraints gbc_btnNeuesBuchHinzufgen = new GridBagConstraints();
		gbc_btnNeuesBuchHinzufgen.gridx = 14;
		gbc_btnNeuesBuchHinzufgen.gridy = 0;
		panel_2.add(btnNeuesBuchHinzufgen, gbc_btnNeuesBuchHinzufgen);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		 
		tableModel= new StartWindowTableModel(library);
		sorter = new TableRowSorter<>(tableModel);
		table = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		table.setRowSorter(sorter);  
		panel_3.add(scrollPane);
		
		 table.addMouseListener(new MouseAdapter() {
			   public void mouseClicked(MouseEvent e) {
			      if (e.getClickCount() == 2) {
			         JTable target = (JTable)e.getSource();
			         int row = target.getSelectedRow();
			         String bookName= (String) table.getValueAt(row, 1);
			         openDetailWindow(bookName);
			      }   
			   }
			});
		
		JLayeredPane layeredPane_2 = new JLayeredPane();
		tabbedPane.addTab("Ausleihen", null, layeredPane_2, null);
		GridBagLayout gbl_layeredPane_2 = new GridBagLayout();
		gbl_layeredPane_2.columnWidths = new int[]{9, 395, 0};
		gbl_layeredPane_2.rowHeights = new int[]{47, 0};
		gbl_layeredPane_2.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_layeredPane_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		layeredPane_2.setLayout(gbl_layeredPane_2);
	}
}
