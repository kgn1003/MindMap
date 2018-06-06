package MindMap;

import java.awt.*;
import javax.swing.*;


public class TextArea extends JPanel{
		TextArea(){
			setLayout(new FlowLayout());
			JLabel label = new JLabel("Text Editor Pane");
			label.setFont(new Font("a", Font.PLAIN, 30));
			label.setForeground(Color.white);
			this.setBackground(Color.CYAN);
			
			add(label,new FlowLayout(FlowLayout.CENTER));
			setVisible(true);
		}
		public static void main(String[] args){
			new TextArea();
		}
}
