package bensa_asema;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.awt.event.ActionEvent;

public class salasana extends JFrame {

	private JPanel contentPane;
	private JTextField k‰ytt‰j‰tunnus;
	private JTextField salasana;
	private JButton kirjaudu;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	   private tankkaus tankkaus = new tankkaus();
	   
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					salasana frame = new salasana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public salasana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		k‰ytt‰j‰tunnus = new JTextField();
		k‰ytt‰j‰tunnus.setBounds(164, 45, 86, 20);
		contentPane.add(k‰ytt‰j‰tunnus);
		k‰ytt‰j‰tunnus.setColumns(10);
		
		salasana = new JTextField();
		salasana.setBounds(164, 93, 86, 20);
		contentPane.add(salasana);
		salasana.setColumns(10);
		
		kirjaudu = new JButton("Kirjaudu");
		kirjaudu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String oikea_kayttajatunnus = "oranssi";
				String oikea_salasana = crypt("porkkana"); 
				String salasana_crypted="";
				
				try {
					salasana_crypted = crypt(salasana.getText());
				} catch (Exception e) {
				}
				
				if(k‰ytt‰j‰tunnus.getText().equals(oikea_kayttajatunnus) && oikea_salasana.equals(salasana_crypted)) {
					salasana.this.setVisible(false);
					tankkaus.setVisible(true);
					
				}
				else {
					JOptionPane.showMessageDialog(null, "V‰‰r‰ salasana!");
				}

			}
		});
		kirjaudu.setBounds(164, 170, 89, 23);
		contentPane.add(kirjaudu);
		
		lblNewLabel = new JLabel("K\u00E4ytt\u00E4j\u00E4tunnus:");
		lblNewLabel.setBounds(79, 48, 86, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Salasana:");
		lblNewLabel_1.setBounds(110, 96, 55, 14);
		contentPane.add(lblNewLabel_1);
	}
	
	public static String crypt(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("String to encript cannot be null or zero length");
        }

        MessageDigest digester;
        try {
            digester = MessageDigest.getInstance("MD5");

            digester.update(str.getBytes());
            byte[] hash = digester.digest();
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                if ((0xff & hash[i]) < 0x10) {
                    hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
                } else {
                    hexString.append(Integer.toHexString(0xFF & hash[i]));
                }
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

}
