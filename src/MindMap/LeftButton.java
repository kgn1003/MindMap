package MindMap;

import java.awt.*;
import javax.swing.*;

public class LeftButton extends JPanel{
	LeftButton(){
		setLayout(new BorderLayout());
		JButton btn = new JButton("Àû¿ë");
		btn.setBackground(Color.RED);
		btn.setFont(new Font("a",Font.BOLD,15));
		add(btn,BorderLayout.SOUTH);
		setVisible(true);
	}
	public static void main(String[] args){
		new LeftButton();
	}
}
