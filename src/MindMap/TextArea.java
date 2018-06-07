package MindMap;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
public class TextArea extends JPanel{
	JTextArea data = new JTextArea(7, 20);
	TextArea(){
		this.setBackground(Color.CYAN);
		data.setBackground(Color.cyan);
		//data.setBorder(BorderFactory.createLineBorder(Color.cyan, 1));
		this.setBorder(new EmptyBorder(new Insets(0,0,0,0)));
		JScrollPane scroll = new JScrollPane(data,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBorder(new EmptyBorder(new Insets(0,0,0,0)));
		add(scroll);
		setVisible(true);
		
	}
	public static void main(String[] args){
		new TextArea();
	}
}
