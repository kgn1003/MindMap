package MindMap;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import MindMap.TextAreaPane;

public class CenterPane extends JPanel{
		
	CenterPane(RightPane item1 ,Attribute item2){
		setLayout(new BorderLayout());
		Border border = BorderFactory.createLineBorder(Color.BLUE, 3);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		
		MindMapLabel label = new MindMapLabel();
		DrawPane draw = new DrawPane(item1,item2,this);
		
		label.setBorder(border);
		
		add(label,BorderLayout.NORTH);
		add(draw);
		
		setVisible(true);
	}
}
