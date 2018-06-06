package MindMap;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import MindMap.TextArea;

public class CenterPane extends JPanel{
	CenterPane(){
		setLayout(new BorderLayout());
		Border border = BorderFactory.createLineBorder(Color.BLUE, 3);
		
		MindMapLabel label = new MindMapLabel();
		
		
		label.setBorder(border);
		
		add(label,BorderLayout.NORTH);
		
		setVisible(true);
	}
	public static void main(String[] args){
		new CenterPane();
	}
}
