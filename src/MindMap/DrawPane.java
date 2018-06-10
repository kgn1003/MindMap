package MindMap;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.colorchooser.ColorChooserComponentFactory;


public class DrawPane extends JPanel{
	JLabel[] label = new JLabel[3];
	Rectangle[] rect = new Rectangle[3];
	String[] title = {"icon1","icon2","icon3"};
	String[] color = new String[3];
	String test;
//	JColorChooser color;
	
//    public void paintComponent(Graphics g) {
////      super.paintComponent(g);
//      Graphics2D g2 = (Graphics2D)g;
////      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
////                          RenderingHints.VALUE_ANTIALIAS_ON);
////      for(int i = 0; i <)
//      
//      g2.setPaint(Color.blue);
//      g2.draw(rect);
//
//  }
//	public void draw(Graphics g){
//		super.paintComponent(g);
//        g.drawRect(100, 100, 200, 100);
//        g.setColor(Color.BLUE);
//	}
	DrawPane(RightPane item1,Attribute item2,CenterPane item3){
		setLayout(null);
		Border border = BorderFactory.createLineBorder(Color.black, 3);
		DrawEvent drawing = new DrawEvent(item2,this);
		this.addMouseListener(drawing);
		int r, g, b;
		String convert;
		String cmd = item2.statusColor.getText();
		this.addMouseMotionListener(drawing);
		for(int i = 0 ; i < label.length; i++){
			label[i] = new JLabel(title[i],JLabel.CENTER);
			label[i].setFont(new Font("Label", Font.BOLD, 15));
			label[i].setSize(60,30);
			label[i].setLocation(100 + (i*50), 100 + (i*50));					
			label[i].setForeground(Color.black);
			label[i].setOpaque(true);
			label[i].setBorder(border);
		}
	
		label[0].setBackground(Color.white);
		label[1].setBackground(Color.yellow);
		label[2].setBackground(Color.blue);
		for(int i = 0; i < label.length; i++){
			r = label[i].getBackground().getRed(); g = label[i].getBackground().getGreen(); b = label[i].getBackground().getBlue();
			color[i] = Integer.toHexString(r)+Integer.toHexString(g)+Integer.toHexString(b);
			convert = setColor(color[i]);
			color[i] = convert;
			label[i].addMouseMotionListener(drawing);
			label[i].addMouseListener(drawing);
//			label[i].setOpaque(true);
			add(label[i]);
		}
		String t = setColor(color[1]);
		int l = color[2].length();
		System.out.println(l);
		System.out.println(">"+t);
//		color[1] = t;
		System.out.println(color[1]);
		setVisible(true);
//		DrawNode xxxx = new DrawNode(this);
	
	}
	String setColor(String c){

		if(c.length() == 4){
			c = "0x00"+c;
		}
		else if(c.length() == 5){
			c = "0x0" +c;
		}
		else if(c.length() == 6){
			c = "0x"+c;
		}

		return c;
	}
		
	
}
