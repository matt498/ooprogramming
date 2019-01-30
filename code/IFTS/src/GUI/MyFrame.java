package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener {
	JButton btnCF;
	JButton btnFC;
	JTextField tfC;
	JTextField tfF;
	
	public MyFrame() {
		super("MyFrame");
		
		btnCF = new JButton("C->F");
		btnFC = new JButton("F->C");
		btnCF.addActionListener(this);
		btnFC.addActionListener(this);
		
		tfC = new JTextField("0");
		tfF = new JTextField("32");
		
		JPanel p2 = new JPanel(new GridLayout(2, 2));
		p2.add(tfC);
		p2.add(tfF);
		p2.add(btnCF);
		p2.add(btnFC);
		
		JPanel p1 = new JPanel(new BorderLayout());
		p1.add(p2, BorderLayout.CENTER);
		p1.add(new JLabel("Ciao!"), BorderLayout.SOUTH);

		add(p1);
		setSize(200, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCF) {
			double tc = Double.parseDouble(tfC.getText());
			double tf = tc * 9 / 5 + 32;
			tfF.setText(new Double(tf).toString());
		}

		if (e.getSource() == btnFC) {
			double tf = Double.parseDouble(tfF.getText());
			double tc = (tf - 32) * 5 / 9;
			tfC.setText(new Double(tc).toString());
		}
	}
	
	public static void main(String[] args) {
		new MyFrame();
	}

}
