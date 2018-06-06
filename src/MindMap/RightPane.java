package MindMap;

import java.awt.*;
import javax.swing.*;

public class RightPane extends JPanel{
	RightPane()
	{	
//		setLayout(new FlowLayout(FlowLayout.CENTER));
		setLayout(new GridLayout(3,1));
		AttributePane x =new AttributePane();
		Attribute y = new Attribute();
		RightButton z = new RightButton();
		add(x); add(y); add(z);
		setVisible(true);
	}
	public static void main(String[] args){
		new RightPane();
	}
}
