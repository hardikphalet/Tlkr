import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

public class Resources extends JFrame{
	private JTextField item1;
	private JTextField item2;
	private JTextField item3;
	private JPasswordField password;

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
		HandlerClass handler = new HandlerClass();
		item1.addActionListener(handler);
		item2.addActionListener(handler);
		item3.addActionListener(handler);
		password.addActionListener(handler);
	}
	private class HandlerClass implements ActionListener{

		public void actionPerformed(ActionEvent event){
			String string = "";
			if (event.getSource()==item1){
				string = String.format("field 1: %s", event.getActionCommand());
			}
			else if (event.getSource()==item2){
				string = String.format("field 1: %s", event.getActionCommand());
			}
			else if (event.getSource()==item3){
				string = String.format("field 1: %s", event.getActionCommand());
			}
			else if (event.getSource()==password){
				string = String.format("password field 1: %s", event.getActionCommand());
			}

			JOptionPane.showMessageDialog(null, string);

		}

	}
}