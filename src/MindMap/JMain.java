package MindMap;

import java.awt.*;
import javax.swing.*;

public class JMain extends JFrame{
	
	JSplitPane leftPane;
	JSplitPane rightPane;
	
	JPanel center = new JPanel();
	JPanel left = new JPanel();
	
	JMain(){
		setTitle("Mind Map");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		RightPane r = new RightPane();
		
		leftPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		rightPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		
		add(rightPane);
		
		
		leftPane.setLeftComponent(left);
		leftPane.setRightComponent(new JScrollPane(center));
		
		rightPane.setLeftComponent(leftPane);
		rightPane.setRightComponent(r);
		
		rightPane.setDividerLocation(0.8);
		rightPane.setDividerSize(5);
		
		
		setVisible(true);
		setBounds(100, 100, 1000, 500);
	}
	public static void main(String[] args){
		new JMain();
	}
}
