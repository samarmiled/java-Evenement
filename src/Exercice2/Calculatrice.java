package Exercice2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculatrice extends JFrame  {
	JLabel la = new JLabel("donner a:");
	JLabel lb = new JLabel("donner b:");
	JLabel lresultat = new JLabel("Resultat:");
	JTextField ta = new JTextField();
	JTextField tb = new JTextField();
	JLabel lres = new JLabel();
	JButton add = new JButton("Addition");
	JButton sous = new JButton("Soustraction");
	JButton mul = new JButton("Multiplication");
	JButton div = new JButton("Division");
	JPanel p1 = new JPanel(new GridLayout(3, 2, 5, 5));
	JPanel p2 = new JPanel(new GridLayout(2, 2, 5, 5));
     class Ecouteur implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				lres.setText(""+calculer(Double.parseDouble(ta.getText()), Double.parseDouble(tb.getText()), e.getActionCommand()));
				}catch(NumberFormatException a) {
					JOptionPane.showMessageDialog(null, a.getMessage());
				}catch(ArithmeticException b)
				{
					JOptionPane.showMessageDialog(null, b.getMessage());
				}
		}
    	 
     }
	public Calculatrice() {
		this.setTitle("Calclatrice");
		p1.add(la);
		p1.add(ta);
		p1.add(lb);
		p1.add(tb);
		p1.add(lresultat);
		p1.add(lres);
		add.setActionCommand("+");
		mul.setActionCommand("*");
		sous.setActionCommand("-");
		div.setActionCommand("/");
		lres.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setLayout(new GridLayout(2, 0, 10, 10));
		this.add(p1);
		p2.add(add);
		p2.add(sous);
		p2.add(mul);
		p2.add(div);
		this.add(p2);
		
		this.setVisible(true);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//add.addActionListener(this);
		//mul.addActionListener(this);
		//sous.addActionListener(this);
		//div.addActionListener(this);
		add.addActionListener(new Ecouteur());
		mul.addActionListener(new Ecouteur());
		sous.addActionListener(new Ecouteur());
		div.addActionListener(new Ecouteur());
		
		

	}

	public static void main(String[] args) {
		new Calculatrice();
	}
	
	private double calculer(double a,double b,String op)
	{
		switch(op)
		{
		case "+":return a+b;
		case "-":return a-b;
		case "*":return a*b;
		case "/":
			if(b==0) throw new ArithmeticException("division par zero");
			return a/b;
		}
		return 0;
	}

	/*@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
		lres.setText(""+calculer(Double.parseDouble(ta.getText()), Double.parseDouble(tb.getText()), e.getActionCommand()));
		}catch(NumberFormatException a) {
			JOptionPane.showMessageDialog(this, a.getMessage());
		}catch(ArithmeticException b)
		{
			JOptionPane.showMessageDialog(this, b.getMessage());
		}
		
	}*/

	
		
		
	

	
}
