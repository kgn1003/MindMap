package MindMap;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class RightPane extends JPanel{

	RightPane(Attribute item)
	{	
		setLayout(new BorderLayout(0,10));
		Border border = BorderFactory.createLineBorder(Color.BLUE, 3);
		AttributePane ap =new AttributePane();
//		Attribute a = new Attribute();
		RightButton rb = new RightButton();
		this.setBackground(Color.CYAN);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		ap.setBorder(border);
		add(ap,BorderLayout.NORTH); add(item,BorderLayout.CENTER); add(rb,BorderLayout.SOUTH);
		setVisible(true);
	}
//
//	public static void main(String[] args){
//		new RightPane();
//	}
}
