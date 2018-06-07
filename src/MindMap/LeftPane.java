package MindMap;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class LeftPane extends JPanel{
	JTextArea data = new JTextArea(7, 20);
	LeftPane(){
		setLayout(new BorderLayout());
		Border border = BorderFactory.createLineBorder(Color.BLUE, 3);
		TextAreaPane pane = new TextAreaPane(); 
		LeftButton btn = new LeftButton();
		pane.setBorder(border);
		data.setBackground(Color.CYAN);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

		add(pane,BorderLayout.NORTH); 
		add(new JScrollPane(data,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),BorderLayout.CENTER);
		add(btn, BorderLayout.SOUTH);
		setVisible(true);
	}
	public static void main(String[] args){
		new LeftPane();
	}
}
