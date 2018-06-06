package MindMap;

import java.awt.*;
import javax.swing.*;

public class JMain extends JFrame{
	
	JSplitPane leftPane;
	JSplitPane rightPane;
	
	RightPane right = new RightPane();
	LeftPane left = new LeftPane();
	CenterPane center = new CenterPane();
	Menu menu = new Menu();
	Toolbar toolbar = new Toolbar();

	
	JMain(){
		setTitle("Mind Map");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		this.setJMenuBar(menu.bar);
		this.add(toolbar);

		
		leftPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		rightPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		
		add(rightPane,"Center");
		setVisible(true);
		
		
		leftPane.setLeftComponent(left);
		leftPane.setRightComponent(new JScrollPane(center));
		leftPane.setContinuousLayout(true);
		rightPane.setContinuousLayout(true);
		
		rightPane.setLeftComponent(leftPane);
		rightPane.setRightComponent(right);
	
		leftPane.setDividerSize(0);
		rightPane.setDividerLocation(0.8);
		rightPane.setDividerSize(0);
		
		

//		setBounds(100, 100, 1000, 500);
	}
	public static void main(String[] args){
		new JMain();
	}
}
