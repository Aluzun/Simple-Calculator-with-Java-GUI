import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Test{
	
	public static void main(String[] args) {
		CalcFrame cf = new CalcFrame();
		cf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cf.setSize(270, 300);
		cf.setLocation(400,100);
		cf.setVisible(true);
	}
} 

class CalcFrame extends JFrame  implements ActionListener {
	JPanel panel = new JPanel();
	JLabel lcd = new JLabel("0",JLabel.RIGHT);
	  double result = 0;
	  String operator = "=";
	  boolean calculating = true;
	
	public CalcFrame(){
		super("CALCULATOR");
		lcd.setFont(new Font("Digital-7 Mono",Font.PLAIN,42));
		lcd.setForeground(Color.RED);
		panel.setLayout(new GridLayout(5,3));
		
		add(lcd,BorderLayout.NORTH);
		add(panel,BorderLayout.CENTER);
		
		JButton b0 = new JButton("0"); panel.add(b0);
		JButton b1 = new JButton("1");  panel.add(b1);
		JButton b2 = new JButton("2");  panel.add(b2);
		JButton b3 = new JButton("3");  panel.add(b3);
		JButton b4 = new JButton("4");  panel.add(b4);
		JButton b5 = new JButton("5");  panel.add(b5);
		JButton b6 = new JButton("6");  panel.add(b6);
		JButton b7 = new JButton("7");  panel.add(b7);
		JButton b8 = new JButton("8");  panel.add(b8);
		JButton b9 = new JButton("9");  panel.add(b9);
		JButton opA = new JButton("+"); panel.add(opA);
		JButton opS = new JButton("-"); panel.add(opS);
		JButton opM = new JButton("x"); panel.add(opM);
		JButton opD = new JButton("/"); panel.add(opD);
		JButton opE = new JButton("="); panel.add(opE);
		JButton opN = new JButton("."); panel.add(opN);
		
		b0.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		
		opA.addActionListener(this);
		opS.addActionListener(this);
		opM.addActionListener(this);
		opD.addActionListener(this);
		opE.addActionListener(this);
		opN.addActionListener(this);
		
	}
	  public void actionPerformed(ActionEvent evt) {
		    String cmd = evt.getActionCommand();
		    if ('0' <= cmd.charAt(0) && cmd.charAt(0) <= '9' || cmd.equals(".")) {
		      if (calculating)
		        lcd.setText(cmd);
		      else
		        lcd.setText(lcd.getText() + cmd);
		      calculating = false;
		    } else {
		      if (calculating) {
		        if (cmd.equals("-")) {
		          lcd.setText(cmd);
		          calculating = false;
		        } else
		          operator = cmd;
		      } else {
		        double x = Double.parseDouble(lcd.getText());
		        calculate(x);
		        operator = cmd;
		        calculating = true;
		      }
		    }
		  }
		 
		  private void calculate(double n) {
		    if (operator.equals("+"))
		      result += n;
		    else if (operator.equals("-"))
		      result -= n;
		    else if (operator.equals("x"))
		      result *=n;
		    else if (operator.equals("/"))
		      result /= n;
		    else if (operator.equals("="))
		      result = n;
		    lcd.setText("" + result);
		  }

	
}