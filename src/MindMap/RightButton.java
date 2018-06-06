package MindMap;
import java.awt.*;
import javax.swing.*;

public class RightButton extends JPanel{
	RightButton(){
		setLayout(new BorderLayout());
		JButton btn = new JButton("º¯°æ");
		btn.setBackground(Color.RED);
		add(btn,BorderLayout.SOUTH);
		setVisible(true);
	}
	public static void main(String[] args){
		new RightButton();
	}
}
