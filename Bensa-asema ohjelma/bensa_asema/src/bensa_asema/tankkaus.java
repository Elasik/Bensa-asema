package bensa_asema;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class tankkaus extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextArea text_95;
	private JTextArea text_98;
	private JTextArea text_d;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField lisaa_95;
	private JTextField lisaa_98;
	private JTextField lisaa_d;
	
	String ysivitonen;
	String ysikasi;
	String diesel;
	
	String filename = "src/bensa_m‰‰r‰/bensa_m‰‰r‰.txt";
	private JButton plus95;
	private JButton plus98;
	private JButton plusd;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_7;


	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tankkaus frame = new tankkaus();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public tankkaus() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("95:");
		lblNewLabel.setBounds(10, 16, 27, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("98:");
		lblNewLabel_1.setBounds(10, 41, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("D:");
		lblNewLabel_2.setBounds(10, 66, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		text_95 = new JTextArea();
		text_95.setBounds(47, 11, 46, 22);
		contentPane.add(text_95);
		
		text_98 = new JTextArea();
		text_98.setBounds(47, 36, 46, 22);
		contentPane.add(text_98);
		
		text_d = new JTextArea();
		text_d.setBounds(47, 66, 46, 22);
		contentPane.add(text_d);
		
		lblNewLabel_3 = new JLabel("Lis\u00E4\u00E4:");
		lblNewLabel_3.setBounds(76, 119, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("95:");
		lblNewLabel_4.setBounds(10, 151, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("98:");
		lblNewLabel_5.setBounds(10, 176, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("D:");
		lblNewLabel_6.setBounds(10, 199, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		lisaa_95 = new JTextField();
		lisaa_95.setBounds(36, 148, 86, 20);
		contentPane.add(lisaa_95);
		lisaa_95.setColumns(10);
		
		lisaa_98 = new JTextField();
		lisaa_98.setBounds(36, 176, 86, 20);
		contentPane.add(lisaa_98);
		lisaa_98.setColumns(10);
		
		lisaa_d = new JTextField();
		lisaa_d.setBounds(36, 196, 86, 20);
		contentPane.add(lisaa_d);
		lisaa_d.setColumns(10);
		
		plus95 = new JButton("Lis\u00E4\u00E4 95");
		plus95.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ysivitonen = "" + (Integer.parseInt(text_95.getText())	+ Integer.parseInt(lisaa_95.getText()));
					
					int result = JOptionPane.showConfirmDialog(null, "Talletetaanko varmasti?","Varmistus",  JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
					
					if( result == JOptionPane.OK_OPTION ) {
						text_95.setText(ysivitonen);
						
						lisaa_95.setText("");
						
						kirjoitaTiedostoon95(ysivitonen, filename);
						
						String teksti = lueTiedostosta(filename);
						
						textArea1.setText(teksti);
						
						if(Integer.parseInt(ysivitonen) <= 100){
							JOptionPane.showMessageDialog(null, "Tankki on l‰hell‰ tyhjentymist‰");
						}
						
					}
					if( result == JOptionPane.NO_OPTION ) {
						lisaa_95.setText("");
					}
					
					
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "V‰‰r‰ syˆte");
					lisaa_95.setText("");
				}
				

			}
		});
		plus95.setBounds(119, 147, 89, 23);
		contentPane.add(plus95);
		
		plus98 = new JButton("Lis\u00E4\u00E4 98");
		plus98.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ysikasi = "" + (Integer.parseInt(text_98.getText())	+ Integer.parseInt(lisaa_98.getText()));
					
					int result = JOptionPane.showConfirmDialog(null, "Talletetaanko varmasti?","Varmistus",  JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
					
					if( result == JOptionPane.OK_OPTION ) {
						text_98.setText(ysikasi);
						
						lisaa_98.setText("");
						
						kirjoitaTiedostoon98(ysikasi, filename);
						
						String teksti = lueTiedostosta(filename);
						
						textArea1.setText(teksti);
						
						if(Integer.parseInt(ysikasi) <= 100){
							JOptionPane.showMessageDialog(null, "Tankki on l‰hell‰ tyhjentymist‰");
						}
						
					}
					if( result == JOptionPane.NO_OPTION ) {
						lisaa_98.setText("");
					}
					
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "V‰‰r‰ syˆte");
					lisaa_98.setText("");
				}
			}
		});
		plus98.setBounds(119, 172, 89, 23);
		contentPane.add(plus98);
		
		plusd = new JButton("Lis\u00E4\u00E4 D");
		plusd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					lueSaldo(filename);
					
					diesel = "" + (Integer.parseInt(text_d.getText())	+ Integer.parseInt(lisaa_d.getText()));
					
					int result = JOptionPane.showConfirmDialog(null, "Talletetaanko varmasti?","Varmistus",  JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
					
					if( result == JOptionPane.OK_OPTION ) {
						
						text_d.setText(diesel);
						
						lisaa_d.setText("");
						
						kirjoitaTiedostoond(diesel, filename);
						
						String teksti = lueTiedostosta(filename);
						
						textArea1.setText(teksti);
						
						if(Integer.parseInt(diesel) <= 100){
							JOptionPane.showMessageDialog(null, "Tankki on l‰hell‰ tyhjentymist‰");
						}
					}
					if( result == JOptionPane.NO_OPTION ) {
						lisaa_d.setText("");
					}
					
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "V‰‰r‰ syˆte");
					lisaa_d.setText("");
				}
			}
		});
		plusd.setBounds(119, 195, 89, 23);
		contentPane.add(plusd);
		
		lueSaldo(filename);
		String teksti = lueTiedostosta(filename);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(242, 11, 171, 226);
		contentPane.add(scrollPane);
		
		textArea1 = new JTextArea();
		scrollPane.setViewportView(textArea1);
		textArea1.setText(teksti);
		
		lblNewLabel_7 = new JLabel("M\u00E4\u00E4r\u00E4t ilmoitettu litroina");
		lblNewLabel_7.setBounds(10, 236, 156, 14);
		contentPane.add(lblNewLabel_7);
		
		
	}
	
        public void lueSaldo(String filename) {
		
		try {
			FileReader freader = new FileReader(filename);
			BufferedReader br = new BufferedReader(freader);
			String line;
			
			ysivitonen = kasitteleRivi(br.readLine());
			ysikasi = kasitteleRivi(br.readLine());
			diesel = kasitteleRivi(br.readLine());
			
			text_95.setText(ysivitonen);
			text_98.setText(ysikasi);
			text_d.setText(diesel);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String kasitteleRivi(String txt) {   
		txt = txt.replace(" ", "");				
		String[] temp = txt.split("=");			
		
		return temp[1];
	}
	
	public String lueTiedostosta(String filename) {

		String alltext = "";

		try {
			FileReader freader = new FileReader(filename);
			BufferedReader br = new BufferedReader(freader);
			String line;
			while ((line = br.readLine()) != null) {
				alltext = alltext + line + "\n";
			}

		} catch (Exception e) {
			e.printStackTrace();
			alltext = "";
		}

		return alltext;
	}
	
	public void kirjoitaTiedostoon95(String ysivitonen,String filename) {
		try {
			java.util.Date date = new java.util.Date();
			FileWriter fwriter = new FileWriter(filename, true);
			fwriter.write(date.toString() + "\n" );
			ysivitonen = text_95.getText();
			String bensa = "95 = ";
			fwriter.write( bensa + ysivitonen + "\n");
			fwriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void kirjoitaTiedostoon98(String ysikasi, String filename) {
		try {
			java.util.Date date = new java.util.Date();
			FileWriter fwriter = new FileWriter(filename, true);
			fwriter.write(date.toString() + "\n" );
			ysikasi = text_98.getText();
			String bensa = "98 = ";
			fwriter.write( bensa + ysikasi + "\n");
			fwriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void kirjoitaTiedostoond(String diesel, String filename) {
		try {
			java.util.Date date = new java.util.Date();
			FileWriter fwriter = new FileWriter(filename, true);
			fwriter.write(date.toString() + "\n" );
			diesel = text_d.getText();
			String bensa = "D = ";
			fwriter.write( bensa + diesel + "\n");
			fwriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
