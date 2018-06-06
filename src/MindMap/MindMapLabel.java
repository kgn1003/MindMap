package MindMap;

import java.awt.*;
import javax.swing.*;

public class MindMapLabel extends JPanel{
	MindMapLabel(){
			setLayout(new FlowLayout(FlowLayout.CENTER));
			JLabel label = new JLabel("Mind Map Pane");
			label.setFont(new Font("a", Font.PLAIN, 30));
			label.setForeground(Color.white);
			this.setBackground(Color.CYAN);
			
			add(label,new FlowLayout(FlowLayout.CENTER));
			setVisible(true);
	}
	public static void main(String[] args){
		new MindMapLabel();
	}
}
