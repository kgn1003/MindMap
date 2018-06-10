package MindMap;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class DrawNode extends JPanel{

	DrawNode(DrawPane item){
//		setLayout(null);
		setLayout(new BorderLayout());
		add(item);
		setVisible(true);
	}
}