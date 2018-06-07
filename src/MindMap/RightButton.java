package MindMap;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
public class RightButton extends JPanel{
	RightButton(){
		setLayout(new BorderLayout());
		JButton btn = new JButton("º¯°æ");
		btn.setBackground(Color.RED);
		
		btn.setFont(new Font("a",Font.BOLD,15));
		add(btn,BorderLayout.SOUTH);
		setVisible(true);
	}
	public static void main(String[] args){
		new RightButton();
	}
}
