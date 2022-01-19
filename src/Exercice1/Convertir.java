package Exercice1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Convertir extends JFrame    {
	JLabel l = new JLabel("donner montant:");
	JTextField text = new JTextField();
	JRadioButton b1 = new JRadioButton("euros-->dinars");
	JRadioButton b2 = new JRadioButton("dinars-->euros");
	JButton b = new JButton("Convertir");
	JLabel resultat = new JLabel("Resultat:");
	JPanel d = new JPanel(new GridLayout(2, 2, 5, 10));
	JPanel rad = new JPanel(new GridLayout(2, 0));
class Ecouteur implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object action = e.getSource();
		if(action instanceof JButton)
		{
			String vtexte=text.getText();
			
			try {
				Double v =Double.parseDouble(vtexte);
				if(b1.isSelected()) {
					resultat.setText(""+(v*3.25));
				}
				else
					resultat.setText(""+(v/3.25));
			}catch(NumberFormatException a) {
JOptionPane.showMessageDialog(null, "Erreur de saisie");				
			}
		}
		else if(!b.isEnabled()){
			b.setEnabled(true);
			System.out.println("okay");
		}
	}
	
}
	public Convertir() {
		super("Convertir");
		b.setEnabled(false);
		rad.add(b1);
		rad.add(b2);
		d.add(l);
		d.add(text);
		d.add(rad);
		d.add(b);
		ButtonGroup bg = new ButtonGroup();
		bg.add(b1);
		bg.add(b2);
		resultat.setFont(new Font("courier", Font.BOLD, 15));
		resultat.setBorder(BorderFactory.createLineBorder(Color.blue, 2));
		this.add(d, BorderLayout.CENTER);
		this.add(resultat, BorderLayout.SOUTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setVisible(true);
		setSize(300, 200);
		b.addActionListener(new Ecouteur());
		b1.addActionListener(new Ecouteur());
		b2.addActionListener(new Ecouteur());
		//b.addActionListener(this);
		//b1.addActionListener(this);
		//b2.addActionListener(this);
		/*b.addActionListener(
				e->{ String vtexte = text.getText();
				try {
					Double v =Double.parseDouble(vtexte);
					if(b1.isSelected()) {
						resultat.setText(""+(v*3));
					}
					else
						resultat.setText(""+(v/3));
				}catch(NumberFormatException a) {
					JOptionPane.showMessageDialog(this, "Erreur de saisie");
					
				}
				});
		b1.addActionListener(e->{
			b.setEnabled(true);
			System.out.println("okay");
			
		});
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				b.setEnabled(true);
				System.out.println("okay");
			}
			
		});
*/		
	}
	/* @Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object action = e.getSource();
		if(action instanceof JButton)
		{
			String vtexte=text.getText();
			
			try {
				Double v =Double.parseDouble(vtexte);
				if(b1.isSelected()) {
					resultat.setText(""+(v*3));
				}
				else
					resultat.setText(""+(v/3));
			}catch(NumberFormatException a) {
				JOptionPane.showMessageDialog(this, "Erreur de saisie");
				
			}
		}
		else if(!b.isEnabled()){
			b.setEnabled(true);
			System.out.println("okay");
		}
	}*/

	public static void main(String[] args) {
		new Convertir();
	}

	


	
	

	
}
