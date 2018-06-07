package MindMap;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;

public class DrawPane extends JPanel{
	JLabel[] label = new JLabel[3];
	String[] title = {"icon1","icon2","icon3"};
	
	DrawPane(RightPane item1,Attribute item2,CenterPane item3){
		setLayout(null);
		Border border = BorderFactory.createLineBorder(Color.BLUE, 1);
		
		DrawEvent draw = new DrawEvent(item2,this);
		
		for (int i = 0; i < label.length; i++) {
			label[i] = new JLabel(title[i]);
			label[i].addMouseMotionListener(draw);
			label[i].addMouseListener(draw);
			label[i].setFont(new Font("Label", Font.BOLD, 15));
			label[i].setSize(60,30);
			label[i].setBorder(border);
			label[i].setLocation(100 + (i*50), 100 + (i*50));
			add(label[i]);
		}
		
		
	}
}
