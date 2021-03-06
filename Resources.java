import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.*;
import javax.swing.*;


public class Resources extends JFrame{
	private JTextField item1;
	private JTextField item2;
	private JTextField item3;
	private JPasswordField password;
	private JButton reg;
	private JButton custom;
	private JCheckBox boldbox;
	private JCheckBox italicbox;

 
	public Resources(){
		super("Tlkr");
		setLayout(new FlowLayout());

		item1 = new JTextField(10);
		item1.setFont(new Font("Serif",Font.PLAIN,14));
		add(item1);

		boldbox = new JCheckBox("Bold");
		italicbox = new JCheckBox("Italics");
		add(boldbox);
		add(italicbox);
		item2 = new JTextField("enter text here");
		add(item2);
		item3 = new JTextField("uneditable", 20);
		item3.setEditable(false);
		add(item3);
		password = new JPasswordField("mypass");
		add(password);
		reg = new JButton("Button(1): Regular");
		add(reg);
		Icon b = new ImageIcon(getClass().getResource("Button1-b.png"));
		Icon x = new ImageIcon(getClass().getResource("Button1-x.png"));
		custom = new JButton("A", b);
		custom.setRolloverIcon(x);
		add(custom);


		HandlerClass handler = new HandlerClass();
		HandlerClass2 handler_ = new HandlerClass2();
		item1.addActionListener(handler);
		item2.addActionListener(handler);
		item3.addActionListener(handler);
		password.addActionListener(handler);
		reg.addActionListener(handler);
		custom.addActionListener(handler);
		boldbox.addItemListener(handler_);
		italicbox.addItemListener(handler_);
	}
	private class HandlerClass implements ActionListener{

		public void actionPerformed(ActionEvent event){
			String string = null;
			// if (event.getSource()==item1){
			// 	string = String.format("field 1: %s", event.getActionCommand());
			// }
			// else 
			if (event.getSource()==item2){
				string = String.format("field 2: %s", event.getActionCommand());
			}
			else if (event.getSource()==item3){
				string = String.format("field 3: %s", event.getActionCommand());
			}
			else if (event.getSource()==password){
				string = String.format("password field 1: %s", event.getActionCommand());
			}
			else if (event.getSource()==reg || event.getSource()==custom){
				string = String.format("%s",event.getActionCommand());
			}

			else if (event.getSource()==boldbox){
				;
			}
			else if (event.getSource()==italicbox){
				;
			}
			if (string != null){
				JOptionPane.showMessageDialog(null, string);
			}

		}

	}
	private class HandlerClass2 implements ItemListener{
		public void itemStateChanged(ItemEvent event){
			Font font = null;
			if (boldbox.isSelected() && italicbox.isSelected()){
				font = new Font("Serif", Font.BOLD + Font.ITALIC,14);
			}
			else if(boldbox.isSelected()){
				font = new Font("Serif", Font.BOLD,14);
			}
			else if(italicbox.isSelected()){
				font = new Font("Serif", Font.ITALIC,14);
			}
			else{
				font = new Font("Serif", Font.PLAIN,14);	
			}
			item1.setFont(font);

		}
	}
}