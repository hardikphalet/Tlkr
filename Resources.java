import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class Resources extends JFrame{
	private JTextField item1;
	private JTextField item2;
	private JTextField item3;
	private JPasswordField password;
	private JButton reg;
	private JButton custom;
 
	public Resources(){
		super("Tlkr");
		setLayout(new FlowLayout());

		item1 = new JTextField(10);
		add(item1);
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
		item1.addActionListener(handler);
		item2.addActionListener(handler);
		item3.addActionListener(handler);
		password.addActionListener(handler);
		reg.addActionListener(handler);
		custom.addActionListener(handler);
	}
	private class HandlerClass implements ActionListener{

		public void actionPerformed(ActionEvent event){
			String string = "";
			if (event.getSource()==item1){
				string = String.format("field 1: %s", event.getActionCommand());
			}
			else if (event.getSource()==item2){
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


			JOptionPane.showMessageDialog(null, string);

		}

	}
}